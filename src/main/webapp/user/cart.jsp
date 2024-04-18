<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/7/2024
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/user/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/user/cart.css"/>">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&family=Sen:wght@400;700;800&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
    <title>Movie Design</title>
    <style type="text/css">
        .profile-options {
            display: none;
            position: absolute;
            top: 35px;
            right: 0;
            background-color: #fff;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .profile-options ul {
            list-style-type: none;
            padding: 0;
        }

        .profile-options ul li {
            padding: 10px;
        }

        .profile-options ul li a {
            text-decoration: none;
            color: #333;
            display: block;
        }

        .profile-options ul li a:hover {
            background-color: #f2f2f2;
        }

        .fas  {
            cursor: pointer;
        }
        .logo{
            cursor:pointer;
        }
        .profile-text{
            cursor: pointer;
        }
        .gradient-custom {
            /* fallback for old browsers */
            background: #6a11cb;

            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));

            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))
        }
        .card-book{
            margin: 0 auto;
            width: 60vh;
        }
    </style>
</head>

<body class="gradient-custom">
<div class="navbar">
    <div class="navbar-container">
        <div class="logo-container">
            <h1 class="logo">Sách Dương Tâm</h1>
        </div>
        <div class="profile-container">
            <div class="profile-text-container" onclick="toggleProfileOptions()">
                <span class="profile-text" cursor="pointer">Tài khoản</span>
                <i class="fas fa-caret-down"></i>
            </div>
            <div class="profile-options" id="profileOptions">
                <ul>
                    <li><a href="">Thông tin</a></li>
                    <li><a href="#">Xem đơn hàng</a></li>
                    <li><a href="http://localhost:8080/login?aciton=login">Đăng xuất</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="sidebar">
    <i class="left-menu-icon fas fa-home"><a href="http://localhost:8080/login?action=showHome"></a></i>
    <i class="left-menu-icon fas fa-shopping-cart"></i>
</div>
<div class="container gradient-custom">
    <div class="card" style="margin-top: 50px;">
        <div class="row">
            <div class="col-md-8 cart">
                <div class="title">
                    <div class="row">
                        <div class="col"><h4><b>Giỏ hàng</b></h4></div>
                        <div class="col align-self-center text-right text-muted">${numbers} sản phẩm</div>
                    </div>
                </div>
                <c:forEach items="${books}" var="item">
                    <div class="row border-top border-bottom">
                        <div class="row main align-items-center">
                            <div class="col-2"><img class="img-fluid" src="./image1/${item.image}"></div>
                            <div class="col">
                                <div class="row text-muted">${item.name}</div>
                                <div class="row">${item.category}</div>
                            </div>
                            <div class="col">
                                <input name="quantity${item.id}" type="number" placeholder="Số lượng">
                            </div>
                            <div class="col">${item.price} VNĐ
                                <form action="http://localhost:8080/user?action=deleteCart&bookId=${item.id}">
                                    <button><span class="close">&#10005;</span></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="back-to-shop"><a href="http://localhost:8080/user?action=home">&leftarrow;</a><span class="text-muted">Back to shop</span></div>
            </div>
            <div class="col-md-4 summary">
                <div><h5><b>Summary</b></h5></div>
                <hr>
                <div class="row">
                    <div class="col" style="padding-left:0;">${numbers} sản phẩm</div>
                    <div class="col text-right">${totalmoney}</div>
                </div>
                <form>
                    <p>Chọn nhà vận chuyển</p>
                    <select>
                        <option class="text-muted" value="100000">VẬN CHUYỂN NHANH</option>
                        <option class="text-muted" value="50000">VẬN CHUYỂN LÂU</option>
                        <option class="text-muted" value="1000000">VẬN CHUYỂN TIẾT KIỆM</option>
                    </select>
                    <p>Địa chỉ</p>
                    <input id="code" placeholder="Nhập địa chỉ" name="address">
                </form>
                <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                    <div class="col">Tổng tiền</div>
                    <div class="col text-right">${totalmoneys}</div>
                </div>
                <button class="btn">Thanh toán</button>
            </div>
        </div>

    </div>
</div>
<script src="app.js"></script>
<script type="text/javascript">
    function toggleProfileOptions() {
        var profileOptions = document.getElementById("profileOptions");
        if (profileOptions.style.display === "none" || profileOptions.style.display === "") {
            profileOptions.style.display = "block";
        } else {
            profileOptions.style.display = "none";
        }
    }
</script>
</body>
</html>
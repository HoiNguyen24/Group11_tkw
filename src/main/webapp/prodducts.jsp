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
    <link rel="stylesheet" href="<c:url value="style.css"/>">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&family=Sen:wght@400;700;800&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
                    <li><a href="http://localhost:8080/login?action=login">Đăng nhập</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="sidebar">
    <i class="left-menu-icon fas fa-home"><a href="http://localhost:8080/login?action=showHome"></a></i>
    <i class="left-menu-icon fas fa-shopping-cart"></i>
</div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-2 bg-primary p-5">
                <form class="form-inline">
                    <div class="row flex-nowrap">
                        <input class="form-control w-75" type="search" placeholder="Search" aria-label="Tìm kiếm">
                        <button class="btn btn-success w-25" type="submit">Tìm kiếm</button>
                    </div>
                    <div class="row">
                        <label>Phân loại</label>
                        <select name="category" class="form-select form-select-lg mb-3 " aria-label=".form-select-lg example" style="width: 100%; height: 38px; margin: 0 !important;">
                            <option selected>Loại sách</option>
                            <option value="mn"><button>SÁCH MẦM NON</button></option>
                            <option value="tn"><button>SÁCH THIẾU NHI</button></option>
                            <option value="kn"><button>SÁCH KĨ NĂNG</button></option>
                            <option value="kd"><button>SÁCH KINH DOANH</button></option>
                            <option value="mb"><button>SÁCH MẸ VÀ BÉ</button></option>
                            <option value="vh"><button>SÁCH VĂN HỌC</button></option>
                            <option value="tk"><button>SÁCH THAM KHẢO</button></option>
                            <option value="nb"><button>NOTEBOOK</button></option>
                        </select>
                    </div>
                </form>
        </div>
        <div class="col-9">
            <div class="row">
                <select class="form-select form-select-lg mb-3 ">
                    <option selected>Chọn sắp xếp</option>
                    <option><a href="http://localhost:8080/user?action=sortDesc">Sắp thoe giá tiền tăng dần</a></option>
                    <option><a href="http://localhost:8080/user?action=sortAsc">Sắp theo giá tiền giảm</a></option>
                </select>
            </div>
            <div class="row">
                <c:forEach var="item" items="${books}">
                    <form>
                        <div class="movie-list">
                            <div class="movie-list-item">
                                <img class="movie-list-item-img" src="./image1/${item.image}" alt="">
                                <span class="movie-list-item-title">${item.name}</span>
                                <p class="movie-list-item-desc">${item.author} </p>
                                <button class="movie-list-item-button" >
                                    <a href="">Mua ngay</a>
                                </button>
                                <button class="movie-list-item-button" >
                                    <a href="">Cho vào giỏ hàng</a>
                                </button>
                            </div>
                        </div>
                        <i class="fas fa-chevron-right arrow"></i>
                    </form>
                </c:forEach>
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
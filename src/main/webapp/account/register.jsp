<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet"  type="text/css" href="css/index.css">
    <title>Hello, world!</title>
</head>
<body>
<div class="header bg-dark">
    <div class="container">
        <div class="col-12 ">
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="collapse navbar-collapse d-flex justify-content-between " id="navbarTogglerDemo01">
                    <a class="navbar-brand" href="#">
                        <img src="https://cdn.discordapp.com/attachments/1147169475746078763/1218167050409869352/logo.png?ex=6606ad79&is=65f43879&hm=18744636b2bdf140e6223074a628ff214071230806765e8be2327e3f6527141b&" width="250" height="50">
                    </a>
                    <form class="form-inline my-2 my-lg-0" method="get" action="search">
                        <input class="form-control rounded-0" type="search" placeholder="Tìm kiếm sách, tác giả, loại sách" aria-label="Search" style="width: 400px;">
                        <button class="btn btn-outline-light" type="submit">Tìm kiếm</button>
                    </form>
                    <a href="" class="btn d-flex justify-content-center text-light btn-secondary rounded-circle">
                        <ion-icon name="cart-outline" style="width: 30px;height: 30px;"></ion-icon>
                    </a>
                    <a href="http://localhost:8080/Gradle___com_example___hauiProject_1_0_SNAPSHOT_war__exploded_/home?action=login" class="btn d-flex justify-content-center text-light btn-secondary" style="height: 40px">
                        <ion-icon name="person-circle-outline" style="width: 30px;height: 30px;"></ion-icon>
                        <p style="font-size: 20px" class="ml-1">Đăng nhập</p>
                    </a>
                </div>
            </nav>
        </div>
    </div>
</div>
<div class="body mt-5">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <section class="vh-100">
                    <div class="container h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-lg-12 col-xl-11">
                                <div class="card text-black" style="border-radius: 25px;">
                                    <div class="card-body p-md-5">
                                        <div class="row justify-content-center">
                                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                                                <form class="mx-1 mx-md-4" method="post" action="http://localhost:8080/Gradle___com_example___hauiProject_1_0_SNAPSHOT_war__exploded_/home?action=register">

                                                    <div class="d-flex flex-row align-items-center mb-4">
                                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                                        <div class="form-outline flex-fill mb-0">
                                                            <input type="text" id="form3Example1c" class="form-control" name="ac-name"/>
                                                            <label class="form-label" for="form3Example1c">Họ tên</label>
                                                        </div>
                                                    </div>

                                                    <div class="d-flex flex-row align-items-center mb-4">
                                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                                        <div class="form-outline flex-fill mb-0">
                                                            <input type="email" id="form3Example3c" class="form-control" name="ac-phonenumber"/>
                                                            <label class="form-label" for="form3Example3c">Số điện thoại</label>
                                                        </div>
                                                    </div>

                                                    <div class="d-flex flex-row align-items-center mb-4">
                                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                                        <div class="form-outline flex-fill mb-0">
                                                            <input type="email" id="form3Example4c" class="form-control" name="ac-username"/>
                                                            <label class="form-label" for="form3Example4c">Tài khoản</label>
                                                        </div>
                                                    </div>

                                                    <div class="d-flex flex-row align-items-center mb-4">
                                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                                        <div class="form-outline flex-fill mb-0">
                                                            <input type="password" id="form3Example5c" class="form-control" name="ac-pass"/>
                                                            <label class="form-label" for="form3Example5c">Mật khẩu</label>
                                                        </div>
                                                    </div>
                                                    <div class="d-flex flex-row align-items-center mb-4">
                                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                                        <div class="form-outline flex-fill mb-0">
                                                            <input type="password" id="form3Example4cd" class="form-control" name="ac-repass"/>
                                                            <label class="form-label" for="form3Example4cd">Mật khẩu</label>
                                                        </div>
                                                    </div>
                                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                                        <button type="button" class="btn btn-primary btn-lg">Đăng kí</button>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                                <img src="https://i.pinimg.com/originals/ca/2c/1e/ca2c1e381bfcd541d6355f5dc181dd04.jpg"
                                                     class="img-fluid" alt="Sample image">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>

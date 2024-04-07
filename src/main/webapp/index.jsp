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
                      <a href="http://localhost:8080/home?action=login" class="btn d-flex justify-content-center text-light btn-secondary" style="height: 40px">
                          <ion-icon name="person-circle-outline" style="width: 30px;height: 30px;"></ion-icon>
                          <p style="font-size: 20px" class="ml-1">Đăng nhập</p>
                      </a>
                  </div>
              </nav>
          </div>
       </div>
    </div>
    <div class="body">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <a href="">
                        <img class="d-block w-100" src="https://theme.hstatic.net/1000237375/1000756917/14/slider_item_6_image.jpg?v=1313" alt="First slide">
                    </a>
                </div>
                <div class="carousel-item">
                    <a href="">
                        <img class="d-block w-100" src="https://theme.hstatic.net/1000237375/1000756917/14/slider_item_4_image.jpg?v=1313" alt="Second slide">
                    </a>
                </div>
                <div class="carousel-item">
                    <a href="">
                        <img class="d-block w-100" src="https://theme.hstatic.net/1000237375/1000756917/14/slider_item_5_image.jpg?v=1313" alt="Third slide">
                    </a>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <div class="container">
             <div class="row">
                 <div class="container d-none w-40 h-40 position-absolute mx-auto" style=" top: 217px; ${loginmodal} ">
                     <div class="d-flex justify-content-center h-100">
                         <div class="card">
                             <div class="card-header">
                                 <h3>Sign In</h3>
                                 <div class="d-flex justify-content-end social_icon">
                                     <span><i class="fab fa-facebook-square"></i></span>
                                     <span><i class="fab fa-google-plus-square"></i></span>
                                     <span><i class="fab fa-twitter-square"></i></span>
                                 </div>
                             </div>
                             <div class="card-body">
                                 <form method="post" action="http://localhost:8080/home?action=doLogin">
                                     <div class="input-group form-group">
                                         <div class="input-group-prepend">
                                             <span class="input-group-text bg-primary"><i class="fas fa-user"></i></span>
                                         </div>
                                         <input type="text" name="username" class="form-control" placeholder="username">
                                     </div>
                                     <div class="input-group form-group">
                                         <div class="input-group-prepend">
                                             <span class="input-group-text bg-primary"><i class="fas fa-key"></i></span>
                                         </div>
                                         <input type="password" name="password"class="form-control" placeholder="password">
                                     </div>
                                     <div class="row align-items-center remember">
                                         <input type="checkbox">Remember Me
                                     </div>
                                     <div class="form-group">
                                         <input type="submit" value="Login" class="btn float-right login_btn bg-primary">
                                     </div>
                                 </form>
                             </div>
                             <div class="card-footer">
                                 <div class="d-flex justify-content-center links">
                                     Don't have an account?<a href="http://localhost:8080/Gradle___com_example___hauiProject_1_0_SNAPSHOT_war__exploded_/home?action=register">Sign Up</a>
                                 </div>
                                 <div class="d-flex justify-content-center">
                                     <a href="#">Forgot your password?</a>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
            <div class="col-4">

            </div>
            <div class="col-8">

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
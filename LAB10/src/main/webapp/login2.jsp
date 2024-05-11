<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio de Sesión</title>

        <!-- BOXICONS -->
        <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>
        <div class="form-container">
            <div class="col col-1">
                <div class="image-layer">
                    <img src="assets/img/white-outline.png" class="form-image-main">
                    <img src="assets/img/dots.png" class="form-image dots">
                    <img src="assets/img/coin.png" class="form-image coin">
                    <img src="assets/img/spring.png" class="form-image spring">
                    <img src="assets/img/rocket.png" class="form-image rocket">
                    <img src="assets/img/cloud.png" class="form-image cloud">
                    <img src="assets/img/stars.png" class="form-image stars">
                </div>
                <p class="featured-words">You Are Few Minutes Way To Boost Your Skills With <span>Ludiflex</span></p>
            </div>

            <div class="col col-2">
                <div class="btn-box">
                    <button class="btn btn-1" id="login">Sign In</button>
                    <button class="btn btn-2" id="register">Sign Up</button>
                </div>

                <!-- Login Form Container -->
                <form method="POST" action="<%=request.getContextPath()%>/Login" >
                    <div class="login-form">
                        <div class="form-title">
                            <span>Sign In</span>
                        </div>
                        <div class="form-inputs">
                            <div class="input-box">
                                <input type="text" class="input-field" placeholder="Username" id="nro_documento" name="nro_documento" required>
                                <i class="bx bx-user icon"></i>
                            </div>
                            <div class="input-box">
                                <input type="password" class="input-field" placeholder="Password" id="password" name="password" required>
                                <i class="bx bx-lock-alt icon"></i>
                            </div>
                            <%if(session.getAttribute("error")!=null){%>
                            <b class="text-error">Datos erróneos</b>
                            <% session.removeAttribute("error");
                            }%>
                            <div class="forgot-pass">
                                <a href="#">Forgot Password?</a>
                            </div>
                            <div class="input-box">
                                <button type="submit" class="input-submit">
                                    <span>Sign In</span>
                                    <i class="bx bx-right-arrow-alt"></i>
                                </button>
                            </div>
                        </div>
                        <div class="social-login">
                            <i class="bx bxl-google"></i>
                            <i class="bx bxl-facebook"></i>
                            <i class="bx bxl-twitter"></i>
                            <i class="bx bxl-github"></i>
                        </div>
                    </div>
                </form>

                <!-- Register Form Container -->
                <div class="register-form">
                    <div class="form-title">
                        <span>Create Account</span>
                    </div>
                    <div class="form-inputs">
                        <div class="input-box">
                            <input type="email" class="input-field" placeholder="Email" required>
                            <i class="bx bx-envelope icon"></i>
                        </div>
                        <div class="input-box">
                            <input type="text" class="input-field" placeholder="Username" required>
                            <i class="bx bx-user icon"></i>
                        </div>
                        <div class="input-box">
                            <input type="password" class="input-field" placeholder="Password" required>
                            <i class="bx bx-lock-alt icon"></i>
                        </div>
                        <div class="forgot-pass">
                            <a href="#">Forgot Password?</a>
                        </div>
                        <div class="input-box">
                            <button class="input-submit">
                                <span>Sign Up</span>
                                <i class="bx bx-right-arrow-alt"></i>
                            </button>
                        </div>
                    </div>
                    <div class="social-login">
                        <i class="bx bxl-google"></i>
                        <i class="bx bxl-facebook"></i>
                        <i class="bx bxl-twitter"></i>
                        <i class="bx bxl-github"></i>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/js/main.js"></script>
    </body>
</html>

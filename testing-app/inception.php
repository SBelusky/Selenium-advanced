<?php
?>
<!doctype html>
<html lang="en">
<?php include 'partials/head.php'; ?>
<style>
    @font-face {
        font-family: 'inception';
        src: url("assets/fonts/Inception_free.ttf");
    }

    h1, h2, h3 {
        font-family: inception, "sans-serif";

    }

    h3 {
        font-weight: 600;
    }

    h1 {
        font-size: 70px;
        color: #be2d2b;
        font-weight: 600;
    }

    .navbar-default .navbar-nav > li > a, .navbar-default .navbar-brand {
        font-family: inception, serif;
        color: #404272;
    }

    body::after {
        content: "";
        background: url("assets/img/inception_background.jpg") no-repeat center center fixed;
        opacity: 0.7;
        top: 0;
        left: 0;
        bottom: 0;
        right: 0;
        position: absolute;
        z-index: -1;
    }

    .btn {
        width: 220px;
        height: 220px;
        border-radius: 50%;
        text-align: center;
        margin: 0 auto;
        text-transform: uppercase;
        font-family: inception, serif;
        font-size: 20px;
        background-color: #be2d2b;
    }

    .btn:active:focus, .btn:focus {
        outline: none;
    }

    div.content {
        position: absolute;
        bottom: 150px;
        right: 250px;
    }


</style>
<body>
<?php include 'partials/navigation.php' ?>
<div class="container">
    <h1 class="text-center">We need to go deeper</h1>
    <div class="content">
        <div class="form">
            <button class="btn-danger btn btn-block" type="button" id="letsGoDeeper">Lets go deeper</button>
        </div>
    </div>
</body>
<script>
    $("#letsGoDeeper").click(function () {
        $("#letsGoDeeper").addClass("disabled");
        setTimeout(function () {
            var baseUrl = document.location.origin;
            window.open(baseUrl +"/inception2.php", "", "width=1200,height=900");
            $("#letsGoDeeper").removeClass("disabled");
        }, 1500);
    });
</script>
</html>

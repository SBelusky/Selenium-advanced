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

    input.form-control {
        border: 2px solid;
        border-color: #7e8e94 #a3b7bd #a3b7bd #7e8e94;
    }

    .content {
        margin: 180px auto;
    }

    h3.message {
        margin-top: 90px;
    }

    input {
        margin: 20px auto;
    }


</style>
<body>
<div class="container">
    <h1 class="text-center">DEEPER</h1>
    <div class="content">
        <div class="col-md-6 col-md-offset-3 text-center">
            <div class="form">
                <input type="text" class="form-control" id="message" placeholder="Leave a message">
                <input type="text" class="form-control" id="message" placeholder="Leave a message">
                <input type="text" class="form-control" id="message" placeholder="Leave a message">
            </div>
            <div class="form">
                <button class="btn-danger btn btn-block" type="button" id="letsGoDeeper">Lets go deeper</button>
            </div>
        </div>
        <div class="col-md-6 col-md-offset-3 text-center">
            <h3 class="message"></h3>
        </div>
    </div>
</div>

</body>
<script>

    $("#letsGoDeeper").click(function () {
        var baseUrl = document.location.origin;
        window.open(baseUrl+"/inception2.php", "", "width=1200,height=900");
    })
</script>
</html>

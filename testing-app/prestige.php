<?php
?>
<!doctype html>
<html lang="en">
<?php include 'partials/head.php'; ?>
<link href="https://fonts.googleapis.com/css?family=Cinzel:900" rel="stylesheet">
<body>
<?php include 'partials/navigation.php' ?>
<style>
    body {
        background-color: #0f1225;
    }

    h1, h2, .navbar-default .navbar-nav > li > a, .navbar-default .navbar-brand {
        font-family: 'Cinzel', serif;
        color: #404272;
    }

    h1 {
        text-transform: uppercase;
        font-size: 70px;
        font-weight: 600;
    }

    .navbar-default .navbar-nav > .active > a,
    .navbar-default .navbar-nav > .active > a:focus,
    .navbar-default .navbar-nav > .active > a:hover,
    .navbar-default .navbar-brand:focus, .navbar-default .navbar-brand:hover,
    .navbar-default .navbar-nav > li > a:hover {
        color: #6769aa;
        background: none;
    }

    img {
        margin-top: 30px;
    }
</style>
</body>
<div class="container">
    <div class="text-center">
        <h1>Prestige</h1>
        <h2>Are you watching closely?</h2>
        <div class="hat">
            <img src="assets/img/hat.png" alt="">
        </div>
    </div>
</div>
<script>
    $('img').click(function () {
        $(this).fadeOut(100);
        $(this).delay(2500).fadeIn(100);
//        setTimeout(function () {
//            $('.hat').append('<img src="assets/img/hat.png" alt="">');
//        }, 2500);
    })
</script>
</html>

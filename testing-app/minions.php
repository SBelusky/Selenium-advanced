<?php
?>
<!doctype html>
<html lang="en">
<?php include 'partials/head.php'; ?>
<link href="https://fonts.googleapis.com/css?family=Secular+One" rel="stylesheet">
<body>
<?php include 'partials/navigation.php' ?>
<style>
    body {
        background: url("assets/img/minions_background.jpg") no-repeat center center fixed;
        background-size: cover;
    }

    .navbar-default .navbar-nav > li > a, .navbar-default .navbar-brand {
        font-family: 'Secular One', sans-serif;
        color: #ffc832;
    }

    .navbar-default .navbar-nav > .active > a,
    .navbar-default .navbar-nav > .active > a:focus,
    .navbar-default .navbar-nav > .active > a:hover,
    .navbar-default .navbar-brand:focus, .navbar-default .navbar-brand:hover,
    .navbar-default .navbar-nav > li > a:hover {
        color: #c07b1a;
        background: none;
    }

    h1 {
        font-family: 'Secular One', sans-serif;
        font-size: 70px;
        font-weight: 600;
        color: #ffc832;
        text-shadow: 2px 2px #ec971f;
    }

    button.btn-warning {
        background-color: #ffc832;
        border: none;
        border-radius: 0;
        color: #825312;
    }

    input.form-control {
        border-radius: 0;
    }

    div.minions {
        list-style: none;
    }

    div.minions img {
        float: left;
        margin: 10px auto;
        width: 80px;
        height: 140px;
    }
</style>
</body>
<div class="container">
    <div class="text-center">
        <h1>minion time</h1>
        <div class="col-md-6 col-md-offset-3">
            <input type="number" class="form-control">
            <button class="btn btn-warning btn-block">Give me minions!</button>
        </div>
        <div class="col-md-10 col-md-offset-1">
            <div class="minions">
            </div>
        </div>
    </div>

</div>
<script>
    $('button').click(function () {
        for (i = 0; i < $('input').val(); i++) {
            setTimeout(function () {
                addMinion($('.minions'));
            }, 300 * i);
        }
    });

    function addMinion(element) {
        element.append('<li><img src="assets/img/minions/' + getRandomMinionImage() + '" alt=""></li>');
    }

    function getRandomMinionImage() {
        var number = Math.round(Math.random() * (9 - 1) + 1);
        return number + ".png"
    }
</script>
</html>

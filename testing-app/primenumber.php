<?php
?>
<!doctype html>
<html lang="en">
<?php include 'partials/head.php'; ?>
<link href="https://fonts.googleapis.com/css?family=Stalinist+One" rel="stylesheet">
<style>
    .navbar-default .navbar-nav > li > a, .navbar-default .navbar-brand {
        font-family: 'Stalinist One', cursive;
        color: #2d63c5;
        font-size: 15px;
    }

    .navbar-default .navbar-nav > .active > a,
    .navbar-default .navbar-nav > .active > a:focus,
    .navbar-default .navbar-nav > .active > a:hover,
    .navbar-default .navbar-brand:focus, .navbar-default .navbar-brand:hover,
    .navbar-default .navbar-nav > li > a:hover {
        color: #8c0f02;
        background: none;
    }

    body {
        background-color: #f0f0f0;
    }

    img {
        height: 500px;
    }

    button {
        font-family: 'Stalinist One', cursive;
    }

    .prime-form {
        margin-top: 150px;
        margin-bottom: 50px;
    }

    h1 {
        font-family: 'Stalinist One', cursive;
        font-size: 50px;
        color: #2d63c5;
    }

    div.result {
        font-family: 'Stalinist One', cursive;
        margin: 50px auto;
        font-size: 35px;
    }

    div.error {
        color: #8c0f02;
    }

    div.success {
        color: #2d63c5;
    }

    input.form-control, button.btn {
        border-radius: 0;
    }
</style>
<body>
<?php include 'partials/navigation.php' ?>
</body>
<div class="container">
    <h1 class="text-center">Optimus Prime</h1>
    <div class="col-md-6 col-md-offset-1">
        <div class="prime-form col-md-6 col-md-offset-3">
            <input type="number" class="form-control">
            <button class="btn btn-default btn-block btn-danger">Is it prime?</button>
        </div>
        <div class="result text-center"></div>
    </div>
    <div class="col-md-3 col-md-offset-1">
        <img src="assets/img/optimus.png" alt="">
    </div>
</div>

<script>
    $('button').click(function () {
        var result = $("div.result");

        result.text('').removeClass("error success");
        var input = $('input');
        setTimeout(function () {
            if (input.val()) {
                if (isPrime(input.val())) {
                    result.text("Optimus approves").addClass("success");
                } else {
                    result.text("Optimus is sad").addClass("error");
                }
            } else {
                result.text("Optimus is confused");
            }
        }, 500);


    });

    function isPrime(num) {
        for (var i = 2; i < num; i++)
            if (num % i === 0) return false;
        return num !== 1;
    }


</script>
</html>

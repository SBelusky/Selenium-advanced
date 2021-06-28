<?php
require_once '_inc/functions.php';
$data = load_data();
?>
<!doctype html>
<html lang="en">
<?php include 'partials/head.php'; ?>
<link href="https://fonts.googleapis.com/css?family=Kalam" rel="stylesheet">
<link rel="stylesheet" href="css/sparta.css">
<script>
    var baseURL = '<?php echo "/_inc/sin-city/" ?>';
</script>
<body>
<?php include 'partials/navigation.php' ?>
<div class="text-center">
  <h1>300</h1>
  <h2>hriechov hrmených</h2>
</div>
<div class="sins col-md-10 col-md-offset-1">
    <?php foreach ($data as $message): ?>
        <?php if (!$message->forgiven): ?>
        <article class="sin" id="<?php echo $message->id ?>">
          <header>
            <h4><?php echo $message->title ?><span><?php echo $message->creation_date ?></span></h4>
          </header>
          <p><?php echo $message->message ?></p>
          <footer>
            <h5><?php echo $message->author ?></h5>
            <button class="btn btn-danger" data-toggle="modal" data-target="#myModal"
                    data="<?php echo $message->id ?>">forgive
            </button>
          </footer>
        </article>
        <?php endif; ?>
    <?php endforeach ?>
</div>
<? include_once "partials/sparta/modal.php" ?>
</body>
<script src="js/bootstrap.min.js"></script>
<script>
    $('button').click(function () {
        var key = $(this).attr('data');
        $.ajax({
            url: baseURL + 'get-detail.php',
            data: {key: key},
            dataType: "json"
        })
            .done(function (data) {
                console.log(data);
                $('h4.modal-title').text(data.title);
                $('.modal-body p').text(data.message);
                $('#confirm').attr('data', data.id);
            })
            .fail(function (msg) {
                console.log(msg);
            })
            .always(function () {
            });
    });

    $('#confirm').click(function () {
        var key = $(this).attr('data');
        $.ajax({
            url: baseURL + 'forgive-sin.php',
            data: {key: key},
            type: 'POST',
            dataType: "json"
        })
            .done(function (data) {
                console.log(data);
                $("#myModal").modal('hide');
                $('article#' + data.id).hide();
            })
            .fail(function (msg) {
            })
            .always(function () {
            });
    })

</script>
</html>

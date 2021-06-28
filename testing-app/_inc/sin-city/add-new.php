<?php
require_once '../functions.php';
$data = load_data();

empty($data) ? $id = 0 : $id = (max($data)->id);
function validate()
{
    return (!empty(trim($_POST['message'])) && !empty(trim($_POST['title'])) && !empty(trim($_POST['author'])));
}


if (validate()) {
    $post = (object)[
        "id" => ++$id,
        "message" => $_POST['message'],
        "title" => $_POST['title'],
        "author"=>$_POST['author'],
        "forgiven" => false,
        "creation_date" => date("m.d.y"),
        "tags" =>$_POST['tag'],
    ];
    array_push($data, $post);
    save_file($data);
}
header("Location: /sincity.php");
die();
?>
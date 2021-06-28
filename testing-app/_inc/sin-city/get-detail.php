<?php
require_once '../functions.php';
$searched_id = $_GET['key'];
$data = load_data();
$desired_sin = null;
foreach ($data as $sin) {
    if ($searched_id == $sin->id) {
        $desired_sin = $sin;
    }
}
echo json_encode($desired_sin);

<?php
require_once '../functions.php';
$searched_id = $_POST['key'];
$data = load_data();
$desired_sin = null;
foreach ($data as $sin) {
    if ($searched_id == $sin->id) {
        $sin->forgiven = true;
        $desired_sin = $sin;
    }
}
save_file($data);
echo json_encode($desired_sin);

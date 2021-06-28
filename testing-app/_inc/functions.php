<?php

require_once 'config.php';

function load_data()
{
    global $file_path;
    return json_decode(file_get_contents($file_path));
}

function save_file($data)
{
    global $file_path;
    file_put_contents($file_path, json_encode($data));
}

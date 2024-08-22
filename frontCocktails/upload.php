<?php
$targetDir = "./frontCocktails/ima";
$targetFile = $targetDir . basename($_FILES["image"]["name"]);
$response = array();

if (move_uploaded_file($_FILES["image"]["tmp_name"], $targetFile)) {
    $response["status"] = "success";
    $response["filePath"] = $targetFile;
} else {
    $response["status"] = "error";
    $response["message"] = "There was an error uploading the file.";
}

echo json_encode($response);
?>

<!DOCTYPE html>
<html>
<head>
    <title>FREESPACE</title>
</head>
<body>
<h1>Файлы ${box.name}:</h1><br>
<#list box.files as file>
    <p>[${file.id}]- ${file.originalFileName}</p>
</#list>
</body>
</html>
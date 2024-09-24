<!DOCTYPE html>
<html>
<head>
    <title>FREESPACE</title>
</head>
<body>
<h1>Список коробок:</h1><br>
<#list boxes as box>
    <div>
        <p>[${box.id}] ${box.name}, ${box.author}. <a href="/box/${box.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Коробок нет</h3>
</#list>

<hr>
<h3>Создать коробку</h3>
<form action="/box/create" method="post" enctype="multipart/form-data">
    Название: <input type="text" name="name"/><br><br>
    Автор: <input type="text" name="author"/><br><br>

    <input type="submit" value="Добавить товар"/>
</form>


</body>
</html>

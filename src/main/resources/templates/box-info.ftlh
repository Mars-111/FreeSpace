<!DOCTYPE html>
<html>
<head>
    <title>FREESPACE</title>
</head>
<body>
    <h1>Информация о ${box.name}:</h1><br>
    <p>Автор: ${box.user.name}</p>
    <p>дата создания: ${box.dateOfCreated}</p>
    <br><br>
    <h1>Файлы ${box.name}:</h1><br>
    <#list box.files as file>
        <p>[${file.id}]- ${file.originalFileName}</p>
        <form action="/files/${file.id}" method="get">
            <input type="submit" value="Открыть"/>
        </form>
        <#if file.getContentType()?contains("text")>
            <form action="/files/edit/${file.id}" method="get">
                <input type="submit" value="Реадктировать"/>
            </form>
        </#if>
    </#list>
    <br><br>
    <form action="/box/${box.id}/create-file" method="post" enctype="multipart/form-data">
        Файл: <input type="file" name="file"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить файл"/>
    </form>

</body>
</html>
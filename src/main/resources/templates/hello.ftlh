Hello
<h3>Создать коробку</h3>
<form action="/box/create" method="post" enctype="multipart/form-data">
    Название: <input type="text" name="name"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить товар"/>
</form>
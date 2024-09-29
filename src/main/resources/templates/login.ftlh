<!DOCTYPE html>
<html>
<head>
    <title>FREESPACE</title>
</head>
<body>
<h1>FREESPACE</h1><hr>
<h4>Вход</h4>
<form action="/login" method="post">
    Эл. почта: <input type="email" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form>
<a href="/registration">Зарегестрироваться</a>
</body>
</html>
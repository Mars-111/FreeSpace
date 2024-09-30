<!DOCTYPE html>
<html>
<head>
    <style>
        textarea {
            background: #fce9c0; /* Цвет фона */
            border: 2px solid #a9c358; /* Параметры рамки */
            padding: 10px; /* Поля */
            width: 100%; /* Ширина */
            height: 800px; /* Высота */
            box-sizing: border-box; /* Алгоритм расчёта ширины */
            font-size: 14px; /* Размер шрифта */
        }
    </style>
    <title>FREESPACE</title>
</head>
<body>
<h1>${file.originalFileName}:</h1><br>


<form action="/files/edit/${file.id}/save_edit" method="post">
    <textarea name="content" id="myTextArea">${content}</textarea>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit">Готово</button>
</form>




</body>
</html>
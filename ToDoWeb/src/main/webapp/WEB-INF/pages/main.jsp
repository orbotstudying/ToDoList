<%--
  Created by IntelliJ IDEA.
  User: orbot
  Date: 17.06.15
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Планировщик задач</title>
  <script>
    function linkClicked() {
      document.getElementById('makenewtask').style.display = 'block';
      return false;
    }
  </script>
  <meta charset="utf-8" />
</head>
<body>
<h1>Добро пожаловать в планировщик задач!</h1>
<p>Здесь вы можете задать себе <a href="#" onclick="linkClicked()">новое задание</a><br />
или посмотреть существующий <a href="${pageContext.request.contextPath}/tasks">список дел.</a></p>
<div id="makenewtask" style="display:none;">
  <form action="${pageContext.request.contextPath}/main" method="post" accept-charset="UTF-8">
    <label for="todo">Что сделать:</label>
    <input id="todo" name="todo" type="text" size="40" />
    <input type="submit" value="Создать задание" />
  </form>
</div>
</body>
</html>

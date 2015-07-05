<%--
  Created by IntelliJ IDEA.
  User: orbot
  Date: 14.06.15
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница входа</title>
</head>
<body>
<form action="${pageContext.request.contextPath}" method="post" accept-charset="UTF-8">
  <label for="login">Логин:</label>
  <input id="login" name="login" type="text" size="20" />
  <br />
  <label for="password">Пароль:</label>
  <input id="password" name="password" type="password" size="20" />
  <br/>
  <input type="submit" value="Войти" />
</form>
<a href="/join">Зарегистрироваться</a>
</body>
</html>

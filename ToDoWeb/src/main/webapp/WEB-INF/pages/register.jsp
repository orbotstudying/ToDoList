<%--
  Created by IntelliJ IDEA.
  User: orbot
  Date: 17.06.15
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
  <script>
    function join() {
      if(document.getElementById('password').value != document.getElementById('passwordagain').value) {
        document.getElementById('notcorrect').style.display = "block";
        return true;
      }
    }
  </script>
</head>
<body>
<form action="${pageContext.request.contextPath}" method="post" onsubmit="if(join()) return false;">
  <label for="username">Введите логин:</label>
  <input id="username" name="username" type="text" size="15" />
  <br />
  <label for="password">Введите пароль:</label>
  <input id="password" name="password" type="password" size="15" />
  <br />
  <label for="passwordagain" type="password">Введите пароль повторно:</label>
  <input type="password" id="passwordagain" size="15" />
  <br />
  <input type="submit" value="Зарегистрироваться" />
  <br />
  <div id="notcorrect" style="display: none; color: red;">Пароли не совпадают</div>
</form>
</body>
</html>

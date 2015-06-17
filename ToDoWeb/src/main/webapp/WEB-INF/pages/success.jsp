<%--
  Created by IntelliJ IDEA.
  User: orbot
  Date: 14.06.15
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вы успешно зашли</title>
</head>
<body>
<p>Поздравляю! Вы залогинились!
Сейчас вас кинет на главную страницу</p>
<script language="JavaScript" type="text/javascript">
  function reDirect(){
    document.location.href="/main";
  }
  setTimeout( 'reDirect()', 1000 );
</script>
</body>
</html>

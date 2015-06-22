<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="tasks.Task" %>
<%--
  Created by IntelliJ IDEA.
  User: orbot
  Date: 22.06.15
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Задания</title>
</head>
<body>
<%List tasks = (List)request.getAttribute("tasks");
for(Iterator it = tasks.iterator(); it.hasNext(); ) {%>
<p>Необходимо: <%Task task = (Task)it.next();
  out.print(task.getName());%> <br />
  Задано: <%out.print(task.getStarted());%>
</p>
<%}%>
</body>
</html>

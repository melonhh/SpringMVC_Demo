<%@ page import="cn.melon.model.User" %><%--
  User: Administrator
  Date: 2020/4/7
  Time: 15:17
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>success</title>
</head>
<body>
success!!
<%=((User)request.getAttribute("user")).getUsername()%>

</body>
</html>

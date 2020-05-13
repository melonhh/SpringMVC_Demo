<%--
  User: Administrator
  Date: 2020/4/7
  Time: 8:28
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>
hello world
<a href="${s:mvcUrl('IC#index').arg(0,'123').build()}">test name 参数</a>

<%--<form action="${s:mvcUrl('IC#addUser').build()}" method="post">--%>
<%--    <input type="text" name="username"/>--%>
<%--    <input type="password" name="password"/>--%>
<%--    <input type="submit" value="提交"/>--%>
<%--</form>--%>
</body>
</html>

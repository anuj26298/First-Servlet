<%--
  Created by IntelliJ IDEA.
  User: ANUJ
  Date: 7/29/2021
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h3>Hello, <%= request.getAttribute("user") %>Login Successful</h3>
<a href="login.html">Login Page</a>
</body>
</html>

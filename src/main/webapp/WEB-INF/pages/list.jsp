<%--
  User: Mr.Yu
  Date: 2021/7/22
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>查询了所有的账户信息</h2>
<c:forEach items="${list}" var="account">
    ${account.name}
</c:forEach>
</body>
</html>

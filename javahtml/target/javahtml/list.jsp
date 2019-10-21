<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 三金
  Date: 2019/10/18
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table align="center" border="1" cellpadding="10" >
    <tr>
        <th>用户名</th>
        <th>密码</th>
    </tr>
    <c:forEach var="user" items="${users}" varStatus="status">
        <tr>
            <td>${user.name}</td>
            <td>${user.pwd}</td>
            <td>
                <button onclick="" value="修改">修改</button>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

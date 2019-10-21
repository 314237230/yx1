<%--
  Created by IntelliJ IDEA.
  User: 三金
  Date: 2019/10/18
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updata</title>
</head>
<body>
<form action="/update" name="updateForm" id="loginForm" method="post" onsubmit="return l(this)">
<table>
    <tr align="center">
        <td><span style="color: red;">用户修改</span></td>
    </tr>
    <tr>
        <td>用户名：</td>
        <td>
            <input id="name" type="text" name="username" onblur="validate();" value="${user.name}"/>
            <span id="id1" style="color: red"></span>
        </td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><input id="pwd" type="text" name="pwd" value="${user.pwd}"></td>
        <span id="id2" style="color: red"></span>
    </tr>
    <tr>
        <td><button id="login">修改</button></td>
        <td><input type="reset" value="重置"></td>
    </tr>
</table>
</form>
</body>
</html>

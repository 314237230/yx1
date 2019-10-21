<%--
  Created by IntelliJ IDEA.
  User: 三金
  Date: 2019/10/17
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="login" name="loginform" id="loginform" method="post" onsubmit="return l(this)">
<table>
    <tr align="center">
        <td><span style="color: blue">用户登录</span> </td>
    </tr>
    <tr>
        <td>用户名：</td><td><input id="name" type="text" name="name"><span id="id1" style="color: red"></span> </td>
    </tr>
    <tr>
        <td>密码：</td><td><input id="pwd" type="password" name="pwd"><span id="id2" style="color: red"></span></td>
    </tr>
    <tr>
        <td><input type="submit" value="登录"></td>
        <td><input type="reset" value="重置"></td>
    </tr>
</table>
</form>
</body>
<script type="text/javascript">
    function l(form) {
        with (form) {
            var name = document.getElementById("name");
            var pwd = document.getElementById("pwd");
            var zz1 = /^[^ ]+$/;
            var end = true;
            var s1=null;
            s1 = document.getElementById("id1");
            s1.innerText = "";
            s1 = document.getElementById("id2");
            s1.innerText = "";
            if (!name.value) {
                s1 = document.getElementById("id1");
                s1.innerText = "*请输入用户名*";
                end = false;
            } else if (!zz1.test(name.value)) {
                s1 = document.getElementById("id1");
                s1.innerText = "*用户名不能有空格*";
                end = false;
            }
            if (!pwd.value) {
                s1 = document.getElementById("id2");
                s1.innerText = "*请输入密码*";
                end = false;
            }
            return end;
        }
    }
</script>
</html>

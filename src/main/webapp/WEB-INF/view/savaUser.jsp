<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/4/10
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加信息</h1>
<form action="saveUsers.do" method="post">
<table>
    <tr>
        <td>
            姓名：
        </td>
        <td>
            <input  type="text" name="username">
        </td>
    </tr>
    <tr>
        <td>
            密码：
        </td>
        <td>
            <input  type="text" name="password">
        </td>
    </tr>
    <tr>
        <td>
            年龄：
        </td>
        <td>
            <input  type="text" name="age">
        </td>
    </tr>

</table>
    <input type="submit" value="添加">
</form>
</body>
</html>

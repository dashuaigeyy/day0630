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
给${us.username}修改信息
<form action="updateUser.do" method="post">
    <input value="${us.id}" type="hidden" name="id">
<table>
    <tr>
        <td>
            姓名：
        </td>
        <td>
            <input value="${us.username}" type="text" name="username">
        </td>
    </tr>
    <tr>
        <td>
            密码：
        </td>
        <td>
            <input value="${us.password}" type="text" name="password">
        </td>
    </tr>
    <tr>
        <td>
            年龄：
        </td>
        <td>
            <input value="${us.age}" type="text" name="age">
        </td>
    </tr>

</table>
    <input type="submit" value="修改">
</form>
</body>
</html>

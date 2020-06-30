<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../js/jquery-1.8.2.js"></script>
</head>
<body>
        <table>
            <tr>
                <th>编码</th>
                <th>姓名</th>
                <th>密码</th>
                <th>年龄</th>
                <th>生日</th>
                <th>操作</th>
            </tr>
            <c:forEach var="u" items="${list}">
                <tr>
                    <td>
                        ${u.id}
                    </td>
                    <td>
                            ${u.username}
                    </td>
                    <td>
                            ${u.password}
                    </td>
                    <td>
                            ${u.age}
                    </td>
                    <td>
                            ${u.birthday}
                    </td>
                    <td>
                        <a href="deleteUser.do?id=${u.id}"><button>删除</button></a>
                        <a href="toupdateUser.do?id=${u.id}"><button>修改</button></a>
                    </td>
                </tr>
            </c:forEach>
            <a href="tosavaUser.do"><button>添加</button></a>
        </table>


</body>
</html>

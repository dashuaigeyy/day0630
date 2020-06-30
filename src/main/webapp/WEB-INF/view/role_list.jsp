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
</head>
<body>
        <table>
            <tr>
                <th>编码</th>
                <th>职位</th>
                <th>操作</th>
            </tr>
            <c:forEach var="d" items="${list}">
                <tr>
                    <td>
                        ${d.rid}
                    </td>
                    <td>
                            ${d.rname}
                    </td>
                    <td>
                        <a href="findAllByrid.do?rid=${d.rid}"><button>选择部门</button></a>
                        <a href="toRolePower.do?rid=${d.rid}"><button>分配权限</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>

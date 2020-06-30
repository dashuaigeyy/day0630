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
                <th>部门</th>
                <th>角色</th>
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
                            ${u.deptBean.dname}
                    </td>
                    <td>
                            ${u.roleBean.rname}
                    </td>
                    <td>
                        <a href="toUserDeptRole.do?id=${u.id}"><button>给员工分配部门和角色</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/10
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="updateRole.do" method="post">
        <h1>目前正在给--${rb.rname}--角色选择部门</h1>
        <input type="hidden" name="rid" value="${rb.rid}"/>
        <c:forEach var="r" items="${list}">

            <input type="checkbox" name="deptids" value="${r.deptid}" ${r.deptid==rb.rid?'checked':''}>${r.dname}<br>
        </c:forEach>
        <input type="submit" value="保存">
    </form>
</body>
</html>

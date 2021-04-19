<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: simple
  Date: 2021/4/18
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
    <table>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>gender</td>
            <td>email</td>
            <td>dId</td>
        </tr>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.gender}</td>
                <td>${employee.email}</td>
                <td>${employee.DId}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<%@ page import="employee.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: jeremymoudy
  Date: 2/2/22
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
    <link href="../resources/styles.css" rel="stylesheet" type="text/css">

    <%
        session.setMaxInactiveInterval(2);
    %>

    <style>
        table, tr, td, th {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
        }

        table.table {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<div class="container" align="center">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Employee Salary</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Employee> employeeList = (ArrayList<Employee>) request.getAttribute("employeeList");
            for (Employee e : employeeList) { %>
        <tr>
            <td><%=e.getId()%></td>
            <td><%=e.getName()%></td>
            <td><%=e.getSalary()%></td>
        </tr>
        <%}%>

        </tbody>
    </table>
</div>
&nbsp;&nbsp;&nbsp;
<div class="home" align="center">
    <a href="../index.jsp"><button>Return Home</button></a>
</div>
</body>
</html>

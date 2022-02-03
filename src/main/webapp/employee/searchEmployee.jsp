<%@ page import="employee.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: jeremymoudy
  Date: 1/5/22
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form action="../employee/search" method="post">
    <label>Employee ID:</label>
    <input type="text" id="id" name="empID"> <br> <br>

    <input type="submit" value="Search">
</form>
<br> <br>
<a href="../index.jsp"><button>Return Home</button></a>

<div class="result">
    <%
        Employee employee = (Employee) request.getAttribute("emp");
    %>
    <%=request.getAttribute("id")%>
    <%=request.getAttribute("name")%>
    <%=request.getAttribute("salary")%>
</div>
</body>
</html>

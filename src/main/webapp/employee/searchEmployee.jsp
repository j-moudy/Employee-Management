<%@ page import="employee.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>

    <%
        session.setMaxInactiveInterval(2);
    %>
</head>
<body>
<form action="../employee/search" method="get">
    <label>Employee ID:</label>
    <input type="text" id="id" name="empID"> <br> <br>
    <input type="submit" value="Search">
</form>
<br> <br>
<a href="../index.jsp"><button>Return Home</button></a>

<div class="result">
    <%=request.getAttribute("id")%>
    <%=request.getAttribute("name")%>
    <%=request.getAttribute("salary")%>
</div>
</body>
</html>

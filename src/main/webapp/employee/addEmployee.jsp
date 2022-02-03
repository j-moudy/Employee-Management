<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jeremymoudy
  Date: 1/5/22
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Add Employee</title>
    <link href="../resources/styles.css" rel="stylesheet" type="text/css">

    <%
        session.setMaxInactiveInterval(2);
    %>
    <script type="text/javascript" >
        var msg = '<%=session.getAttribute("getAlert")%>';
        if (msg !== "null") {
            function alertName() {
                alert("Success!");
            }
        }
    </script>
</head>
<body>
<form action="../employee/add" method="post">
    <label>Employee ID:</label>
    <input type="text"  id="id" name="empID"> <br>

    <label>Name:</label>
    <input type="text"  id="name" name="empName" value=""> <br>

    <label>Salary:$</label>
    <input type="text"  id="salary" name="empSalary" value=""> <br> <br>

    <input type="submit" value="Add Employee">
</form>
<script type="text/javascript">window.onload = alertName; </script>

<a href="../index.jsp"><button>Return Home</button></a>

</body>
</html>

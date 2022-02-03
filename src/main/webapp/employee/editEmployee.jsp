<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="../employee/edit" method="post">
    <label>ID of employee to update:</label>
    <input type="text"  id="id" name="empID"> <br>

    <label>Name:</label>
    <input type="text"  id="name" name="empName" value=""> <br>

    <label>Salary:$</label>
    <input type="text"  id="salary" name="empSalary" value=""> <br> <br>

    <input type="submit" value="Update Employee">
</form>
<script type="text/javascript">window.onload = alertName; </script>

<a href="../index.jsp"><button>Return Home</button></a>
</body>
</html>
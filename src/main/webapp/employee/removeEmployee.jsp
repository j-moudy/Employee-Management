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
    <title>Remove Employee</title>
    <link href="../resources/styles.css" rel="stylesheet" type="text/css">

    <%
        session.setMaxInactiveInterval(2);
    %>
    <script type="text/javascript">
        var msg = '<%=session.getAttribute("getAlert")%>';
        if (msg !== "null"){
            function alertName() {
                alert("Success!");
            }
        }
    </script>
</head>
<body>
<form action="../employee/remove" method="post">
    <label>Employee ID:</label>
    <input type="text" id="id" name="empID"> <br> <br>

    <input type="submit" value="Remove Employee">
</form>
<script type="text/javascript">window.onload = alertName;</script>

<a href="../index.jsp"><button>Return Home</button></a>
</body>
</html>

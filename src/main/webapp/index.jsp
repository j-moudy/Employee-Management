<html>
<head>
    <title>Employee Management</title>
    <link href="resources/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3>Select an option:</h3>
<div class="buttons">
    <a href="employee/addEmployee.jsp"><button>Add Employee</button></a>
    <a href="employee/searchEmployee.jsp"><button>Search for Employee</button></a>
    <a href="employee/removeEmployee.jsp"><button>Delete Employee</button></a>
    <a href="editEmployee.jsp"><button>Edit Employee</button></a>
    <form action="employee/list" method="post">
        <input type="submit" value="List Employees"/>
    </form>
</div>
</body>
</html>

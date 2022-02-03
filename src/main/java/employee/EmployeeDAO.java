package employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private String url = "jdbc:mysql://localhost:3306/business-management";
    private String username = "root";
    private String password = "rootpass";

    private Connection connection;

    // SQL statements
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO EMPLOYEE VALUES (?,?,?)";
    private static final String SELECT_EMPLOYEE_BY_ID_SQL = "SELECT ID, NAME, SALARY FROM EMPLOYEE WHERE ID = ?";
    private static final String SELECT_ALL_EMPLOYEE_SQL = "SELECT * FROM EMPLOYEE";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM EMPLOYEE WHERE ID = ?";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE EMPLOYEE SET NAME = ?, SALARY = ? WHERE ID = ?";

    public EmployeeDAO() {
        Connection connection = getConnection();
    }

    protected Connection getConnection () {
        System.out.println("Connecting to database...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        }
        catch (ClassNotFoundException e){
            throw new IllegalStateException("Cannot find the driver in the classpath", e);
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");
            return connection;
        }
        catch (SQLException e){
            throw new IllegalStateException("Could not connect to database", e);
        }
    }


    public void insertEmployee (Employee employee) {
        Connection connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDouble(3, employee.getSalary());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new IllegalStateException("Error inserting into database", e);
        }
    }
    public void deleteEmployee (int id) {
        Connection connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new IllegalStateException("Error deleting from database", e);
        }
    }

    public List<Employee> selectAllEmployees(){
        List<Employee> employeeList = new ArrayList<Employee>();
        Connection connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                employeeList.add(new Employee(id, name, salary));
            }
        }
        catch (SQLException e){
            throw new IllegalStateException("Error selecting all employees", e);
        }

        return employeeList;
    }

    public Employee selectEmployeeByID(int id) {
        Connection connection = getConnection();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int empID = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double salary = resultSet.getDouble(3);
                employee = new Employee(empID, name, salary);
            }
        }
        catch (SQLException e){
            throw new IllegalStateException("Error selecting all employees", e);
        }
        return employee;
    }

    public void editEmployee(Employee employee) {
        Connection connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setInt(3, employee.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new IllegalStateException("Could not update employee", e);
        }
    }
}

package employee;

import java.sql.*;

public class EmployeeDAO {
    private String url = "jdbc:mysql://localhost:3306/business-management";
    private String username = "root";
    private String password = "rootpass";

    private Connection connection;

    // SQL statements
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO EMPLOYEE VALUES (?,?,?)";
    private static final String SELECT_EMPLOYEE_BY_ID_SQL = "SELECT ID, NAME, SALARY FROM EMPLOYEE WHERE ID = ?";
    private static final String SELECT_ALL_EMPLOYEE_SQL = "SELECT * FROM EMPLOYEE";

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

}

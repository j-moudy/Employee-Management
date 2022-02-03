package employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID= 1L;

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public EmployeeServlet() {super ();}

    /**
     * The doPost method is used for inserting/updating date into the database.
     * @param request Request from the client.
     * @param response Response from the server.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // HttpSession is used for interacting with the client.
        HttpSession session = request.getSession();
        String action = request.getServletPath();

        switch (action) {
            case "/employee/add":
                int id = Integer.parseInt(request.getParameter("empID"));
                String name = request.getParameter("empName");
                double salary = Double.parseDouble(request.getParameter("empSalary"));
                Employee employee = new Employee(id, name, salary);

                employeeDAO.insertEmployee(employee);
                session.setAttribute("getAlert", "success");
                response.sendRedirect("addEmployee.jsp");
                break;
            case "/employee/remove":
                employeeDAO.deleteEmployee(Integer.parseInt(request.getParameter("empID")));
                session.setAttribute("getAlert", "success");
                response.sendRedirect("removeEmployee.jsp");
                break;

            case "/employee/edit":
                int editID = Integer.parseInt(request.getParameter("empID"));
                String editName = request.getParameter("empName");
                double editSalary = Double.parseDouble(request.getParameter("empSalary"));
                Employee editEmp = new Employee(editID, editName, editSalary);

                employeeDAO.editEmployee(editEmp);
                session.setAttribute("getAlert", "success");
                response.sendRedirect("editEmployee.jsp");
                break;
        }
    }

    /**
     * The doGet method is used retrieve remote data for displaying to the client.
     * @param request Request from the client.
     * @param response Response from the server.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getServletPath();

        if (action.equals("/employee/search")){
            Employee emp = employeeDAO.selectEmployeeByID(Integer.parseInt(request.getParameter("empID")));
            request.setAttribute("id", emp.getId());
            request.setAttribute("name", emp.getName());
            request.setAttribute("salary", emp.getSalary());
            request.getRequestDispatcher("searchEmployee.jsp").forward(request, response);
        }
        else {
            List<Employee> employeeList = employeeDAO.selectAllEmployees();
            request.setAttribute("employeeList", employeeList);
            request.getRequestDispatcher("listEmployee.jsp").forward(request, response);
        }
    }
}
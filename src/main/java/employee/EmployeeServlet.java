package employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID= 1L;

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public EmployeeServlet() {super ();}

    /**
     * The doPost method is used for getting data from the front end to store in the db.
     * @param request Request from the front end to the back end.
     * @param response Response from the back end to the front end.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Get the current session information to be used for sending response back to the front end
        HttpSession session = request.getSession();

        // Parameters received from the font end
        int id = Integer.parseInt(request.getParameter("empID"));
        String name = request.getParameter("empName");
        double salary = Double.parseDouble(request.getParameter("empSalary"));
        Employee employee = new Employee(id, name, salary);

        String action = request.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/employee/add":
                employeeDAO.insertEmployee(employee);
                session.setAttribute("getAlert", "success");
                response.sendRedirect("addEmployee.jsp");
                break;
            case "/employee/delete":
                employeeDAO.deleteEmployee(employee);
                break;

        }

    }


    /**
     * The doGet method is used for sending data from the db to the font end for displaying to the user
     */
}
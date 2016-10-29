package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import connections.ConnectionUtils;
import model.Employee;
import service.EmployeeService;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeService employeeService;

//	@Override
//	public void init() throws ServletException {
//		employeeService = new EmployeeService();
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ConnectionUtils cu = new ConnectionUtils();
		Connection conn = null;
		
		try {
			conn = cu.connection();
			new EmployeeService(conn, request)
					.insertEmployee(new Employee(-1, request.getParameter("name"), request.getParameter("surname"),
							request.getParameter("position"), Integer.parseInt(request.getParameter("salary"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("/webapp04/employees");
	}
	
}

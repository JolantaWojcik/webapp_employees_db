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

import beans.MyUtils;
import model.Employee;
import service.EmployeeService;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeService employeeService;

	@Override
	public void init() throws ServletException {
		employeeService = new EmployeeService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		Connection conn = MyUtils.getStoredConnection(request);
		 
		try {
			employeeService = new EmployeeService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String name = request.getParameter("name");
//		String surname = request.getParameter("surname");
//		String position = request.getParameter("position");
//		int salary = Integer.parseInt(request.getParameter("salary"));
		
		//employeeService.addEmployee(new Employee(name, surname, position, salary));
		
		response.sendRedirect("/webapp04/");
	}

}

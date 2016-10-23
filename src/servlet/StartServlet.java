package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.MyUtils;
import model.Employee;
import service.EmployeeService;

@WebServlet("/")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;

	@Override
	public void init() throws ServletException {
		employeeService = new EmployeeService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  Connection conn = MyUtils.getStoredConnection(request);
		  
	        String errorString = null;
	        List<Employee> list = null;
	        try {
	            list = employeeService.queryEmployees(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	   
	        // Store info in request attribute, before forward to views
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("empsLis", list);
	        
	        // Forward to /WEB-INF/...
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/pages/mainForm.jsp");
	        dispatcher.forward(request, response);
	}
}

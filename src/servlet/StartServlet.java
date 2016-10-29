package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
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

import connections.ConnectionUtils;
import model.Employee;
import service.EmployeeService;


@WebServlet("/")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ConnectionUtils cu = new ConnectionUtils();
		Connection conn = null;
		
		try {
			 conn = cu.connection();
			request.setAttribute("empsList", new EmployeeService(conn, request).queryEmployees());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("mainForm.jsp");
		rd.forward(request, response);
	}
	
}

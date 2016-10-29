package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connections.ConnectionUtils;
import model.AppUser;
import service.AppUserService;
import service.EmployeeService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Override
//	public void init() throws ServletException {
//		appUserService = new AppUserService();
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//INSERT INTO `zajecia`.`user_accounts` (`id`, `user_name`, `pass`) VALUES ('1', 'admin', 'admin');
		ConnectionUtils cu = new ConnectionUtils();
		Connection conn = null;

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		AppUser user = null;
		String user_name = null;
		try {
			conn = cu.connection();
			user = new AppUserService(conn, request).findUser(login, password);
			request.setAttribute("appUser", user.getLogin());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("appUser", user.getLogin());
		
		RequestDispatcher rd = request.getRequestDispatcher("mainForm.jsp");
		rd.forward(request, response);
		
		//response.sendRedirect("/webapp04/");	
		
//		response.setContentType("text/html");
//		response.getWriter().println("<b>Wynik to: " + user.getLogin() + "</b>");
	}

}

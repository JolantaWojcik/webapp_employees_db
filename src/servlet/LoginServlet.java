package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MyUtils;
import model.AppUser;
import service.AppUserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AppUserService appUserService;

	@Override
	public void init() throws ServletException {
		appUserService = new AppUserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 Connection conn = MyUtils.getStoredConnection(request);

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		AppUser user = null;
		try {
			user = appUserService.findUser(conn, login, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("appUser", user);
		
		response.sendRedirect("/webapp04/");
		
	}

}

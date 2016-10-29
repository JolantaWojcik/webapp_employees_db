package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.AppUser;
import model.Employee;

public class AppUserService {
	
	private static Connection connection;
	private HttpServletRequest request;

	public AppUserService(Connection connection, HttpServletRequest request) {
		this.connection = connection;
		this.request = request;
	}
	
	 public static AppUser findUser(String userName, String pass) throws SQLException {
		 //INSERT INTO `zajecia`.`user_accounts` (`id`, `user_name`, `pass`) VALUES ('1', 'admin', 'admin');
		 StringBuilder sql = new StringBuilder("Select * from user_accounts"
				 + " where user_name = ? and pass= ?");

		 PreparedStatement pstm = connection.prepareStatement(sql.toString());
		 pstm.setString(1, userName);
		 pstm.setString(2, pass);
		 ResultSet rs = pstm.executeQuery();
		 AppUser user = new AppUser(); 
		   
		 if (rs.next()) {
			 user.setLogin(userName);
			 user.setPassword(pass);
		 }
		 rs.close();
		 pstm.close();
		 return user;
	 }
	     
}

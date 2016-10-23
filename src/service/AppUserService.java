package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AppUser;

public class AppUserService {
//	private static ArrayList<AppUser> DATABASE = new ArrayList<>();
//	static {
//		DATABASE.add(new AppUser("admin", "admin"));
//		DATABASE.add(new AppUser("test", "test"));
//	}
//
//	public AppUser findByLoginAndPassword(String login, String password) {
//		return DATABASE.stream().filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
//				.findFirst().orElse(null);
//	}
	
	 public static AppUser findUser(Connection conn, String userName, String password) throws SQLException {
		 
	      String sql = "Select a.user_name, a.password from user_account a "
	              + " where a.user_name = ? and a.password= ?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, userName);
	      pstm.setString(2, password);
	      ResultSet rs = pstm.executeQuery();
	 
	      if (rs.next()) {
	          AppUser user = new AppUser();
	          user.setLogin(userName);
	          user.setPassword(password);
	          return user;
	      }
	      return null;
	  }
	 
	  public static AppUser findUser(Connection conn, String userName) throws SQLException {
	 
	      String sql = "Select a.User_Name, a.Password from User_Account a " + " where a.User_Name = ? ";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, userName);
	 
	      ResultSet rs = pstm.executeQuery();
	 
	      if (rs.next()) {
	    	  String login = rs.getString("login");
	          String password = rs.getString("password");
	          AppUser user = new AppUser();
	          user.setLogin(login);
	          user.setPassword(password);
	          return user;
	      }
	      return null;
	  }

}

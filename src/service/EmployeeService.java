package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Employee;

public class EmployeeService {
	
	public static List<Employee> queryEmployees(Connection conn) throws SQLException {
		//czy employees
	      String sql = "Select a.name, a.surname, a.position, a.salary from employees a";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      ResultSet rs = pstm.executeQuery();
	      List<Employee> list = new ArrayList<Employee>();
	      while (rs.next()) {
	          String name = rs.getString("name");
	          String surname = rs.getString("surname");
	          String position = rs.getString("position");
	          int salary = rs.getInt("salary");
	          Employee e = new Employee();
	          e.setName(name);
	          e.setSurname(surname);
	          e.setPosition(position);
	          e.setSalary(salary);
	          list.add(e);
	      }
	      return list;
	  }
	 
	  public static Employee findEmployee(Connection conn, String name) throws SQLException {
	      String sql = "Select a.name, a.surname, a.position, a.salary from employees a where a.name=?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, name);
	 
	      ResultSet rs = pstm.executeQuery();
	 
	      while (rs.next()) {
	          name = rs.getString("name");
	          String surname = rs.getString("surname");
	          String position = rs.getString("position");
	          int salary = rs.getInt("salary");
	          Employee e = new Employee(name, surname, position, salary);
	          return e;
	      }
	      return null;
	  }
	 
	  public static void insertEmployee(Connection conn, Employee emp) throws SQLException {
	      String sql = "Insert into employees(name, surname, position, salary) values (?,?,?)";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      pstm.setString(1, emp.getName());
	      pstm.setString(2, emp.getSurname());
	      pstm.setString(3, emp.getPosition());
	      pstm.setInt(4, emp.getSalary());
	 
	      pstm.executeUpdate();
	  }
	 
	  public static void deleteProduct(Connection conn, String code) throws SQLException {
	      String sql = "Delete employees where code= ?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      pstm.setString(1, code);
	 
	      pstm.executeUpdate();
	  }
	 
	}




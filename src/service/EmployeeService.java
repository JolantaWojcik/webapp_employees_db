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
		
	      String sql = "Select a.name, a.surname, a.position, a.salary from employees a";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      ResultSet rs = pstm.executeQuery();
	      List<Employee> list = new ArrayList<Employee>();
	      while (rs.next()) {
	          String name = rs.getString("name");
	          String surname = rs.getString("surname");
	          String position = rs.getString("surname");
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
	 
	  public static Employee findEmployee(Connection conn, String code) throws SQLException {
	      String sql = "Select a.name, a.surname, a.position, a.salary from Employee a where a.code=?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, code);
	 
	      ResultSet rs = pstm.executeQuery();
	 
	      while (rs.next()) {
	          String name = rs.getString("name");
	          String surname = rs.getString("surname");
	          String position = rs.getString("position");
	          int salary = rs.getInt("salary");
	          Employee e = new Employee(name, surname, position, salary);
	          return e;
	      }
	      return null;
	  }
	 
//	  public static void updateEmployees(Connection conn, Employee product) throws SQLException {
//	      String sql = "Update Product set Name =?, Price=? where Code=? ";
//	 
//	      PreparedStatement pstm = conn.prepareStatement(sql);
//	 
//	      pstm.setString(1, product.getName());
//	      pstm.setFloat(2, product.getPrice());
//	      pstm.setString(3, product.getCode());
//	      pstm.executeUpdate();
//	  }
	 
	  public static void insertEmployee(Connection conn, Employee emp) throws SQLException {
	      String sql = "Insert into Employee(name, surname, position, salary) values (?,?,?)";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      pstm.setString(1, emp.getName());
	      pstm.setString(2, emp.getSurname());
	      pstm.setString(3, emp.getPosition());
	      pstm.setInt(4, emp.getSalary());
	 
	      pstm.executeUpdate();
	  }
	 
	  public static void deleteProduct(Connection conn, String code) throws SQLException {
	      String sql = "Delete Employee where code= ?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      pstm.setString(1, code);
	 
	      pstm.executeUpdate();
	  }
	 
	}

//	public void addEmployee(Employee employee) {
//		DATABASE.add(employee);
//	}



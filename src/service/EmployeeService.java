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
	
	private static Connection connection;
	private HttpServletRequest request;

	public EmployeeService(Connection connection, HttpServletRequest request) {
		this.connection = connection;
		this.request = request;
	}
	
	public static List<Employee> queryEmployees() throws SQLException {
		StringBuilder query = new StringBuilder("select * from employees");

		PreparedStatement pstm = connection.prepareStatement(query.toString());

		ResultSet rs = pstm.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			String position = rs.getString("position");
			int salary = rs.getInt("salary");
			Employee e = new Employee(id, name, surname, position, salary);
			e.setName(name);
			e.setSurname(surname);
			e.setPosition(position);
			e.setSalary(salary);
			list.add(e);
		}

		rs.close();
		pstm.close();
		connection.close();
		return list;
	  }

	 
	  public static void insertEmployee(Employee emp) throws SQLException {
		  PreparedStatement pstm = connection.prepareStatement(
				  "insert into employees(name, surname, position, salary) values (?,?,?,?)",
				  PreparedStatement.RETURN_GENERATED_KEYS);

		  pstm.setString(1, emp.getName());
		  pstm.setString(2, emp.getSurname());
		  pstm.setString(3, emp.getPosition());
		  pstm.setInt(4, emp.getSalary());

		  pstm.executeQuery();

		  ResultSet rs = pstm.getGeneratedKeys();
		  if (rs.next()) {
			  emp.setId(rs.getInt("id"));
		  }
		  rs.close();
		  pstm.close();
	  }
	 
	  public static void deleteEmployee(Employee emp) throws SQLException {
	      StringBuilder query = new StringBuilder("delete from employees where id= ?");
	      PreparedStatement pstm = connection.prepareStatement(query.toString());
	      pstm.setInt(1, emp.getId());

		  ResultSet rs = pstm.executeQuery();
		 
		  rs.close();
		  pstm.close();
	  }
	 
	}




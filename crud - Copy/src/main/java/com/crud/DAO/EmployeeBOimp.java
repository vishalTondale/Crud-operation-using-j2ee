package com.crud.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Employee;

public class EmployeeBOimp implements employeeBO {
	
	private Connection con;
	
	
	private final String INSERT_QUERY = "insert into employee(id,name,gender,mail,mobileNumber,designation,salary) values(?,?,?,?,?,?,?)";
	private final String UPDATE_MAIL = "update employee set mail=? where id=?";
	private final String DELETE_QUERY = "delete from employee where id=?";
	private final String GET = "select * from employee where id=?";
	private final String GET_ALL = "select * from employee";
	
	public EmployeeBOimp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int insert(Employee e) {
		try {
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			statement.setInt(1,e.getId());
			statement.setString(2, e.getName());
			statement.setString(3, e.getGender());
			statement.setString(4, e.getMail());
			statement.setString(5, e.getMobileNumber());
			statement.setString(6, e.getDesignation());
			statement.setInt(7, e.getSalary());
			
			return statement.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(int id, String mail) {
		try {
			PreparedStatement statement = con.prepareStatement(UPDATE_MAIL);
			statement.setString(1,mail);
			statement.setInt(2, id);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		
		try {
			PreparedStatement statement = con.prepareStatement(DELETE_QUERY);
			statement.setInt(1,id);
			
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Employee get(int id) {
		try {
			PreparedStatement statement = con.prepareStatement(GET);
			statement.setInt(1, id);
			
			ResultSet res = statement.executeQuery();
			res.next();
			Employee e = new Employee(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getString(6) ,res.getInt(7));
			
			return e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAll() {
		try {
			
			List<Employee> al = new ArrayList<Employee>();
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(GET_ALL);
			
			while(res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String gender = res.getString(3);
				String mail = res.getString(4);
				String mobileNumber = res.getString(5);
				String designation = res.getString(6);
				int salary = res.getInt(7);
				Employee e = new Employee(id, name, gender, mail, mobileNumber, designation, salary);
				al.add(e);
				
			}
			return al;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

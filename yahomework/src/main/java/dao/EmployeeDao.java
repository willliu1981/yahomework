package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import jdbc.JDBCConnection;
import pojo.Employee;

public class EmployeeDao implements Dao<Employee> {

	public Employee findByUsernameAndPassword(String username,
			String password) {
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement statement = null;
		String sql = "select u_id from employee where username=? and password=?";
		ResultSet result = null;
		Employee employee = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			result = statement.executeQuery();

			boolean flag = result.next();
			if (flag) {
				employee = new Employee();
				employee.setU_id(result.getInt("u_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	public Employee findByUsername(String username) {
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from employee where username=?";
		ResultSet result = null;
		Employee employee = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			result = statement.executeQuery();

			if (result.next()) {
				employee = new Employee();
				employee.setU_id(result.getInt("u_id"));
				employee.setUsername(result.getString("username"));
				employee.setPassword(result.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public Employee find(Integer id) {
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from employee where u_id=?";
		ResultSet result = null;
		Employee employee = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();

			if (result.next()) {
				employee = new Employee();
				employee.setU_id(result.getInt("u_id"));
				employee.setUsername(result.getString("username"));
				employee.setPassword(result.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Test
	public void testQuery() {
		EmployeeDao dao = new EmployeeDao();
		Employee find = dao.findByUsername("David");
		System.out.println("test1 = " + find);
	}

	@Override
	public void create(Employee t) {

	}

	@Override
	public void update(Employee t, Integer id) {
	}

	@Override
	public void delete(Integer id) {

	}

}

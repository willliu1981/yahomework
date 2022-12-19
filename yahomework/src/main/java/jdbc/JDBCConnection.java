package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class JDBCConnection {
	static public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/yahomework?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String username = "root";
		String password = "1234";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}

	@Test
	public void test() {
		Connection connection = getConnection();
		if (connection != null) {
			System.out.println("Connection successful!");
		}
	}
}

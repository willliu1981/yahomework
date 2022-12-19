package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import jdbc.JDBCConnection;
import pojo.Product;

public class ProductDao implements Dao<Product> {

	public List<Product> findByName(String name) {
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from product where name like ?";
		ResultSet result = null;
		List<Product> list = new ArrayList<>();
		Product product = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
			result = statement.executeQuery();

			while (result.next()) {
				product = new Product();
				product.setP_id(result.getInt("p_id"));
				product.setName(result.getString("name"));
				product.setPrice(result.getInt("price"));
				product.setUnitsInStock(result.getInt("units_in_stock"));
				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Product find(Integer id) {
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from product where p_id=?";
		ResultSet result = null;
		Product product = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();

			if (result.next()) {
				product = new Product();
				product.setP_id(result.getInt("p_id"));
				product.setName(result.getString("name"));
				product.setPrice(result.getInt("price"));
				product.setUnitsInStock(result.getInt("units_in_stock"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	@Test
	public void testQuery() {
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findByName("鞋");
		System.out.println("test1 = " + list.size());
		list.forEach(System.out::println);
	}

	@Test
	public void testQuery2() {
		ProductDao dao = new ProductDao();
		Product p = dao.find(1);
		System.out.println("test2 = " + p);
	}

	@Override
	public void create(Product t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Product t, Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}

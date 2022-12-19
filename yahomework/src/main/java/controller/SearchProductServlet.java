package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import pojo.Product;

/**
 * Servlet implementation class SearchProductServlet
 */
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchProductServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
		
		ProductDao dao=new ProductDao();
		List<Product> products = dao.findByName(name);
		
		System.out.println("test search");
		products.forEach(System.out::println);
		

	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import pojo.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		EmployeeDao dao = new EmployeeDao();
		Employee find = dao.findByUsername(username);
		RequestDispatcher disp = null;
		if (find != null) {
			if (find.getPassword().equals(password)) {
				disp = request
						.getRequestDispatcher("account/login/successful.html");
			} else {
				disp = request
						.getRequestDispatcher("account/login/failure.html");
			}
		} else {
			disp = request.getRequestDispatcher(
					"account/login/accountisntexist.html");
		}
		disp.forward(request, response);

	}

}

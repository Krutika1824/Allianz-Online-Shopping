package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.allianz.shopping.dao.CustomerDAOImpl;
import com.allianz.shopping.model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		CustomerDAOImpl cudao = new CustomerDAOImpl();
		if (action != null && action.equals("Login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (cudao.login(username, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				//request.getSession(true).setAttribute("username", username);
				response.sendRedirect("Index.jsp");
				// RequestDispatcher dispatcher=request.getRequestDispatcher("Index.jsp");
				// dispatcher.forward(request, response);
			} else {
				response.sendRedirect("Login.jsp");
				// RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
				// dispatcher.forward(request, response);
			}

		} else if (action != null && action.equals("Register")) {
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Customer customer = new Customer(firstname, lastname, username, password, email);

			if (cudao.addCustomer(customer)) {
				response.sendRedirect("Login.jsp");
				// request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				response.sendRedirect("Registration.jsp");
				// request.getRequestDispatcher("Registration.jsp").forward(request, response);
			}
		}

		doGet(request, response);
	}

}

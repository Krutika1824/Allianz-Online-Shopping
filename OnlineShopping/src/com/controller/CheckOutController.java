package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.dao.AddDaoImpl;
import com.allianz.shopping.dao.AddToCartDAO;
import com.allianz.shopping.dao.OrderDAO;
import com.allianz.shopping.dao.OrderDaoImpl;
import com.allianz.shopping.model.AddToCart;
import com.allianz.shopping.model.Order;

@WebServlet("/CheckOutController")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDAO orderDAO = new OrderDaoImpl();
	AddToCartDAO addToCartDAO = new AddDaoImpl();

	public CheckOutController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * int order_id=0; System.out.println("get"); String username = (String)
		 * request.getSession().getAttribute("username");
		 * 
		 * String id[] = request.getParameterValues("id"); if (id != null && id.length >
		 * 0) { float grandTotal = 0; for (int i = 0; i < id.length; i++) { String total
		 * = request.getParameter("total" + id[i]); System.out.println(total);
		 * grandTotal = grandTotal + Float.parseFloat(total);
		 * System.out.println(grandTotal); } Order order = new Order();
		 * order.setOrderDate(new Date()); order.setStatus("Ordered");
		 * order.setUsername(username); order.setTotalPrice(grandTotal); order_id =
		 * orderDAO.addOrder(order); System.out.println(orderDAO); for (int i = 0; i <
		 * id.length; i++) { if (id[i] != null && !id[i].trim().equals("")) { String
		 * quantity = request.getParameter("quantity" + id[i]);
		 * System.out.println(quantity); String total = request.getParameter("total" +
		 * id[i]); System.out.println(total); if (quantity != null)
		 * 
		 * { AddToCart add = new AddToCart(); add.setOrder_id(order_id);
		 * add.setQuantity(Integer.parseInt(quantity));
		 * add.setId1(Integer.parseInt(id[i])); add.setTotal(grandTotal);
		 * addToCartDAO.addToCart(add); System.out.println(addToCartDAO); } } } }
		 * List<Order> order = new ArrayList<Order>();
		 * 
		 * 
		 * System.out.println("Order id is" + order_id);
		 * 
		 * OrderDaoImpl odao = new OrderDaoImpl();
		 * System.out.println(odao.getAllOrderById(order_id)); Order o =
		 * odao.getAllOrderById(order_id); order.add(o);
		 * System.out.println("order : "+order); request.setAttribute("orderdetails",
		 * order); order.add(odao.getOrderById(order_id)); RequestDispatcher dispatcher
		 * = request.getRequestDispatcher("orderData.jsp");
		 * request.setAttribute("orderdetails", order); dispatcher.forward(request,
		 * response);
		 */		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int order_id=0;
		System.out.println("get");
		String username = (String) request.getSession().getAttribute("username");
		
		String id[] = request.getParameterValues("id");
		if (id != null && id.length > 0) {
			float grandTotal = 0;
			for (int i = 0; i < id.length; i++) {
				String total = request.getParameter("total" + id[i]);
				System.out.println(total);
				grandTotal = grandTotal + Float.parseFloat(total);
				System.out.println(grandTotal);
			}
			Order order = new Order();
			order.setOrderDate(new Date());
			order.setStatus("Ordered");
			order.setUsername(username);
			order.setTotalPrice(grandTotal);
			order_id = orderDAO.addOrder(order);
			System.out.println(orderDAO);
			for (int i = 0; i < id.length; i++) {
				if (id[i] != null && !id[i].trim().equals("")) {
					String quantity = request.getParameter("quantity" + id[i]);
					System.out.println(quantity);
					String total = request.getParameter("total" + id[i]);
					System.out.println(total);
					if (quantity != null)

					{
						AddToCart add = new AddToCart();
						add.setOrder_id(order_id);
						add.setQuantity(Integer.parseInt(quantity));
						add.setId1(Integer.parseInt(id[i]));
						add.setTotal(grandTotal);
						addToCartDAO.addToCart(add);
						System.out.println(addToCartDAO);
					}
				}
			}
		}
		List<Order> order = new ArrayList<Order>();

	
		System.out.println("Order id is" + order_id);
		
		OrderDaoImpl odao = new OrderDaoImpl();
		System.out.println(odao.getAllOrderById(order_id));
		Order o = odao.getAllOrderById(order_id);
		order.add(o);
		System.out.println("order : "+order);
		request.setAttribute("orderdetails", order);
		order.add(odao.getOrderById(order_id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderData.jsp");
		request.setAttribute("orderdetails", order);	
		dispatcher.forward(request, response);
		

		
		
		
		
		/*String action = request.getParameter("action");
		if (action != null && action.equals("getAllOrderById")) {
*/
			

		}

	}



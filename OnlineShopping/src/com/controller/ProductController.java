package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.dao.CategoryDAODatabaseImpl;
import com.allianz.shopping.dao.ProductDAO;
import com.allianz.shopping.dao.productDAODatabaseImpl;
import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;

/**
 * 
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductDAO pdao = new ProductDAOImpl();
	ProductDAO pdao = new productDAODatabaseImpl();
	CategoryDAODatabaseImpl cdao = new CategoryDAODatabaseImpl();

	public ProductController() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("delete")) {
			String id = request.getParameter("id");
			boolean flag = pdao.deleteProduct(Integer.parseInt(id));
			if (flag) {
				response.sendRedirect("ProductController");
			}
		} else if (action != null && action.equals("edit")) {
			String id = request.getParameter("id");
			Product product = pdao.getProductById(Integer.parseInt(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
			request.setAttribute("product", product);
			dispatcher.forward(request, response);
		}

		else if (action != null && action.equals("getDetailById")) {
			String id = request.getParameter("productId");
			Product product = pdao.getProductById(Integer.parseInt(id)); 
			cdao.getAllcategoriesByProductId(Integer.parseInt(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("Subpage.jsp");
			request.setAttribute("product", product);
			dispatcher.forward(request, response);
		}
		else if(action != null && action.equals("Addtocart")) {
			System.out.println("Add to cart");
			String id = request.getParameter("productid");
			Product product = pdao.getProductById(Integer.parseInt(id));
			
			if(product!=null)
			{
				List<Product> prod=new ArrayList<Product>();
				if(request.getSession().getAttribute("product")!=null)
				{
					
					prod=(List<Product>)request.getSession().getAttribute("product");
					prod.add(product);
					request.getSession().setAttribute("product", prod);
				}
				else {
					prod.add(product);
					request.getSession().setAttribute("product", prod);
					
				}
				response.sendRedirect("AddtoCart.jsp");
				
				
			}
			
			
		}
		else if (action != null && action.equals("deletefromCart")) {
			String index = request.getParameter("index");
			List<Product> productList=new ArrayList<Product>();
			if(request.getSession().getAttribute("product")!=null)
			{
			 productList=(List<Product>)request.getSession().getAttribute("product");
			 productList.remove(Integer.parseInt(index));
			 request.getSession().removeAttribute("product");
			 request.getSession().setAttribute("product", productList);
			}
			response.sendRedirect("AddtoCart.jsp");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("AddtoCart.jsp");
			//request.setAttribute("product", product);
			//dispatcher.forward(request, response);
		
		}
		
		 
		
		else   {
			List<Product> productList = pdao.getAllProducts();
			List<Category> categoryList=cdao.getAllCategory();
			RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
			request.setAttribute("productList", productList);
			request.setAttribute("categoryList", categoryList);
			dispatcher.forward(request, response);

			// response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("update")) {
			String id = request.getParameter("id");
			String code = request.getParameter("code");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String manfDate = request.getParameter("date");
			Product product = new Product();
			product.setId(Integer.parseInt(id));
			product.setCode(code);
			product.setDescription(description);
			product.setPrice(Float.parseFloat(price));
			product.setManfDate(DateUtility.convertStringToDate(manfDate));
			// boolean flag=dao.updateProduct(product);

			pdao.updateProduct(product);

		} else if (action != null && action.equals("add")) {
			String code = request.getParameter("code");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String manfDate = request.getParameter("date");
			Product product = new Product();
			product.setCode(code);
			product.setDescription(description);
			product.setPrice(Float.parseFloat(price));
			product.setManfDate(DateUtility.convertStringToDate(manfDate));
			// boolean flag=dao.updateProduct(product);
			pdao.addProduct(product);

		}
		response.sendRedirect("ProductController");

	}

}

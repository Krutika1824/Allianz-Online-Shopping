package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Order;
import com.allianz.shopping.utility.DateUtility;
import com.allianz.shopping.utility.DbUtility;

public class OrderDaoImpl implements OrderDAO {

	@Override
	public int addOrder(Order order) {
		String sql = "INSERT INTO `ORDER`(ORDERDATE,TOTALPRICE,STATUS,USERNAME) VALUES(?,?,?,?)";
		Connection con = null;
		int orderId = 0;
		try {
			con = DbUtility.getConnection();
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setDate(1, DateUtility.convertUtilToSql(order.getOrderDate()));
			ps.setFloat(2, order.getTotalPrice());
			ps.setString(3, order.getStatus());
			ps.setString(4, order.getUsername());

			int result = ps.executeUpdate();
			System.out.println("Rows updated are" + result);
			if (result > 0) {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						orderId = generatedKeys.getInt(1);
						System.out.println(orderId);
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderId;
	}

	@Override
	public Order getAllOrderById(int orderId) {
		Order order=new Order();
		try {
			Connection con=DbUtility.getConnection();
			String sql="SELECT * FROM `ORDER` WHERE ORDERID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,orderId);
			ResultSet rs=ps.executeQuery();
			rs.next();
			order.setOrderId(rs.getInt("orderid"));
			order.setOrderDate(rs.getDate("orderdate"));
			order.setTotalPrice(rs.getFloat("totalprice"));
			order.setStatus(rs.getString("status"));
		    order.setUsername(rs.getString("username"));
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		return order;
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> orderlist = new ArrayList<Order>();
		Order order=new Order();
		
		try {
			Connection con = DbUtility.getConnection();
			String sql="SELECT * FROM `ORDER`";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				order.setOrderId(rs.getInt("orderid"));
				order.setOrderDate(rs.getDate("orderdate"));
				order.setTotalPrice(rs.getFloat("totalprice"));
				order.setStatus(rs.getString("status"));
				order.setUsername(rs.getString("username"));
				orderlist.add(order);
			}
			
			} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return orderlist;
	}

	public Order getOrderById(int orderId) {
		AddToCartDAO addtocartdao=new AddDaoImpl();
		try {
			Connection con=DbUtility.getConnection();
			String sql="SELECT * FROM `ORDER` WHERE ORDERID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
				Order order=new Order();
				order.setOrderId(rs.getInt("orderid"));
				order.setOrderDate(rs.getDate("orderdate"));
				order.setTotalPrice(rs.getFloat("totalprice"));
				order.setStatus(rs.getString("status"));
				order.setUsername(rs.getString("username"));
				order.setAddToCartlist(addtocartdao.getAllAddToCartByOrderId(order.getOrderId()));
				System.out.println("list of orders"+order);
			return order;
			
					
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}

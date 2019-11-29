package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.Order;

public interface OrderDAO {
	
	public int addOrder(Order order);
	
	public Order getAllOrderById( int orderId);
	
	List<Order> getAllOrder();
	
  public Order getOrderById(int orderId);
	
	

}

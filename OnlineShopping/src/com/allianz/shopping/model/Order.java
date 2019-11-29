package com.allianz.shopping.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private int orderId;
	private Date orderDate;
	private float totalPrice;
	private String status;
	private String username;

	private List<AddToCart> addToCartlist=new ArrayList<AddToCart>();
	
	public Order()
	{
		
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", status="
				+ status + ", username=" + username + "]";
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public float getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Order(int orderId, Date orderDate, float totalPrice, String status, String username) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.username = username;
	}
	public List<AddToCart> getAddToCartlist() {
		return addToCartlist;
	}
	public void setAddToCartlist(List<AddToCart> addToCartlist) {
		this.addToCartlist = addToCartlist;
	}
	

}

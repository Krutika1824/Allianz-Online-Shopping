package com.allianz.shopping.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private int id;
	private String fname,lname,username,password,email;
	List<Order> orderList=new ArrayList<Order>(); //get orderlist by the username  create method getAllOrderbyName
	
	
	public Customer()
	{
		
	}
	
	public Customer(String fname, String lname, String username, String password, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Customer(int id, String fname, String lname, String username, String password, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


}

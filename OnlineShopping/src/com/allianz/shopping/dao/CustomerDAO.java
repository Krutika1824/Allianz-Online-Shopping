package com.allianz.shopping.dao;

import com.allianz.shopping.model.Customer;

public interface CustomerDAO {
	
	public boolean addCustomer(Customer customer);
	public boolean login(String username,String password);

}

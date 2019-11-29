package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.AddToCart;
import com.allianz.shopping.model.Order;
import com.allianz.shopping.model.Product;

public interface AddToCartDAO {
	
	public boolean addToCart(AddToCart addtocart);
	
	public List<AddToCart>getAllAddToCartByOrderId(int orderId);
}

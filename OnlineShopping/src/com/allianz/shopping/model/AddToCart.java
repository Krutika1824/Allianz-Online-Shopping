
package com.allianz.shopping.model;

public class AddToCart {
	
	private int id1,id,quantity;
	private float total;
	private int order_id;
	Product product=new Product();
			
	
	public AddToCart()
	{
		
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AddToCart [id1=" + id1 + ", id=" + id + ", quantity=" + quantity + ", total=" + total + ", order_id="
				+ order_id + "]";
	}
	public AddToCart(int id1, int id, int quantity, float total, int order_id) {
		super();
		this.id1 = id1;
		this.id = id;
		this.quantity = quantity;
		this.total = total;
		this.order_id = order_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

}

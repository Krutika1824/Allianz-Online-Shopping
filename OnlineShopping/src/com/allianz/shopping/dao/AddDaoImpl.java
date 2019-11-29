package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.AddToCart;
import com.allianz.shopping.model.Order;
import com.allianz.shopping.utility.DbUtility;

public class AddDaoImpl implements AddToCartDAO {

	public boolean addToCart(AddToCart addtocart) {
		String sql = "INSERT INTO CART (PRODUCTID,QUANTITY,TOTAL,ORDERID) VALUES (?,?,?,?)";
		Connection con = null;
		int orderId = 0;

		try {
			con = DbUtility.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, addtocart.getId1());
			ps.setInt(2, addtocart.getQuantity());
			ps.setFloat(3, addtocart.getTotal());
			ps.setInt(4, addtocart.getOrder_id());

			int result = ps.executeUpdate();
			System.out.println("Rows updated are" + result);
			if (result > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<AddToCart> getAllAddToCartByOrderId(int id) {
		
		List<AddToCart> addtocartlist=new ArrayList<AddToCart>();
		
		try {
			Connection con=DbUtility.getConnection();
			String sql="select * from cart where orderid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AddToCart addtocart=new AddToCart();
				addtocart.setId(rs.getInt("CartId"));
				addtocart.setId1(rs.getInt("ProductId"));
				addtocart.setQuantity(rs.getInt("Quantity"));
				addtocart.setTotal(rs.getFloat("Total"));
				addtocart.setOrder_id(rs.getInt("Orderid"));
				addtocartlist.add(addtocart);
			}
			System.out.println("Add to cart list"+addtocartlist);
			return addtocartlist;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}

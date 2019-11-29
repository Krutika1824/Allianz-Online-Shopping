package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.allianz.shopping.model.Customer;
import com.allianz.shopping.utility.DbUtility;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean addCustomer(Customer customer) {
		Connection con;
		try {
			con = DbUtility.getConnection();
			String sql = "INSERT INTO CUSTOMER(id,FIRSTNAME,LASTNAME,EMAIL,USERNAME,PASSWORD)values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getFname());
			
			
			ps.setString(3, customer.getLname());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getUsername());
			ps.setString(6, customer.getPassword());
			int no = ps.executeUpdate();
			if (no > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean login(String username, String password) {
		Connection con;
		try {
			con = DbUtility.getConnection();
			String sql = "SELECT * FROM CUSTOMER WHERE USERNAME=? AND PASSWORD=? LIMIT 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.first();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;
import com.allianz.shopping.utility.DbUtility;

public class productDAODatabaseImpl implements ProductDAO {

	CategoryDAODatabaseImpl cadao=new CategoryDAODatabaseImpl();
	@Override
	public boolean addProduct(Product product) {
		Connection con;
		try {
			con = DbUtility.getConnection();
			String sql = "INSERT INTO PRODUCT(ID,Code,Description,Price,Manufacturing)values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getCode());
			ps.setString(3, product.getDescription());
			ps.setFloat(4, product.getPrice());
			ps.setDate(5, DateUtility.convertUtilToSql(product.getManfDate()));
			int no = ps.executeUpdate();
			if (no > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		Connection con;
		try {
			con = DbUtility.getConnection();
			String sql = "UPDATE PRODUCT SET Code=?,Description=?,Price=?,Manufacturing=? WHERE ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getCode());
			ps.setString(2, product.getDescription());
			ps.setFloat(3, product.getPrice());
			ps.setDate(4, DateUtility.convertUtilToSql(product.getManfDate()));
			ps.setInt(5, product.getId());
			int no = ps.executeUpdate();
			if (no > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		Connection con;
		try {
			con = DbUtility.getConnection();

			String sql = "DELETE FROM PRODUCT WHERE ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		Connection con;
		try {
			con = DbUtility.getConnection();
			List<Product> productList = new ArrayList<Product>();
			String sql = "SELECT ID,CODE,DESCRIPTION,PRICE,MANUFACTURING FROM PRODUCT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getInt("id"));
				product.setCode(rs.getString("code"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setManfDate(rs.getDate("Manufacturing"));
				productList.add(product);
				product.setCategoryList(cadao.getAllCategoryByProductId(product.getId()));

			}
			return productList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Product> getAllProductsByName(String name) {

		return null;
	}

	@Override
	public List<Product> getAllProductByPrice(float min, float max) {

		return null;
	}

	@Override
	public Product getProductById(int id1) {
		Connection con;
		try {
			con = DbUtility.getConnection();

			String sql = "SELECT * FROM PRODUCT WHERE ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id1);
			ResultSet rs = ps.executeQuery();
			rs.next();

			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setCode(rs.getString("code"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getFloat("price"));
			product.setManfDate(rs.getDate("Manufacturing"));
			product.setCategoryList(cadao.getAllCategoryByProductId(product.getId()));
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	

	@Override
	public List<Product> getAllProductByCategoryId(int category_id) {
		Connection con;
		try {
			con = DbUtility.getConnection();
			List<Product>productList=new ArrayList<Product>();
			List<Category> categoryList = new ArrayList<Category>();
			String sql = "SELECT * FROM PRODUCT WHERE ID IN ( SELECT PRODUCT_ID FROM CATEGORY_PRODUCT WHERE CATEGORYID=?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, category_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product=new Product();
				Category category = new Category();
				category.setCategory_id(rs.getInt("Category_Id"));
				category.setCategory_code(rs.getInt("Category_Code"));
				category.setCategory_decs(rs.getString("Category_Description"));
				categoryList.add(category);
				product.setCategoryList(cadao.getAllCategoryByProductId(product.getId()));
			}
			return productList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}

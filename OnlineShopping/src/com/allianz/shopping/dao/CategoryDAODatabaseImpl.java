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

public class CategoryDAODatabaseImpl implements CategoryDAO {
	private static List<Category> categoryList = new ArrayList<Category>();

	@Override
	public boolean addCategory(Category category) {
		Connection con;
		try {
			con=DbUtility.getConnection();
			String sql="INSERT INTO CATEGORY(Category_Id,Category_Code,Category_Description)values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, category.getCategory_id());
			ps.setInt(2,category.getCategory_code());
			ps.setString(3, category.getCategory_decs());
			int no=ps.executeUpdate();
			if(no>0)
				return true;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean updateCategory(Category category) {
		Connection con;
		try {
			con=DbUtility.getConnection();
			String sql="UPDATE PRODUCT SET Category_Code=?,Category_Description=? WHERE ID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,category.getCategory_id());
			ps.setInt(2, category.getCategory_code());
			ps.setString(3,category.getCategory_decs());
			int no=ps.executeUpdate();
			if(no>0)
				return true;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
		
		
	}

	@Override
	public boolean deleteCategory(int id) {
		Connection con;
		try {
			con=DbUtility.getConnection();
			
			String sql="DELETE FROM CATEGORY WHERE ID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
			
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Category> getAllCategory() {
		
		Connection con;
		try {
			con=DbUtility.getConnection();
			
			String sql="SELECT CATEGORY_Id,CATEGORY_Code,CATEGORY_Description FROM CATEGORY";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Category category=new Category();
				category.setCategory_id(rs.getInt("Category_Id"));
				category.setCategory_code(rs.getInt("Category_Code"));
				category.setCategory_decs(rs.getString("Category_Description"));
				
				categoryList.add(category);
			}
			return categoryList;
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		
		
		return null;
	}

	@Override
	public List<Category> getAllCategoryByProductId(int id) {
		return null;
	}

	

	@Override
	public Category geCategoryById(int id1) {
		Connection con;
		try {
			con=DbUtility.getConnection();
			
			String sql="SELECT * FROM PRODUCT where Category_Id=? limit 1";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id1);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
				Category category=new Category();
				category.setCategory_id(rs.getInt("id"));
				category.setCategory_code(rs.getInt("code"));
				category.setCategory_decs(rs.getString("description"));
				
				return category;
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		 
		return null;
	}
	
	@Override
	public List<Category> getAllcategoriesByProductId(int id) {
		Connection con;
		try {
			Product product=new Product();
			CategoryDAODatabaseImpl cadao=new CategoryDAODatabaseImpl();
			con = DbUtility.getConnection();
			List<Category> categoryList = new ArrayList<Category>();
			String sql = "SELECT * FROM CATEGORY WHERE CATEGORY_ID IN ( SELECT CATEGORYID FROM CATEGORY_PRODUCT WHERE Product_id=?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCategory_id(rs.getInt("Category_Id"));
				category.setCategory_code(rs.getInt("Category_Code"));
				category.setCategory_decs(rs.getString("Category_Description"));
				categoryList.add(category);
				product.setCategoryList(cadao.getAllCategoryByProductId(product.getId()));
			}
			return categoryList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

		
}

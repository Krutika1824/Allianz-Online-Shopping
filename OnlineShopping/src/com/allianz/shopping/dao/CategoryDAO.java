package com.allianz.shopping.dao;

import java.util.List;
import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;

public interface CategoryDAO {
	
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int id);
	public  List<Category> getAllCategory();
	public List<Category> getAllCategoryByProductId(int id);

	public Category geCategoryById(int id1);
	List<Category> getAllcategoriesByProductId(int id);
	

}

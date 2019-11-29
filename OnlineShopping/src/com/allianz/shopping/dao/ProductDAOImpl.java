package com.allianz.shopping.dao;

import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;

public class ProductDAOImpl implements ProductDAO {
	private static List<Product> productList = new ArrayList<Product>();
	static {
		productList.add(new Product(101, "Colgate1", "Colgate Tube", 50, DateUtility.convertStringToDate("12/10/2019")));
		productList.add(new Product(102, "Colgate2", "Colgate Tube", 60, DateUtility.convertStringToDate("12/11/2019")));
		productList.add(new Product(103, "Colgate3", "Colgate Tube", 70, DateUtility.convertStringToDate("12/12/2019")));
		productList.add(new Product(104, "Colgate4", "Colgate Tube", 80, DateUtility.convertStringToDate("12/01/2019")));
		productList.add(new Product(105, "Colgate5", "Colgate Tube", 90, DateUtility.convertStringToDate("12/02/2019")));

	}

	@Override
	public boolean addProduct(Product product) {
		productList.add(product);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		if (productList != null && productList.size() > 0) {
			for (int i = 0; i < productList.size(); i++) {
				Product producttemp = productList.get(i);
				if (producttemp.getId() == product.getId()) {
					productList.set(i, product);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		if (productList != null && productList.size() > 0) {
			for (int i = 0; i < productList.size(); i++) {
				Product producttemp = productList.get(i);
				if (producttemp.getId() == id) {
					productList.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return  productList;
	}

	@Override
	public List<Product> getAllProductsByName(String namePattern) {
		List<Product> productListTemp = new ArrayList<Product>();
		if (productList != null && productList.size() > 0) {
			for (int i = 0; i < productList.size(); i++) {
				Product producttemp = productList.get(i);
				if (producttemp.getDescription().toLowerCase().contains(namePattern.toLowerCase())) {
					productListTemp.add(producttemp);

				}
			}
			return productListTemp;
		}

		return null;
	}

	@Override
	public List<Product> getAllProductByPrice(float min, float max) {
		List<Product> productListTemp = new ArrayList<Product>();
		if (productList != null && productList.size() > 0) {
			for (int i = 0; i < productList.size(); i++) {
				Product producttemp = productList.get(i);
				if (producttemp.getPrice() >= min && producttemp.getPrice() <= max) {
					productListTemp.add(producttemp);
				}
			}
			return productListTemp;
		}
		return null;
	}

	@Override
	public Product getProductById(int id1) {
		if (productList != null && productList.size() > 0) {
			for (int i = 0; i < productList.size(); i++) {
				Product producttemp = productList.get(i);
				if (producttemp.getId() == id1) {
					return producttemp;
				}
			}
		}
		return null;
	}

	
	@Override
	public List<Product> getAllProductByCategoryId(int category_id) {
		return null;
	}

}

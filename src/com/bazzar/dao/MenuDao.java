package com.bazzar.dao;

import java.util.List;

import com.bazzar.domain.menu.Category;
import com.bazzar.domain.menu.Product;
import com.bazzar.domain.menu.SubCategory;

public interface MenuDao {

	public void deleteCategory ( Long id );
	public void deleteSubCategory ( Long id );
	public void deleteProduct ( Long id );
	
	public void add ( Category category );
	
	public Category getCategory ( Long id );
	public SubCategory getSubCategory ( Long id );
	public Product getProduct ( Long id );
	
	public List <Category> getAllCategories ();
	public List <SubCategory> getAllSubCategories ();
	public List <Product> getAllProducts ();
	
	public void edit ( Category category );
	public void edit ( SubCategory category );
	public void edit ( Product category );
}

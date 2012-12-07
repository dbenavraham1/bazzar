package com.bazzar.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.dao.MenuDao;
import com.bazzar.domain.menu.Category;
import com.bazzar.domain.menu.Product;
import com.bazzar.domain.menu.SubCategory;

@Service ( "menuService" )
@Transactional
public class MenuDaoImpl implements MenuDao {
	protected static Logger logger = Logger.getLogger ( "MenuDao" );
	  
	@Resource ( name="sessionFactory" )
	private SessionFactory sessionFactory;
	 
	public void deleteCategory ( Long id ){
		logger.debug ( "Deleting existing Category : " + id);
		Session session = sessionFactory.getCurrentSession ( );
		Category category = ( Category ) session.get ( Category.class, id );
		session.delete ( category );		
	}
	public void deleteSubCategory ( Long id ){
		logger.debug ( "Deleting existing SubCategory : " + id);
		Session session = sessionFactory.getCurrentSession ( );
		SubCategory subCategory = ( SubCategory ) session.get ( SubCategory.class, id );
		session.delete ( subCategory );		
	}
	public void deleteProduct ( Long id ){
		logger.debug ( "Deleting existing Product : " + id);
		Session session = sessionFactory.getCurrentSession ( );
		Product product = ( Product ) session.get ( Product.class, id );
		session.delete ( product );		
	}
	
	public void add ( Category category ){
		logger.debug ( "Adding new Category" );
		Session session = sessionFactory.getCurrentSession ( );
		session.save ( category );		
	}
	
	public Category getCategory ( Long id ){
		Session session = sessionFactory.getCurrentSession ( );
		return ( Category ) session.get ( Category.class, id );
	}
	public SubCategory getSubCategory ( Long id ){
		Session session = sessionFactory.getCurrentSession ( );
		return ( SubCategory ) session.get ( SubCategory.class, id );
	}
	public Product getProduct ( Long id ){
		Session session = sessionFactory.getCurrentSession ( );
		return ( Product ) session.get ( Product.class, id );
	}
	
	@SuppressWarnings("unchecked")
	public List <Category> getAllCategories ( ){
		logger.debug ( "Retrieving all Categories" );
		Session session = sessionFactory.getCurrentSession ( );
		Query query = session.createQuery ( "FROM Category" );
		return  query.list ( );
	}
	@SuppressWarnings("unchecked")
	public List <SubCategory> getAllSubCategories ( ){
		logger.debug ( "Retrieving all SubCategory" );
		Session session = sessionFactory.getCurrentSession ( );
		Query query = session.createQuery ( "FROM SubCategory" );
		return  query.list ( );
	}
	@SuppressWarnings("unchecked")
	public List <Product> getAllProducts ( ){
		logger.debug ( "Retrieving all Product" );
		Session session = sessionFactory.getCurrentSession ( );
		Query query = session.createQuery ( "FROM Product" );
		return  query.list ( );
	}
	
	public void edit ( Category category ){
		logger.debug ( "Editing Category : " + category.getId ( ) );
		Session session = sessionFactory.getCurrentSession ( );
		Category existingCategory = ( Category ) session.get ( Category.class, category.getId ( ) );
		existingCategory.setAttribute( category.getAttribute());
		existingCategory.setDisplayOption( category.getDisplayOption());
		existingCategory.setSubCategory( category.getSubCategory());
		existingCategory.setUpdated( category.getUpdated());
		existingCategory.setValue( category.getValue());
		session.save ( existingCategory );
	}
	public void edit ( SubCategory subCategory ){
		logger.debug ( "Editing SubCategory : " + subCategory .getId ( ) );
		Session session = sessionFactory.getCurrentSession ( );
		SubCategory existingSubCategory = ( SubCategory ) session.get ( SubCategory.class, subCategory.getId ( ) );
		existingSubCategory.setAttribute( subCategory.getAttribute());
		existingSubCategory.setDisplayOption( subCategory.getDisplayOption());
		existingSubCategory.setProduct( subCategory.getProduct());
		existingSubCategory.setUpdated( subCategory.getUpdated());
		existingSubCategory.setValue( subCategory.getValue());
		session.save ( existingSubCategory );
	}
	public void edit ( Product product ){
		logger.debug ( "Editing Product : " + product.getId ( ) );
		Session session = sessionFactory.getCurrentSession ( );
		Product existingProduct = ( Product ) session.get ( Product.class, product.getId ( ) );
		existingProduct.setAttribute( product.getAttribute());
		existingProduct.setDisplayOption( product.getDisplayOption());
		existingProduct.setPicture( product.getPicture());
		existingProduct.setUpdated( product.getUpdated());
		existingProduct.setValue( product.getValue());
		session.save ( existingProduct );
	}

	
}

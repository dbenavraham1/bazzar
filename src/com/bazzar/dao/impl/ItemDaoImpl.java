package com.bazzar.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bazzar.dao.ItemDao;
import com.bazzar.domain.product.Item;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service ( "itemService" )
@Transactional
class ItemDaoImpl implements ItemDao {
	
	protected static Logger logger = Logger.getLogger ( "ItemDao" );
	  
	@Resource ( name="sessionFactory" )
	private SessionFactory sessionFactory;
	 
	public void delete ( Long id ){
		logger.debug ( "Deleting existing item : " + id);
		Session session = sessionFactory.getCurrentSession ( );
		Item item = ( Item ) session.get ( Item.class, id );
		session.delete ( item );		
	}
	
	public void add ( Item item ){
		logger.debug ( "Adding new item" );
		Session session = sessionFactory.getCurrentSession ( );
		session.save ( item );		
	}
	
	public Item get ( Long id ){
		Session session = sessionFactory.getCurrentSession ( );
		return ( Item ) session.get ( Item.class, id );
	}
	
	@SuppressWarnings("unchecked")
	public List <Item> getAll ( ){
		logger.debug ( "Retrieving all items" );
		Session session = sessionFactory.getCurrentSession ( );
		Query query = session.createQuery ( "FROM Item" );
		return  query.list ( );
	}
	
	public void edit ( Item item ){
		logger.debug ( "Editing Item : " + item.getId ( ) );
		
		Session session = sessionFactory.getCurrentSession ( );
		
		Item existingItem = ( Item ) session.get ( Item.class, item.getId ( ) );
		existingItem.setSubgect ( item.getSubgect ( ) );
		existingItem.setSpecialOfferPrice ( item.getSpecialOfferPrice ( ) );
		existingItem.setSpecialPriceStart ( item.getSpecialPriceStart ( ) );
		existingItem.setSpecialPriceEnd ( item.getSpecialPriceEnd ( ) );
		existingItem.setSpesialPriceActive ( item.isSpesialPriceActive ( ) );
		existingItem.setSalePrice ( item.getSalePrice ( ) );
		existingItem.setListedPrice ( item.getListedPrice ( ) );
		existingItem.setQuantity ( item.getQuantity ( ) );
		existingItem.setRebate( item.isRebate ( ) );
		existingItem.setInStock ( item.isInStock ( ) );
		existingItem.setAverageCustomerRating ( item.getAverageCustomerRating ( ) );
		existingItem.setManufacture ( item.getManufacture ( ) );
		existingItem.setShipping ( item.getShipping ( ) );
		existingItem.setReview ( item.getReview ( ) );
		existingItem.setPictureLocation ( item.getPictureLocation ( ) );
		existingItem.setWarranty ( item.getWarranty ( ) );
		existingItem.setWieght ( item.getWieght ( ) );
		existingItem.setFeatures ( item.getFeatures ( ) );
		existingItem.setDemensions ( item.getDemensions ( ) );
		existingItem.setAccessories ( item.getAccessories ( ) );
		existingItem.setDetail ( item.getDetail ( ) );
		existingItem.setSpecification ( item.getSpecification ( ) );
		existingItem.setQa ( item.getQa() );
		existingItem.setManufactureModelNumber ( item.getManufactureModelNumber () );
		existingItem.setBarCode ( item.getBarCode () );
		existingItem.setUpdated( item.getUpdated());
		
		session.save ( existingItem );
	}

}

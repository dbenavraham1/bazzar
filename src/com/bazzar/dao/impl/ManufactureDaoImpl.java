package com.bazzar.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.dao.ManufactureDao;
import com.bazzar.domain.product.Manufacture;

@Service ( "manufactureService" )
@Transactional
public class ManufactureDaoImpl implements ManufactureDao {

	protected static Logger logger = Logger.getLogger ( "ManufactureDao" );
	  
	@Resource ( name="sessionFactory" )
	private SessionFactory sessionFactory;
	 
	public void delete ( Long id ){
		logger.debug ( "Deleting existing manufacture : " + id);
		Session session = sessionFactory.getCurrentSession ( );
		Manufacture manufacture = ( Manufacture ) session.get ( Manufacture.class, id );
		session.delete ( manufacture );		
	}
	
	public void add ( Manufacture manufacture ){
		logger.debug ( "Adding new manufacture" );
		Session session = sessionFactory.getCurrentSession ( );
		session.save ( manufacture );		
	}
	
	public Manufacture get ( Long id ){
		Session session = sessionFactory.getCurrentSession ( );
		return ( Manufacture ) session.get ( Manufacture.class, id );
	}
	
	@SuppressWarnings("unchecked")
	public List <Manufacture> getAll ( ){
		logger.debug ( "Retrieving all manufactures" );
		Session session = sessionFactory.getCurrentSession ( );
		Query query = session.createQuery ( "FROM Manufacture" );
		return  query.list ( );
	}
	
	public void edit ( Manufacture manufacture ){

		logger.debug ( "Editing Manufacture : " + manufacture.getId ( ) );
		
		Session session = sessionFactory.getCurrentSession ( );
		
		Manufacture existingManufacture = ( Manufacture ) session.get ( Manufacture.class, manufacture.getId ( ) );
		
		existingManufacture.setAuthorizePicture( manufacture.isAuthorizePicture());
		existingManufacture.setName( manufacture.getName());
		existingManufacture.setNumber( manufacture.getNumber());
		existingManufacture.setPicture( manufacture.getPicture());
		existingManufacture.setUpdated( manufacture.getUpdated());
		
		session.save ( existingManufacture );
	}

}

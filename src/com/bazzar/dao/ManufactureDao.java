package com.bazzar.dao;

import java.util.List;

import com.bazzar.domain.product.Manufacture;

public interface ManufactureDao {
	
	public void delete ( Long id );
	public void add ( Manufacture manufacture );
	public Manufacture get ( Long id );
	public List <Manufacture> getAll ();
	public void edit ( Manufacture manufacture );

}

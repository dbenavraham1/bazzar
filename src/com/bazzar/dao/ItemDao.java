package com.bazzar.dao;

import java.util.List;
import com.bazzar.domain.product.Item;

public interface ItemDao {
	
	public void delete ( Long id );
	public void add ( Item item );
	public Item get ( Long id );
	public List <Item> getAll ();
	public void edit ( Item item );

}

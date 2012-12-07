package com.bazzar.domain.order;

import java.util.Collection;
import java.util.LinkedHashSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* An order.
*/
@Entity
@Table(name="ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ORDER_ID")
	private Collection<?> items = new LinkedHashSet();
	
	/**
	* @return the customer
	*/
	public String getCustomer() {
		return customer;
	}
	
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	/**
	 * @return the items
	 */
	public Collection<?> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Collection<?> items) {
		this.items = items;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
}
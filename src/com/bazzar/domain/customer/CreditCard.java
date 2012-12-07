package com.bazzar.domain.customer;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bazzar.domain.Address;

@Entity
@Table(name="CREDITCARD")
public class CreditCard {
	
	private static final long serialVersionUID = 2013406734640664822L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

   	@Column(name="TYPE")
   	private String type;
   	@Column(name="NUMBER")
   	private Long number; 
   	@Column(name="EXP_MONTH")
   	private Long expMonth;
   	@Column(name="EXP_YEAR")
   	private Long expYear;
   	@Column(name="CARDHOLDER_NAME")
   	private String cardholderName;
   	@Column(name="CREATED")
   	private Date created;
   	@Column(name="UPDATED")
   	private Date updated;
   	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<CREDITCARD_ADDRESS>",
	     joinColumns = @JoinColumn( name="CREDIT_ID"),
	     inverseJoinColumns = @JoinColumn( name="ADDRESS_ID")
	)
	private Set <Address> address;
   	
   	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(Long expMonth) {
		this.expMonth = expMonth;
	}
	public Long getExpYear() {
		return expYear;
	}
	public void setExpYear(Long expYear) {
		this.expYear = expYear;
	}
	public String getCardholderName() {
		return cardholderName;
	}
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
   	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

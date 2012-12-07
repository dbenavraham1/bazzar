package com.bazzar.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Address.
*/
@Entity
@Table(name="ADDRESS")
public class Address {
	
	private static final long serialVersionUID = 2013406734640664822L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="TYPE")
  	private String type;
  	@Column(name="ADDRESS_1")
  	private String address1;
  	@Column(name="ADDRESS_2")
  	private String address2;
  	@Column(name="ADDRESS_3")
  	private String adderss3;
  	@Column(name="COUNTRY_CODE")
  	private String countryCode;
  	@Column(name="CITY")
  	private String city;
  	@Column(name="STATE")
  	private String state;
  	@Column(name="ZIP")
  	private String zip;
  	@Column(name="ZIP_PLUS")
  	private String zipPlus;
  	@Column(name="CREATED")
  	private Date created;
  	@Column(name="UPDATED")
 	private Date updated;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAdderss3() {
		return adderss3;
	}
	public void setAdderss3(String adderss3) {
		this.adderss3 = adderss3;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZipPlus() {
		return zipPlus;
	}
	public void setZipPlus(String zipPlus) {
		this.zipPlus = zipPlus;
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

package com.bazzar.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* PHONE.
*/
@Entity
@Table(name="PHONE")
public class Phone {
	
	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="TYPE")
  	private String type;
  	@Column(name="COUNTRY_CODE")
  	private String countryCode;
  	@Column(name="AREA_CODE")
  	private String areaCode;
  	@Column(name="NUMBER")
  	private String number;
  	@Column(name="EXTENSION")
  	private String extension;
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
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
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

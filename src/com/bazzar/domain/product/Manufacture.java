package com.bazzar.domain.product;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bazzar.domain.Picture;


@Entity
@Table(name = "MANUFACTURE")
public class Manufacture {
	
	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "NUMBER")
	private String number;
	@Column(name = "AUTHORIZE_PICTURE")
	private boolean authorizePicture;
	@Column(name="CREATED")
 	private Date created;
 	@Column(name="UPDATED")
	private Date updated; 
 	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<MANUFACTURE_PICTURE>",
	     joinColumns = @JoinColumn( name="MANUFACTURE_ID"),
	     inverseJoinColumns = @JoinColumn( name="PICTURE_ID")
	)
 	private Set <Picture> picture;
 	
 	
	public Set<Picture> getPicture() {
		return picture;
	}
	public void setPicture(Set<Picture> picture) {
		this.picture = picture;
	}
	public boolean isAuthorizePicture() {
		return authorizePicture;
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
	public void setAuthorizePicture(boolean authorizePicture) {
		this.authorizePicture = authorizePicture;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

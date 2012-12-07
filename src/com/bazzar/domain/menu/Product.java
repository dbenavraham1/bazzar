package com.bazzar.domain.menu;

import java.io.Serializable;
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

import com.bazzar.domain.Picture;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 

	@Column(name="ATTRIBUTE") 
 	private String attribute;
 	@Column(name="VALUE") 
 	private String value;
 	@Column(name="DISPLAY_OPTIONO")
 	private String displayOption;
 	@Column(name="CREATED")
 	private Date created;
 	@Column(name="UPDATED")
	private Date updated; 
 	
 	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<PRODUCT_PICTURE>",
	     joinColumns = @JoinColumn( name="PRODUCT_ID"),
	     inverseJoinColumns = @JoinColumn( name="PICTURE_ID")
	)
	private Set <Picture> picture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayOption() {
		return displayOption;
	}

	public void setDisplayOption(String displayOption) {
		this.displayOption = displayOption;
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

	public Set<Picture> getPicture() {
		return picture;
	}

	public void setPicture(Set<Picture> picture) {
		this.picture = picture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 	
 	
}

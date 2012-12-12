package com.bazzar.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PICTURES")
public class Picture {

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	@Column(name = "PICTURE_LOCATION")
	private String pictureLocation;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ALT")
	private String alt;
	@Column(name="CREATED")
 	private Date created;
 	@Column(name="UPDATED")
	private Date updated; 
 	
 	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPictureLocation() {
		return pictureLocation;
	}
	public void setPictureLocation(String pictureLocation) {
		this.pictureLocation = pictureLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}

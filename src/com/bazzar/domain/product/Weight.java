package com.bazzar.domain.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEIGHT")
public class Weight {

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "CATEGORY_GROUP")
	private long categoryGroup;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "ATTRIBUTE")
	private String attribute;
	@Column(name = "VALUE")
	private String value;
	@Column(name = "DISPLAY_OPTION")
	private String displayOption;
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
	public long getCategoryGroup() {
		return categoryGroup;
	}
	public void setCategoryGroup(long categoryGroup) {
		this.categoryGroup = categoryGroup;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

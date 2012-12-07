package com.bazzar.domain.product;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bazzar.domain.Picture;
import com.bazzar.domain.QA;
import com.bazzar.domain.Review;
import com.bazzar.domain.Shipping;

@Entity
@Table(name = "ITEM") 
public class Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "SUBJECT")
	private String subgect;
	@Column(name = "SPECIAL_OFFER_PRICE")
	private double specialOfferPrice;
	@Column(name = "SPECIAL_PRICE_START")
	private Date specialPriceStart;
	@Column(name = "SPECIAL_PRICE_END")
	private Date specialPriceEnd;
	@Column(name = "SPECIAL_PRICE_ACTIVE")
	private boolean spesialPriceActive;
	@Column(name = "SALE_PRICE")
	private double salePrice;
	@Column(name = "LISTED_PRICE")
	private double listedPrice;
	@Column(name = "QTY")
	private int quantity; 
	@Column(name = "REBATE")
	private boolean rebate;
	@Column(name = "IN_STOCK")
	private boolean inStock;
	@Column(name = "AVERAGE_CUSTOMER_RATING")
	private int averageCustomerRating;
	@Column(name = "MANUFACTURE_MODEL_NUMBER")
	private String manufactureModelNumber;
	@Column(name = "BAR_CODE")
	private String barCode;
	@Column(name="CREATED")
	private Date created;
	@Column(name="UPDATED")
	private Date updated;
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_MANUFACTURE>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="MANUFACTURE_ID")
	)
	private Set<Manufacture> manufacture;
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_SHIPPING>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="SHIPPING_ID")
	)
	private Set <Shipping> shipping;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_REVIEW>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="REVIEW_ID")
	)
	private Set <Review> review;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_PICTURES>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="PICTURES_ID")
	)
	private Set <Picture> pictureLocation;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_WARRANTY>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="WARRANTY_ID")
	)
	private Set <Warranty> warranty;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_WEIGHT>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="WEIGHT_ID")
	)
	private Set <Weight> wieght;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_FEATURES>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="FEATURES_ID")
	)
	private Set <Features> features;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_DEMENSIONS>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="DEMENSIONS_ID")
	)
	private Set <Demensions> demensions;
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_ACCESSORIES>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="ACCESSORIES_ID")
	)
	private Set <Accessories> accessories;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_DETAIL>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="DETAIL_ID")
	)
	private Set <Detail> detail;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_SPECIFICATION>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="SPECIFICATION_ID")
	)
	private Set <Specification> specification;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<ITEM_QA>",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="QA_ID")
	)
	private Set <QA> qa;
	
	
	public boolean isRebate() {
		return rebate;
	}
	public void setRebate(boolean rebate) {
		this.rebate = rebate;
	}
	public String getManufactureModelNumber() {
		return manufactureModelNumber;
	}
	public void setManufactureModelNumber(String manufactureModelNumber) {
		this.manufactureModelNumber = manufactureModelNumber;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
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
	public Set<QA> getQa() {
		return qa;
	}
	public void setQa(Set<QA> qa) {
		this.qa = qa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubgect() {
		return subgect;
	}
	public void setSubgect(String subgect) {
		this.subgect = subgect;
	}
	public double getSpecialOfferPrice() {
		return specialOfferPrice;
	}
	public void setSpecialOfferPrice(double specialOfferPrice) {
		this.specialOfferPrice = specialOfferPrice;
	}
	public Date getSpecialPriceStart() {
		return specialPriceStart;
	}
	public void setSpecialPriceStart(Date specialPriceStart) {
		this.specialPriceStart = specialPriceStart;
	}
	public Date getSpecialPriceEnd() {
		return specialPriceEnd;
	}
	public void setSpecialPriceEnd(Date specialPriceEnd) {
		this.specialPriceEnd = specialPriceEnd;
	}
	public boolean isSpesialPriceActive() {
		return spesialPriceActive;
	}
	public void setSpesialPriceActive(boolean spesialPriceActive) {
		this.spesialPriceActive = spesialPriceActive;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public double getListedPrice() {
		return listedPrice;
	}
	public void setListedPrice(double listedPrice) {
		this.listedPrice = listedPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public int getAverageCustomerRating() {
		return averageCustomerRating;
	}
	public void setAverageCustomerRating(int averageCustomerRating) {
		this.averageCustomerRating = averageCustomerRating;
	}
	public Set<Manufacture> getManufacture() {
		return manufacture;
	}
	public void setManufacture(Set<Manufacture> manufacture) {
		this.manufacture = manufacture;
	}
	public Set<Shipping> getShipping() {
		return shipping;
	}
	public void setShipping(Set<Shipping> shipping) {
		this.shipping = shipping;
	}
	public Set<Review> getReview() {
		return review;
	}
	public void setReview(Set<Review> review) {
		this.review = review;
	}
	public Set<Picture> getPictureLocation() {
		return pictureLocation;
	}
	public void setPictureLocation(Set<Picture> pictureLocation) {
		this.pictureLocation = pictureLocation;
	}
	public Set<Warranty> getWarranty() {
		return warranty;
	}
	public void setWarranty(Set<Warranty> warranty) {
		this.warranty = warranty;
	}
	public Set<Weight> getWieght() {
		return wieght;
	}
	public void setWieght(Set<Weight> wieght) {
		this.wieght = wieght;
	}
	public Set<Features> getFeatures() {
		return features;
	}
	public void setFeatures(Set<Features> features) {
		this.features = features;
	}
	public Set<Demensions> getDemensions() {
		return demensions;
	}
	public void setDemensions(Set<Demensions> demensions) {
		this.demensions = demensions;
	}
	public Set<Accessories> getAccessories() {
		return accessories;
	}
	public void setAccessories(Set<Accessories> accessories) {
		this.accessories = accessories;
	}
	public Set<Detail> getDetail() {
		return detail;
	}
	public void setDetail(Set<Detail> detail) {
		this.detail = detail;
	}
	public Set<Specification> getSpecification() {
		return specification;
	}
	public void setSpecification(Set<Specification> specification) {
		this.specification = specification;
	}
		
}

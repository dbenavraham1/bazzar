package com.bazzar.domain.customer;


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

import com.bazzar.domain.Address;
import com.bazzar.domain.Email;
import com.bazzar.domain.Phone;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
	
	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="TYPE")
	private String type;
	@Column(name="PREFIX")
	private Long prefix;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="MIDDLE_NAME")
	private String middleName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="DOB")
	private Date dob;
	@Column(name="CREATED")
	private Date created;
	@Column(name="UPDATED")
	private Date update;
 
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<PERSON_ADDRESS>",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="ADDRESS_ID")
	)
	private Set <Address> address;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<PERSON_USER>",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="USER_ID")
	)
	private Set <User> user;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<PERSON_CREDITCARD>",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="CREDITCARD_ID")
	)
	private Set <CreditCard> creditcard;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<PERSON_EMAIL>",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="EMAIL_ID")
	)
	private Set <Email> email;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="<PERSON_PHONE>",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="PHONE_ID")
	)
	private Set <Phone> phone;

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

	public Long getPrefix() {
		return prefix;
	}

	public void setPrefix(Long prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Set<CreditCard> getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(Set<CreditCard> creditcard) {
		this.creditcard = creditcard;
	}

	public Set<Email> getEmail() {
		return email;
	}

	public void setEmail(Set<Email> email) {
		this.email = email;
	}

	public Set<Phone> getPhone() {
		return phone;
	}

	public void setPhone(Set<Phone> phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

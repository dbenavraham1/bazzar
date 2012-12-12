package com.bazzar.domain.customer;

import java.io.Serializable;

import javax.persistence.OneToOne;

class CustomerId implements Serializable {

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	private static final long serialVersionUID = 1L;
	@OneToOne User user;
	String customerNumber;
}

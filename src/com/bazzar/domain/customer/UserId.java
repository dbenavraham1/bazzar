package com.bazzar.domain.customer;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
class UserId implements Serializable {

	private static final long serialVersionUID = 1L;
	String firstName;
	String lastName;
}

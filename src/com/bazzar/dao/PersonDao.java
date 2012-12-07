package com.bazzar.dao;

import com.bazzar.domain.customer.Person;
import com.bazzar.domain.security.Authority;
import com.bazzar.domain.security.BazzarUser;

public interface PersonDao {
	
	public Person findPersonById (long personId);
	public Person getPersonNotifications(long personId);
	public Person getPersonReviews(long personId);
	public Person getPersonCreditCards(long personId);
	public long createPerson (Person person);
	public long updatePerson (Person person);
	
	public long saveUser(BazzarUser user);
	public BazzarUser findUserByName(String userName);
	public Authority saveAuthority(Authority auth) ;
}

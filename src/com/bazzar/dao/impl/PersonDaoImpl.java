package com.bazzar.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.dao.PersonDao;
import com.bazzar.domain.customer.Person;
import com.bazzar.domain.security.Authority;
import com.bazzar.domain.security.BazzarUser;

@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl implements PersonDao {
	protected static Logger logger = Logger.getLogger ( "PersonDao" );
	  
	public Person findPersonById(long personId) {
		return (Person) entityManager.find(Person.class, personId);
	}
	@Transactional
	public long saveUser(BazzarUser user) {
		try {
			BazzarUser user1 = findUserByName(user.getUsername());
			if (user1 != null && user1.getId() == user.getId()) {
				user = entityManager.merge(user);
			} else if (user1 != null) {
				throw new RuntimeException("User with name '"
						+ user.getUsername() + "' already exists");
			} else {
				entityManager.persist(user);
			}

		} finally {
			if (entityManager != null)
				entityManager.close();
		}
		return user.getId();
	}
	@Transactional
	public Authority saveAuthority(Authority auth) {
		try {
			entityManager.persist(auth);
		} finally {
			if (entityManager != null)
				entityManager.close();
		}
		return auth;
	}
	@Transactional
	public long createPerson(Person person) {
		try {
			entityManager.persist(person);
		} finally {
			if (entityManager != null)
				entityManager.close();
		}
		return person.getId();
	}
	@Transactional
	public long updatePerson(Person person) {
		try {
			entityManager.merge(person);
		} finally {
			if (entityManager != null)
				entityManager.close();
		}
		return person.getId();
	}
	public Person getPersonNotifications(long personId) {
		return (Person) entityManager
				.createQuery(
						"FROM Person p left outer join Notification n WHERE p.status<>0 and p.id = :personId")
				.setParameter("personId", personId).getSingleResult();
	}
	public Person getPersonReviews(long personId) {
		return (Person) entityManager
				.createQuery(
						"FROM Person p left outer join Review r WHERE p.status<>0 and p.id = :personId")
				.setParameter("personId", personId).getSingleResult();
	}
	public BazzarUser findUserByName(String userName) {
		Query q = (Query) entityManager.createQuery(
				"FROM CEConvergenceUser u WHERE u.username = :userName")
				.setParameter("userName", userName);
		BazzarUser user = null;
		try {
			user = (BazzarUser) ((javax.persistence.Query) q).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public Person getPersonCreditCards(long personId) {
		return (Person) entityManager
				.createQuery(
						"FROM Person p left outer join CReditcard r WHERE p.status<>0 and p.id = :personId")
				.setParameter("personId", personId).getSingleResult();
	}


}

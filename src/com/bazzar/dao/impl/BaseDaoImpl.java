package com.bazzar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bazzar.dao.BaseDao;

/**
 * @author Chris.Johnson
 *
 */
public class BaseDaoImpl implements BaseDao {
	
	@PersistenceContext(unitName = "cecdb")
	protected EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.hsc.vantage.dao.BaseDao#findById(long)
	 */
	public <T> T findById(Class<T> entityClass, Object id) {
		return entityManager.find(entityClass, id);
	}

    public List<?> findAll(Class<?> entityClass) {
        return entityManager.createQuery("from " + entityClass.getName()).getResultList();
    }
    
    public List<?> findByProperty(Class<?> entity, String prop, Object val) {
    	return entityManager.createQuery(
    		"from " + entity.getName() + " where " + prop + " = :prop ")
    		.setParameter("prop", val)
    		.getResultList();
	}

    /* (non-Javadoc)
	 * @see com.hsc.vantage.dao.BaseDao#merge(java.lang.Object)
	 */
	public Object merge(Object o) {
		return entityManager.merge(o);
	}

	/* (non-Javadoc)
	 * @see com.hsc.vantage.dao.BaseDao#persist(java.lang.Object)
	 */
	public void persist(Object o) {
		entityManager.persist(o);
	}

	public void refresh(Object o) {
		entityManager.refresh(o);
	}

	public void flush(){
	    entityManager.flush();
	}

    public void remove(Object o) {
        entityManager.remove(o);
    }
}

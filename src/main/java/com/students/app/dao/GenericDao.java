package com.students.app.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class GenericDao <T> extends HibernateUtil
{
	public void save(T entity) {

		final Session session = getSession();
		final Transaction ts = session.beginTransaction();
		session.saveOrUpdate(entity);
		ts.commit();
		session.close();
	}

	public void remove(T entity) {
		
		final Session session = getSession();
		final Transaction ts = session.beginTransaction();
		session.delete(entity);
		ts.commit();
		session.close();
		
	}
	
	public void update(T entity) {
		
		final Session session = getSession();
		final Transaction ts = session.beginTransaction();
		session.update(entity);
		ts.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		
		final Session session = getSession();
		final Criteria c = session.createCriteria(getEntityClass());
		final List<T> objs = c.list();
		session.close();
		return objs;
	}

	@SuppressWarnings("unchecked")
	public T find(Integer id) {
		final Session session = getSession();
		T obj = (T)session.load(getEntityClass(), id);
		Hibernate.initialize(obj);
		session.close();
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		
		final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();  
		return (Class<T>)(type).getActualTypeArguments()[0];
	}

}

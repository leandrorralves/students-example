package com.students.app.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.students.app.entity.Student;

public class StudentDao extends GenericDao<Student> {
	
	@SuppressWarnings("unchecked")
	public List<Student> list() {
		final Session session = getSession();
		final Criteria c = session.createCriteria(getEntityClass());
		c.addOrder(Order.asc("name"));
		final List<Student> objs = c.list();
		for (Student obj : objs)
			obj = obj.clone();
		session.close();
		return objs;
	}
}

package com.students.app.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import com.students.app.entity.Team;

public class TeamDao extends GenericDao<Team> {
	
	@SuppressWarnings("unchecked")
	public List<Team> list() {
		final Session session = getSession();
		final Criteria c = session.createCriteria(getEntityClass());
		final List<Team> objs = c.list();
		for (Team obj : objs)
			obj = obj.clone();
		session.close();
		return objs;
	}
}
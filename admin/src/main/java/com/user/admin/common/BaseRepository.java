package com.user.admin.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepository 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
}

package com.alpha.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import antlr.collections.List;

import com.alpha.dao.UserDAO;
import com.alpha.entity.User;

public class UserDAOImpl implements UserDAO{

	SessionFactory sessionFactory;
	

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public List search(User condition) {
		List list = null;
		
		//获取Session
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			
			Criteria c = session.createCriteria(User.class);
			Example example = Example.create(condition);
			c.add(example);
			list = (List) c.list();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("错误发生在UserDAOImpl的Serch函数");
			tx.rollback();
		}
		return list;
	}

}

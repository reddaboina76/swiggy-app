package com.swiggy.controller.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.ui.Model;

import com.swiggy.controller.dao.interfaces.IUserDao;
import com.swiggy.controller.pojo.User;

public class UserHibernateDaoImpl implements IUserDao { ////Assume this is Dog..

	final static Logger logger = Logger.getLogger(UserHibernateDaoImpl.class);
	public void saveUser(User user) {
		logger.info("Executing UserHibernateDaoImpl :: saveUser");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();// Session Factory is pool of sessions(connections)
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user); // save to database.. saveUser.. layer1.3
		tx.commit();
		logger.debug("User Registration completed!! "+ user.getMailId());
		session.close();
		logger.info("Exiting UserHibernateDaoImpl :: saveUser");

	}
		public List<User> loginUser(String name,String password) {
			logger.info("Executing UserHibernateDaoImpl :: loginUser");
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			SessionFactory sf = config.buildSessionFactory();// Session Factory is pool of sessions(connections)
			Session session = sf.openSession();
			Query userSelectQuery = session.createQuery("from User where mailid=:mail and password=:pwd ");
			userSelectQuery.setParameter("mail", name);
			userSelectQuery.setParameter("pwd", password);
			List<User> list = userSelectQuery.list();
			logger.info("Exiting UserHibernateDaoImpl :: loginUser");
				return list;
		
	}
		 
}

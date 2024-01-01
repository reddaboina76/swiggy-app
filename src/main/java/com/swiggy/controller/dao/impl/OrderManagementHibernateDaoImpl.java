package com.swiggy.controller.dao.impl;   //data access object(DAO)..dao layer work on DataBase..

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.ui.Model;

import com.swiggy.controller.pojo.ItemInfo;

public class OrderManagementHibernateDaoImpl {    //Assume this is Dog..
	
	final static Logger logger = Logger.getLogger(OrderManagementHibernateDaoImpl.class);
	public int deleteItem(int itemId) {
		logger.info("Executing OrderManagementDaoImpl :: deleteItem");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();// Session Factory is pool of sessions(connections)
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("delete ItemInfo where itemId = :id");
		query.setParameter("id", itemId);
		int result = query.executeUpdate();
		tx.commit();
		session.close();
		logger.debug("deleteItem done!!  :: " + itemId);
		logger.info("Exiting OrderManagementDaoImpl :: deleteItem");
		return result;
	}
	public List<ItemInfo> fetchMenu() {
		logger.info("Executing OrderManagementDaoImpl :: fetchMenu");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();// Session Factory is pool of sessions(connections)
		Session session = sf.openSession();
		
		Query FecthMenuQuery = session.createQuery("from ItemInfo ");
		List<ItemInfo> menuData = FecthMenuQuery.list();
		session.close();
		
		logger.info("Exiting OrderManagementDaoImpl :: fetchMenu");
		return menuData;
	}
	public void updateItem(ItemInfo item) {
		logger.info("Executing OrderManagementDaoImpl :: updateItem");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();// Session Factory is pool of sessions(connections)
		Session session = sf.openSession();
		
		Transaction tc = session.beginTransaction();
		session.update(item);
		tc.commit();
		logger.debug("update done for :: " + item.getItem());
		logger.info("Exiting OrderManagementDaoImpl :: updateItem");
		session.close();
	}
	public ItemInfo getItemInfoByItemId(int itemId) {
		logger.info("Executing OrderManagementDaoImpl :: getItemInfoByItemId");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();// Session Factory is pool of sessions(connections)
		Session session = sf.openSession();

		// fetch item information from database based on itemId
		Query FecthMenuQuery = session.createQuery("from ItemInfo where itemId = : id ");
		FecthMenuQuery.setParameter("id", itemId);
		ItemInfo item = (ItemInfo) FecthMenuQuery.list().get(0);
		logger.info("Exiting OrderManagementDaoImpl :: getItemInfoByItemId");
		return item;
	}
}

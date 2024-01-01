package com.swiggy.controller.dao.Jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.Logger;

import com.swiggy.controller.dao.interfaces.IUserDao;
import com.swiggy.controller.pojo.User;

public class UserJdbcDaoImpl implements IUserDao{ //Assume this is Cat..

	final static Logger logger = Logger.getLogger(UserJdbcDaoImpl.class);
	public void saveUser(User user) {
		logger.info("Execute UserJdbcDaoImpl :: saveUser"); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggyproject", "root", "root");
			//PreparedStatement ps = con.prepareStatement("insert into(MailId,Name,Password,MobileNumber,City) values(?,?,?,?,?)"); oracle quarry..
			PreparedStatement ps=con.prepareStatement("insert into swiggyuser values(?,?,?,?,?)"); 
			ps.setString(1, user.getMailId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassWord());
			ps.setString(4, user.getMobileNumber());
			ps.setString(5, user.getCity());
			ps.executeUpdate();
			logger.debug("User registration completed ::" + user.getMailId());
			con.close();
		} catch (Exception e) {
			logger.debug("Exception occured while saving user to databse!! ::",e );
		}
		logger.info("Exit UserJdbcDaoImpl :: saveUser");
	}
	public List<User> loginUser(String name, String password) {
		logger.info("Execute UserJdbcDaoImpl :: loginUser");
		logger.debug("In Progress...");
		logger.info("Exit UserJdbcDaoImpl :: loginUser");

		return null;
	}

}

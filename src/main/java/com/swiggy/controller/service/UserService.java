package com.swiggy.controller.service;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.swiggy.controller.dao.Jdbc.impl.UserJdbcDaoImpl;
import com.swiggy.controller.dao.impl.UserHibernateDaoImpl;
import com.swiggy.controller.dao.interfaces.IUserDao;
import com.swiggy.controller.pojo.User;
import com.swiggy.controller.validations.SwiggyValidation;

public class UserService {    //in service layer Business logic,validation logic
	
	@Autowired
	IUserDao dao;                      //db tableName:services..
	
	//UserHibernateDaoImpl dao = new UserHibernateDaoImpl();
	//IUserDao dao = new UserHibernateDaoImpl();
	
	final static Logger logger = Logger.getLogger(UserService.class);
	
	public String saveUser(User user, Model m) {
		logger.info("Executing UserService :: saveUser");
		logger.debug("Request came for registration :: " +user.getMailId()+ "--"+user.getMobileNumber()+"--"+user.getCity()+"--"+user.getName()+"--"+user.getPassWord());
		// Validation Logic Here
		boolean isValidmail = SwiggyValidation.isValidmail(user.getMailId());
		logger.info("MailId Validation Check : " + isValidmail);
		if (!isValidmail) {
			logger.debug("Invalid MailId entered :: " +user.getMailId());
			m.addAttribute("message", "Invalid MailId Entered!! Please Try With Valid One!!");
			return "register";
		}

		boolean isValidmobile = SwiggyValidation.isValidmobile(user.getMobileNumber());
		logger.info("Mobile Validation Check : " + isValidmobile);
		if (!isValidmobile) {
			logger.debug("Invalid MobileNumber entered :: " +user.getMobileNumber());
			m.addAttribute("message", "Invalid mobile Entered!! Please Try With Valid One!!");
			return "register";
		}
		// Validation Logic Ends Here	
		try {
		logger.debug("saving user to database :: " + user.getMailId());
		dao.saveUser(user); //saveUser send to dao layer..1.2
		}catch(Exception e) {
			logger.error("Excetion while registration " ,e);
		}
		logger.info("Exiting UserService :: saveUser");
		return "login";
	}

	public String loginUser(String name, String password, Model model /* ,HttpSession httpSession */ ) {
		logger.info("Executing UserService :: loginUser");
		
		
		List<User> list=dao.loginUser(name, password);

		logger.debug("parsing list of user and printing console   1");
		if (list == null || list.isEmpty()) {  //if list is empty means username or password is not matching with database.. 
			logger.debug("User entered Invalid credentials :: " + name);
			model.addAttribute("message", "Invalid UserName or PassWord!!prease try again!!");
			return "login";
		}
		//httpSession.setAttribute("name", name);	//adding name to session object..
		//httpSession.setAttribute("password", password);
		//httpSession.setMaxInactiveInterval(10); //session time..
		for (User user : list) {
			System.out.println(user.getName() + " " + user.getMailId() + " " + user.getPassWord() + " "
					+ user.getMobileNumber() + " " + user.getCity());
		}
		logger.debug("parsing is done 2");
		
		logger.info("Exiting UserService :: loginUser");

		return "Home";
	}
}

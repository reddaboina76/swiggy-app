package com.swiggy.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.swiggy.controller.pojo.User;
import com.swiggy.controller.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	final static Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	// Get The Data From jsp Page..Store the information database...
	public String saveUser(User user, Model m) {   //this method must return a String..
		logger.info("Executing Usercontroller method :: saveUser");
									// 1.public String saveUser(@RequestParam("UserName") String
									// name,@RequestParam("MailId") String mailid,@RequestParam("MobileNumber")
									// String mobilenumber,@RequestParam("PassWord") String password,
									// @RequestParam ("City") String city) {
		System.out.println(user.getName() + " " + user.getMailId() + " " + user.getPassWord() + " "
				+ user.getMobileNumber() + " " + user.getCity());
									/*
									 * 1.1..User user = new User(); user.setMailId(mailid); user.setName(name);
									 * user.setMobileNumber(mobilenumber); user.setPassWord(password);
									 * user.setCity(city);
									 */							
									//UserService service = new UserService();   //UserService class object.. //send to service layer1.1
		String res = service.saveUser(user, m);   //user(User pojo class) object..
		logger.info("Exiting UserController :: saveUser");
		return res ; //res=register or login jsp pages..	
	}
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("userName") String name, @RequestParam("PassWord") String password,
			Model model/* ,HttpSession httpSession */) {
		System.out.println("Executing loginUser method :: loginUser!!");
		
		String res = service.loginUser(name, password, model/* ,httpSession */);
		
		System.out.println("Exiting loginUser method :: loginUser!!");
		return res;
	}

	@RequestMapping(value="/logout")
	public String logoutUser(Model model, HttpSession httpSession) {
		httpSession.removeAttribute("name");
		model.addAttribute("message", "logout successfully completed!!");
		return "login";
	}
}

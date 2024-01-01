package com.swiggy.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SpringSecurityHelperController {

	@RequestMapping(value="/loginPage")
	public String goToLoginPage(){
		return "login";
	}
	@RequestMapping(value="/loginFailed")
	public String loginFail(Model model) {
		model.addAttribute("message", "Login attempt failed!!");
		model.addAttribute("message2", "Reason ::Bad Credentails!!");
		return "login";
	}
	@RequestMapping(value="/goToHome")
	public String goToHome() {
		return "Home";
	}
	@RequestMapping(value="/logoutPage")
	public String logoutSuccess(Model model){
		model.addAttribute("message", "User Logout Successfully done!!");
		return "login";
	}
	@RequestMapping(value="/accessDenied")
	public String accessDenied(Model model){
		model.addAttribute("message", "You don't have access this Page!!");
		return "Home";
	}
}

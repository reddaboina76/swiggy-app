package com.swiggy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
	@RequestMapping(value="/goToHomePage")
	public String goToHome() {
		System.out.println("Executing BaseController :: goToHome Method!! ");
		return "Home";
		
	}
}

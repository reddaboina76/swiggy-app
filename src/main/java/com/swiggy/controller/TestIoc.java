package com.swiggy.controller;

import com.swiggy.controller.pojo.Passport;
import com.swiggy.controller.pojo.Student;

public class TestIoc {

	public static void main(String[] args) {  
		Student s1 = new Student();   //which time use setter and getters big data time...Mostly use this..but based class Design..[1.constructor will use goto constructor othrwise goto use setter and getters ]
		s1.setStdId(200);
		s1.setStdName("hareesh");
		s1.setCollegeName("abv");
		s1.setPport(new Passport());
		
		
		//which time use constructor least data setting time only..Not recomanded... 
		Student s2 = new Student(200, "chiru", "cbit", "ameerpet", new Passport()); 
	}
}

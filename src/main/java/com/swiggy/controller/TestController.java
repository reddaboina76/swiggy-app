package com.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swiggy.controller.dao.impl.Cat;
import com.swiggy.controller.dao.impl.Dog;
import com.swiggy.controller.dao.impl.Human;
import com.swiggy.controller.dao.impl.IAnimal;
import com.swiggy.controller.pojo.College;
import com.swiggy.controller.pojo.Passport;
import com.swiggy.controller.pojo.Student;


@Controller
public class TestController {
	
	@Autowired(required =false) // default required=true and required=false Object Creation Time..
	private Student s1;
	
	@Autowired(required =false)
	private Student s2;
	
	@Qualifier(value="cbObj")
	@Autowired
	College c1;
	
	@Qualifier(value="cbObj")
	@Autowired
	College c2;
	
		@Qualifier(value = "aurObj")
		@Autowired
		College c3;
	
		@Qualifier(value = "aurObj")
		@Autowired
		College c4;
	 
	
	@RequestMapping(value = "/testIoc")
	public String testIoc() {
		System.out.println("Triggred testIoc method!!");
		
		/*
		 * //In Case::spring not creating Object..To Create Own logic to create Object..
		 * if (s1 == null) { System.out.println("s1 is null.."); s1 = new Student();
		 * s1.setPport(new Passport()); } if (s2 == null) {
		 * System.out.println("s2 is null.."); s2 = new Student(); s2.setPport(new
		 * Passport()); }
		 */

		System.out.println("-------------------");
		c1.setLocation("c1 ::   hyd");
		c2.setLocation("c2 ::    wgl");
		c3.setLocation("c3 ::   vkl");
		c4.setLocation("c4 ::   mgt");

		System.out.println(c1.getCollegeName() + "----" + c1.getLocation());
		System.out.println(c2.getCollegeName() + "----" + c2.getLocation());
		System.out.println(c3.getCollegeName() + "----" + c3.getLocation());
		System.out.println(c4.getCollegeName() + "----" + c4.getLocation());

		System.out.println("-------------------");
		
		s2.setStdId(101);
		s2.setStdName("raghu");
		s2.setCollegeName("Aurora");
		//s2.setCollegeLocation("hyd");
		
		s2.getPport().setPptId(123);
		s2.getPport().setIssuedCity("ameerpet");
		
		System.out.println(s2.getStdId()+" " +s2.getCollegeName()+"  "+s2.getCollegeLocation()+" "+s2.getPport().getPptId()+"  "+s2.getPport().getIssuedCity()+"  "+s2.getPport().getCountry());	 
		
		s1.setStdId(100);
		s1.setStdName("srinivas");
		s1.setCollegeName("cbit");
		//s1.setCollegeLocation("guntur");
		
		s1.getPport().setPptId(458);
		s1.getPport().setIssuedCity("Hyderabad"); 
		System.out.println(s1.getStdId()+" " +s1.getCollegeName()+" " +s1.getCollegeLocation()+" "+s1.getPport().getPptId()+"  "+s2.getPport().getIssuedCity()+"  "+s2.getPport().getCountry());	 

		/*
		 * List<String> list=s1.getSubjects(); for (String sub : list) {
		 * System.out.println(sub); } //java 1.8 version will work::maven 1.8 compiler
		 * properties add on pox.xml.... System.out.println("1.8 example.....");
		 * list.forEach(System.out::println);
		 * System.out.println("........................");
		 */
		
		return "register";
	}

	public static void main(String[] args) {
		IAnimal animal = new Dog(); // IAnimal is reference...Human is object..
		animal.getNoice();
		animal.getLegs();
		animal.database();
	}
}

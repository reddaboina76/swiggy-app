package com.swiggy.controller.pojo;

import java.util.List;

public class Student {

	private int stdId;
	private String stdName;
	private String collegeName;
	private String collegeLocation;
	private List<String> subjects;
	private Passport pport;
	
	public Student(){
		System.out.println("no Argument constructor Student!!");
	}
	
	public Student(String collegeName,String collegeLocation,Passport pport) {
		System.out.println("3 Student Argument constructor Student!!");

		this.collegeName = collegeName;
		this.collegeLocation= collegeLocation;
		this.pport = pport;
	}
	
	public Student(int stdId, String stdName, String collegeName, String collegeLocation, Passport pport) {
		System.out.println("Argument constructor Student!!");

		this.stdId = stdId;
		this.stdName = stdName;
		this.collegeName = collegeName;
		this.collegeLocation = collegeLocation;
		this.pport = pport;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeLocation() {
		return collegeLocation;
	}
	
	
	public void setCollegeLocation(String collegeLocation) {
		this.collegeLocation = collegeLocation;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public Passport getPport() {
		return pport;
	}
	public void setPport(Passport pport) {
		this.pport = pport;
	}
	
	
}

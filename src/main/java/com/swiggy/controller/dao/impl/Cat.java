package com.swiggy.controller.dao.impl;

public class Cat implements IAnimal {

	public void getNoice() { // Assume that JDBC implementation..
		System.out.println("Meaw Meaw!!");
	}

	public void getLegs() {
		System.out.println("4 legs!!");
	}

	public void database() {
		System.out.println("jdbc flow");
	}
}

package com.swiggy.controller.dao.impl;

public class Dog implements IAnimal {

	public void getNoice() { // Assume that HIBERNATE implementation
		System.out.println("Bow Bow!!");
	}

	public void getLegs() {
		System.out.println("4 Legs!!");

	}

	public void database() {
		System.out.println("hibernate flow");
	}
}

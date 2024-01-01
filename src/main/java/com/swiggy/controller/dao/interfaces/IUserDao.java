package com.swiggy.controller.dao.interfaces;

import java.util.List;

import com.swiggy.controller.pojo.User;

public interface IUserDao {

	public void saveUser(User user);
	
	public List<User> loginUser(String name,String password);
}

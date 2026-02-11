package com.twg.fruitstorerestapi.service;

import com.twg.fruitstorerestapi.Entity.User;

public interface UserService {

	public User registerUser(User user);
	
	public User findByUsername(String username);
	
}

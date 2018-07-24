package com.csc.dao;

import java.util.List;

import com.csc.model.User;

public interface UserDao {
	User checkLogin(String username, String password);
	List<User> findAllUser();
	User getUser(int id);
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(int id);
}

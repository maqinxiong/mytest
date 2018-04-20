package com.itheima.dao;

import java.util.List;

import com.itheima.domin.User;

public interface UserDao {
	
	User findById(int id);
	
	List<User> findByUserName(String username);
}

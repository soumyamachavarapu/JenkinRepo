package com.rest.service;

import java.util.List;

import com.rest.model.User;

public interface IUserService 
{
	public User saveUser(User uobj);
	public User updateUser(User uobj,int uid);
	public User getUserById(int uid);
	public List<User> getAllUsers();
	public boolean delUser(int uid);

}

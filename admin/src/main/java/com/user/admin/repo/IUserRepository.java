package com.user.admin.repo;

import java.util.List;

import com.user.admin.entity.UserDetails;

public interface IUserRepository 
{
	public List<UserDetails> getUsers();
	
	public UserDetails getUserById(Long id);
	
	public void saveOrUpdateUser(UserDetails userDetails);
	
	public void deleteUser(Long id);
	
}

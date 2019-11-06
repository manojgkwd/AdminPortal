package com.user.admin.repo;

import java.util.List;

import com.user.admin.entity.UserDetails;

public interface IUserRepository 
{
	public List<UserDetails> getUsers();
	
}

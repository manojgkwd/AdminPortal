package com.user.admin.service;

import java.util.List;

import com.user.admin.dto.UserDetailsDto;

public interface IUserService 
{
	public List<UserDetailsDto> getUsers();
	
}

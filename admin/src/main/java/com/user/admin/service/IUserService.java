package com.user.admin.service;

import java.util.List;

import com.user.admin.dto.UserDetailsDto;

public interface IUserService 
{
	public List<UserDetailsDto> getUsers();

	public UserDetailsDto getUserById(Long id);

	public void saveUser(UserDetailsDto userDetails);

	public void updateUser(UserDetailsDto userDetails);
	
	public void deleteUser(Long id);

}

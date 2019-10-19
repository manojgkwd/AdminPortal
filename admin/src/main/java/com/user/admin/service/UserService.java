package com.user.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.admin.dto.UserDetailsDto;
import com.user.admin.entity.UserDetails;
import com.user.admin.repo.IUserRepository;

@Service
public class UserService implements IUserService 
{
	@Autowired
	private IUserRepository userRepository;

	@Override
	public List<UserDetailsDto> getUsers() 
	{
		List<UserDetailsDto> list = null;
		List<UserDetails> data = userRepository.getUsers();
		
		if (data.size() > 0) 
		{
			list = new ArrayList<UserDetailsDto>();
			for (UserDetails dataa : data) {
				UserDetailsDto detailsDto = new UserDetailsDto();
				BeanUtils.copyProperties(dataa, detailsDto);
				list.add(detailsDto);
			}
		}

		return list;
	}
	
	
	
}

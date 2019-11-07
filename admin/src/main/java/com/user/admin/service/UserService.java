package com.user.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.admin.dto.UserDetailsDto;
import com.user.admin.entity.UserDetails;
import com.user.admin.repo.IUserRepository;

@Service
public class UserService implements IUserService 
{
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
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

	@Override
	public UserDetailsDto getUserById(Long id) 
	{
		UserDetails userDetails = userRepository.getUserById(id);
		UserDetailsDto dto = null;
		if (userDetails != null) 
		{
			dto = new UserDetailsDto();
			BeanUtils.copyProperties(userDetails, dto);
		}
		return dto;
	}

	@Override
	public void saveUser(UserDetailsDto userDetails) 
	{
		if (userDetails != null ) 
		{
			UserDetails user = new UserDetails();
			BeanUtils.copyProperties(userDetails, user);
			
			try 
			{
				userRepository.saveOrUpdateUser(user);
			} catch (Exception e) 
			{
				logger.info(e.getStackTrace().toString());
			}
			
		}
		
	}

	@Override
	public void updateUser(UserDetailsDto userDetails) 
	{
		if (userDetails != null ) 
		{
			UserDetails user = new UserDetails();
			BeanUtils.copyProperties(userDetails, user);
			try 
			{
				userRepository.saveOrUpdateUser(user);
			} catch (Exception e) 
			{
				logger.info(e.getStackTrace().toString());
			}
		}
		
	}
	
	@Override
	public void deleteUser(Long id) 
	{
		userRepository.deleteUser(id);
	}

	
}

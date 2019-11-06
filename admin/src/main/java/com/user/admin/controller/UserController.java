package com.user.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.admin.dto.UserDetailsDto;
import com.user.admin.service.UserService;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> user()
	{
		List<UserDetailsDto> data = userService.getUsers();
		Map<String,Object> response=new HashMap<String,Object>();
		response.put("status", true);
		response.put("data", data);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		
	}
	
	/*
	 * @RequestMapping(value = "/user", method = RequestMethod.GET) public
	 * ResponseEntity<Map<String,Object>> userById() { List<UserDetailsDto> data =
	 * userService.getUsers(); Map<String,Object> response=new
	 * HashMap<String,Object>(); response.put("status", true); response.put("data",
	 * data);
	 * 
	 * return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	 * 
	 * }
	 */
	
	
	
}

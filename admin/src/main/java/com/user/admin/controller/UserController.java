package com.user.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.admin.dto.UserDetailsDto;
import com.user.admin.service.UserService;

@RestController
public class UserController 
{

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	/*List user*/
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> user() 
	{

		Map<String, Object> response = new HashMap<String, Object>();
		try 
		{
			List<UserDetailsDto> data = userService.getUsers();
			response.put("status", true);
			response.put("data", data);
		
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
		} catch (Exception e) 
		{
			e.printStackTrace();
			response.put("Status", false);
			response.put("data", "Data not found !");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
		
		}
	}

	  /*User by id*/
	  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET) 
	  public ResponseEntity<Map<String,Object>> userById(@PathVariable Long id) 
	  { 
		  Map<String,Object> response=new HashMap<String,Object>(); 

		  try 
		  {
			  UserDetailsDto data = userService.getUserById(id);
			  response.put("status", true);
			  response.put("data", data);
			  
			  return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
			  
		  } catch (Exception e) 
		  {
				e.printStackTrace();
				response.put("Status", false);
				response.put("data", "Exception occurred !");
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
		  }
		  
	  }
	  
	 
	  /*Save user*/
	  @RequestMapping(value="/user",method=RequestMethod.POST)
	  public ResponseEntity<Map<String, Object>> saveUser(@RequestBody UserDetailsDto userDetailsDto)
	  {
		  Map<String, Object> response = new HashMap<String, Object>();
		  try 
		  {
			  response.put("Status", true);
			  if (userDetailsDto != null) 
			  {
				  userService.saveUser(userDetailsDto);
				  response.put("data", "User created successfully");
			  } else 
			  {
				  response.put("data", "Data can not be null");
			  }

			  return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		  
		  } catch (Exception e) 
		  {
			  e.printStackTrace();
			  response.put("Status", false);
			  response.put("data", "Exception occurred !");
			
			  return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		  
		  }

	  }

	  
	  /*Update user*/
	  @RequestMapping(value="/user",method=RequestMethod.PUT)
	  public ResponseEntity<Map<String, Object>> updateUser(@RequestBody UserDetailsDto userDetailsDto)
	  {
		  Map<String,Object> response = new HashMap<String,Object>();
			try 
			{
				response.put("Status", true);
				if (userDetailsDto != null) 
				{
					userService.updateUser(userDetailsDto);
					response.put("data", "User updated successfully");
				}else
				{
					response.put("data", "Data can not be null !");
				}
			
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
			
			} catch (Exception e) 
			{
				e.printStackTrace();
				response.put("Status", false);
				response.put("data", "Exception occurred !");
			
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
			}
	  }
	  
	  
	  /*Delete user*/
	  @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE) 
	  public ResponseEntity<Map<String,Object>> deleteUser(@PathVariable Long id)
	  {
		  Map<String,Object> response=new HashMap<String,Object>();
		  try
		  {
			  response.put("status", true);
			  userService.deleteUser(id);
			  response.put("data",  "User deleted successfully");
			  return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		  }catch(org.springframework.dao.DataIntegrityViolationException ex){
			  response.put("status", false);
			  response.put("data", "This User can not be deleted as it is in use.");
			
			  return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		  
		  }
		  catch(Exception e)
		  {
			  response.put("status", false);
			  response.put("data", "Server error");
			
			  return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		  
		  }
	  }
	  
}

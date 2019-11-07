package com.user.admin.repo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.user.admin.common.BaseRepository;
import com.user.admin.entity.UserDetails;

@Repository
public class UserRepository extends BaseRepository implements IUserRepository 
{

	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	/*All users*/
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> getUsers()
	{
		List<UserDetails> userList = new ArrayList<UserDetails>();
		
		String sql = "from UserDetails";
		userList = getCurrentSession().createQuery(sql).list();
		return userList;
	}

	/*User by id*/
	@Override
	public UserDetails getUserById(Long id) 
	{
		String sql = "from UserDetails where userId = :userId";
		return (UserDetails) getCurrentSession().createQuery(sql).setParameter("userId", id).uniqueResult();
	}

	/*Save or update user*/
	@Override
	public void saveOrUpdateUser(UserDetails userDetails) 
	{
		try 
		{
			getCurrentSession().saveOrUpdate(userDetails);
		} catch (Exception e) 
		{
			logger.info(e.getStackTrace().toString());
		}
	}

	/*Delete user*/
	@Override
	public void deleteUser(Long id) 
	{
		UserDetails userDetails = getUserById(id);
		try 
		{
			getCurrentSession().delete(userDetails);
		} catch (Exception e) 
		{
			logger.info(e.getStackTrace().toString());
		}
	}

	
}

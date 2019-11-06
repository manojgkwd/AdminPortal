package com.user.admin.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.user.admin.common.BaseRepository;
import com.user.admin.entity.UserDetails;

@Repository
public class UserRepository extends BaseRepository implements IUserRepository 
{

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> getUsers() 
	{
		String sql = "from UserDetails";
		return getCurrentSession().createQuery(sql).list();
	}

}

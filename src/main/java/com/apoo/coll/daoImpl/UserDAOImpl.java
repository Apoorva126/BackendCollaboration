package com.apoo.coll.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.apoo.coll.dao.UserDAO;
import com.apoo.coll.model.UserDetail;

public class UserDAOImpl implements UserDAO {


	@Autowired
	SessionFactory sessionFactory;

	public boolean registerUser(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured adding User"+e);
			return false;
		}
	}

	
	public boolean updateUserDetail(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured updating User"+e);
			return false;
		}
	}

	
	public UserDetail getUser(String username) {
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class,username);
		session.close();
		return user;
	}

	
	public boolean makeOffline(UserDetail user) {
		try
		{
			user.setIsOnline("Off");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured to makeOffline"+e);
			return false;
		}
	}

	
	public boolean makeOnline(UserDetail user) {
		try
		{
			user.setIsOnline("On");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured to makeOnline"+e);
			return false;
		}
	}

	
	public boolean approveUser(UserDetail user) {
		try
		{
			user.setStatus("A");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: Approve User"+e);
			return false;
		}
	}

	
	public boolean rejectUser(UserDetail user) {
		try
		{
			user.setStatus("R");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:Reject User"+e);
			return false;
		}
	}

	
	
}
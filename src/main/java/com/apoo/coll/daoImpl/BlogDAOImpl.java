package com.apoo.coll.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apoo.coll.dao.BlogDAO;
import com.apoo.coll.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO

{
    @Autowired
    SessionFactory sessionFactory;
	
	
	public boolean addBlog(Blog blog) {

		try
		{
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: Adding blog"+e);
	        return false;
		}
	}

	
	public boolean deleteBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().remove(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: Deleting blog"+e);
	        return false;
		}
	}

	
	public boolean updateBlog(Blog blog) {

		try
		{
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: updating blog"+e);
	        return false;
		}
	}

	
	public Blog getBlog(int blogId) {
		Session session=sessionFactory.openSession();
		Blog blog=session.get(Blog.class, blogId);
		session.close();
		return blog;
	}

	
	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		@SuppressWarnings("unchecked")
		List<Blog> listBlog=(List<Blog>)query.list();
		session.close();
		return listBlog;
	}

	
	public boolean incrementLikes(Blog blog) {
		try
		{
			blog.setLikes(blog.getLikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:Increment Like:"+e);
		    return false;
		}
	}

	
	public boolean incrementDisLikes(Blog blog) {
		try
		{
			blog.setLikes(blog.getDislikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:Increment DisLikes:"+e);
		    return false;
		}
	}

	
	public boolean approveBlog(Blog blog) {
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:Approving Blog:"+e);
		    return false;
		}
	}

	
	public boolean rejectBlog(Blog blog) {
		try
		{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:Rejecting Blog:"+e);
		    return false;
		}
	}
	}

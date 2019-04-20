package com.apoo.coll.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apoo.coll.dao.BlogCommentDAO;
import com.apoo.coll.model.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO

{
	@Autowired
	SessionFactory sessionFactory;

	
	public boolean addBlogComment(BlogComment comment) {
		
		try
		{
			sessionFactory.getCurrentSession().save(comment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised: Adding the comment"+e);
			return false;
		}
	}

	
	public boolean deleteBlogComment(BlogComment comment) {
		try
		{
			sessionFactory.getCurrentSession().remove(comment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised: deleting the comment"+e);
			return false;
		}
	}

	
	public List<BlogComment> listBlogComments(int blogId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:myBlogId");
		query.setParameter("myBlogId",blogId);
		List<BlogComment> listComment=query.list();
		session.close();
		return listComment;
	}

	
	public BlogComment getBlogComment(int commentId) {
		Session session=sessionFactory.openSession();
		BlogComment comment=session.get(BlogComment.class, commentId);
		session.close();
		return comment;
	}
	
}
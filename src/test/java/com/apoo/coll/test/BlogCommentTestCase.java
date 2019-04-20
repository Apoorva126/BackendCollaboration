package com.apoo.coll.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.apoo.coll.dao.BlogCommentDAO;
import com.apoo.coll.model.BlogComment;

public class BlogCommentTestCase {

	 static BlogCommentDAO blogCommentDAO;
		
		@BeforeClass
		public static void initialize()
		{
	        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			
			context.scan("com.apoo.coll");
			
			context.refresh();
			
			blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
		}
		
	
		@Test
		public void addBlogCommentTest()
		{
			BlogComment comment=new BlogComment();
			comment.setCommentId(11);
			comment.setBlogId(679);
			comment.setCommentText("Nice Blog");
			comment.setCommentDate(new java.util.Date());
			comment.setUsername("apoorva");
	assertTrue("Problem in adding the comment",blogCommentDAO.addBlogComment(comment));
				
		}
		
	/*	
		@Test
		public void deleteBlogTest()
		{
			BlogComment comment=blogCommentDAO.getBlogComment(955);
			
			assertTrue("problem in deleting the blog",blogCommentDAO.deleteBlogComment(comment));
		}
		*/
		
	}

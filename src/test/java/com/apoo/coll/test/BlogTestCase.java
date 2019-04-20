package com.apoo.coll.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.apoo.coll.dao.BlogDAO;
import com.apoo.coll.model.Blog;

public class BlogTestCase {

static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize() 
	{
       
		 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.apoo.coll");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	

	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogName("Core Java");
		blog.setBlogContent("Learning of Core Java Programming");
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setDislikes(0);
		blog.setStatus("NA");
		blog.setUsername("apoorva");
		
	assertTrue("Problem in adding the Blog",blogDAO.addBlog(blog));
	}
/*	
	@Ignore
	@Test
	public void updateBlogTest()
	{
		Blog blog=blogDAO.getBlog(952);
		blog.setBlogContent("");
		assertTrue("problem in updating the blog",blogDAO.updateBlog(blog));
	}
	
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=blogDAO.getBlog(954);
		
		assertTrue("problem in deleting the blog",blogDAO.deleteBlog(blog));
	}
	
	@Ignore
	@Test
	public void listBlogTest()
	{
			List<Blog> listBlogs=blogDAO.getAllBlogs();
			
			assertTrue("Problem in Listing Blog",listBlogs.size()>0);
			
			for(Blog blog:listBlogs)
			{
				System.out.print(blog.getBlogId()+"\t");
				System.out.print(blog.getBlogName()+"\t");
				System.out.print(blog.getBlogContent()+"\t");
				System.out.println(blog.getStatus());				
			}
	}
	
	@Ignore
	@Test
	public void approveBlogTest()
	{
		Blog blog=blogDAO.getBlog(955);
		
		assertTrue("Problem in approving the blog",blogDAO.approveBlog(blog));
	}
	
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=blogDAO.getBlog(956);
		
		assertTrue("Problem in rejecting the blog",blogDAO.rejectBlog(blog));
	}
	
	@Ignore
	@Test
	public void incrementLikesTest()
	{
		Blog blog=blogDAO.getBlog(952);
		
		assertTrue("Problem in increment likes of a blog",blogDAO.incrementLikes(blog));
	}
	
	@Test
	public void incrementDisLikesTest()
	{
		Blog blog=blogDAO.getBlog(952);
		
		assertTrue("Problem in increment Dislikes of a blog",blogDAO.incrementDisLikes(blog));
	}*/
}

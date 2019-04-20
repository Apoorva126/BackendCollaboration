package com.apoo.coll.dao;

import java.util.List;


import com.apoo.coll.model.BlogComment;

public interface BlogCommentDAO 
{
	public boolean addBlogComment(BlogComment comment);
	public boolean deleteBlogComment(BlogComment comment);
	public List<BlogComment> listBlogComments(int blogId);
	public BlogComment getBlogComment(int commentId);
	

}

package com.apoo.coll.dao;

import com.apoo.coll.model.UserDetail;

public interface UserDAO {
	 public boolean registerUser(UserDetail user);
     public boolean updateUserDetail(UserDetail user);
     public UserDetail getUser(String username);
     public boolean makeOffline(UserDetail user);
     public boolean makeOnline(UserDetail user);
     public boolean approveUser(UserDetail user);
     public boolean rejectUser(UserDetail user);
}

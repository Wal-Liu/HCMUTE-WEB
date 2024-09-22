package vn.iotstar.dao;

import vn.iotstar.models.User;

public interface UserDao {
	User findByUserName(String username);

	boolean checkExistUsername(String username);

	void insert(User user);
	
	 boolean checkExistEmail(String email);

	 boolean checkExistPhone(String phone);
}

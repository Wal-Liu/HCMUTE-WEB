package vn.iotstar.services;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.UserDaoImpl;
import vn.iotstar.models.User;

public class UserServiceImpl implements UserService{
	 UserDao userDao = new UserDaoImpl(); //lấy tất cả các hàm trong tầng Dao 

	@Override
	public User login(String username, String password) {
		User user = this.findByUserName(username);
		
		 if (user != null && password.equals(user.getPassword())) {
			 return user;
		 }
		 return null;
	}
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		System.out.println(userService.login("tuong","123"));
	}

//	public static void main( String[] args)
//	{
//		User user = userDao.findByUserName("tuong");
//		String password = "123";
//		if (user != null && password.equals(user.getPassWord())) {
//			 System.out.println("dang nhap thanh cong");
//			 }
//		else
//			 System.out.println("khong thanh cong");
//	}
	@Override
	 public User findByUserName(String username) {
		 return userDao.findByUserName(username);
		 }

	@Override
	public void insert(User user) {
		userDao.insert(user);
		
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			 return false;
		}
		 long millis=System.currentTimeMillis();   
		 java.sql.Date date=new java.sql.Date(millis);
		  userDao.insert(new User(email, username, fullname,password,null,5,phone,date));
		  return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
	
	


}

package test;

import User.User;
import dao.UserDao;

public class test {
	public static void testLogin() {
		User loginuser = new User();
		loginuser.setUsername("abc");
		loginuser.setPassword("123");
		UserDao dao = new UserDao();
		User user = dao.login(loginuser);
		System.out.println(user);
	}
	public static void main(String[] args) {
		 testLogin() ;
	}
}
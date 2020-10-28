package dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import User.User;
import util.JDBCUtils;

//操作数据库中user表

public class UserDao {
	
	//登陆方法loginuser只有用户名和密码 return全部数据
	//生命jdbcTemplate
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	public User login(User loginUser) {
		try {
			
		
		String sql = "select * from user where username = ? and password = ?";
		User  user=template.queryForObject
				(sql, new BeanPropertyRowMapper<User>(User.class),
				loginUser.getUsername(),loginUser.getPassword());
		
		
		return user;
		} catch (DataAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}

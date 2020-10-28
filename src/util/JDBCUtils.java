package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//JDBC工具类DURID连接池


public class JDBCUtils {
	
	private static DataSource ds;
	
	static {
		try {
		//1.加载配置
		Properties pro = new Properties();
		InputStream is =  JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");		
		pro.load(is);
		ds = DruidDataSourceFactory .createDataSource(pro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接池对象
	
	
	public static DataSource getDataSource() {
		return ds;
	}
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	//获取Conntion
}

package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import User.User;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
//		String username = request.getParameter("username");
//		
//		String password = request.getParameter("password");
//		
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		
		Map<String,String[]> map  =   request.getParameterMap();
		
		User user = new User();
		
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		UserDao dao = new UserDao();
		
		User ruser = dao.login(user);
		if(ruser==null) {
			request.getRequestDispatcher("/failServlet").forward(request, response);
		}else {
			request.getRequestDispatcher("/success").forward(request, response);
			request.setAttribute("user", ruser);
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.User;

/**
 * Servlet implementation class failServlet
 */
@WebServlet("/success")
public class success extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getAttribute("user");
		if(user == null) {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("登陆成功欢迎"+user.getUsername());
		}
		
	}

}

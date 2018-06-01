package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("utf-8");
		req.setCharacterEncoding("utf-8");	
		
		//读取用户名和密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("用户名:"+username+",密码:"+password);
		
		/**
		 * 查询数据库是否有匹配条件的记录:
		 * 如果有则登录成功,跳转到用户列表.(重定向)
		 * 如果没有则登录失败,跳转到登录页面并提示用户.(转发)
		 */
		UserDAO dao = new UserDAO();
		try {
			User user = dao.find(username);
			if(user != null && user.getPassword().equals(password)) {
				//登录成功
				res.sendRedirect("Select");
			}else {
				//登录失败
				req.setAttribute("login_failed","用户名或密码错误");
				req.getRequestDispatcher("Login.jsp").forward(req,res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","系统繁忙,稍后重试.....");
			req.getRequestDispatcher("error.jsp").forward(req,res);
		}
	}
}

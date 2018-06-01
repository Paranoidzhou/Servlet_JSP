package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class UpdateUser extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		User users = new User();
		UserDAO dao = new UserDAO();
		
		users.setUsername(req.getParameter("username"));
		users.setPassword(req.getParameter("password"));
		users.setEmail(req.getParameter("email"));
		users.setPhone(req.getParameter("phone"));
		
		try {
			dao.update(users);
			
			res.sendRedirect("Select");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("系统繁忙,稍后重试.....");
		}
	}
}

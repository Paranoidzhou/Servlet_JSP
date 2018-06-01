package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class SelectUser extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		//先查询出所有用户信息
		 UserDAO dao = new UserDAO();
		try {	
			List<User> users = dao.findAll();
			//依据查询到的用户信息,输出表格
			//step1.绑定数据到request
			req.setAttribute("users",users);
			//step2.获得转发器
			RequestDispatcher rd = req.getRequestDispatcher("listUser2.jsp");
			//step3.转发
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","系统繁忙,稍后重试.....");
			req.getRequestDispatcher("error.jsp").forward(req,res);
		}
	}
}

package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class DeleteUser extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");

		
		User users = new User();
		UserDAO dao = new UserDAO();
		
		String id = req.getParameter("id");
		users.setId(Integer.parseInt(id));

		try {
			dao.delete(users);
			res.sendRedirect("Select");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","服务器繁忙,稍后重试..........");
			req.getRequestDispatcher("error.jsp").forward(req,res);;
		}
	}
}

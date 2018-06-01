package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		System.out.println(username);
//		res.sendRedirect(req.getContextPath()+"/biz01/b1.jsp");
		req.getRequestDispatcher("/biz01/b1.jsp ").forward(req,res);
	}
}

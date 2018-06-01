package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		PrintWriter out = res.getWriter();
		//先查询出所有用户信息
		 UserDAO dao = new UserDAO();
		try {	
			List<User> users = dao.findAll();
			//依据查询到的用户信息,输出表格
			out.println("<table border='1' width='800px' cellspacing='0'>");
			out.println("<tr><td>ID</td><td>用户名</td><td>密码</td><td>邮箱</td><td>手机</td><td>操作</td></tr>");
			for (User user : users) {
					int id = user.getId();
					String username = user.getUsername();
					String password = user.getPassword();
					String email = user.getEmail();
					String phone = user.getPhone();
					out.println("<tr><td>"+id+"</td><td>"+username+"</td><td>"+password+"</td><td>"+email+"</td><td>"+phone+"</td>"+"<td><a href='Delete?id="+id+"'>删除</a></td></tr>");
			}
			out.println("</table>");
			out.println("<span><a href='Insert.html'>添加用户</a></span>");
			out.println("<span><a href='Delete.html'>删除用户</a></span>");
			out.println("<span><a href='Update.html'>修改用户</a></span>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙,稍后重试.......");
		}
	}
}

package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.DBUtils;
import dao.UserDAO;
import entity.User;

public class InsertUser extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			/**
			 * 对浏览器端提交过来的数据使用
			 * 注:
			 *   这行代码要添加到所有的getParmeter方法的前面.
			 *   只针对POST请求有效.
			 */
			req.setCharacterEncoding("utf-8");

			/**
			 * 此行代码由两个作用:
			 * 1.设置content-type消息头,告诉浏览器,服务器返回的数据类型及编码.
			 * 2.设置out在输出时,使用哪种字符集来编码.(即MIME类型)
			 * 注:(了解)
			 * 	text/html  MIME类型
			 * 	image/jpeg 
			 */
		    res.setContentType("text/html;charset=utf-8");
		    
			PrintWriter out = res.getWriter();
		
			User users = new User();
			UserDAO dao = new UserDAO();
			
			String name = req.getParameter("username");
			String pwd = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			
			System.out.println("姓名:"+name);
			System.out.println("密码:"+pwd);
			System.out.println("邮箱:"+email);
			System.out.println("手机:"+phone);
			
			
			users.setUsername(name);
			users.setPassword(pwd);
			users.setEmail(email);
			users.setPhone(phone);
			
			try {
				
				dao.insert(users);
				
				//重定向到用户列表
				res.sendRedirect("Select");
				
			} catch (Exception e) {
				/**
				 * 异常出现step1:记日志(保留现场)
				 * 注:
				 * 	 记日志,就是将异常信息记录下来,一般是记录在文件里面.
				 *   这儿只是模拟将记录的异常在控制台输出.
				 */
				e.printStackTrace();
				out.println("系统繁忙!稍后重试.......");
				/**
				 * 异常出现step2:
				 *    <1>看异常能否恢复,如果不能恢复(比如:数据库暂时停止,网络中断等等....这些异常
				 * 我们称之为系统异常),对于这种异常,我们需要提示用户稍后重试. 
				 *    <2>如果能够恢复,则立即恢复.
				 */
			}
			/**
			 * out在输出时,默认会使用ISO-8859-1 来编码
			 * IOS-8859-1不支持中文.
			 */
//			out.println("Commit 成功!");
//			out.println("<p><a href='List'>查询</a></p>");
					
	}
}

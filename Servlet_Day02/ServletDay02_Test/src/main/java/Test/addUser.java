package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addUser extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			/**
			 * 对浏览器端提交过来的数据使用
			 * 注:
			 *   这行代码要添加到所有的getParmeter方法的前面.
			 *   只针对POST请求有效.
			 */
			req.setCharacterEncoding("utf-8");
		
			//读取用户信息:
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			
			//控制台输出:
			if(username!=null&&password!=null) {
				System.out.println("账号:"+username);	
				System.out.println("密码:"+password);
				System.out.println("邮箱:"+email);	
				System.out.println("联系电话:"+phone);
			}
	
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
			/**
			 * out在输出是,默认会使用ISO-8859-1 来编码
			 * IOS-8859-1不支持中文.
			 */
			out.println("Commit 成功!");   
	}
}

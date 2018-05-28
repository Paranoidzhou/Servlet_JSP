package Web_Demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	/**
	 * Servlet容器收到请求之后,会调用Servlet的service方法来处理请求. 
	 * 注:
	 *   容器会实现创建好request(请求)和response(响应),其中request
	 * 对象封装了请求数据包里面的所有数据,我们可以将处理结果写到response  
	 * 对象里面,然后容器负责从response对象中获取处理结果,然后打包发送给
	 * 服务器.
	 */ 
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			       throws ServletException, IOException {
		
//		String number = request.getParameter("number"); //获取请求参数值
//		try {
//			Integer.parseInt(number);
//		} catch (Exception e) {
//			System.out.println("输入不合法~~~");
//		}

		response.setContentType("text/html");   //设置 content-type消息头,告诉浏览器,服务器返回的数据类型
		PrintWriter out = response.getWriter(); //通过response对象获得输出流.
		/**
		 * 实际上是把数据写到了响应对象里面,还没有发出去;
		 * 注:
		 *   Servlet容器会将response对象上存放的数据取出来,打一个包(数据响应包),然后发送给浏览器.
		 */
		out.println("<h1>Hello World,Hello Servlet</h1>"); 
		
		out.close();   //此行不写也可以,它通过响应对象获得,如果没有调用out.close,则容器会自动关闭out.
		
	}
}

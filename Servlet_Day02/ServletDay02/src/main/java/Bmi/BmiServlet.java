package Bmi;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.interceptors.FragmentationInterceptor;

public class BmiServlet  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			        throws ServletException, IOException {
		//读取身高和体重
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		System.out.println("height:"+height+",weight:"+weight);
		//暂时不做参数合法性检查,只做业务逻辑.
		double bmi = Double.parseDouble(weight)/
				     Double.parseDouble(height)/
				     Double.parseDouble(height);
		
		//当有多个请求参数名相同,应该使用getParameterValues()方法
		String[] interest = req.getParameterValues("interest");
		
		//对于多选框,如果用户一个都不选,会返回Null值.
		if(interest!=null) {
			for (String str : interest) {
				System.out.println(str);
			}
		}
		
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(1);

		//设置content-type消息头,告诉浏览器服务器返回的数据类型
		res.setContentType("text/html");
		
		//通过response获得输出流,向流中写入数据,这些数据会存放到response对象里面.
		//当service方法执行完毕,容器会从response中获取处理结果,然后打包发送给服务器
		PrintWriter out = res.getWriter();
		out.print("Bmi:"+nf.format(bmi));
	} 
}

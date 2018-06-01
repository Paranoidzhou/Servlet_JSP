2018-5-31  Day04
# Jsp (Java server page)
## Jsp 是什么?
- sun公司制定的一种服务器端动态页面技术规范.
	  注:
		 a. 虽然使用Servlet也可以生成动态页面,但是过于繁琐.因为直接使用out.println()语句输出繁琐,开发不方便,且维护也麻烦(要修改页面就需要修改java代码).所以sun公司才指定了Jsp规范
		 b. Jsp是以(.jsp)为后缀的文件,主要内容是HTML和少量的java代码.容器(比如Tomcat)会将该文件转换成一个对应的Servlet然后执行.
		 C. Jsp本质就是一个Servlet.

- 如何写一个Jsp文件.
  (1) step1 : 添加一个以 .jsp 为后缀的文件
  (2) step2 : 在该文件里面,可以添加如下内容:
		a. HTML(css,JavaScript) : 直接写即可
		b. java代码 :
		         第一种形式 java代码片段   <% Java代码 %>
				 第二种形式 jsp表达式  <%=java表达式 %>
		c. 隐含对象
		   c1.什么是隐含对象?
		   在Jsp文件里面直接可以使用的对象,比如out,request,response.

		   c2.为什么可以直接使用这些隐含对象?
		   因为Jsp会被容器转换成一个对应的Servlet,在转换过程中,容器会自动添加获得这些对象的代码.
		d. 指令
		   d1.什么是指令?
		   通知容器在将JsP转换成Servlet时,做一些额外的处理,比如导包.
		   d.语法:
		         <%@ 指令名 属性=值 %>
		    示例:<%@ page import="java.util.*">
			注:	page指令
			   如果要导多个包,包与包之间用逗号','隔开.
			<%@ page contentType="ufr-8;charset=utf-8">
			<%@ page pageEncodint="utf-8"%>:告诉容器,在读取jsp文件的内容时,使用指定的字符集去解码.

			<%@ include file="header.jsp"%>
			注: include指令
				file属性:指定要包含的文件名.
				-> 容器在将jsp转换成servlet时,会将file属性指定的文件的内容插入到该指令所在的位置.

## Jsp是如何运行的?
- 阶段一 : 容器将 .jsp 文件转换成一个 .java 文件.
	  a. html ---> 在service方法里面,使用out.write输出.
	  b. <%%> ---> 在service方法里面照搬java语句.
	  c. <%= %>--> 在service方法里面,使用out.print输出.

- 阶段二 : 容器再执行该Servlet
	  注:
	     包括编译,实例化,调用Servlet方法.
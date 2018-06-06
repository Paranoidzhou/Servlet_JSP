# Servlet_JSP
- Servlet_JSP day01:
  		今天主要讲了什么是Servlet,Tomcat的安装与配置,Servlet是如何运行的.以及一些常见的错误代码(404,405,500)的解释.并且写了一个用Servlet运行的HelloWrod的小Demo

- Servlet_JSP day02:
		今天主要讲了Http协议,其通信过程(一次请求,一次连接).以及数据包的结构(分析请求行,消息头,实体内容)
		然后讲了两种请求方式:
		GET请求:地址栏可见,安全性不高.
		POST请求:地址栏不可见,安全性相对高.
		以及如何获取请求参数值,并且解决了Servlet输出中文时产生的乱码问题,以及传输过程中的编码解码声明类型不一样会导致的乱码问题.

- Servlet_JSP day03:
		今天通过了大量练习巩固了前两天的知识,并讲了一个知识点:重定向

- Servlet_JSP day04:
		今天讲了JSP文件的一些属性,如何写一个JSP文件,JSP是如何运行的.

- Servlet_JSP day05:
		今天讲了转发(如何转发,获得转发器,比较转发和重定向的区别),以及登录业务流程详解(附Demo),还讲了路径问题:
		绝对路径
		相对路径
		如何写绝对路径
		万能路径写法 : String request.getContextPath();

- Servlet_JSP day06:
		今天讲了状态管理(什么是状态管理,如何进行状态管理)以及Coolkie技术(其工作原理,添加Cookie,读取Cookie)然后就是处理Cookie的编码问题,生存时间问题,Cookie路径问题.
		并且写了一个Cookie工具类
		封装了读取Cookie功能,删除Cookie功能,添加Cookie功能.

- Servlet_JSP day07:
		今天讲了Cookie的限制,Session(会话)对象,(包括什么是Session,其工作原理,如何获得Session对象,如何绑定数据,Session超时相关详解,删除session),以及用Session的登录验证.
		容器如何处理请求资源路径,以及如何让一个Servlet处理多种请求
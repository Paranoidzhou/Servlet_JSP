2018-6-11  Day11

## 做一些简单的运算 (e1.jsp)
   注： 运算结果可以用来给jsp标签的属性赋值，也可以直接输出。

- 算术运算
  `+` , `-` , `*` , `/` , `%`
>  注：`+`只能做求和，不能够连接字符串。

- 关系运算
  `>` , `>=` ,`<` , `<=` ， `=` , `==` , `!=`
		${ 1<2 }

		<%
			request.setAttribute("s1","abc");
		%>
		${ s1 == "abc" }<br/>
		${ sessionScope.s1 == "abc"}

		<%
			User user = new User();
			user.setGender("m");
			request.setAttribute("user",user);
		%>
		${user.gender == "m"}<br/>

- 逻辑运算
  `&&` , `||` , `!`

- empty运算 (e2.jsp)
   -  empty 运算是判断集合内容是否为空，或者是否为一个空字符串。
   	  注 ： 哪怕加一个空格，都代表有内容了，判断就会为false.
			<%
				request.setAttribute("s2","");
				List list1 = new ArrayList();
				request.setAttribute("list1",list1);
			%>
			是否为空字符串: ${ empty s2 }
			是否为空的集合: ${ empty list1 }
			值为null:	   ${ empty null}
			找不到对应的值： ${ empty abc}


## jstl
- jstl是什么？
  java standard tag lib 即java标准标签库。
  它是apache开发的一套通用的jsp标签库，后来捐献给了sun，sun将其命名为jstl;

- 编程步骤：
	step1 : 导包 - -> 去Maven镜像库将jstl地址copy.
		<dependency>
		  <groupId>jstl</groupId>
		  <artifactId>jstl</artifactId>
		  <version>1.2</version>
		</dependency>

	step2 : 使用taglib指令导入要使用的标签。
			<%@ taglib uri='' prefix="" %>
			注：
				uri是标签的命名空间: 是为了区分同名的元素而在元素前添加的一个限定， 通常是一个域名。它的属性值是指定要导入的标签的命名空间。

				prefix是别名：指定命名空间的别名。

#### 核心标签：
- if 标签(e3.jsp)
	  语法：
	      <c:if test="">
			 标签体
		  </c:if>
		  解释：
		  a.当test属性值为true的时候，容器会执行标签体的内容。
		  b.test属性值可以使用el表达式来赋值。
		  c.var属性指定绑定名，scope属性值指定绑定的范围。

- choose 标签 (e4.jsp)
	  语法：
	  	  <c:choose>
		  	<c:when test="">标签体</c:when>
			<c:when test="">标签体</c:when>
			...
  			<c:otherwise>当不满足上面条件时，会执行此标签内容</c:otherwise>
	  	  </c:choose>

- forEach标签 ： 遍历集合或者数组 （e5.jsp）
	  语法：
	  	 <c:forEach items="" var=""  varStatus="">
		 </c:forEach>
		 注：
		 	items属性用来指定要遍历的集合或者数组，可以使用el表达式来赋值。
			var属性用来指定绑定名，其绑定范围固定是pageContext.该标签每次从集合或者数组中取一个元素，然后将钙元素绑定到pageContext上。
			varStatus属性用来指定绑定名，其绑定范围固定是pageContext.绑定值是一个特殊的对象，该对象提供了几个方法用来获得当前遍历的状态：
			-》 getIndex(): 获得当前正在被遍历的元素的下标（从0开始）;
			-》 getCount(): 获得当前是第几次遍历（从1开始）;

#### 自定义标签
- 编程步骤： （hello.jsp）
	step1 : 写一个java类，继承SimpleTagSupport类
	   注：
	     复杂标签技术（old）
		 简单标签技术（new），继承SimpleTagSupport类属于简单标签技术。

	step2 : override doTag方法，在该方法里面，编写相应的处理逻辑。（helloTag.java）
	  三步骤：
			1.继承SimpleTagSupport
			2.override doTag方法
		    3.标签有哪些属性，标签类就有对应的属性，类型要匹配，并且提供对应的set方法
	step3 : 在.tld文件里面描述标签。

		<?xml version="1.0" encoding="UTF-8" ?>

		<taglib xmlns="http://java.sun.com/xml/ns/javaee"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd"
			version="2.1">

		  <tlib-version>1.1</tlib-version>	<!-- 版本随意 -->
		  <short-name>d</short-name>		<!-- 这里填多少，调用此tld的别名就得用什么，参考helloDemo.jsp -->
		  <uri>http://tedu.cn/tag</uri>		<!-- 这里填多少，调用此tld的uri就得用什么-->

		  <tag>
			<name>hello</name>				<!-- 设置标签名 -->
			<tag-class>tag.HelloTag</tag-class>  <!-- 完整类名 -->
			<!-- 
				body-content内有三个值：
					1.empty : 它表示该标签没有标签体。
					2.scriptless : 它表示该标签可以有标签体，不能包含
							Java代码片段(<% %>)、
							Java表达式(<%= %>)、
							Java申明(<%! %>)
					3.JSP : 它表示该标签可以有标签体，并且标签体的内容可以出现java代码，但是只有复杂标签技术才支持。
			 -->
			<body-content>empty</body-content>
			<attribute>
				<name>info</name>  <!-- 必须跟标签的属性名一样 -->
				<required>true</required> <!-- true表示必选的，false表示可选的 -->
				<rtexprvalue>true</rtexprvalue> <!-- true表示属性值可以动态赋值（即可以用el表达式来赋值）false则不可以 -->
			</attribute>
			<attribute>
				<name>qty</name>
				<required>true</required>
				<rtexprvalue>true</rtexprvalue>
			</attribute>
		  </tag>
		</taglib>

- 标签的运行过程
	step1 : 容器依据标签的命名空间，找到标签的描述文件。
	比如: 以helloDemo.jsp为例，容器依据命名空间("http://tedu.cn/tag")找到标签的描述文件(mytag.tld).

	step2 : 容器依据标签的名字找到对应的标签类。
	比如: 标签名字为"hello",对应的标签类是"tag.HelloTag"。

	step3 : 容器调用标签类的构造器，创建其实例。

	step4 : 容器将标签的属性值赋给标签对象对应的属性。
	比如: 将"HelloWorld" 赋给HelloTag对象对应的属性info属性（通过调用对应的set方法）。

	step5 : 最后容器调用标签对象的doTag方法。



























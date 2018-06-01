<%@ page import="java.util.*" contentType="text/html;charset=utf-8"  
pageEncoding="utf-8"%>
<html>
	<head style="font-size: 30px;"></head>
	<body>
		来自风平浪静的明天
		time:<%=new Date()%><br/>						
		time:<%
			Date date = new Date();
			out.println(date);
		%>
		<br/>
		<% 
			for(int i=0;i<100;i++){
				out.println("HelloWord<br/>");
			}
		%>
	</body>
</html>
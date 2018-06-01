<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Demo</title>
</head>
<body style="font-size:30px;">
	这是一个华丽的Demo
	<a href="../b2.jsp">它跳转到一个美丽的地方..</a><br/>
	<a href="<%=request.getContextPath()%>/b2.jsp">使用绝对路径跳转到一个美丽的地方..</a>
</body>
</html>
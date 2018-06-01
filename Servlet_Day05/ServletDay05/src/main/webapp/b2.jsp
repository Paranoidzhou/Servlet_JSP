<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Demo</title>
</head>
<body style="font-size:30px;">
	这是一个华丽的Demo<br/>
	它华丽的有点不像话.....
	<a href="biz01/b1.jsp">它将去一个D1</a><br/>
	<a href="<%=request.getContextPath()%>/biz01/b1.jsp">它将去D1(绝对路径)</a>
</body>
</html>
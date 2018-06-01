<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="dao.*,java.util.*,entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>查询数据</title>
<style type="text/css">
	.row1{background-color: pink}
	.row2{background-color: #f0f0f0}
	table{border:2px solid red;}
</style>
</head>
<body>
	<table width="800px" cellpadding="0" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>用户名:</td>
			<td>密码:</td>
			<td>邮箱:</td>
			<td>电话:</td>
			<td>操作:</td>
		</tr>
		<% 
			UserDAO dao = new UserDAO();
			List<User> users = dao.findAll();
			for(int i=0;i<users.size();i++){
				User u = users.get(i);
		%>
			<tr class="row<%=i%2+1%>">
				<td><%=u.getId()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getPhone()%></td>
				<td><a href='Delete?id=<%=u.getId()%>'>删除</a></td>
			</tr>
		<% 
			}
		%>
	</table>
			<span><a href='Insert.html'>添加用户</a></span>
			<span><a href='Delete.html'>删除用户</a></span>
			<span><a href='Update.html'>修改用户</a></span>
</body>
</html>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="entity.*,java.util.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>用户列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
			
				<!-- 利用include指令插入头部 -->  
				<%@ include file="header.jsp" %>
				
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						用户列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								用户名
							</td>
							<td>
								电话
							</td>
							<td>
								邮箱
							</td>
							<td>
								操作
							</td>
						</tr>
						<% 
							List<User> users = (List<User>)request.getAttribute("users");
							for(int i=0; i<users.size();i++){
								User u = users.get(i);		
						%>
							<tr class="row<%=i%2+1%>">
								<td><%=u.getId()%></td>
								<td><%=u.getUsername()%></td>
								<td><%=u.getPhone()%></td>
								<td><%=u.getEmail()%></td>
								<td>
									<a href="Delete?id=<%=u.getId()%>" onclick="return confirm('是否确认删除<%=u.getUsername()%>吗?');">×</a>
								</td>
							</tr>
						<%
							}
						%>
						
					</table>
					<p>
						<input type="button" class="button" value="添加用户" onclick="location='Insert.jsp'"/>
					</p>
				</div>
			</div>
			
			<!-- 利用include指令插入尾部 -->
			<%@ include file="footer.jsp" %>	
		</div>
	</body>
</html>

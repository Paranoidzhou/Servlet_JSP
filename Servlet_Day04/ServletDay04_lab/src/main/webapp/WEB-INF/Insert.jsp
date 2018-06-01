<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
</head>
<body style="font-size:30px">
	<form action="Insert" method="POST">
		<fieldset style="width:300px;">
			<legend>用户注册</legend>
			 账号:<input type="text" name="username" /><br/>
			 密码:<input type="password" name="password" /><br/>
			 邮箱:<input type="text" name="email"/><br/>
			 电话:<input type="text" name="phone"/><br/>
			 <input type="submit" value="提交" /><input  type="button" value="查询用户列表" onClick="window.location.href='http://localhost:8080/ServletDay03/Select'"/>
		</fieldset>
	</form>
</body>
</html>
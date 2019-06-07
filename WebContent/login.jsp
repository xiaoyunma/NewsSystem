<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<!--<link rel="stylesheet" type="text/css" href="Login.css" />  -->
</head>
<body>
	<div id="login">
		<h1>欢迎登陆管理系统</h1>
		<%
			String error = (String) request.getAttribute("error");
			if (error != null && !"".equals(error)) {
		%>
		<p style="color: red"><%=error%>
		</p>

		<%
			}
		%>

		<form role="form" action="UserServlet" method="post">
			<input type="text" required="" placeholder="账号" name="userphone"></input>
			<input type="password" required="" placeholder="密码"
				name="userpassword"></input> 
				<select name="select" class="select">
				<option value="普通用户">普通用户</option>
				<option value="管理员">管理员</option>
			</select>
			<button class="but" type="submit">登录</button>

		</form>
	</div>
</body>
</html>
<style>
html {
	width: 100%;
	height: 100%;
	color: white;
	overflow: hidden;
	font-style: sans-serif;
}

body {
	width: 100%;
	height: 100%;
	font-family: 'Open Sans', sans-serif;
	margin: 0;
	background-color: #4A374A;
}

#login {
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -150px 0 0 -150px;
	width: 300px;
	height: 300px;
}

#login h1 {
	color: #fff;
	text-shadow: 0 0 10px;
	letter-spacing: 1px;
	text-align: center;
}

h1 {
	font-size: 2em;
	margin: 0.67em 0;
}

input {
	width: 278px;
	height: 18px;
	margin-bottom: 10px;
	outline: none;
	padding: 10px;
	font-size: 13px;
	color: #fff;
	text-shadow: 1px 1px 1px;
	border-top: 1px solid #312E3D;
	border-left: 1px solid #312E3D;
	border-right: 1px solid #312E3D;
	border-bottom: 1px solid #56536A;
	border-radius: 4px;
	background-color: #2D2D3F;
}

.but {
	width: 300px;
	min-height: 20px;
	display: block;
	background-color: #4a77d4;
	border: 1px solid #3762bc;
	color: #fff;
	padding: 9px 14px;
	font-size: 15px;
	line-height: normal;
	border-radius: 5px;
	margin: 0;
	margin-top:13px;
}
.select{
     width:100px;
     height:25px;
     border:1px solid #312E3D;
     text-align:center;
     background-color: #2D2D3F;
     color: #fff;
}
</style>
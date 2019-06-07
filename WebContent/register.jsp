<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<div id="login">
		<!--注册失败提示  -->
		<%
			String error = (String) request.getAttribute("error");
			if (error != null && !"".equals(error)) {
		%>
		<p style="color: red"><%=error%>
		</p>

		<%
			}
		%>
		<!-- 两次密码不一致提示 -->
		<%
			String error_repeat = (String) request.getAttribute("error_repeat");
			if (error_repeat != null && !"".equals(error_repeat)) {
		%>
		<p style="color: red"><%=error_repeat%>
		</p>

		<%
			}
		%>
		<!-- 用户名为空提示 -->
		<%
			String error_name = (String) request.getAttribute("error_name");
			if (error_name != null && !"".equals(error_name)) {
		%>
		<p style="color: red"><%=error_name%>
		</p>

		<%
			}
		%>
		<!-- 手机号为空提示 -->
		<%
			String error_phone = (String) request.getAttribute("error_phone");
			if (error_phone != null && !"".equals(error_phone)) {
		%>
		<p style="color: red"><%=error_phone%>
		</p>

		<%
			}
		%>

		<form action="RegisterServlet" method="post">


			<input placeholder="用户名" style="height: 35px" id="username"
				name="username" type="text" > 
			<input
				id="phone" placeholder="手机号" style="height: 35px" name="userphone"
				type="text"> 
			<input placeholder="密码"
				style="height: 35px" id="password" type="password"
				name="userpassword"> 
			<input placeholder="确认密码"
				style="height: 35px" id="password1" type="password"
				name="userpassword1"> 
		男：<input type="radio"
				style="width: 50px; height: 20px" name="sex" value="男" checked="" />
		女：<input type="radio" style="width: 50px; height: 20px" name="sex"
				value="女" />

			<button class="but" type="submit">注册</button>

		</form>
	</div>
	<style scoped="scoped">
.tb {
	width: 100%;
	margin: 0;
	padding: 5px 4px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}
</style>

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
	width: 280px;
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
}
</style>
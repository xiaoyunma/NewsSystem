<%@page import="com.news.model.User"%>
<%@page import="com.news.model.News"%>
<%@page import="com.news.model.Type"%>
<%@page import="java.util.List"%>
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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>新闻主页</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<div id="wrapper">
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav metismenu" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span> <img height="48px" width="48px" alt="image"
								class="img-circle" src="img/head.jpg" />
							</span> <a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<span class="clear"> <span class="block m-t-xs"> <strong
										class="font-bold">
											<%
												String userphone = request.getSession().getAttribute("userphone").toString();
											%>
											<%=userphone%>
									</strong>
								</span>
							</span>
							</a>

						</div>
						<div class="logo-element">IN+</div>
					</li>



					<li><a href="UserInfoServlet"><i class="fa fa-flask"></i>
							<span class="nav-label">个人信息</span></a></li>
					<li><a href="NewsServlet"><i class="fa fa-pie-chart"></i>
							<span class="nav-label">全部新闻</span> </a></li>


					<li><a href=""><i class="fa fa-flask"></i> <span
							class="nav-label">留言管理</span></a></li>

				</ul>

			</div>
		</nav>

		<div id="page-wrapper" class="gray-bg">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top white-bg" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
							href="#"><i class="fa fa-bars"></i> </a>

					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li><span class="m-r-sm text-muted welcome-message">欢迎浏览新闻</span></li>


						<li><a href="login.jsp"> <i class="fa fa-sign-out"></i>
								Log out
						</a></li>

					</ul>

				</nav>
			</div>
			<div id="tab-2" class="tab-pane">
				<%
					User users = (User) request.getAttribute("users");
				%>
				<div class="contact-box" >

					<div class="col-sm-3">
						<div class="text-center">
							<img alt="image" class="img-circle m-t-xs img-responsive" style="width:100px;height:100px"
								src="img/head.jpg">
							<div class="m-t-xs font-bold"><%=users.getIsReader()%></div>
						</div>
					</div>
					<div class="col-sm-9">
						<h3>
							<strong><%=users.getUserName()%></strong>
						</h3>

						<p>
							<i class="fa fa-map-marker"></i> 宁夏
						</p>
						<address>
							<br> ID：<%=users.getUserID()%>
							<br>
							<br> 手机号：
							<%=users.getUserPhone()%>
							<br>
							<br> 性别：
							<%=users.getUserSex()%>
							<br>
							<br>
						</address>
					</div>
					<div class="clearfix"></div>
					</a>
				</div>

			</div>
			<div class="footer">
				<div class="pull-right">
					<%=new java.util.Date()%>
				</div>
				<div>
					<strong>Copyright</strong> maxiaoyun &copy; 2018-2028
				</div>
			</div>
		</div>

	</div>

	<!-- Mainly scripts -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Flot -->
	<script src="js/plugins/flot/jquery.flot.js"></script>
	<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script src="js/plugins/flot/jquery.flot.spline.js"></script>
	<script src="js/plugins/flot/jquery.flot.resize.js"></script>
	<script src="js/plugins/flot/jquery.flot.pie.js"></script>
	<script src="js/plugins/flot/jquery.flot.symbol.js"></script>
	<script src="js/plugins/flot/jquery.flot.time.js"></script>

	<!-- Peity -->
	<script src="js/plugins/peity/jquery.peity.min.js"></script>
	<script src="js/demo/peity-demo.js"></script>

	<!-- Custom and plugin javascript -->
	<script src="js/inspinia.js"></script>
	<script src="js/plugins/pace/pace.min.js"></script>

	<!-- jQuery UI -->
	<script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>

	<!-- Jvectormap -->
	<script src="js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
	<script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

	<!-- EayPIE -->
	<script src="js/plugins/easypiechart/jquery.easypiechart.js"></script>

	<!-- Sparkline -->
	<script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>

	<!-- Sparkline demo data  -->
	<script src="js/demo/sparkline-demo.js"></script>

</body>
</html>

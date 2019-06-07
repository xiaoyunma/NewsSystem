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

<title>分类管理系统</title>

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
										class="font-bold"><%String userphone = request.getSession().getAttribute("userphone").toString();%> 
									<%=userphone %></strong>
								</span>
							</span>
							</a>

						</div>
						<div class="logo-element">IN+</div>
					</li>

					<li><a href="<%=basePath%>admin/Home"><i
							class="fa fa-diamond"></i> <span class="nav-label">首页</span></a></li>


					<li><a href="admin/Category"><i class="fa fa-pie-chart"></i>
							<span class="nav-label">分类管理</span> </a></li>
					<li><a href="admin/News"><i class="fa fa-flask"></i> <span
							class="nav-label">新闻管理</span></a></li>
                    <li><a href="admin/Messages"><i class="fa fa-flask"></i> <span
							class="nav-label">留言管理</span></a>
							</li>


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
						<li><span class="m-r-sm text-muted welcome-message">欢迎登陆新闻管理后台</span></li>


						<li><a href="login.jsp"> <i class="fa fa-sign-out"></i>
								Log out
						</a></li>

					</ul>

				</nav>
			</div>
			<div class="wrapper wrapper-content">
				<div class="row">
					<div class="col-lg-12">
						<div class="wrapper wrapper-content animated fadeInRight">

							<div class="ibox-content m-b-sm border-bottom">
								<div class="text-center p-lg">
									<div class="form-group">

										<div class="col-sm-10">
											<div class="row">
												<form action="<%=basePath%>admin/Category" method="post">
													<div class="col-md-4">
														<input type="text" name="typename" placeholder="分类名称"
															class="form-control">
													</div>
													<div class="col-md-2">
														<button title="Create new cluster"
															class="btn btn-primary btn-sm">
															<i class="fa fa-plus"></i> <span class="bold">增加分类</span>
														</button>
													</div>
													<div class="col-md-4">
														<!-- 分类名称为空提示 -->
														<%
															String error = (String) request.getAttribute("error");
															if (error != null && !"".equals(error)) {
														%>
														<p style="color: red"><%=error%>
														</p>

														<%
															}
														%>
													</div>
												</form>
											</div>
										</div>
									</div>


								</div>
							</div>
							<%
								List<Type> types = (List<Type>) request.getAttribute("types");
								for (Type type : types) {
							%>
							<div class="faq-item">
								<div class="row">
									<div class="col-md-8">
										<a data-toggle="collapse" href="" class="faq-question"><%=type.getTypename()%></a>
									</div>
									<div class="col-md-2">
										<a
											href="<%=basePath%>admin/CategoryEdit?action=edit&id=<%=type.getId()%>"><button
												type="button" class="btn btn-w-m btn-info">编辑</button></a>
									</div>
									<div class="col-md-2">
										<form action="admin/CategoryEdit" method="post">
											<input name="id" value="<%=type.getId()%>" type="hidden" />
											<input name="action" value="delete" type="hidden" />
											<button type="submit" class="btn btn-w-m btn-warning">删除</button>
										</form>
									</div>
								</div>

							</div>
							<%
								}
							%>
						</div>
					</div>

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

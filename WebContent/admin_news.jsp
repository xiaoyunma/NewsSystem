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

<title>新闻管理</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<link href="css/plugins/summernote/summernote.css" rel="stylesheet">
<link href="css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
<link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/dropzone.css" rel="stylesheet">
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
											<%=userphone%></strong>
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
						<li><span class="m-r-sm text-muted welcome-message">新闻添加</span></li>


						<li><a href="login.jsp"> <i class="fa fa-sign-out"></i>
								Log out
						</a></li>

					</ul>

				</nav>
			</div>
			<div class="wrapper wrapper-content animated fadeInRight ecommerce">

				<div class="row">
					<div class="col-lg-12">
						<div class="tabs-container">
							<ul class="nav nav-tabs">
								<li class="active"><a data-toggle="tab" href="#tab-1">
										新闻发布</a></li>
								<li class=""><a data-toggle="tab" href="#tab-2"> 新闻列表</a></li>

							</ul>

							<div class="tab-content">
								<div id="tab-1" class="tab-pane active">
									<div class="panel-body">
<%
			String error = (String) request.getAttribute("error");
			if (error != null && !"".equals(error)) {
		%>
		<p style="color: red"><%=error%>
		</p>

		<%
			}
		%>
										<fieldset class="form-horizontal">
											<form action="admin/News"  method="post">
												<div class="form-group">
													<label class="col-sm-2 control-label">新闻标题:</label>
													<div class="col-sm-10">
														<input type="text" name="newstitle" class="form-control"
															placeholder="新闻名称" />
													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-2 control-label">新闻内容:</label>
													<div class="col-sm-10">
														<div class="note-editor note-frame panel panel-default">
															<div class="note-dropzone">
																<div class="note-dropzone-message"></div>
															</div>

															<div class="note-editing-area">

																 <textarea class="form-control" id="deblock_udid" name="newscontent" rows="16" style="min-width: 90% "></textarea>

																
															</div>

														</div>
													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-2 control-label">选择类型:</label>
													<div class="col-sm-10">
														<span style="font-size: 16px; width: 30px"><select
															name="newstype">
																<%
																	List<Type> types = (List<Type>) request.getAttribute("types");
																	for (Type type : types) {
																%>

																<option value="<%=type.getId()%>"><%=type.getTypename()%></option>

																<%
																	}
																%>
														</select></span>

													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-2 control-label">上传图片:</label>
													<div class="col-sm-10">

														<div class="dz-default dz-message">

															<input type="text" name="newsimg">

														</div>

													</div>
												</div>

												<button style="margin-left: 1000px" type="submit"
													class="btn btn-w-m btn-primary">发布</button>
											</form>
										</fieldset>


									</div>
								</div>
								<div id="tab-2" class="tab-pane">
								<%
								List<News> news = (List<News>) request.getAttribute("news");
								for (News news2 : news) {
							%>
									<div class="panel-body">
									<div class="col-md-7">
										<a data-toggle="collapse" href="" class="faq-question"><%=news2.getNewsTitle()%></a>
									</div>
									<div class="col-md-3">
										<a data-toggle="collapse" href="" class="faq-question"><%=news2.getNewsTime()%></a>
									</div>
									<div class="col-md-1">
										<a data-toggle="collapse" href="" class="faq-question"><%=news2.getTypeID() %></a>
									</div>
									
									<div class="col-md-1">
										<a data-toggle="collapse" href="" class="faq-question"><%=news2.getUserID() %></a>
									</div>
									</div>
									<%
								}
							%>
								</div>


							</div>
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
	<script src="js/dropzone.js"></script>
	<script>
		$(document).ready(function() {

			$('.summernote').summernote();

			$('.input-group.date').datepicker({
				todayBtn : "linked",
				keyboardNavigation : false,
				forceParse : false,
				calendarWeeks : true,
				autoclose : true
			});

		});
	</script>

</body>
</html>

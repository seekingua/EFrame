<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>EFrame</title>
<meta name="description" content="User login page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@include file="/view/common/head.jsp"%>
</head>
<body class="login-layout">
	<div class="space-24"></div>
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box" class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter center">
											<i class="icon-fire red bold"></i>
											<span style="font-weight: 600; font-family: 微软雅黑; font-style: italic; padding-right: 5px; padding-left: 5px">EFrame</span>
										</h4>
										<div class="space-6"></div>
										<div class="center" style="padding-bottom: 10px">
											<c:if test="${message != null }">
												<h5 class="red">
													<span style="font-weight: 700; font-family: 微软雅黑">${message}</span>
												</h5>
											</c:if>
										</div>
										<form action="<%=path%>/login" method="post" id="login">
											<fieldset>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="text" class="form-control" name="username" <c:if test="${username!=null}">value="${username}"</c:if> placeholder="账户名" /> <i class="icon-user"></i>
													</span>
												</label>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="password" class="form-control" name="password" value="admin" placeholder="密码" /> <i class="icon-lock"></i>
													</span>
												</label>
												<div class="space"></div>
												<div class="clearfix">
													<button onclick="document.getElementById('login').submit();" class="form-control btn btn-sm btn-primary">
														<i class="icon-key"></i>
														<span style="font-weight: 600">登录</span>
													</button>
												</div>
												<div class="space-4"></div>
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/view/common/foot.jsp"%>
</body>
</html>
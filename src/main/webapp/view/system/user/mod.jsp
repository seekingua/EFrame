<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>添加用户</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@include file="/view/common/head.jsp"%>
</head>
<body>
	<%@ include file="/view/common/navbar.jsp"%>
	<div class="main-container-inner">
		<%@ include file="/view/common/sidebar.jsp"%>

		<div class="main-content">
			<%@ include file="/view/common/search.jsp"%>

			<div class="page-content">
				<div class="row">
					<div class="col-sm-6">
						<form action="<%=request.getContextPath()%>/manager/system/user/mod/user" class="form-horizontal" method="post">
							<p></p>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="username">用户名</label>
								<div class="col-sm-9" style="color: red">
									<input type="text" name="username" value="${user.username}" <c:if test="${user.id!=null}">readonly="readonly"</c:if> required="required" placeholder=用户名>&nbsp;&nbsp;*&nbsp;&nbsp;
									<c:if test="${message != null }">
										<span style="font-weight: 700; color: red">${message}</span>
									</c:if>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="passwd">密码</label>
								<div class="col-sm-9" style="color: red">
									<input type="password" name="passwd" value="${user.passwd}" required="required" placeholder="密码">&nbsp;&nbsp;* <input type="hidden" name="id" value="${user.id}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="passwd">备注</label>
								<div class="col-sm-9">
									<textarea rows="3" class="input-xlarge" style="height: 80px" name="remark">${user.remark}</textarea>
								</div>
							</div>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info btn-sm" id="add" type="submit">
										<i class="icon-ok bigger-110"></i> 保存用户
									</button>
									&nbsp; &nbsp; &nbsp;
									<button class="btn btn-info btn-sm" type="button" onclick="location.href='<%=request.getContextPath()%>/manager/system/user/list'">
										<i class="icon-arrow-left"></i> 返回
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/view/common/foot.jsp"%>
</body>
</html>
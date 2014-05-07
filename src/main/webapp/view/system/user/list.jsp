<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>用户管理</title>
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
						<form class="form-horizontal" id="form" method="get" action="<%=path%>/manager/system/user/list">
							<p class="form-p">

								用户名&nbsp;&nbsp;<input type="text" name="username" value="${user.username}" class="input-sm">&nbsp;&nbsp;&nbsp;&nbsp;
								<button onclick="javascript:doSubmit(1,'<%=path%>/manager/system/user/list')" class="btn btn-sm btn-purple">
									查找 <i class="icon-search icon-on-right bigger-110"></i>
								</button>
								<button type="button" onclick="location.href='<%=path%>/manager/system/user/mod'" class="btn btn-sm btn-purple">
									添加用户 <i class="icon-plus-sign icon-on-right bigger-110"></i>
								</button>
								<input type="hidden" name="pageNo" id="pageNo" value="${pageNo}"> <input type="hidden" name="length" value="${length}">
							</p>
						</form>
					</div>
					<div class="table-responsive">
						<table id="sample-table-1" class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>用户名</th>
									<th>备注</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.content}" var="user" varStatus="i">
									<tr>
										<td>${i.index+(pageNo-1)*page.size+1}</td>
										<td>${user.username}</td>
										<td>${user.remark}</td>
										<td>
											<button class="btn btn-xs btn-primary" onclick="location.href='<%=path %>/manager/system/user/mod?id=${user.id}'">
												<i class=" icon-edit"></i>&nbsp;编辑
											</button> <c:if test="${user.username!='admin'}">
												<button class="btn btn-xs btn-primary" onclick="if(window.confirm('确认删除？')==true)location.href='<%=path %>/manager/system/user/delete?id=${user.id}'">
													<i class="icon-remove"></i>&nbsp;删除
												</button>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<%@ include file="/view/common/pagination.jsp"%>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/view/common/foot.jsp"%>
</body>
</html>
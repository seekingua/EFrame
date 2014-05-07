<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="sidebar" id="sidebar">

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="icon-user"></i>
			</button>
			<button class="btn btn-info">
				<i class="icon-bell"></i>
			</button>
			<button class="btn btn-warning">
				<i class="icon-envelope"></i>
			</button>
			<button class="btn btn-danger">
				<i class="icon-cogs"></i>
			</button>
		</div>
	</div>

	<ul class="nav nav-list">
		<li <c:if test="${sidebar=='portal'}">class="active"</c:if>>
			<a href="<%=request.getContextPath()%>/manager/portal">
				<i class="icon-th-large"></i>
				<span class="menu-text-side">门户</span>
			</a>
		</li>
		<li <c:if test="${sidebar=='sys_user'}">class="active"</c:if>>
			<a href="#" class="dropdown-toggle">
				<i class="icon-wrench"></i>
				<span class="menu-text-side">
					系统配置
					<span class="badge badge-grey">1</span>
				</span>
				<b class="arrow icon-angle-down"></b>
			</a>
			<ul class="submenu">
				<li <c:if test="${sidebar=='sy_user'}">class="active"</c:if>>
					<a href="<%=request.getContextPath()%>/manager/system/user/list">
						<i class="icon-double-angle-right"></i>
						<span class="menu-text-side">用户管理</span>
					</a>
				</li>
			</ul>
		</li>
	</ul>

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>
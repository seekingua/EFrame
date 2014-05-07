<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="navbar navbar-default" id="navbar">

	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="navbar-container">

		<div class="navbar-header pull-left">
			<a href="<%=request.getContextPath()%>/manager/portal" class="navbar-brand">
				<small>
					<i class="icon-fire"></i>
					<span style="color: yellow; font-style: italic; padding-right: 5px; padding-left: 5px">BigData</span>
					辅助管理系统
				</small>
			</a>
		</div>

		<div class="navbar-header pull-right">
			<ul class="nav ace-nav">
				<li class="green">
					<a href="<%=request.getContextPath()%>/manager/portal">
						<small style="font-size: 110%">
							<i class="icon-home icon-white"></i> 首页
						</small>
					</a>
				</li>
				<li class="red">
					<a href="<%=request.getContextPath()%>/logout">
						<small style="font-size: 110%">
							<i class="icon-off icon-white"></i> 注销
						</small>
					</a>
				</li>
			</ul>
		</div>
	</div>
</div>
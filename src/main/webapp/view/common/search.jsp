<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
		try {
			ace.settings.check('breadcrumbs', 'fixed')
		} catch (e) {
		}
	</script>

	<ul class="breadcrumb">
		<li>
			<i class="icon-home home-icon"></i> ${first}
		</li>
		<li class="active">${second}</li>
		<c:if test="${third != null }">
			<li class="active">${third}</li>
		</c:if>
		<c:if test="${fourth != null }">
			<li class="active">${fourth}</li>
		</c:if>
	</ul>

<!-- 	<div class="nav-search" id="nav-search">
		<form class="form-search">
			<span class="input-icon">
				<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" /> <i class="icon-search nav-search-icon"></i>
			</span>
		</form>
	</div> -->
</div>
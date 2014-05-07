<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pagination pull-right">
	<button class="btn btn-primary btn-xs" onclick="javascript:doPage(${pageNo-1},null)" <c:if test="${pageNo <= 1}">disabled="disabled"</c:if>>&laquo;</button>
	<button class="btn btn-primary btn-xs" disabled="disabled">第 ${length==0?0:pageNo}/${length} 页</button>
	<button class="btn btn-primary btn-xs" onclick="javascript:doPage(${pageNo+1},null)" <c:if test="${pageNo >= length}">disabled="disabled"</c:if>>&raquo;</button>
</div>
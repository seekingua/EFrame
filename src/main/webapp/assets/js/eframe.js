function doPage(pageNo, id) {

	// alert($('#form').attr("action"));
	$('#pageNo').attr("value", pageNo);
	$("input[name=id]").attr('value', id);
	// $('#form').attr("action", url).submit();
	$('#form').submit();
}

function doSubmit(pageNo, url) {

	$('#pageNo').attr("value", pageNo);
	$('#form').attr("action", url).submit();
}
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>json测试与接收</title>

</head>
<body>
	<center>
		<h2>json测试与接收</h2>
		<input type="button" class="jsonbutton" value="json测试">
	</center>
	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="js/client.js" type="text/javascript"></script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Jimmy Demo Portal</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <h1>Jimmy Demo Portal</h1>
    <h2>1. Spring Framework Examples</h2>
    <a target="_blank" href="/SpringWeb/restWSDemo"><h2>2. Spring Restful WebServices Examples</h2></a>
    <h2>3. Spring non-blocking + REST services</h2>
    <h2>Kafka Integration Examples</h2>    
    <h2>3. AngularJS Examples</h2>
  </body>
</html>

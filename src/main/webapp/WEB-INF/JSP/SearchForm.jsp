<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>searchAccount</title>
</head>
<body>

	<form action="search">
		<h3>Search Account By</h3>
		<li><a href="searchByAccountNumber">By Account Number</a></li>
		<li><a href="searchByAccountHolderName">By Holder Name</a></li>
		<br>
		<br>
	</form>


	<div>
		<jsp:include page="homeLink.html"></jsp:include>
	</div>
</body>
</html>
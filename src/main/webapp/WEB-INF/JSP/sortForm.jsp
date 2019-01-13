<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="sort">
		<h3>Sort Account By</h3>
		<li><a href="sortByAccountNumber">By Account Number</a></li>
		<li><a href="sortByAccountHolderName">By Holder Name</a></li> 
		<li><a href="sortBySalaryType">By Salary Type</a></li> <br>
	</form>


	<div>
		<jsp:include page="homeLink.html"></jsp:include>
	</div>
</body>
</html>
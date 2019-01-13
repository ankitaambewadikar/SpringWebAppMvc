<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addDetailsCurrent">
Enter AccountHolderName:<input type="text" name="accountHolderName" maxlength="30"><br>
Enter Initial Account Balance:<input type=number name="accountBalance"><br>
Enter OverDraft Limit:<input type=number name="odLimit"><br>
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>
<div>
		<jsp:include page="homeLink.html"></jsp:include>
	</div>
</body>
</html>
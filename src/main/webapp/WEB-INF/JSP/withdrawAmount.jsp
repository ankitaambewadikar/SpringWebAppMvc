<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="withdrawAmountFromAccount">
		Enter Account Number:<input type="text" name="accountNumber"><br>
		Enter Amount withdraw:<input type=number name="amounttowithdraw"><br>

		<input type="submit" value="Submit">

	</form>
	<div>
		<jsp:include page="homeLink.html"></jsp:include>
	</div>
</body>
</html>
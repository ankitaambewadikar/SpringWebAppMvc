<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Amount</title>
</head>
<body>
	<h2>Deposit Account</h2>
	<form action="depositAmountInAccount">
		Enter Account Number:<input type="text" name="accountNumber"><br>
		Enter Amount to deposit:<input type=number name="amounttodeposit"><br>

		<input type="submit" value="Submit">

	</form>
	<div>
		<jsp:include page="homeLink.html"></jsp:include>
	</div>
</body>
</html>
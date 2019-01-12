<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 
	 <form action="updatedb">
	 		<table>
			<tr>
				<th>Account Number</th>
				<th><a href="sortByName.mm">Holder Name</a></th>
				<th><a href="sortByBalance.mm">Account Balance</a></th>
				<th><a href="sortBySalary.mm">Salary</a></th>
				<th>Over Draft Limit</th>
				<th>Type Of Account</th>
			</tr>
			<jstl:if test="${account!=null}">
				<tr>
					<td><input name="txtAccountNumber" value=${account.bankAccount.accountNumber} readonly="readonly"></td>
					<td><input name="accountHolderName"	value=${account.bankAccount.accountHolderName} ></td>
					<td><input value=${account.bankAccount.accountBalance}
						readonly="readonly"></td>
					
					 <jstl:if test="${account.salary==true}">
						<td><select name="salary">
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select> </td>
					</jstl:if>
					
					<jstl:if test="${account.salary==false}">
						<td><select name="salary">
							<option value="no">No</option>
							<option value="yes">Yes</option>	
						</select></td>
					</jstl:if>
					
					<td>${"N/A"}</td>
					<td>${"Savings"}</td>
				</tr>
			</jstl:if>

		</table>
		<input type="submit" value="Update">
	 </form>
	 <div>
		<jsp:include page="homeLink.html"></jsp:include>
	</div>
 </body>
</html>








<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<form:form action="add" method="post" commandName="userForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Spring MVC Form Demo -
							Registration</h2></td>
				</tr>
				<tr>
					<td>UserId:</td>
					<td><form:input path="userid" /></td>
				</tr>
				<tr>
					<td>Full name:</td>
					<td><form:input path="fullname" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Role id:</td>
					<td><form:input path="role.roleid" /></td>
				</tr>
				<tr>
					<td>Sex:</td>
					<td><form:input path="sex" /></td>
				</tr>
				<tr>
					<td>Date of birth:</td>
					<td><form:input path="dateofbirth"/></td>
				</tr>
				<tr>
					<td>Place of birth:</td>
					<td><form:input path="placeofbirth" /></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
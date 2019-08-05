<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<script>
function validateform(){
var name=document.loginForm.username.value;
var password=document.loginForm.password.value;
var letterNumber = /^[0-9a-zA-Z]+$/;
var passwordCriteria = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
if (name==null || name=="" || password ==null || password==""){
  alert("You can't leave any field blank");
  return false;
} else if (!name.match(letterNumber)) {
    alert("Only alphanumeric username allowed");
    return false;
}else if(password.length<8){
  alert("Password must be at least 8 characters long.");
  return false;
  } else if(!password.match(passwordCriteria)) {
  alert("Please make sure your password consists of atleast one uppercase letter,one lowercase letter and one number");
  return false;
  }
}
</script>

<body>

	<form:form name="loginForm" modelAttribute="login" action="loginProcess"
		method="post" onsubmit="return validateform()">
		<table align="center">
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td><form:input path="username" name="username" id="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="login" name="login">Register</form:button></td>
			</tr>

			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>

	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

</body>
</html>
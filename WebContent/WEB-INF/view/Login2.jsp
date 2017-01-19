<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Please Login</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">

</head>

<body>
	<div class="container">
	<form:form action="login" modelAttribute="loginBean" method="POST" class="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Username</label> 
			<form:input
				type="text" id="inputEmail" class="form-control"
				placeholder="Email address" path="username" required="true" autofocus="true"/> 
			<label
				for="inputPassword" class="sr-only">Password</label> 
			<form:input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" path="password" required="true"/>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	</form:form>
	</div>
	<!-- /container -->
</body>
</html>

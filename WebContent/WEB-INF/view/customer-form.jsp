<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"></link>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"></link>

</head>
<body>


	<%
		if (session.getAttribute("UName") == null) {
			response.sendRedirect("http://localhost:8080/CRM_Spring_Hibernate/");
		}
	%>

	<div id="wrapper">
		<div id="header">
			<h2>C.R.M</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>

		<form:form action="saveCustomer" modelAttribute="newCustomer"
			method="POST">
			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label>
						<td><form:input path="firstName" />
					</tr>

					<tr>
						<td><label>Last Name:</label>
						<td><form:input path="lastName" />
					</tr>

					<tr>
						<td><label>Email:</label>
						<td><form:input path="email" />
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>

		<div>
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Cancel</a>
			</p>
		</div>
	</div>

</body>
</html>
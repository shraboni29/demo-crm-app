<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>List Customers</title>

	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		<!--  add a search box -->
			<form:form action="search" method="GET">
				Search customer: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Search" class="add-button" />
			</form:form>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>action</th>
					<th>action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="temp" items="${customers}">
				
				<c:url var="updatelink" value="/updateCustomer">
				<c:param name="customerId" value="${temp.id}"></c:param>
				</c:url>
				<c:url var="deletelink" value="/deleteCustomer">
				<c:param name="customerMId" value="${temp.id}"></c:param>
				</c:url>
				
					<tr>
						<td> ${temp.firstName} </td>
						<td> ${temp.lastName} </td>
						<td> ${temp.email} </td>
						<td> ${temp.address} </td>
					
				<td><a href="${updatelink}">Update</a></td>	
					<td><a href="${deletelink}"onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>				
				</c:forEach>
						
			</table>
			<button onclick="window.location.href='addCustomer'" >ADD CUSTOMER</button>
		
			</div>
			</div>	
	

</body>

</html>







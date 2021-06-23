<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous"
	>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: lightblue">
			<div>
				<a href="#" class="navbar-brand"> Corporate Information WebApp </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Corporate Information</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" style="background-color:lightblue" class="btn btn-success">Add
					New Data</a>
					
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Sr NO</th>
						<th>Corporate Name</th>
						<th>Corporate Id</th>
						<th>Account Number</th>
						<th>Manage</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.getSn()}"/></td>
							<td><c:out value="${user.getCorporateName()}" /></td>
							<td><c:out value="${user.getCorporateId()}" /></td>
							<td><c:out value="${user.getAccountNumber()}" /></td>
							<td><a href="edit?sn=<c:out value='${user.getSn()}' />">MODIFY</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?sn=<c:out value='${user.getSn()}' />">DELETE</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								 </td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
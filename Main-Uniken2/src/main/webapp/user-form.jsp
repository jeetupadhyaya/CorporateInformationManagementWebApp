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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Modify Data
            		</c:if>
						<c:if test="${user == null}">
            			Add New Data
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="sn" value="<c:out value='${user.getSn()}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Corporate Name</label> <input type="text"
						value="<c:out value='${user.getCorporateName()}' />" class="form-control"
						name="corporate_name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Corporate Id</label> <input type="text"
						value="<c:out value='${user.getCorporateId()}' />" class="form-control"
						name="corporateid">
				</fieldset>

				<fieldset class="form-group">
					<label>Account Number</label> <input type="text"
						value="<c:out value='${user.getAccountNumber()}' />" class="form-control"
						name="accountnumber">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

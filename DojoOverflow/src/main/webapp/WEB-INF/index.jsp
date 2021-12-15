<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<meta charset="ISO-8859-1">
	<title>Questions Dashboard</title>
</head>
<body>

	<h1>Questions Dashboard</h1>
	
	<table class="table border border-dark table-striped table-hover m-auto w-50 p-3">
		<thead>
			<tr>
				<th scope="col">Question</th>
				<th scope="col">Tags</th>
		    </tr>
		</thead>
			<tbody>
			    <c:forEach var="question" items="${questions}">
			    <tr>
					<!-- c:out not needed for each time -->
					<td><a href="/questions/${question.id}">${question.aQuestion}</a></td>
					<c:forEach var="tag" items="${question.tags}">
					<td>${tag.subject}</td>
					</c:forEach>
				</tr>
				</c:forEach>
			</tbody>
	</table>
	
	
	<p><a href="/questions/new">New Question</a></p>

</body>
</html>
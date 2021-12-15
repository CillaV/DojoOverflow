<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Question Profile</title>
</head>
<body>

	<h1>${question.aQuestion}</h1>
	<h2>Tags:</h2>
	<c:forEach var="tag" items="${question.tags}">
		<p>${tag.subject}</p>
	</c:forEach>

	<table class="table border border-dark tab0le-striped table-hover m-auto w-50 p-3">
		<thead>
			<tr>
				<th scope="col">Answers</th>
		    </tr>
		</thead>
		<tbody>
		    <c:forEach var="answer" items="${question.answers}">
		    <tr>
				<!-- c:out not needed for each time -->
				<td>${answer.tAnswer}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
	<h2>Add your answer:</h2>
	
	<form:form class="m-auto w-50 p-3" action="/questions/${question.id}/new/answer" method="POST" modelAttribute="answer">
	    
  	    <p class="m-auto w-50 p-2 d-flex justify-content-between">
	        <form:label path="tAnswer">Answer:</form:label>
	        <form:errors path="tAnswer"/>
	        <form:textarea path="tAnswer"/>
	    </p>
      
	    <input class ="btn btn-success btn-sm d-flex justify-content-sm-end" type="submit" value="Submit"/>
	</form:form>    


</body>
</html>
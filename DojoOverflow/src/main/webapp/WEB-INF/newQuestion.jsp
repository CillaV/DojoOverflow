<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<meta charset="ISO-8859-1">
	<title>New Question</title>
</head>
<body>


	<h1>What is your question?</h1>
	
	<p><a href="/questions">Back To Questions Dashboard</a></p>
		
	<form:form class="m-auto w-50 p-3" action="/questions/new" method="POST" modelAttribute="question">
    
  	    <p class="m-auto w-50 p-2 d-flex justify-content-between">
	        <form:label path="aQuestion">Question:</form:label>
	        <form:errors path="aQuestion"/>
	        <form:textarea path="aQuestion"/>
	    </p>
	    
	    
	    <p class="m-auto w-50 p-2 d-flex justify-content-between">
	        <form:label path="frontEndTags">Tags:</form:label>
	        <form:errors path="frontEndTags"/>
	        <form:input path="frontEndTags"/>
	    </p>
	    
      
	    <input class ="btn btn-success btn-sm d-flex justify-content-sm-end" type="submit" value="Submit"/>
	</form:form>    




</body>
</html>
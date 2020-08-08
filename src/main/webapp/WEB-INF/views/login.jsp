<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
position:absolute;
padding:10px;
left:50px;}
div{
 width: 500px;
 clear: both;
}
input{
width: 50%;
 clear: both;
}
form{
width:500px;
padding:10px;
background-color:yellow;}
</style>
<meta charset="ISO-8859-1">
<title>My Page</title>
</head>
<body>
Hi! ${name}
<br><label>${err}</label>
<div>
<form action"/spring-mvc/login" method="POST">
<label for="name">Enter Your Name:</label>
<input type="text" id="name" name="name"/></br></br>
<label for="password">Enter Your Password:</label>
<input type="password" id="password" name="password"/></br></br>
<button type="submit">Submit</button>
</form>
</div>
</body>
</html>
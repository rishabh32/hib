<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <style>
 html { width: 100%; height:100%; overflow:hidden; }
body { 
	width: 100%;
	height:100%;
	font-family: 'Open Sans', sans-serif;
	background: #092756;
	background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
}
.login { 
	position: absolute;
	top: 40%;
	left: 50%;
	margin: -150px 0 0 -150px;
	width:300px;
	height:300px;
}
.login h1 { color: #fff; text-shadow: 0 0 10px rgba(0,0,0,0.3); letter-spacing:1px; text-align:center; }
</style>
</head>
<body>
<h1 align="center" style="color:white">Registration Form</h1>
<br>
<br>
<div class="login" >
<div class="container" style="border: 1px solid rgb(103, 91, 153); margin-top:4px">
<form action="sub" method="post">
 <div class="form-group">
  <label for="usr" style="color:white; margin-top:8px">First Name:</label>
  <input type="text" class="form-control" id="first" name="firstname" required="required"> 
  <label for="usr" style="color:white">Last Name:</label>
  <input type="text" class="form-control" id="last" name="lastname" required="required"> 
  <label for="usr" style="color:white">User Name:</label>
  <input type="text" class="form-control" id="username" name="username" required="required">
   <label for="pwd" style="color:white">Password:</label>
   <input type="password" class="form-control" id="pwd"  name="password" required="required"> 
  <label for="usr" style="color:white">Age:</label>
  <input type="text" class="form-control" id="age" name="age" required="required"> 
  <label for="usr" style="color:white">Contact No:</label>
  <input type="text" class="form-control" id="contact" name="contact" required="required">
  <label for="usr" style="color:white">Which is your favourite movie:</label>
  <input type="text" class="form-control" id="movie" name="movie" required="required">
 <br>
<center><button type="submit" class="btn btn-light" style="width:200px;background-color:rgb(103, 91, 153);focus:rgb(147, 109, 191)">SUBMIT</button></center>
</div>
</form>
</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">${message}</font>
<form action="registerUser"  method="post">
Name : <input type="text"  name="Name"/></br></br>
MailId : <input type="text"  name="MailId"/></br></br>
Mobile : <input type="text"  name="MobileNumber"/></br></br>
password : <input type="password"  name="PassWord"/></br></br>
city : <input type="text"  name="City"/></br></br>
<input type="submit" value="register"></br></br>
<a href="login.jsp">Click Here</a> for login page
</form></br></br>
<a href="goToHomePage">Click Here</a> for Home page
<br><br><br><br>
<form action="testIoc">
<input type="submit" value="TestIoc">
</form>
</body>
</html>
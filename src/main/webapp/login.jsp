<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<font color="red">
${message}</br></br>
${message2}
</font> 
<form action="<c:url value='j_spring_security_check' />" method="POST">
UserName : <input type="text" name="userName"/></br></br>
Password : <input type="password" name="PassWord"/></br></br>
<input type="submit" value="login">
<a href="register.jsp">Click Here</a> for register page
</form></br></br>
<a href="Home.jsp">Click Here</a> for Home page
</body>
</html>
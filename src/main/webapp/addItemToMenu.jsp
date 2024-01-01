<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="Green"> ${message}</font></br>
<form action="AddItem" method="post">
Item : <input type="text" name="item"/></br></br>
Price : <input type="text" name="price"/></br></br>
Quantity : <input name="qty"/></br></br>
Veg : <input type="radio" name="typeofItem" value="Veg"/></br></br>
Non Veg : <input type="radio" name="typeofItem" value="NonVeg"/></br></br>
<input type="submit" value="Add"/>
</form>
<a href="goToHomePage">Click Here</a> for Home page
</body>
</html>
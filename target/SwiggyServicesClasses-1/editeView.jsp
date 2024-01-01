<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 click here for <a href=<core:url value="/j_spring_security_logout"/>>logout</a>
<form action="UpDatedItem" method="post">
ItemId : <input type="text" name="itemId" readonly="readonly" value="${itemInfo.itemId}"></br></br>
Item : <input type="text" name="item" value="${itemInfo.item}"/></br></br>
Price : <input type="text" name="price" value="${itemInfo.price}"/></br></br>
Quantity : <input name="qty" value="${itemInfo.qty}"/></br></br>
Veg : <input type="radio" name="typeofItem" ${veg} value="Veg"/></br></br>
Non Veg : <input type="radio" name="typeofItem" ${nonveg} value="NonVeg"/></br></br>
<input type="submit" value="Update"/>
</form>
</body>
</html>
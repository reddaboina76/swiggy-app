<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function editItem(itemid) {
	alert(itemid + 'edit button triggered!!')
	
	document.forms[0].action="${pageContext.request.contextPath}/editItemView?ItemId="+ itemid;
	document.forms[0].method="post";
	document.forms[0].submit();
}

function deleteItem(itemId) {
	alert(itemId + 'delete button triggered!!')
	
	document.forms[0].action="${pageContext.request.contextPath}/deleteItem?ItemId="+ itemId;
	document.forms[0].method="post";
	document.forms[0].submit();
}

</script>
</head>
<body>
<font color="green" >${msg}</font>
 click here for <a href=<core:url value="/j_spring_security_logout"/>>logout</a></br></br>
<form action="deleteMultiple">
<table border="1">
<tr>
<th>ITEMID</th>
<th>ITEM</th>
<th>PRICE</th>
<th>VEG/NONVEG</th>
<th>QTY</th>
<th>OPERATIONS</th>
 </tr>
<core:forEach var="item" items="${menuData}">
<tr>
<td>${item.itemId}</td>
<td>${item.item}</td>
<td>${item.price}</td>
<td>${item.typeofItem}</td>
<td>${item.qty}</td>
<td><input type="button" onclick="editItem('${item.itemId}')"  value="edit"></td>
<td><input type="button" onclick="deleteItem('${item.itemId}')" value="delete"></td>
<td><input type="checkbox" name="itemCheckBox" value="'${item.itemId}'"></td>
</tr>
 
</core:forEach>
</table></br>
<input type="submit" value="Delete Multiple">
</form>
<a href="goToHomePage">Click Here</a> for Home page
</body>
</html>
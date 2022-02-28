<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current visit count</title>
</head>
<body>
    <h2>Tu has visitado <c:out value="${serverName}"/> <c:out value="${countToShow}"/> veces.</h2>
	<a href="/">Prueba otra visita</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
</head>
<body>
	<div>
		<p>
			Bienvenue
			<c:out value="${utilisateur.prenom}"></c:out>
			<c:out value="${utilisateur.nom}"></c:out>
			,
		</p>
	</div>
	<div>Voici la liste de vos transaction actuel :</div>
</body>
</html>
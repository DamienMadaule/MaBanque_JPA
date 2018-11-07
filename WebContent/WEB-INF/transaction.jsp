<%@include file="header.jsp"%>
<body>
	<%@include file="navBar.jsp"%>
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
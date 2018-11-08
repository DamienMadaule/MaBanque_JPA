<%@include file="header.jsp"%>
<body>
	<%@include file="navBar.jsp"%>
	<div class="container">
		<form action="ajouterCompte" method="post">
			<div>
				<label for="nomCompte">Nom du Compte :</label>
				<input type="text" name="nomCompte" id="nomCompte">
			</div>
			<div>
				<label>Type de Compte :</label>
				<input type="text" name="typeCompte" id="typeCompte">
			</div>
			<div>
				<button class="btn btn-succes btn-block" type="submit"></button>
			</div>
		</form>
	</div>
</body>
</html>
<%@include file="header.jsp"%>
<body>
	<%@include file="navBar.jsp"%>
	<div class="container">
		<form action="ajouterCompte" method="post">
			<div class="form-group">
				<label for="nomCompte">Nom du Compte :</label>
				<input type="text" name="nomCompte" id="nomCompte" class="form-control">
			</div>
			<div class="form-group">
				<label>Type de Compte :</label>
				<input type="text" name="typeCompte" id="typeCompte" class="form-control">
			</div>
			<div class="col-md-4">
				<button class="btn btn-success btn-block" type="submit">envoyer</button>
			</div>
		</form>
	</div>
</body>
</html>
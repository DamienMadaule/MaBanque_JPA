<%@include file="header.jsp"%>
<body>
	<%@include file="navBar.jsp"%>
	<div class="container">
		<form action="ajouterTransaction" method="post">
			<div class="form-group">
				<label for="nomCompte">Motif :</label>
				<input type="text" name="motif" id="motif" class="form-control">
			</div>
			<div class="form-group">
				<label>id Compte Source :</label>
				<input type="text" name="cptSource" id="cptSource" class="form-control">
			</div>
			<div class="form-group">
				<label>id Compte Destination :</label>
				<input type="text" name="cptDestination" id="cptDestination" class="form-control">
			</div>
			<div class="form-group">
				<label>Somme :</label>
				<input type="text" name="somme" id="somme" class="form-control">
			</div>
			<div class="col-md-4">
				<button class="btn btn-success btn-block" type="submit" >Envoyer</button>
			</div>
		</form>
	</div>
</body>
</html>
<%@include file="header.jsp"%>
<body>
	<%@include file="navBar.jsp"%>
	<div class="container">
	
		<form action="password" method="post">
			<div class="form-group">
				<label for="ancienPwd">ancien mot de passe :</label> 
				<input class="form-control" type="text" name="ancienPwd" id="ancienPwd" placeholder="Ancien mot de passe">
			</div>
			<div class="form-group">
				<label for="nouveauPwd">Nouveau mot de passe :</label> 
				<input class="form-control" type="text" name="nouveauPwd" id="nouveauPwd" placeholder="nouveau mot de passe">
			</div>
			<div class="form-group">
				<label for="nouveauPwdConformation">Nouveau mot de passe (confirmation) :</label> 
				<input class="form-control" type="text" name="nouveauPwdConformation" id="nouveauPwdConformation" placeholder="nouveau mot de passe">
			</div>
			<div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>
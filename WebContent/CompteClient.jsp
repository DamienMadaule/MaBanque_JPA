<%@include file="header.jsp" %>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">My Bank</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Parametre
						<span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">

				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
			</form>
		</div>
	</nav>
	<div class="container">
		<div>
			<p>
				Bienvenue
				<c:out value="${utilisateur.prenom}"></c:out>
				<c:out value="${utilisateur.nom}"></c:out>
				,
			</p>
		</div>
		<div>Voici la liste de vos compte actuel :</div>
		<div>
			<table class="table">
				<tr>
					<th scope="col">id</th>
					<th scope="col">Solde</th>
					<th scope="col">Action</th>
				</tr>
				<tbody>
					<c:if test="${fn:length(utilisateur.comptes) gt 0}">
						<c:forEach items="${utilisateur.comptes}" var="compte">
							<tr scope="row">
								<td><c:out value="${compte.id}"></c:out></td>
								<td><c:out value="${compte.solde}"></c:out></td>
								<td>
									<form method="post" action="CompteClient">
										<button value="${compte.id}" onclick="submit()"
											class="btn btn-primary" name="submitButton">Consulter</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
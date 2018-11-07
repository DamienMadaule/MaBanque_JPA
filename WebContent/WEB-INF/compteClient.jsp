<%@include file="header.jsp"%>
<body>
	<%@include file="navBar.jsp"%>
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
									<form method="post" action="compteClient">
										<input type="hidden" value="${compte.id}" name="id"> <input
											type="submit" value="Consulter" class="btn btn-primary"
											name="submitButton" />
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
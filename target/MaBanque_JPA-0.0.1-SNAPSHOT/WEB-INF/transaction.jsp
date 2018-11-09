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
		<div>Voici la liste de vos transaction actuel :</div>
		<div>
			Solde : 
			<strong><c:out value="${compte.solde }"></c:out></strong>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">date</th>
						<th scope="col">libelle</th>
						<th scope="col">montant</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${compte.transaction}" var="transaction">
						<tr>
							<td scope="row"><c:out value="${transaction.date}"></c:out></td>
							<td><c:out value="${transaction.libelle}"></c:out></td>
							<td>					
								<c:choose>
									<c:when test="${transaction.cptSource.equals(Integer.toString(compte.id))}">
										<div class="text-danger">
											- <c:out value="${transaction.montant}"></c:out>
										</div>
									</c:when>
									<c:otherwise>
    									<div class="text-success">
											<c:out value="${transaction.montant}"></c:out>
										</div>
  									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
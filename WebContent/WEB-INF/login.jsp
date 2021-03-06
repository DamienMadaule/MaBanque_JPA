<%@include file="header.jsp" %>
<body>
	<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
	<fmt:setLocale value="${ language }"  />
	<fmt:setBundle basename="fr.ynov.mabanque.language"/>


	<div class="container text-center">
		<fmt:message key="login" />
		<div>				
		<form>
			<button value="fr" onclick="submit()" name="language" class="btn btn-default">fr</button>
			<button value="en" onclick="submit()" name="language" class="btn btn-default">en</button>
		</form>
		</div>
		<form action="login" method="post">
			<div class="form-group">
				<label for="InputLogin"><fmt:message key="loginMessage" /></label> <input type="text"
					class="form-control" id="InputLogin" aria-describedby="loginHelp"
					placeholder="<fmt:message key="loginInput" />" name="login">
			</div>
			<div class="form-group">
				<label for="InputPassword"><fmt:message key="passwordMessage" /></label> 
				<input type="password" class="form-control" id="InputPassword"
					placeholder="<fmt:message key="passwordInput" />" name="password">
			</div>
			<button type="submit" class="btn btn-primary"><fmt:message key="connexion" /></button>
		</form>
	</div>
</body>

</html>
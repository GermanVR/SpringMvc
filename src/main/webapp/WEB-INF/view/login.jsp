<jsp:include page="includes/header.jsp" />
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<h1 align="center">Bienvenidos al Sistema de Cinefila</h1>
	<c:if test="${error != null}">
		<script>
			toastr.error('${error}');
		</script>
	</c:if>
	<div class="row">
		<div style="float: none; margin: 0 auto;">
			<form action="./logeo" method="post">
				<div class="card " style="width: 18rem;">
					<div class="card-body">
						<label for="user">Usuario</label>
						<input id="user" name="usuario" class="form-control" type="text" placeholder="Ingrese Usuario">
						<br />
						<label for="pass">Contraseña</label>
						<input id="pass" name="password" class="form-control" type="password" placeholder="Ingrese Contraseña">
						<br />
						<input type="submit" class="btn btn-primary" value="Ingresar" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
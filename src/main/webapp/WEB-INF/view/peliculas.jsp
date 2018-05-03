<jsp:include page="includes/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Bienvenido</title>
</head>

<body>
	<jsp:include page="includes/menu.jsp" />
	<br>
	<div class="card">
		<div class="card-header">Lista de Peliculas</div>
		<div class="card-body">

			<table class="table">
				<thead class="thead-light">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Titulo</th>
						<th scope="col">Duracion</th>
						<th scope="col">Clasificacion</th>
						<th scope="col">Genero</th>
						<th scope="col">Fecha Estreno</th>
						<th scope="col">Imagen</th>
						<th scope="col">Estatus</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas }" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.titulo}</td>
							<td>${p.duracion}</td>
							<td>${p.clasificacion}</td>
							<td>${p.genero}</td>
							<td>
								<fmt:formatDate value="${p.fechaEstreno}" pattern="dd-MM-yyyy"></fmt:formatDate>
							</td>
							<td>
								<img width="200px" height="300px" src="${p.imagen}" />
							</td>
							<td>
								<c:choose>
									<c:when test="${p.estatus eq 'A'.charAt(0)}">
										<span class="badge badge-pill badge-success">Activa</span>
									</c:when>
									<c:otherwise>
										<span class="badge badge-pill badge-danger">Inactiva</span>
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
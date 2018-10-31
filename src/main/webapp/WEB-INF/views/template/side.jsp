<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

</div>
</div>
<div class="col-sm-3">
	<div class="panel panel-default">
		<div class="panel-heading">Buscar por:</div>
		<div class="panel-body">
			<form class="form-row" method="post" action="<c:url value="/produto/buscar"/>">
				<div class="form-group">
					<label for="nome">Nome</label>
					<input type="text" name="nome" class="form-control">
				</div>
				<div class="form-group">
					<label for="categoriaId">Categoria</label>
					<select class="form-control" name="categoriaId">
						<option selected value=""></option>
						<c:forEach items="${categorias}" var="categoria">
							<option value="${categoria.id}">${categoria.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="lojaId">Loja</label>
					<select class="form-control" name="lojaId">
						<option selected value=""></option>
						<c:forEach items="${lojas}" var="loja">
							<option value="${loja.id}">${loja.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary form-control" value="Buscar">
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
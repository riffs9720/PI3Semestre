<%@ page language ="java" contentType ="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>

	<head>
	<meta charset ="utf-8">
	<meta http-equiv ="X-UA-Compatible" content="IE=edge">
	<meta name ="viewport" content ="width=device-width, initial-scale=1">
	<title>Buscar Empresas</title>
	
	<link href ="css/bootstrap.min.css" rel ="stylesheet">
	<link href ="css/style.css" rel ="stylesheet">
	
	</head>
	<body>
	<!-- Modal -->
		<div class ="modal fade" id ="delete-modal" tabindex ="-1" role ="dialog" aria-labelleby ="modalLabel">
			<div class ="modal-dialog" role ="document">
				<div class ="modal-content">
					<div class ="modal-header">
						<button type ="button" class="close" data-dismiss="modal" aria-label="Fechar">
							<span aria-hidden ="true">&times;></span>
						</button>
						<h4 class ="modal-title" id="modalLabel">Excluir Empresa</h4>
					</div>
					<div class="modal-body">
						Deseja realmente excluir está Empresa ?
					</div>
					<div class ="modal-footer">
						<form action ="controller.do" method ="post">
							<input type ="hidden" name ="id" id ="id_excluir" />
							<button type ="submit" class ="btn btn-primary" name ="command" value ="ExcluirEmpresa">Sim</button>
							<button type ="button" class ="btn btn-default" data-dismiss = "modal">N&atilde;o</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal -->
		<!-- Barra superior com os menus de navegação. -->
			<c:import url="Menu.jsp" />
		<!-- Container Principal -->
		<div id ="main" class = "container">
			<form action = "controller.do" method = "post">
				<div id = "top" class = "row">
					<div class = "col-md-3">
						<h2>Empresas</h2>
					</div>
					<div class = "col-md-6">
						<div class = "input-ground h2">
							<input name = "data[search]" class = "from-control" id = "search" type = "text" placeholder = "Procurar Empresas">
							<span class = "input-group-btn">
								<button class = "btn btn-primary" type ="submit" name="command" value="ListarEmpresaBuscar">
									<span class = "glyphilcon glyphilcon-search"></span>
								</button>
							</span>
						</div>
					</div>
					<div class = "col-md-3">
						<a href = "CriarEmpresa.jsp" class = "btn btn-primary pull-right h2">Nova Empresa</a>
					</div>
				</div>
			</form>
			<hr />
			<c:if test="${not empty lista}">
				<div id = "list" class = "row">
					<div class = "table-responsive col-md-12">
						<table class = "table table-striped" cellspacing = "0" cellpadding = "0">
							<thead>
								<tr>
									<th>ID</th>
									<th>Nome</th>
									<th>Endereço</th>
									<th>Categoria</th>
									<th class = "actions">Ações</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var = "empresa" items = "${lista}">
									<tr>
										<td>
											${empresa.id}
										</td>
										<td>
											${empresa.nome}
										</td>
										<td>
											${empresa.endereco}
										</td>
										<td>
											${empresa.categoria}
										</td>
										<td class = "actions">
											<a class = "btn btn-success btn-xs" href = "controller.do?command=VisualizarEmpresa&id=${empresa.id}">Visualizar Avaliações</a>
											<a class = "btn btn-warning btn-xs" href = "controller.do?command=EditarPais&id=${empresa.id}">Avaliar</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /#list -->
				<div id = "bottom" class = "row">
					<div class = "col-md-12">
					<!-- paginação ainda não foi implementada -->
						<ul class = "pagination">
							<li class = "disabled"><a>&lt;Anterior</a>
							</li>
							<li class = "disabled"><a>1</a>
							</li>
							<li><a href = "#">2</a>
							</li>
							<li><a href = "#">3</a>
							</li>
							<li class = "next"><a href = "#" rel = "next">Próximo &gt;</a>
							</li>
						</ul>
						<!-- /.pagination -->
					</div>
				</div>
			</c:if>
			<!-- /#bottom -->
		</div>
		<!-- /#main -->
		<script type="js/jquery.min.js"></script>
		<script type="js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$("#delete-modal").on('show.bs.modal', function(event){
				var button = $(event.relatedTarget); // botão que disparou ou inicializou o modal.
				var recipient = button.data('pais');
				$("#id_excluir").val(recipient);
			});
		</script>
	</body>
</html>
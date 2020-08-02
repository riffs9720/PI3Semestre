<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Categoria"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="java.util.ArrayList"%>

<% 
	CategoriaDAO dao = new CategoriaDAO();
	ArrayList<Categoria> lista;
	
	lista = dao.listar();
%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Empresa</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Cadastrar Empresa</h3>
		<!-- Formulario para inclusao de Empresa -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->

			<div class="row">
				<div class="form-group col-md-12">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome"
						placeholder="Digite o nome Completo da Empresa">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" name="endereco" id="endereco"
						placeholder="Digite o endereco da Empresa">
				</div>
				<div class="row">
					<div class="form-group col-md-3">
					<label for="sel1">Selecione a Categoria:</label>
         <select class="form-control" id="sel1" name="categoria" >

       <%
        for (Categoria registro : lista) {
       %>
       <option><%=registro.getId()%></option>
       <%
        }
       %>
      </select><br>
					</div>
				</div>
				<hr>
				<button type="submit" class="btn btn-primary" name="command"
					value="CriarEmpresa">Cadastrar</button>
				<a href="index.jsp" class="btn btn-default">Cancelar</a>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script language="JavaScript">
		function vai(combo)

		{

			var x = combo.selectedIndex;
		}
	</script>
</body>

</html>
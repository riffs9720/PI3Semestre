<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<nav class="navbar navbar-inverse navbar-fixed-top"
	style="background-color: #0066CC;">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp" style="color: white;">AcessReport</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a style="color: white;"><span
						class="glyphicon glyphicon-user" style="color: white;"></span>
						<%
							Usuario usuAutenticado = (Usuario) session.getAttribute("usuAutenticado");
						%>
						<%
								out.print("Você está logado como: " + usuAutenticado.getNome());
							%></a></li>
				<li><a href="autenticador" style="color: white;"><span
						class="glyphicon glyphicon-log-in" style="color: white;"></span>
						Logout</a></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" style="color: white;">Menu <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="CriarEmpresa.jsp">Cadastrar Empresa</a></li>
						<li><a href="ListarEmpresa.jsp">Visualizar Empresas</a></li>
						<li><a href="CriarAvaliacao.jsp">Fazer Avaliação</a></li>
						<li><a href="#">Trocar Senha</a></li>
					</ul>
		</div>
	</div>
</nav>
<footer
	style="position: absolute; bottom: 0px; width: 100%; height: 30px; background-color: #0066CC; text-align: center; font-size: 16px; color: white;">
	Grupo 14 copyright™
	<article>
</footer>

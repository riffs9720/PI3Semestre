<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Avaliacao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Avaliacao Cadastrado</title>
</head>
<body>
	<%Avaliacao avaliacao = (Avaliacao)request.getAttribute("avaliacao"); %>

	Id: <%=avaliacao.getId() %><br>
	IdUsuario: <%=avaliacao.getIdUsuario() %><br>
	Nota1: <%=avaliacao.getNota1() %><br>
	Nota2: <%=avaliacao.getNota2() %><br>
	Nota3: <%=avaliacao.getNota3() %><br>
	Nota4: <%=avaliacao.getNota4() %><br>
	Comentario1: <%=avaliacao.getComentario1() %><br>
	Comentario2: <%=avaliacao.getComentario2() %><br>
	Comentario3: <%=avaliacao.getComentario3() %><br>
	Comentario4: <%=avaliacao.getComentario4() %><br>
	
</body>
</html>
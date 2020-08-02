<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página - Login</title>
</head>
<body>
	<div>
		<c:import url="Menu1.jsp" />

		<div style="margin-top: 5%;"></div>

		<fieldset>
			<legend align="center">Login</legend>
			<table cellspacing="20" align="center">
				<form action="autenticador" method="post">
					<tr>
						<td><label>E-mail:</label></td>
						<td align="left"><input type="text" name="email" size="30"
							placeholder="Digite seu email"></td>
					</tr>
					<tr>
						<td><label>Senha:</label></td>
						<td align="left"><input type="password" name="senha"
							size="30" maxlength="9" placeholder="Digite sua senha"></td>
					</tr>
			</table>
			<div class="button">
				<input type="submit" value="Logar"
					style="width: 160px; height: 20px; margin-left: 5%">
				<p class="txt-center ls-login-signup">
					<a href="Esqueci a senha.html">Esqueci a senha!</a>
				</p>
				<p class="txt-center ls-login-signup">
					Não possui um login? <a href="CriarUsuario.jsp">Cadastre-se agora</a>
				</p>
			</div>

		</fieldset>
	</div>
</body>
</html>
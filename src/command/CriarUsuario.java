package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class CriarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uNome = request.getParameter("nome");
		String uEmail = request.getParameter("email");
		String uSenha = request.getParameter("senha");
		String uGenero = request.getParameter("genero");
		
		try {

		} catch (NumberFormatException e) {

		}

		Usuario usuario = new Usuario();
		usuario.setNome(uNome);
		usuario.setEmail(uEmail);
		usuario.setSenha(uSenha);
		usuario.setGenero(uGenero);
		
		UsuarioService.criar(usuario);

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		session.setAttribute("usuario", usuario);
		view = request.getRequestDispatcher("Usuario.jsp");

		view.forward(request, response);

	}
}

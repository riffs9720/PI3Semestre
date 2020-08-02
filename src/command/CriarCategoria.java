package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import service.CategoriaService;


public class CriarCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cNome = request.getParameter("nome");

		// instanciar o javabean
		Categoria categoria = new Categoria();
		categoria.setNome(cNome);

		CategoriaService.criar(categoria);

		// enviar para o jsp
		request.setAttribute("categoria", categoria);
		RequestDispatcher view = request.getRequestDispatcher("Categoria.jsp");
		view.forward(request, response);
	}
}
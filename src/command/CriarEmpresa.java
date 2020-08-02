package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import service.EmpresaService;

public class CriarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String eNome = request.getParameter("nome");
		String eEndereco = request.getParameter("endereco");
		int eCategoria = Integer.parseInt(request.getParameter("categoria"));

		// instanciar o javabean
		Empresa empresa = new Empresa();
		empresa.setNome(eNome);
		empresa.setEndereco(eEndereco);
		empresa.setIdCategoria(eCategoria);

		EmpresaService.criar(empresa);

		// enviar para o jsp
		request.setAttribute("empresa", empresa);
		RequestDispatcher view = request.getRequestDispatcher("Empresa.jsp");
		view.forward(request, response);
	}
}
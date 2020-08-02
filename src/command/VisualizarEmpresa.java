package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import service.EmpresaService;

public class VisualizarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String eNome = request.getParameter("nome");
		String eEndereco = request.getParameter("endereco");
		int eCategoria = Integer.parseInt(request.getParameter("categoria"));
		
		try {
			
		} catch (NumberFormatException e) {

		}

		Empresa empresa = new Empresa();
		empresa.setNome(eNome);
		empresa.setEndereco(eEndereco);
		empresa.setIdCategoria(eCategoria);
		EmpresaService es = new EmpresaService();
		
		RequestDispatcher view = null;

		empresa = es.carregar(empresa.getId());
		request.setAttribute("empresa", empresa);
		view = request.getRequestDispatcher("ListarEmpresa.jsp");

		view.forward(request, response);

	}

}

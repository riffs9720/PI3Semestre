package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import service.EmpresaService;

public class ListarEmpresaBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		EmpresaService empresa = new EmpresaService();
		ArrayList<Empresa> lista = null;
		HttpSession session = request.getSession();
		if (chave != null || chave.length() > 0) {
			lista = empresa.listarEmpresa(chave);
		} else {
			lista = empresa.listarEmpresa();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarEmpresa.jsp");
		dispatcher.forward(request, response);
	}
}

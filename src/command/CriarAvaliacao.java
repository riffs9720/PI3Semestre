package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Avaliacao;
import model.Empresa;
import model.Usuario;
import service.AvaliacaoService;


public class CriarAvaliacao implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String aId = request.getParameter("id");
		String aIdEmpresa = request.getParameter("empresa");
		Usuario usuAutenticado = (Usuario) request.getSession().getAttribute("usuAutenticado");
		int aNota1 = Integer.parseInt(request.getParameter("nota1"));
		int aNota2 = Integer.parseInt(request.getParameter("nota2"));
		int aNota3 = Integer.parseInt(request.getParameter("nota3"));
		int aNota4 = Integer.parseInt(request.getParameter("nota4"));
		String aComentario1 = request.getParameter("comentario1");
		String aComentario2 = request.getParameter("comentario2");
		String aComentario3 = request.getParameter("comentario3");
		String aComentario4 = request.getParameter("comentario4");
		int id = -1;
		int idEmpresa = 0;
		
		try {
			id = Integer.parseInt(aId);
			idEmpresa = Integer.parseInt(request.getParameter("empresa"));
		} catch (NumberFormatException e) {
			System.out.println("Numero com formato errado!");
		}

		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId(id);
		
	
		avaliacao.setIdEmpresa(idEmpresa);
		avaliacao.setIdUsuario(usuAutenticado.getId());
		avaliacao.setNota1(aNota1);
		avaliacao.setNota2(aNota2);
		avaliacao.setNota3(aNota3);
		avaliacao.setNota4(aNota4);
		avaliacao.setComentario1(aComentario1);
		avaliacao.setComentario2(aComentario2);
		avaliacao.setComentario3(aComentario3);
		avaliacao.setComentario4(aComentario4);
		
		AvaliacaoService as = new AvaliacaoService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		as.criar(avaliacao);
		ArrayList<Avaliacao> lista = new ArrayList<>();
		lista.add(avaliacao);
		System.out.println(avaliacao);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarAvaliacao.jsp");

		view.forward(request, response);

	}

	public int busca(Avaliacao avaliacao, ArrayList<Avaliacao> lista) {
		Avaliacao to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == avaliacao.getId()) {
				return i;
			}
		}
		return -1;
	}
}
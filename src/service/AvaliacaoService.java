package service;

import model.Avaliacao;

import dao.AvaliacaoDAO;

public class AvaliacaoService {
	static AvaliacaoDAO dao = new AvaliacaoDAO();
	
	public static int criar(Avaliacao avaliacao) {
		return dao.criar(avaliacao);
	}
	
	public static void atualizar(Avaliacao avaliacao) {
		dao.atualizar(avaliacao);
	}
	
	public static void excluir(int id) {
		dao.excluir(id);
	}
	
	public static void carregar(int id) {
		dao.carregar(id);
	}
	
}

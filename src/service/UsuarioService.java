package service;

import model.Usuario;
import dao.UsuarioDAO;

public class UsuarioService {
	static UsuarioDAO dao = new UsuarioDAO();
	
	public static int criar(Usuario usuario) {
		return dao.criar(usuario);
	}
	
	public static void atualizar(Usuario usuario) {
		dao.atualizar(usuario);
	}
	
	public static void excluir(int id) {
		dao.excluir(id);
	}
	
	public static Usuario carregar (int id) {
		return dao.carregar();
	}
	public static Usuario autenticacao (Usuario usuario) {
		return dao.autenticacao(usuario);
	}
	
}

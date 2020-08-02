package service;

import model.Categoria;
import model.Empresa;

import java.util.ArrayList;

import dao.CategoriaDAO;

public class CategoriaService {
	static CategoriaDAO dao = new CategoriaDAO();
	
	public static int criar(Categoria categoria) {
		return dao.criar(categoria);
	}
	
	public static void atualizar(Categoria categoria) {
		dao.atualizar(categoria);
	}
	
	public static void excluir(int id) {
		dao.excluir(id);
	}
	
	public static Categoria carregar (int id) {
		return dao.carregar(id);
	}
	public ArrayList<Categoria> listar(){
		return dao.listar();
	}
}

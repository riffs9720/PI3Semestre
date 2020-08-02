package service;

import model.Empresa;

import java.util.ArrayList;

import dao.EmpresaDAO;

public class EmpresaService {
	static EmpresaDAO dao = new EmpresaDAO();
	
	public static int criar(Empresa empresa) {
		return dao.criar(empresa);
	}
	
	public static void atualizar(Empresa empresa) {
		dao.atualizar(empresa);
	}
	
	public static void excluir(int id) {
		dao.excluir(id);
	}
	
	public Empresa carregar(int id) {
		return dao.carregar(id);
	}
	public ArrayList<Empresa> listarEmpresa(){
		return dao.listarEmpresa();
	}
	public ArrayList<Empresa> listarEmpresa(String chave){
		return dao.listarEmpresa(chave);
	}
}

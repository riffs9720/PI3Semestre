package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;
import model.Empresa;

public class EmpresaDAO {
	public int criar(Empresa empresa) {
		String sqlInsert = "INSERT INTO Empresa(id, nome, endereco, Categoria_id) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, empresa.getId());
			stm.setString(2, empresa.getNome());
			stm.setString(3, empresa.getEndereco());
			stm.setInt(4, empresa.getIdCategoria());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					empresa.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresa.getId();
	}

	public void atualizar(Empresa empresa) {
		String sqlUpdate = "UPDATE Empresa SET nome=?, endereco=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, empresa.getNome());
			stm.setString(2, empresa.getEndereco());
			stm.setInt(3, empresa.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM Empresa WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Empresa carregar(int id) {
		Empresa empresa = new Empresa();
		empresa.setId(id);
		String sqlSelect = "SELECT nome, endereco, Categoria_id FROM empresa WHERE Empresa.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, empresa.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setNome(rs.getString("nome"));
					empresa.setEndereco(rs.getString("endereco"));
					empresa.setIdCategoria(rs.getInt("categoria"));
				} else {
					empresa.setId(-1);
					empresa.setNome(null);
					empresa.setEndereco(null);
					empresa.setIdCategoria(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}

	public ArrayList<Empresa> listarEmpresa() {
		ArrayList<Empresa> empresa = new ArrayList<Empresa>();
		String sqlSelect = "SELECT id, nome FROM Empresa";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Empresa item = new Empresa();
					item.setId(rs.getInt("id"));
					item.setNome(rs.getString("nome"));
					empresa.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}

	public ArrayList<Empresa> listarEmpresa(String chave) {
		Empresa empresa;
		ArrayList<Empresa> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, endereco, Categoria_id FROM Empresa where upper(nome) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					empresa = new Empresa();
					empresa.setId(rs.getInt("id"));
					empresa.setNome(rs.getString("nome"));
					empresa.setEndereco(rs.getString("endereco"));
					empresa.setIdCategoria(rs.getInt("categoria"));
					lista.add(empresa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
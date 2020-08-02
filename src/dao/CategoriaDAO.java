package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;
import model.Empresa;

public class CategoriaDAO {
	public int criar(Categoria categoria) {
		String sqlInsert = "INSERT INTO Categoria(id, nome) VALUES (?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, categoria.getId());
			stm.setString(2, categoria.getNome());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					categoria.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria.getId();
	}

	public void atualizar(Categoria categoria) {
		String sqlUpdate = "UPDATE Categoria SET nomeCategoria=? WHERE idCategoria=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, categoria.getId());
			stm.setString(2, categoria.getNome());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM Categoria WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Categoria carregar(int id) {
		Categoria categoria = new Categoria();
		categoria.setId(id);
		String sqlSelect = "SELECT nomeCategoria FROM Categoria WHERE Categoria.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, categoria.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					categoria.setNome(rs.getString("nome"));
				} else {
					categoria.setId(-1);
					categoria.setNome(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return categoria;
	}

	public ArrayList<Categoria> listar() {
		ArrayList<Categoria> categoria = new ArrayList<Categoria>();
		String sqlSelect = "SELECT id, nome FROM Categoria";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Categoria item = new Categoria();
					item.setNome(rs.getString("nome"));
					item.setId(rs.getInt("id"));
					categoria.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return categoria;
	}
}

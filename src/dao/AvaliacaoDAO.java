package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Avaliacao;

public class AvaliacaoDAO {
	public int criar(Avaliacao avaliacao) {
		String sqlInsert = "INSERT INTO Avaliacao(id, nota1, nota2, nota3, nota4, comentario1, comentario2, comentario3, comentario4, Usuario_id, Empresa_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, avaliacao.getId());
			stm.setInt(2, avaliacao.getNota1());
			stm.setInt(3, avaliacao.getNota2());
			stm.setInt(4, avaliacao.getNota3());
			stm.setInt(5, avaliacao.getNota4());
			stm.setString(6, avaliacao.getComentario1());
			stm.setString(7, avaliacao.getComentario2());
			stm.setString(8, avaliacao.getComentario3());
			stm.setString(9, avaliacao.getComentario4());
			stm.setInt(10, avaliacao.getIdUsuario());
			stm.setInt(11, avaliacao.getIdEmpresa());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					avaliacao.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avaliacao.getId();
	}

	public void atualizar(Avaliacao avaliacao) {
		String sqlUpdate = "UPDATE Avaliacao SET nota1=?, nota2=?, nota3=?, nota4=?, comentario1=? comentario2=? comentario3=? comentario4=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, avaliacao.getNota1());
			stm.setInt(2, avaliacao.getNota2());
			stm.setInt(3, avaliacao.getNota3());
			stm.setInt(4, avaliacao.getNota4());
			stm.setString(5, avaliacao.getComentario1());
			stm.setString(5, avaliacao.getComentario2());
			stm.setString(5, avaliacao.getComentario3());
			stm.setString(5, avaliacao.getComentario4());
			stm.setInt(6, avaliacao.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM Avaliacao WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Avaliacao carregar(int id) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId(id);
		String sqlSelect = "SELECT nota1, nota2, nota3, nota4, comentario1, comentario2, comentario3, comentario4, Usuario_id, Empresa_id FROM Avaliacao WHERE Avaliacao.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, avaliacao.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					avaliacao.setNota1(rs.getInt("nota1"));
					avaliacao.setNota2(rs.getInt("nota2"));
					avaliacao.setNota3(rs.getInt("nota3"));
					avaliacao.setNota4(rs.getInt("nota4"));
					avaliacao.setComentario1(rs.getString("comentario1"));
					avaliacao.setComentario2(rs.getString("comentario2"));
					avaliacao.setComentario3(rs.getString("comentario3"));
					avaliacao.setComentario4(rs.getString("comentario4"));
					avaliacao.setIdUsuario(rs.getInt("idUsuario"));
					avaliacao.setIdEmpresa(rs.getInt("idEmpresa"));
				} else {
					avaliacao.setId(-1);
					avaliacao.setNota1(-1);
					avaliacao.setNota2(-1);
					avaliacao.setNota3(-1);
					avaliacao.setNota4(-1);
					avaliacao.setComentario1(null);
					avaliacao.setComentario2(null);
					avaliacao.setComentario3(null);
					avaliacao.setComentario4(null);
					avaliacao.setIdUsuario(-1);
					avaliacao.setIdEmpresa(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return avaliacao;
	}
}
package model;

import java.io.Serializable;

public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String endereco;
	private int idCategoria;
	
	//Construtores
	
	public Empresa(int id, String nome, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}	
	
	public Empresa() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", endereco=" + endereco
				+ ", categoria" + idCategoria +"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if ( !endereco.equals(other.endereco)) 
			return false;
		if (idCategoria == 0) {
			if (other.idCategoria != 0)
				return false;
		} else if (idCategoria != other.idCategoria)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}

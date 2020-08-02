package model;

import java.io.Serializable;

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	
	//Construtores
	
	public Categoria(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}	
	
	public Categoria() {
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

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if ( !nome.equals(other.nome)) 
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}

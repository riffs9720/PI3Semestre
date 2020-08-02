package model;

import java.io.Serializable;

public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int idUsuario;
	private int idEmpresa;
	private int nota1;
	private int nota2;
	private int nota3;
	private int nota4;
	private String comentario1;
	private String comentario2;
	private String comentario3;
	private String comentario4;
	
	//Construtores
	
	public Avaliacao(int id, int idUsuario, int idEmpresa, int nota1, int nota2, int nota3, int nota4, String comentario1, String comentario2, String comentario3, String comentario4) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idEmpresa = idEmpresa;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.comentario1 = comentario1;
		this.comentario2 = comentario2;
		this.comentario3 = comentario3;
		this.comentario4 = comentario4;
	}	
	
	public Avaliacao() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public int getNota1() {
		return nota1;
	}
	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}
	public int getNota2() {
		return nota2;
	}
	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}
	public int getNota3() {
		return nota3;
	}
	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}
	public int getNota4() {
		return nota4;
	}
	public void setNota4(int nota4) {
		this.nota4 = nota4;
	}
	public String getComentario1() {
		return comentario1;
	}
	public void setComentario1(String comentario1) {
		this.comentario1 = comentario1;
	}
	public String getComentario2() {
		return comentario2;
	}
	public void setComentario2(String comentario2) {
		this.comentario2 = comentario2;
	}
	public String getComentario3() {
		return comentario3;
	}
	public void setComentario3(String comentario3) {
		this.comentario3 = comentario3;
	}
	public String getComentario4() {
		return comentario4;
	}
	public void setComentario4(String comentario4) {
		this.comentario4 = comentario4;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", idUsuario=" +idUsuario+ ", idEmpresa=" +idEmpresa+  " nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", nota4=" 
				+ nota4 + ", comentario1=" + comentario1 + ", comentario2=" + comentario2 + ", comentario3=" + comentario3 + ", comentario4=" + comentario4 +"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (nota1 == 0) {
			if (other.nota1 != 0)
				return false;
		} else if (nota1 != other.nota1)
			return false;
		if (nota2 == 0) {
			if (other.nota2 != 0)
				return false;
		} else if (nota2 != other.nota2)
			return false;
		if (nota3 == 0) {
			if (other.nota3 != 0)
				return false;
		} else if (nota3 != other.nota3)
			return false;
		if (nota4 == 0) {
			if (other.nota4 != 0)
				return false;
		} else if (nota4 != other.nota4)
			return false;
		if (comentario1 == null) {
			if (other.comentario1 != null)
				return false;
		} else if ( !comentario1.equals(other.comentario1)) 
			return false;
		if (comentario2 == null) {
			if (other.comentario2 != null)
				return false;
		} else if ( !comentario2.equals(other.comentario2)) 
			return false;
		if (comentario3 == null) {
			if (other.comentario3 != null)
				return false;
		} else if ( !comentario3.equals(other.comentario3)) 
			return false;
		if (comentario4 == null) {
			if (other.comentario4 != null)
				return false;
		} else if ( !comentario4.equals(other.comentario4)) 
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}

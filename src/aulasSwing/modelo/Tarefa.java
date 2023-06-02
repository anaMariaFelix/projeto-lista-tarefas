package aulasSwing.modelo;

import java.util.Date;

public class Tarefa {

	private long id;
	private String titulo;
	private String descricao;
	private Date prazo;
	private String tipo;
	private boolean secreto;
	private String senha;
	
	public Tarefa() {
		id = System.currentTimeMillis();
	}
	
	public Tarefa(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	public String toString() {
		return titulo +" (" + tipo + "): " + descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isSecreto() {
		return secreto;
	}

	public void setSecreto(boolean secreto) {
		this.secreto = secreto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}
	
	
}


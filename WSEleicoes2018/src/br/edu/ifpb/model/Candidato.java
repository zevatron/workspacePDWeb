package br.edu.ifpb.model;

public class Candidato {
	
	private int numero;
	private String nome;
	private int votos;
	
	
	
	public Candidato(int numero, String nome) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.votos = 0;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	

}

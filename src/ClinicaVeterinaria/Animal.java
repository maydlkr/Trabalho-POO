package ClinicaVeterinaria;

import java.io.Serializable;

public abstract class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	private   String nome;
	private   int idade;
	private   String dono;
	protected String especie;
	
	public Animal(String nome, int idade, String dono) {
		this.nome = nome;
		this.idade = idade;
		this.dono = dono;
	}
	public String toString() {
		String retorno = "";
		retorno += "Nome: "     + this.nome     + "\n";
		retorno += "Idade: "    + this.idade    + " anos\n";
		retorno += "Dono: "     + this.dono     + "\n";
		retorno += "Especie: "  + this.especie  + "\n";
		retorno += "Alimentação: "  + alimentacao() + "\n";
                retorno += "Cuidados Próprios: "  + cuidadosProprios() + "\n";
		return retorno;
	}
	public abstract String alimentacao();
        public abstract String cuidadosProprios();
}

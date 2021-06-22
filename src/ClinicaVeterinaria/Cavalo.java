
package ClinicaVeterinaria;

public class Cavalo extends Animal {

	private static final long serialVersionUID = 1L;

	public String alimentacao() {
		return "Ração, aveia e alfafa";
	}
        public String cuidadosProprios() {
		return "Corrida, trote e limpeza de cascos";
	}
        
	public Cavalo(String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "Cavalo";
	}
}

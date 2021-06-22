
package ClinicaVeterinaria;

public class Gato extends Animal {

	private static final long serialVersionUID = 1L;

	public String alimentacao() {
		return "Ração e petiscos";
	}
        public String cuidadosProprios() {
		return "Banho, arranhadores e caixa de areia";
	}
        
	public Gato(String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "Gato";
	}
}
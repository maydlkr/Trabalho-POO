
package ClinicaVeterinaria;

public class Passaro extends Animal {

	private static final long serialVersionUID = 1L;

	public String alimentacao() {
		return "Alpiste e frutas";
	}
    
	public String cuidadosProprios() {
		return "Abrigo e est�mulos";
	}
        
	public Passaro (String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "P�ssaro";
	}
}

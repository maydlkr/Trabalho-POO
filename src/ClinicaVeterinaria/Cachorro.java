
package ClinicaVeterinaria;

public class Cachorro extends Animal {

	private static final long serialVersionUID = 1L;

	public String alimentacao() {
		return "Ra��o e carne";
	}
    
	public String cuidadosProprios() {
		return "Banho, tosa e passeio";
	}
        
	public Cachorro(String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "Cachorro";
	}
}

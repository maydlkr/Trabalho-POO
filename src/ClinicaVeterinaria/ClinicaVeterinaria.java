package ClinicaVeterinaria;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClinicaVeterinaria {
	private ArrayList<Animal> animais;

	public ClinicaVeterinaria() {
		this.animais = new ArrayList<Animal>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public Cachorro leCachorro (){

		String [] valores = new String [3];
		String [] nomeVal = {"Nome", "Idade", "Dono"};
		valores = leValores (nomeVal);

		int idade = this.retornaInteiro(valores[1]);

		Cachorro cachorro = new Cachorro (valores[0],idade,valores[2]);
		return cachorro;
	}

	public Gato leGato (){

		String [] valores = new String [3];
		String [] nomeVal = {"Nome", "Idade", "Dono"};
		valores = leValores (nomeVal);

		int idade = this.retornaInteiro(valores[1]);

		Gato gato = new Gato (valores[0],idade,valores[2]);
		return gato;
	}
        
        public Cavalo leCavalo (){

		String [] valores = new String [3];
		String [] nomeVal = {"Nome", "Idade", "Dono"};
		valores = leValores (nomeVal);

		int idade = this.retornaInteiro(valores[1]);

		Cavalo cavalo = new Cavalo (valores[0],idade,valores[2]);
		return cavalo;
	}
        
        public Passaro lePassaro (){

		String [] valores = new String [3];
		String [] nomeVal = {"Nome", "Idade", "Dono"};
		valores = leValores (nomeVal);

		int idade = this.retornaInteiro(valores[1]);

		Passaro passaro = new Passaro (valores[0],idade,valores[2]);
		return passaro;
	}

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // Método estático, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // Não conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	public int retornaInteiro(String entrada) { // retorna um valor inteiro
		int numInt;

		//Enquanto não for possível converter o valor de entrada para inteiro, permanece no loop
		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro.");
		}
		return Integer.parseInt(entrada);
	}

	public void salvaAnimais (ArrayList<Animal> animais){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("c:\\temp\\clinicaVeterinaria.dados"));
			for (int i=0; i < animais.size(); i++)
				outputStream.writeObject(animais.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Animal> recuperaAnimais (){
		ArrayList<Animal> animaisTemp = new ArrayList<Animal>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("c:\\temp\\petStore.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Animal) {
					animaisTemp.add((Animal) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com animais NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return animaisTemp;
		}
	}

	public void menuClinicaVeterinaria (){

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle Clínica Veterinária\n" +
					"Opções:\n" + 
					"1. Entrar Animais\n" +
					"2. Exibir Animais\n" +
					"3. Limpar Animais\n" +
					"4. Gravar Animais\n" +
					"5. Recuperar Animais\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de Animais\n" +
						"Opções:\n" + 
						"1. Cachorro\n" +
						"2. Gato\n" +
                                                "3. Cavalo\n" +
                                                "4. Pássaro\n";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: animais.add((Animal)leCachorro());
				break;
				case 2: animais.add((Animal)leGato());
				break;
                                case 3: animais.add((Animal)leCavalo());
				break;
                                case 4: animais.add((Animal)lePassaro());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Animal para entrada NÃO escolhido!");
				}

				break;
			case 2: // Exibir dados
				if (animais.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com animais primeiramente");
					break;
				}
				String dados = "";
				for (int i=0; i < animais.size(); i++)	{
					dados += animais.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (animais.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com animais primeiramente");
					break;
				}
				animais.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (animais.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com animais primeiramente");
					break;
				}
				salvaAnimais(animais);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5: // Recupera Dados
				animais = recuperaAnimais();
				if (animais.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo Clínica Veterinária");
				break;
			}
		} while (opc1 != 9);
	}


	public static void main (String [] args){

		ClinicaVeterinaria bicho = new ClinicaVeterinaria ();
		bicho.menuClinicaVeterinaria();

	}

}

package view;

import java.io.IOException;

import controller.FifaController;
import controller.IFifaController;
import model.Lista;
import model.Pilha;

public class Principal {

	public static void main(String[] args) {
		Pilha<String> pilha = new Pilha<>();
		Lista<String> lista = new Lista<>();
		IFifaController cont = new FifaController();
		
		String path = "C:\\TEMP";
		String nome = "data.csv";
		
		try {
			pilha = cont.empilhaBrasileiros(path, nome);
			cont.desmpilhaBonsBrasileiros(pilha);
			lista = cont.listaRevelacoes(path, nome);
			cont.buscaListaBonsJovens(lista);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}

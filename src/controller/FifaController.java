package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Lista;
import model.Pilha;
public class FifaController implements IFifaController{
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		Pilha<String> pilha = new Pilha<>();
		File arq = new File(caminho, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while(linha != null) {
				String[] jogador = linha.split(",");
				if(jogador[5].contains("Brazil")) {
					pilha.push(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido!");
		}
		System.out.println("Jogadores Brasileiros empilhados.\n");
		return pilha;
	}
	@Override
	public void desmpilhaBonsBrasileiros(Pilha<String> pilha) throws IOException {
		System.out.println("Jogadores Brasieliros:\n");
		while(!pilha.isEmpty()) {
			String jogador = pilha.pop();
			String[] inf = jogador.split(",");
			int overall = Integer.parseInt(inf[7]);
			if(overall > 80) {
				System.out.println("Nome: "+inf[2] +", Overall: "+ inf[7]);
			}
		}
	}
	@Override
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException {
		Lista<String> lista = new Lista<>();
		File arq = new File(caminho, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while(linha != null) {
				String[] jogador = linha.split(",");
				int idade = Integer.parseInt(jogador[3]);
				if(idade <= 20) {
					lista.addLast(linha); 
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido!");
		}
		System.out.println("\nJogadores listados com idade <= 20 anos.\n");
		return lista;
	}
	@Override
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException {
		System.out.println("Jogadores com Overall > 80 e idade <= 20 anos:\n");
		for(int i = lista.size() - 1; i >= 0; i--){
			String linha = lista.get(i);
			String[] jogador = linha.split(",");
			int overall = Integer.parseInt(jogador[7]);
			int idade = Integer.parseInt(jogador[3]);
			if(overall > 80 && idade <= 20) {
				System.out.println("Nome: "+jogador[2] + ", Idade: "+jogador[3]+" anos, Overall: "+ jogador[7]);
			}
		}
	}
}

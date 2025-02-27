package dicionario;

public class Main {

	public static void main(String[] args) {
	       Dicionario dicionario = new Dicionario();
	       dicionario.inserir("chave1", 10);
	       dicionario.inserir("chave2", 20);
	       dicionario.imprimirEstado();
	       dicionario.remover("chave1");
	       dicionario.imprimirEstado();
	}
}

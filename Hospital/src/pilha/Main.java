package pilha;

public class Main {
	public static void main(String[] args) {
	     Pilha pilha = new Pilha();
	     pilha.inserir(10);
	     pilha.inserir(20);
	     pilha.inserir(30);
	     pilha.imprimirEstado();
	     pilha.remover();
	     pilha.imprimirEstado();
	     pilha.remover();
	     pilha.remover();
	     pilha.imprimirEstado();
	     pilha.remover();
	}
}

package listaPrioridade;

public class Main {

	public static void main(String[] args) {
        ListaPrioridade lista = new ListaPrioridade(10);
        lista.inserir(30);
        lista.inserir(10);
        lista.inserir(20);
        lista.imprimirEstado();
        lista.remover();
        lista.imprimirEstado(); 
	}

}

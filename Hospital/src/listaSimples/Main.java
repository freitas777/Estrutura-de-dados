package listaSimples;

public class Main {
	public static void main(String[] args) {
        Lista lista = new Lista();
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.imprimirEstado();
        lista.remover(20);
        lista.imprimirEstado();
        lista.remover(10);
        lista.imprimirEstado();
        lista.remover(30);
        lista.imprimirEstado(); 
    }
}

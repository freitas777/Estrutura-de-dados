package listaSimplesAprimorada;

public class Main {

	public static void main(String[] args) {
	     ListaPrioridade lista = new ListaPrioridade();
	     lista.inserir(new Paciente("João", 3));
	     lista.inserir(new Paciente("Maria", 1)); 
	     lista.inserir(new Paciente("Pedro", 5)); 
	     lista.inserir(new Paciente("Ana", 2));
	     lista.imprimirEstado();
	     System.out.println("\nPercorrendo a lista com Iterator:");
	     Iterator iterador = lista.iterator();
	     while (iterador.hasNext()) {
	         System.out.println(iterador.next());
	     }
	}
}

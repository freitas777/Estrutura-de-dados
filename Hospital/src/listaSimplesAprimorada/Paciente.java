package listaSimplesAprimorada;

//Definição da classe Paciente
class Paciente {
 String nome;
 int urgencia; // Nível de urgência (1 = mais urgente, 5 = menos urgente)

 // Construtor
 Paciente(String nome, int urgencia) {
     this.nome = nome;
     this.urgencia = urgencia;
 }

 @Override
 public String toString() {
     return nome + " (Urgência: " + urgencia + ")";
 }
}

//Definição da classe No para a lista encadeada
class No {
 Paciente paciente; // Dados do paciente
 No proximo; // Referência para o próximo nó

 // Construtor
 No(Paciente paciente) {
     this.paciente = paciente;
     this.proximo = null;
 }
}

//Interface Comparator para comparar dois pacientes
interface Comparator {
 int comparar(Paciente a, Paciente b);
}

//Implementação de um Comparator para ordenar por urgência (do mais urgente ao menos urgente)
class ComparadorUrgencia implements Comparator {
 @Override
 public int comparar(Paciente a, Paciente b) {
     return a.urgencia - b.urgencia; // Ordena do menor (mais urgente) para o maior (menos urgente)
 }
}

//Interface Iterator para percorrer os pacientes
interface Iterator {
 boolean hasNext(); // Verifica se há um próximo paciente
 Paciente next(); // Retorna o próximo paciente
}

//Classe ListaPrioridade para gerenciar pacientes
class ListaPrioridade {
 private No inicio; // Referência para o início da lista

 // Construtor
 public ListaPrioridade() {
     this.inicio = null;
 }

 // Método para inserir um paciente na lista de prioridade
 public void inserir(Paciente paciente) {
     No novoNo = new No(paciente);
     if (inicio == null) {
         inicio = novoNo;
     } else {
         No atual = inicio;
         while (atual.proximo != null) {
             atual = atual.proximo;
         }
         atual.proximo = novoNo;
     }
     ordenar(new ComparadorUrgencia()); // Ordena a lista após inserção
 }

 // Método para ordenar a lista usando um Comparator
 public void ordenar(Comparator comparator) {
     if (inicio == null || inicio.proximo == null) return; // Lista vazia ou com apenas um paciente

     boolean trocou;
     do {
         trocou = false;
         No anterior = null;
         No atual = inicio;
         No proximo = inicio.proximo;

         while (proximo != null) {
             if (comparator.comparar(atual.paciente, proximo.paciente) > 0) {
                 // Troca os pacientes
                 Paciente temp = atual.paciente;
                 atual.paciente = proximo.paciente;
                 proximo.paciente = temp;
                 trocou = true;
             }
             anterior = atual;
             atual = proximo;
             proximo = proximo.proximo;
         }
     } while (trocou);
 }

 // Método para criar um Iterator
 public Iterator iterator() {
     return new IteradorLista();
 }

 // Classe interna para o Iterator
 private class IteradorLista implements Iterator {
     private No atual;

     public IteradorLista() {
         this.atual = inicio;
     }

     @Override
     public boolean hasNext() {
         return atual != null;
     }

     @Override
     public Paciente next() {
         if (!hasNext()) {
             throw new IllegalStateException("Não há próximo paciente.");
         }
         Paciente paciente = atual.paciente;
         atual = atual.proximo;
         return paciente;
     }
 }

 // Método para imprimir o estado atual da lista
 public void imprimirEstado() {
     No atual = inicio;
     System.out.println("Lista de Pacientes:");
     while (atual != null) {
         System.out.println(atual.paciente);
         atual = atual.proximo;
     }
 }
}
package listaSimplesAprimorada;

class Paciente {
 String nome;
 int urgencia;

 Paciente(String nome, int urgencia) {
     this.nome = nome;
     this.urgencia = urgencia;
 }

 @Override
 public String toString() {
     return nome + " (Urgência: " + urgencia + ")";
 }
}

class No {
 Paciente paciente;
 No proximo; 

 No(Paciente paciente) {
     this.paciente = paciente;
     this.proximo = null;
 }
}

interface Comparator {
 int comparar(Paciente a, Paciente b);
}

class ComparadorUrgencia implements Comparator {
 @Override
 public int comparar(Paciente a, Paciente b) {
     return a.urgencia - b.urgencia; 
 }
}

interface Iterator {
 boolean hasNext(); 
 Paciente next(); 
}

class ListaPrioridade {
 private No inicio;

 public ListaPrioridade() {
     this.inicio = null;
 }

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
     ordenar(new ComparadorUrgencia());
 }

 public void ordenar(Comparator comparator) {
     if (inicio == null || inicio.proximo == null) return;

     boolean trocou;
     do {
         trocou = false;
         No anterior = null;
         No atual = inicio;
         No proximo = inicio.proximo;

         while (proximo != null) {
             if (comparator.comparar(atual.paciente, proximo.paciente) > 0) {
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

 public Iterator iterator() {
     return new IteradorLista();
 }

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

 public void imprimirEstado() {
     No atual = inicio;
     System.out.println("Lista de Pacientes:");
     while (atual != null) {
         System.out.println(atual.paciente);
         atual = atual.proximo;
     }
 }
}
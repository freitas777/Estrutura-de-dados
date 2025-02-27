package pilha;

class No {
 int valor; 
 No proximo; 

 No(int valor) {
     this.valor = valor;
     this.proximo = null;
 }
}

class Pilha {
 private No topo;

 public Pilha() {
     this.topo = null; 
 }

 public void inserir(int valor) {
     No novoNo = new No(valor);
     novoNo.proximo = topo;
     topo = novoNo;
 }

 public void remover() {
     if (topo == null) {
         System.out.println("Pilha vazia! Não é possível remover.");
         return;
     }
     topo = topo.proximo;
 }

 public void imprimirEstado() {
     No atual = topo;
     System.out.print("Estado da pilha: ");
     while (atual != null) {
         System.out.print(atual.valor + " -> ");
         atual = atual.proximo;
     }
     System.out.println("null");
 }
}
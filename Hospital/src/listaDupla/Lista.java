package listaDupla;

class NoDuplo {
    int valor;
    NoDuplo anterior;
    NoDuplo proximo;

    NoDuplo(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

class Lista {
    private NoDuplo inicio;
    private NoDuplo fim;

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserir(int valor) {
        NoDuplo novoNo = new NoDuplo(valor);
        if (fim == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public void remover(int valor) {
        NoDuplo atual = inicio;
        while (atual != null && atual.valor != valor) {
            atual = atual.proximo;
        }

        if (atual == null) return;

        if (atual.anterior != null) {
            atual.anterior.proximo = atual.proximo;
        } else {
            inicio = atual.proximo;
        }

        if (atual.proximo != null) {
            atual.proximo.anterior = atual.anterior;
        } else {
            fim = atual.anterior;
        }
    }

    public void imprimirEstado() {
        NoDuplo atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " <-> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}
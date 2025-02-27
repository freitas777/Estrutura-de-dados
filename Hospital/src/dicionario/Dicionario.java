package dicionario;

class ParChaveValor {
    String chave;
    int valor;
    ParChaveValor proximo;

    ParChaveValor(String chave, int valor) {
        this.chave = chave;
        this.valor = valor;
        this.proximo = null;
    }
}

class Dicionario {
    private ParChaveValor inicio;

    public Dicionario() {
        this.inicio = null;
    }

    public void inserir(String chave, int valor) {
        ParChaveValor atual = inicio;
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                atual.valor = valor;
                return;
            }
            atual = atual.proximo;
        }

        ParChaveValor novoPar = new ParChaveValor(chave, valor);
        novoPar.proximo = inicio;
        inicio = novoPar;
    }

    public void remover(String chave) {
        if (inicio == null) return;

        if (inicio.chave.equals(chave)) {
            inicio = inicio.proximo;
            return;
        }

        ParChaveValor atual = inicio;
        while (atual.proximo != null && !atual.proximo.chave.equals(chave)) {
            atual = atual.proximo;
        }

        if (atual.proximo != null) {
            atual.proximo = atual.proximo.proximo;
        }
    }

    public void imprimirEstado() {
        ParChaveValor atual = inicio;
        while (atual != null) {
            System.out.println(atual.chave + ": " + atual.valor);
            atual = atual.proximo;
        }
    }
}

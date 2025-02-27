package listaPrioridade;

class ListaPrioridade {
    private int[] heap;
    private int tamanho;
    private int capacidade;

    public ListaPrioridade(int capacidade) {
        this.capacidade = capacidade;
        this.heap = new int[capacidade];
        this.tamanho = 0;
    }

    public void inserir(int valor) {
        if (tamanho == capacidade) {
            System.out.println("Lista de prioridade cheia!");
            return;
        }

        heap[tamanho] = valor;
        int atual = tamanho;
        tamanho++;

        while (atual > 0 && heap[atual] < heap[(atual - 1) / 2]) {
            int temp = heap[atual];
            heap[atual] = heap[(atual - 1) / 2];
            heap[(atual - 1) / 2] = temp;
            atual = (atual - 1) / 2;
        }
    }

    public void remover() {
        if (tamanho == 0) return;

        heap[0] = heap[tamanho - 1];
        tamanho--;
        int atual = 0;

        while (true) {
            int filhoEsquerdo = 2 * atual + 1;
            int filhoDireito = 2 * atual + 2;
            int menor = atual;

            if (filhoEsquerdo < tamanho && heap[filhoEsquerdo] < heap[menor]) {
                menor = filhoEsquerdo;
            }

            if (filhoDireito < tamanho && heap[filhoDireito] < heap[menor]) {
                menor = filhoDireito;
            }

            if (menor == atual) break;

            int temp = heap[atual];
            heap[atual] = heap[menor];
            heap[menor] = temp;
            atual = menor;
        }
    }

    public void imprimirEstado() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
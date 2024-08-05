package EstruturaDados;

class NoFila {
    int dado;
    NoFila proximo;

    NoFila(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class FilaComEncadeamento {
    private NoFila frente;
    private NoFila traseira;
    private int tamanho;

    public FilaComEncadeamento() {
        this.frente = null;
        this.traseira = null;
        this.tamanho = 0;
    }

    // Método para adicionar um elemento à fila (enqueue)
    public void enqueue(int item) {
        NoFila novoNo = new NoFila(item);
        if (traseira != null) {
            traseira.proximo = novoNo;
        }
        traseira = novoNo;
        if (frente == null) {
            frente = traseira;
        }
        tamanho++;
    }

    // Método para remover e retornar o elemento da frente da fila (dequeue)
    public int dequeue() {
        if (frente == null) {
            throw new IllegalStateException("Queue underflow");
        }
        int item = frente.dado;
        frente = frente.proximo;
        if (frente == null) {
            traseira = null;
        }
        tamanho--;
        return item;
    }

    // Método para retornar o elemento da frente da fila sem removê-lo (peek)
    public int peek() {
        if (frente == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return frente.dado;
    }

    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
        return frente == null;
    }

    // Método para retornar o tamanho da fila
    public int size() {
        return tamanho;
    }

    // Método principal para testar a fila encadeada
    public static void main(String[] args) {
        FilaComEncadeamento fila = new FilaComEncadeamento();

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        System.out.println("Elemento da frente da fila: " + fila.peek()); // Deve imprimir 1
        System.out.println("Removido da fila: " + fila.dequeue()); // Deve imprimir 1
        System.out.println("Elemento da frente da fila após remoção: " + fila.peek()); // Deve imprimir 2

        System.out.println("Tamanho da fila: " + fila.size()); // Deve imprimir 2
        System.out.println("A fila está vazia? " + fila.isEmpty()); // Deve imprimir false

        fila.dequeue();
        fila.dequeue();

        System.out.println("A fila está vazia após remover todos os elementos? " + fila.isEmpty()); // Deve imprimir true
    }
}


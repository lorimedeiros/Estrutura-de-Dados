package EstruturaDados;

public class FilaComVetor {
    private int capacidade; //capacidade maxima
    private int[] itens; //armazenamento de elementos
    private int frente; //cabeça
    private int traseira; //calda
    private int tamanho; //elementos na fila

    public FilaComVetor(int capacidade) {
        this.capacidade = capacidade;
        this.itens = new int[capacidade];
        this.frente = 0;
        this.traseira = -1;
        this.tamanho = 0;
    }

    // Método para adicionar um elemento à fila (enqueue)
    public void enqueue(int item) {
        if (tamanho == capacidade) {
            throw new IllegalStateException("Queue overflow");
        }
        traseira = (traseira + 1) % capacidade;
        itens[traseira] = item;
        tamanho++;
    }

    // Método para remover e retornar o elemento da frente da fila (dequeue)
    public int dequeue() {
        if (tamanho == 0) {
            throw new IllegalStateException("Queue underflow");
        }
        int item = itens[frente];
        frente = (frente + 1) % capacidade;
        tamanho--;
        return item;
    }

    // Método para retornar o elemento da frente da fila sem removê-lo (peek)
    public int peek() {
        if (tamanho == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return itens[frente];
    }

    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Método para retornar o tamanho da fila
    public int size() {
        return tamanho;
    }

    // Método principal para testar a fila com vetor
    public static void main(String[] args) {
        FilaComVetor fila = new FilaComVetor(5);

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


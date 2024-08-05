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
        // Verifica se a fila está cheia e precisa de redimensionamento
        if (tamanho == capacidade) {
            redimensionar(capacidade * 2); // Dobra a capacidade do array
        }
        itens[traseira] = item;
        traseira = (traseira + 1) % capacidade; // Atualiza a posição do fim
        tamanho++;
    }

    // Método para remover e retornar o elemento da fila (dequeue)
    public int dequeue() {
        if (tamanho == 0) {
            throw new IllegalStateException("Queue underflow");
        }
        int itemRemovido = itens[frente];
        frente = (frente + 1) % capacidade; // Atualiza a posição do início
        tamanho--;

        // Reduz a capacidade do array se o número de elementos for menor que um quarto da capacidade
        if (tamanho > 0 && tamanho == capacidade / 4) {
            redimensionar(capacidade / 2);
        }

        return itemRemovido;
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

    // Método para redimensionar o array
    private void redimensionar(int novaCapacidade) {
        int[] novosItens = new int[novaCapacidade];
        for (int i = 0; i < tamanho; i++) {
            novosItens[i] = itens[(frente + i) % capacidade];
        }
        itens = novosItens;
        capacidade = novaCapacidade;
        frente = 0;
        traseira = tamanho;
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

    /*
    Descreva a saída resultante da seguinte série de operações sobre uma fila: enfileire(5), enfileire(3),
    desenfileire(), enfileire(2), enfileire(8), desenfileire(), desenfileire(),enfileire(9),
    enfileire(1), desenfileire(), enfileire(7), enfileire(6). desenfileire(), desenfileire().

enfileire(5): Adiciona o elemento 5 à fila.

Fila: [5]
enfileire(3): Adiciona o elemento 3 à fila.

Fila: [5, 3]
desenfileire(): Remove o elemento do início da fila (5).

Fila: [3]
Saída: 5
enfileire(2): Adiciona o elemento 2 à fila.

Fila: [3, 2]
enfileire(8): Adiciona o elemento 8 à fila.

Fila: [3, 2, 8]
desenfileire(): Remove o elemento do início da fila (3).

Fila: [2, 8]
Saída: 3
desenfileire(): Remove o elemento do início da fila (2).

Fila: [8]
Saída: 2
enfileire(9): Adiciona o elemento 9 à fila.

Fila: [8, 9]
enfileire(1): Adiciona o elemento 1 à fila.

Fila: [8, 9, 1]
desenfileire(): Remove o elemento do início da fila (8).

Fila: [9, 1]
Saída: 8
enfileire(7): Adiciona o elemento 7 à fila.

Fila: [9, 1, 7]
enfileire(6): Adiciona o elemento 6 à fila.

Fila: [9, 1, 7, 6]
desenfileire(): Remove o elemento do início da fila (9).

Fila: [1, 7, 6]
Saída: 9
desenfileire(): Remove o elemento do início da fila (1).

Fila: [7, 6]
Saída: 1

    ordem: 5, 3, 2, 8, 9, 1

    */
}
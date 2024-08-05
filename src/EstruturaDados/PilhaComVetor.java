package EstruturaDados;

public class PilhaComVetor {
    private int capacidade;
    private int[] itens;
    private int topo;

    public PilhaComVetor(int capacidade) {
        this.capacidade = capacidade;
        this.itens = new int[capacidade];
        this.topo = -1; // Indica que a pilha está vazia
    }

    // Método para adicionar um elemento à pilha (push)
    public void push(int item) {
        if (topo == capacidade - 1) {
            throw new IllegalStateException("Stack overflow");
        }
        itens[++topo] = item;
    }

    public void push2(int item) {
        // Verifica se a pilha está cheia
        if (topo == capacidade - 1) {
            redimensionar();
        }
        itens[++topo] = item;
    }

    // Método para remover e retornar o elemento do topo da pilha (pop)
    public int pop() {
        if (topo == -1) {
            throw new IllegalStateException("Stack underflow");
        }
        return itens[topo--];
    }

    // Método para remover e retornar o elemento do topo da pilha + redimensionamento (pop)
    public int pop2() {
        if (topo == -1) {
            throw new IllegalStateException("Stack underflow");
        }
        int itemRemovido = itens[topo--];

        // Reduz a capacidade do array se o número de elementos for menor que um quarto da capacidade
        if (topo > 0 && topo == capacidade / 4) {
            redimensionar(capacidade / 2);
        }

        return itemRemovido;
    }

    // Método para retornar o elemento do topo da pilha sem removê-lo (peek)
    public int peek() {
        if (topo == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return itens[topo];
    }

    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Método para retornar o tamanho da pilha
    public int size() {
        return topo + 1;
    }

    // Método para redimensionar o array quando a capacidade é atingida
    private void redimensionar() {
        int novaCapacidade = capacidade * 2;
        int[] novosItens = new int[novaCapacidade];
        System.arraycopy(itens, 0, novosItens, 0, capacidade);
        itens = novosItens;
        capacidade = novaCapacidade;
    }

    // Método para redimensionar o array diminuindo a capacidade
    private void redimensionar(int novaCapacidade) {
        int[] novosItens = new int[novaCapacidade];
        System.arraycopy(itens, 0, novosItens, 0, topo + 1);
        itens = novosItens;
        capacidade = novaCapacidade;
    }

    // Método principal para testar a pilha com vetor
    public static void main(String[] args) {
        PilhaComVetor pilha = new PilhaComVetor(5);

        pilha.push(1);
        pilha.push(2);
        pilha.push(3);

        System.out.println("Topo da pilha: " + pilha.peek()); // Deve imprimir 3
        System.out.println("Removido da pilha: " + pilha.pop()); // Deve imprimir 3
        System.out.println("Topo da pilha após remoção: " + pilha.peek()); // Deve imprimir 2

        System.out.println("Tamanho da pilha: " + pilha.size()); // Deve imprimir 2
        System.out.println("A pilha está vazia? " + pilha.isEmpty()); // Deve imprimir false

        pilha.pop();
        pilha.pop();

        System.out.println("A pilha está vazia após remover todos os elementos? " + pilha.isEmpty()); // Deve imprimir true
    }
}


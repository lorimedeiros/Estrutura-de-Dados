package EstruturaDados;

// Classe No
class No {
    int dado;
    No proximo;

    No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

// Classe PilhaEncadeada
public class PilhaComEncadeamento {
    private No topo;

    public PilhaComEncadeamento() {
        this.topo = null;
    }

    // Método para adicionar um elemento à pilha (push)
    public void push(int item) {
        No novoNo = new No(item);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    // Método para remover e retornar o elemento do topo da pilha (pop)
    public int pop() {
        if (topo == null) {
            throw new IllegalStateException("Stack underflow");
        }
        int item = topo.dado;
        topo = topo.proximo;
        return item;
    }

    // Método para retornar o elemento do topo da pilha sem removê-lo (peek)
    public int peek() {
        if (topo == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return topo.dado;
    }

    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == null;
    }

    // Método para retornar o tamanho da pilha
    public int size() {
        int tamanho = 0;
        No atual = topo;
        while (atual != null) {
            tamanho++;
            atual = atual.proximo;
        }
        return tamanho;
    }

    // Método principal para testar a pilha encadeada
    public static void main(String[] args) {
        PilhaComEncadeamento pilha = new PilhaComEncadeamento();

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

package EstruturaDados.LinkedList;

// Classe para representar um nó da lista duplamente encadeada circular
class NodeDoublyCircular {
    int valor;
    NodeDoublyCircular proximo;
    NodeDoublyCircular anterior;

    NodeDoublyCircular(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}

// Classe para representar a lista duplamente encadeada circular
class CircularDoublyLinkedList {
    NodeDoublyCircular cabeca;

    CircularDoublyLinkedList() {
        this.cabeca = null;
    }

    // Método para inserir um novo elemento no fim da lista
    void inserirNoFim(int valor) {
        NodeDoublyCircular novoNo = new NodeDoublyCircular(valor);

        if (cabeca == null) {
            cabeca = novoNo;
            cabeca.proximo = cabeca;
            cabeca.anterior = cabeca;
        } else {
            NodeDoublyCircular ultimo = cabeca.anterior;

            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
        }
    }

    // Método para imprimir a lista (opcional, para verificação)
    void imprimirLista() {
        if (cabeca == null) {
            System.out.println("Lista está vazia.");
            return;
        }
        NodeDoublyCircular temp = cabeca;
        do {
            System.out.print(temp.valor + " ");
            temp = temp.proximo;
        } while (temp != cabeca);
        System.out.println();
    }

    // Método para procurar um valor na lista
    boolean procurarNaLista(int valor) {
        if (cabeca == null) return false;

        NodeDoublyCircular temp = cabeca;
        do {
            if (temp.valor == valor) {
                return true;
            }
            temp = temp.proximo;
        } while (temp != cabeca);
        return false;
    }

    // Método para procurar e remover um valor na lista
    boolean procurarERemoverNaLista(int valor) {
        if (cabeca == null) return false;

        NodeDoublyCircular atual = cabeca;

        do {
            if (atual.valor == valor) {
                // Atualizando os ponteiros
                if (atual == cabeca && cabeca.proximo == cabeca) {
                    cabeca = null;
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;

                    if (atual == cabeca) {
                        cabeca = atual.proximo;
                    }
                }
                return true; // Valor removido
            }
            atual = atual.proximo;
        } while (atual != cabeca);

        return false; // Valor não encontrado
    }
}

package EstruturaDados.LinkedList;

// Classe para representar um nó da lista simplesmente encadeada circular
class NodeCircular {
    int valor;
    NodeCircular proximo;

    NodeCircular(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

// Classe para representar a lista simplesmente encadeada circular
class CircularSinglyLinkedList {
    NodeCircular cabeca;

    CircularSinglyLinkedList() {
        this.cabeca = null;
    }

    // Método para inserir um novo elemento no fim da lista
    void inserirNoFim(int valor) {
        NodeCircular novoNo = new NodeCircular(valor);

        if (cabeca == null) {
            cabeca = novoNo;
            cabeca.proximo = cabeca; // A lista aponta para si mesma
        } else {
            NodeCircular temp = cabeca;
            while (temp.proximo != cabeca) {
                temp = temp.proximo;
            }
            temp.proximo = novoNo;
            novoNo.proximo = cabeca;
        }
    }

    // Método para imprimir a lista (opcional, para verificação)
    void imprimirLista() {
        if (cabeca == null) {
            System.out.println("Lista está vazia.");
            return;
        }
        NodeCircular temp = cabeca;
        do {
            System.out.print(temp.valor + " ");
            temp = temp.proximo;
        } while (temp != cabeca);
        System.out.println();
    }

    // Método para procurar um valor na lista
    boolean procurarNaLista(int valor) {
        if (cabeca == null) return false;

        NodeCircular temp = cabeca;
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

        NodeCircular atual = cabeca, anterior = null;

        // Se o nó a ser removido é a cabeça
        if (cabeca.valor == valor) {
            if (cabeca.proximo == cabeca) {
                cabeca = null;
            } else {
                NodeCircular temp = cabeca;
                while (temp.proximo != cabeca) {
                    temp = temp.proximo;
                }
                temp.proximo = cabeca.proximo;
                cabeca = cabeca.proximo;
            }
            return true;
        }

        // Procurando pelo nó
        do {
            anterior = atual;
            atual = atual.proximo;
            if (atual.valor == valor) {
                anterior.proximo = atual.proximo;
                return true;
            }
        } while (atual != cabeca);

        return false; // Valor não encontrado
    }
}

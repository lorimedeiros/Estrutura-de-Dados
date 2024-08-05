package EstruturaDados.LinkedList;

// Classe para representar um nó da lista duplamente encadeada
class NodeDLL {
    int valor;
    NodeDLL proximo;
    NodeDLL anterior;

    NodeDLL(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}

// Classe para representar a lista duplamente encadeada
class DoublyLinkedList {
    NodeDLL cabeca;
    NodeDLL cauda;

    DoublyLinkedList() {
        this.cabeca = null;
        this.cauda = null;
    }

    // Método para inserir um novo elemento no início da lista
    void inserirNoInicio(int valor) {
        // Criar um novo nó
        NodeDLL novoNo = new NodeDLL(valor);

        // O novo nó vai ser o início da lista
        novoNo.proximo = cabeca;
        novoNo.anterior = null;

        // Se a lista não estiver vazia, atualizar o anterior do antigo início
        if (cabeca != null) {
            cabeca.anterior = novoNo;
        }

        // Atualizar a cabeça da lista para o novo nó
        cabeca = novoNo;

        // Se a lista estava vazia, o novo nó é também a cauda
        if (cauda == null) {
            cauda = novoNo;
        }
    }

    // Método para procurar um valor na lista
    boolean procurarNaLista(int valor) {
        NodeDLL atual = cabeca;

        while (atual != null) {
            if (atual.valor == valor) {
                return true; // Valor encontrado
            }
            atual = atual.proximo; // Move para o próximo nó
        }

        return false; // Valor não encontrado
    }

    // Método para procurar e remover um valor na lista
    boolean procurarERemoverNaLista(int valor) {
        NodeDLL atual = cabeca;

        while (atual != null) {
            if (atual.valor == valor) {
                // Valor encontrado, removê-lo da lista

                // Atualiza o próximo nó do nó anterior
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    // Se não há nó anterior, atualiza a cabeça
                    cabeca = atual.proximo;
                }

                // Atualiza o anterior do próximo nó
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    // Se não há próximo nó, atualiza a cauda
                    cauda = atual.anterior;
                }

                return true; // Valor removido
            }
            atual = atual.proximo; // Move para o próximo nó
        }

        return false; // Valor não encontrado
    }

    // Método para imprimir a lista do início para o fim (opcional)
    void imprimirLista() {
        NodeDLL atual = cabeca;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

// Exemplo de uso
class MainDLL {
    public static void main(String[] args) {
        DoublyLinkedList lista = new DoublyLinkedList();

        lista.inserirNoInicio(10);
        lista.inserirNoInicio(20);
        lista.inserirNoInicio(30);

        // Esperado: 30 20 10
        lista.imprimirLista();
    }
}


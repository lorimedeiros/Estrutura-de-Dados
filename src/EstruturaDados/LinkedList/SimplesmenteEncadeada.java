package EstruturaDados.LinkedList;

// Classe para representar um nó da lista encadeada
class Node {
    int valor;
    Node proximo;

    Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

// Classe para representar a lista encadeada
class LinkedList {
    Node cabeca;
    Node cauda;
    LinkedList() {
        this.cabeca = null;
        this.cauda = null;
    }

    // Método para inserir um novo elemento no início da lista
    void inserirNoInicio(int valor) {
        Node novoNo = new Node(valor);
        novoNo.proximo = cabeca; // O próximo do novo nó é a cabeça atual
        cabeca = novoNo;         // Atualiza a cabeça da lista

        if (cauda == null) {
            cauda = novoNo; // Se a lista estava vazia, a cauda também deve ser atualizada
        }
    }

    // Método para inserir um novo elemento no fim da lista
    void inserirNoFim(int valor) {
        Node novoNo = new Node(valor);

        if (cauda != null) {
            cauda.proximo = novoNo; // O próximo do nó atual da cauda é o novo nó
        }
        cauda = novoNo; // Atualiza a cauda da lista

        if (cabeca == null) {
            cabeca = novoNo; // Se a lista estava vazia, a cabeça deve ser atualizada
        }
    }

    // Método para procurar e remover um valor na lista
    boolean procurarERemoverNaLista(int valor) {
        Node anterior = null;
        Node atual = cabeca;

        while (atual != null) {
            if (atual.valor == valor) {
                // Valor encontrado, removê-lo da lista
                if (anterior != null) {
                    // Não é o primeiro nó
                    anterior.proximo = atual.proximo;
                } else {
                    // É o primeiro nó
                    cabeca = atual.proximo;
                }
                return true; // Valor removido
            }
            // Atualizar as variáveis auxiliares
            anterior = atual;
            atual = atual.proximo;
        }

        return false; // Valor não encontrado
    }

    // Método para procurar um valor na lista
    boolean procurarNaLista(int valor) {
        Node atual = cabeca;

        while (atual != null) {
            if (atual.valor == valor) {
                return true; // Valor encontrado
            }
            atual = atual.proximo; // Move para o próximo nó
        }

        return false; // Valor não encontrado
    }

    // Método para imprimir a lista (opcional, para verificação)
    void imprimirLista() {
        Node atual = cabeca;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

// Exemplo de uso
class Main {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();

        lista.inserirNoInicio(10);
        lista.inserirNoInicio(20);
        lista.inserirNoInicio(30);

        // Verifica se o valor 20 está na lista
        if (lista.procurarNaLista(20)) {
            System.out.println("Valor 20 encontrado na lista.");
        } else {
            System.out.println("Valor 20 não encontrado na lista.");
        }

        // Remove o valor 20
        if (lista.procurarERemoverNaLista(20)) {
            System.out.println("Valor 20 removido da lista.");
        } else {
            System.out.println("Valor 20 não encontrado na lista.");
        }

        // Esperado: 30 20 10
        lista.imprimirLista();
    }
}


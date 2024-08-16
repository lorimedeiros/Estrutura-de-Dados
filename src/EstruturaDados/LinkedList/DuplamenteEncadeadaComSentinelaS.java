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

// Classe para representar a lista duplamente encadeada com sentinelas
class DoublyLinkedListWithSentinels {
    NodeDLL sentinelaInicio;
    NodeDLL sentinelaFim;

    DoublyLinkedListWithSentinels() {
        // Inicializando os sentinelas
        sentinelaInicio = new NodeDLL(0); // O valor dos sentinelas é irrelevante
        sentinelaFim = new NodeDLL(0);
        
        // Conectando os sentinelas entre si
        sentinelaInicio.proximo = sentinelaFim;
        sentinelaFim.anterior = sentinelaInicio;
    }

    // Método para inserir um novo elemento no início da lista
    void inserirNoInicio(int valor) {
        NodeDLL novoNo = new NodeDLL(valor);
        
        // Ajustando os ponteiros para inserir o novo nó após o sentinela de início
        novoNo.proximo = sentinelaInicio.proximo;
        novoNo.anterior = sentinelaInicio;
        sentinelaInicio.proximo.anterior = novoNo;
        sentinelaInicio.proximo = novoNo;
    }

    // Método para inserir um novo elemento no fim da lista
    void inserirNoFim(int valor) {
        NodeDLL novoNo = new NodeDLL(valor);
        
        // Ajustando os ponteiros para inserir o novo nó antes do sentinela de fim
        novoNo.proximo = sentinelaFim;
        novoNo.anterior = sentinelaFim.anterior;
        sentinelaFim.anterior.proximo = novoNo;
        sentinelaFim.anterior = novoNo;
    }

    // Método para procurar um valor na lista
    boolean procurarNaLista(int valor) {
        NodeDLL atual = sentinelaInicio.proximo;

        while (atual != sentinelaFim) {
            if (atual.valor == valor) {
                return true; // Valor encontrado
            }
            atual = atual.proximo;
        }

        return false; // Valor não encontrado
    }

    // Método para procurar e remover um valor na lista
    boolean procurarERemoverNaLista(int valor) {
        NodeDLL atual = sentinelaInicio.proximo;

        while (atual != sentinelaFim) {
            if (atual.valor == valor) {
                // Remover o nó
                atual.anterior.proximo = atual.proximo;
                atual.proximo.anterior = atual.anterior;
                return true; // Valor encontrado e removido
            }
            atual = atual.proximo;
        }

        return false; // Valor não encontrado
    }

    // Método para imprimir a lista do início ao fim (opcional)
    void imprimirLista() {
        NodeDLL atual = sentinelaInicio.proximo;
        while (atual != sentinelaFim) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    // Método para imprimir a lista do fim ao início (opcional)
    void imprimirListaInversa() {
        NodeDLL atual = sentinelaFim.anterior;
        while (atual != sentinelaInicio) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }
}

// Exemplo de uso
class MainDLL {
    public static void main(String[] args) {
        DoublyLinkedListWithSentinels lista = new DoublyLinkedListWithSentinels();

        lista.inserirNoInicio(10);
        lista.inserirNoInicio(20);
        lista.inserirNoFim(30);

        lista.imprimirLista(); // Esperado: 20 10 30
        lista.imprimirListaInversa(); // Esperado: 30 10 20
    }
}

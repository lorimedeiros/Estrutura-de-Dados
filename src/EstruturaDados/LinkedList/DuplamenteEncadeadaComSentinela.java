package EstruturaDados.LinkedList;

class NodeCS {
    int valor;
    NodeCS proximo;
    NodeCS anterior;

    NodeCS(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}

class ListaDuplamenteEncadeadaComSentinela {
    NodeCS sentinelaInicio;

    ListaDuplamenteEncadeadaComSentinela() {
        // Inicializa a sentinela
        sentinelaInicio = new NodeCS(0); // Valor 0 é um placeholder
        sentinelaInicio.proximo = null;
        sentinelaInicio.anterior = null;
    }

    // Inserir no início (antes do primeiro nó real)
    void inserirNoInicio(int valor) {
        NodeCS novoNo = new NodeCS(valor);
        // Inserir o novo nó entre a sentinela e o primeiro nó real
        novoNo.proximo = sentinelaInicio.proximo;
        novoNo.anterior = sentinelaInicio;
        if (sentinelaInicio.proximo != null) {
            sentinelaInicio.proximo.anterior = novoNo;
        }
        sentinelaInicio.proximo = novoNo;
    }

    NodeCS procurar(int valor) {
        NodeCS atual = sentinelaInicio.proximo; // Começa após a sentinela
        while (atual != null) {
            if (atual.valor == valor) {
                return atual; // Valor encontrado
            }
            atual = atual.proximo; // Avança para o próximo nó
        }
        return null; // Valor não encontrado
    }

    // Procurar e remover um dado da lista
    boolean procurarERemover(int valor) {
        NodeCS atual = sentinelaInicio.proximo; // Começa após a sentinela
        while (atual != null) {
            if (atual.valor == valor) {
                // Remover o nó
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                }
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                }
                // Se o nó removido é o primeiro nó real
                if (atual == sentinelaInicio.proximo) {
                    sentinelaInicio.proximo = atual.proximo;
                }
                // Liberar o nó removido (não é necessário em Java, mas ilustrativo)
                atual = null;
                return true; // Valor encontrado e removido
            }
            atual = atual.proximo; // Avança para o próximo nó
        }
        return false; // Valor não encontrado
    }

    // Procurar e mover um dado para o início da lista
    boolean procurarEMoverParaInicio(int valor) {
        NodeCS atual = sentinelaInicio.proximo; // Começa após a sentinela
        while (atual != null) {
            if (atual.valor == valor) {
                // Remover o nó
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                }
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                }
                // Se o nó removido é o primeiro nó real
                if (atual == sentinelaInicio.proximo) {
                    sentinelaInicio.proximo = atual.proximo;
                }

                // Inserir o nó no início
                atual.proximo = sentinelaInicio.proximo;
                atual.anterior = sentinelaInicio;
                if (sentinelaInicio.proximo != null) {
                    sentinelaInicio.proximo.anterior = atual;
                }
                sentinelaInicio.proximo = atual;

                return true; // Valor encontrado e movido
            }
            atual = atual.proximo; // Avança para o próximo nó
        }
        return false; // Valor não encontrado
    }

    // Imprimir a lista
    void imprimirLista() {
        NodeCS atual = sentinelaInicio.proximo;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

// Exemplo de uso
class MainCS {
    public static void main(String[] args) {
        ListaDuplamenteEncadeadaComSentinela lista = new ListaDuplamenteEncadeadaComSentinela();

        lista.inserirNoInicio(10);
        lista.inserirNoInicio(20);
        lista.inserirNoInicio(30);

        lista.imprimirLista(); // Esperado: 30 20 10
    }
}


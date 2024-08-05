package EstruturaDados.LinkedList;

class NodeC {
    int valor;
    NodeC proximo;

    NodeC(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class ListaEncadeadaCircular {
    NodeC cabeca; // Referência para o primeiro nó da lista
    NodeC cauda;  // Referência para o último nó da lista

    ListaEncadeadaCircular() {
        cabeca = null;
        cauda = null;
    }

    // Inserir no início da lista
    void inserirNoInicio(int valor) {
        NodeC novoNo = new NodeC(valor);
        if (cabeca == null) { // Lista vazia
            cabeca = novoNo;
            cauda = novoNo;
            novoNo.proximo = cabeca; // Circularidade
        } else {
            novoNo.proximo = cabeca;
            cabeca = novoNo;
            cauda.proximo = cabeca; // Manter a circularidade
        }
    }

    // Inserir no fim da lista
    void inserirNoFim(int valor) {
        NodeC novoNo = new NodeC(valor);
        if (cabeca == null) { // Lista vazia
            cabeca = novoNo;
            cauda = novoNo;
            novoNo.proximo = cabeca; // Circularidade
        } else {
            cauda.proximo = novoNo;
            cauda = novoNo;
            cauda.proximo = cabeca; // Manter a circularidade
        }
    }

    // Remover um nó da lista
    void remover(int valor) {
        if (cabeca == null) return; // Lista vazia

        NodeC atual = cabeca;
        NodeC anterior = cauda;

        do {
            if (atual.valor == valor) {
                if (atual == cabeca) { // Remover o primeiro nó
                    if (cabeca == cauda) { // Só havia um nó
                        cabeca = null;
                        cauda = null;
                    } else {
                        cabeca = cabeca.proximo;
                        cauda.proximo = cabeca;
                    }
                } else {
                    anterior.proximo = atual.proximo;
                    if (atual == cauda) {
                        cauda = anterior;
                    }
                }
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        } while (atual != cabeca);
    }

    // Imprimir a lista
    void imprimirLista() {
        if (cabeca == null) {
            System.out.println("Lista vazia.");
            return;
        }

        NodeC atual = cabeca;
        do {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        } while (atual != cabeca);
        System.out.println();
    }
}

// Exemplo de uso
class MainC {
    public static void main(String[] args) {
        ListaEncadeadaCircular lista = new ListaEncadeadaCircular();

        lista.inserirNoInicio(10);
        lista.inserirNoFim(20);
        lista.inserirNoFim(30);

        lista.imprimirLista(); // Esperado: 10 20 30

        lista.remover(20);
        lista.imprimirLista(); // Esperado: 10 30
    }
}

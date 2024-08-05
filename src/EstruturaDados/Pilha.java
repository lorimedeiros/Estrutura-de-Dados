package EstruturaDados;

public class Pilha<T> {

    private T[] elementos;
    private int tamanho;

    public Pilha(int capacidade){
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    public int tamanho(){
        return tamanho;
    }

    private void aumentaCapacidade(){
        if(this.tamanho == this.elementos.length){
            T elementosNovos[] = (T[]) new Object[this.elementos.length*2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    } // dobra capacidade quando chegar ao limite

    public boolean adiciona(T elemento){
        aumentaCapacidade();
        if (this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0){
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]");

        return s.toString();
    }

    // Exercício de Wagner
    /*

    Indique a ordem em que os elementos são removidos na seguinte série de operações sobre
    uma pilha: push(3), pop(), push(2), push(8), pop(), pop(), push(9), push(1), pop(),
    push(7), push(6), pop(), pop(), push(4), pop(), pop().

push(3): Adiciona o elemento 3 à pilha.

Pilha: [3]
pop(): Remove o elemento do topo da pilha (3).

Pilha: []
push(2): Adiciona o elemento 2 à pilha.

Pilha: [2]
push(8): Adiciona o elemento 8 à pilha.

Pilha: [2, 8]
pop(): Remove o elemento do topo da pilha (8).

Pilha: [2]
pop(): Remove o elemento do topo da pilha (2).

Pilha: []
push(9): Adiciona o elemento 9 à pilha.

Pilha: [9]
push(1): Adiciona o elemento 1 à pilha.

Pilha: [9, 1]
pop(): Remove o elemento do topo da pilha (1).

Pilha: [9]
push(7): Adiciona o elemento 7 à pilha.

Pilha: [9, 7]
push(6): Adiciona o elemento 6 à pilha.

Pilha: [9, 7, 6]
pop(): Remove o elemento do topo da pilha (6).

Pilha: [9, 7]
pop(): Remove o elemento do topo da pilha (7).

Pilha: [9]
push(4): Adiciona o elemento 4 à pilha.

Pilha: [9, 4]
pop(): Remove o elemento do topo da pilha (4).

Pilha: [9]
pop(): Remove o elemento do topo da pilha (9).

Pilha: []

    a ordem em que os elementos são removidos da pilha é: 3, 8, 2, 1, 6, 7, 4, 9.

    */

}

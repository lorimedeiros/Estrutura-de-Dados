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

}

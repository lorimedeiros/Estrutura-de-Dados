package EstruturaDados;

import java.lang.reflect.Array;

public class Lista<T> {

    private T[] elementos;
    private int tamanho;

    public Lista(int capacidade, Class<T> tipoDaClasse){
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(T elemento){
        aumentaCapacidade();
        if (this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, T elemento){
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição Inválida!");
        }

        aumentaCapacidade();

        //mover os elementos
        for (int i = this.tamanho - 1; i >= posicao; i--){
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;

        return false;
    }

    public void remove(int posicao){
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição Inválida!");
        }

        for (int i = posicao; i < this.tamanho - 1; i++){
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;

    }

    public int tamanho(){
        return this.tamanho;
    }

    public T buscaPosicao(int posicao){
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição inválida!");
        }
        return this.elementos[posicao];
    }

    public int buscaElementoRetornaPosicao(T elemento){
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public boolean buscaElementoRetornaBool(T elemento){
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)){
                return true;
            }
        }
        return false;
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

    //MÉTODOS DE EXERCÍCIOS
    public boolean contem(T elemento){
        return buscaElementoRetornaPosicao(elemento) > -1;
    }

    public int ultimoIndiceDe(T elemento){
        for (int i = this.tamanho; i >= 0; i--){
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public void remove(T elemento){
        int pos = this.buscaElementoRetornaPosicao(elemento);
        if (pos > -1){
            this.remove(pos);
        }
    }

    public T obtem(int pos){
        if(!(pos >= 0 && pos < tamanho)){
            throw new IllegalArgumentException("Podsição inv´lida");
        }
        return this.elementos[pos];
    }

    public void limpar(){
        for (int i = 0; i < this.elementos.length; i++){
            this.elementos[i] = null;
        }
        this.tamanho = 0;
    }

}

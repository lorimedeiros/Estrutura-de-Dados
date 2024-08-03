package EstruturaDados;
import java.util.Arrays;

public class Vetor {
    //PILHA COM VETOR EM WAGNÊS
    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionaVersãoIneficiente(String elemento){
        for(int i = 0; i < elementos.length; i++){
            if (this.elementos[i] == null){ //valor default de string é null
                this.elementos[i] = elemento;
                break; //necessario esse break se não ele vai meter o elemento em tudo que for null
            }
        }
        //"mas pq é ineficiente?" Esse trem vai ter que ficar percorrendo todo o vetor até o topo sempre que precisar adicionar elementos
    }

    public void adicionaVersãoMeiaBomba(String elemento) throws Exception {
        if (this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho += 1;
        } else {
            throw new Exception("Vetor cheio! Impossível adicionar elemento.");
        }
        //usar try-catch pode ser ineficiente
    }

    public boolean adiciona(String elemento){
        aumentaCapacidade();
        if (this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, String elemento){
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

    public String buscaPosicao(int posicao){
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição inválida!");
        }
        return this.elementos[posicao];
    }

    public int buscaElementoRetornaPosicao(String elemento){
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public boolean buscaElementoRetornaBool(String elemento){
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)){
                return true;
            }
        }
        return false;
    }

    private void aumentaCapacidade(){
        if(this.tamanho == this.elementos.length){
            String elementosNovos[] = new String[this.elementos.length*2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    } // dobra capacidade quando chegar ao limite

    public String toStringMeiaBomba(){
        return Arrays.toString(elementos);
    } //vai printar os espaços não preenchidos com null, mas só quereos os elementos

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
    public boolean contem(String elemento){
        return buscaElementoRetornaPosicao(elemento) > -1;
    }

    public int ultimoIndiceDe(String elemento){
        for (int i = this.tamanho; i >= 0; i--){
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public void remove(String elemento){
        int pos = this.buscaElementoRetornaPosicao(elemento);
        if (pos > -1){
            this.remove(pos);
        }
    }

    public String obtem(int pos){
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

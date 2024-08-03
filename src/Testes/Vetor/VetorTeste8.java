package Testes.Vetor;

import EstruturaDados.Vetor;

public class VetorTeste8 {
    public static void main(String[] args) {

        // remoção de elemento
        Vetor vetor = new Vetor(3);

        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("E");
        vetor.adiciona("F");
        vetor.adiciona("G");
        System.out.println(vetor);

        vetor.remove(1);
        System.out.println(vetor);

        vetor.remove(vetor.buscaElementoRetornaPosicao("F"));
        System.out.println(vetor);

        System.out.println(vetor.contem("F"));
        System.out.println(vetor.contem("G"));
        
    }
}

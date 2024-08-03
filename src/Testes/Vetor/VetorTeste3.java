package Testes.Vetor;

import EstruturaDados.Vetor;

public class VetorTeste3 {
    public static void main(String[] args) {

        // tamanho de um vetor + printando elementos
        Vetor vetor = new Vetor(10);

        vetor.adiciona("elemento 1");
        vetor.adiciona("elemento 2");
        vetor.adiciona("elemento 3");

        System.out.println(vetor.tamanho());
        System.out.println(vetor);

    }
}

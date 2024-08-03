package Testes.Vetor;

import EstruturaDados.Vetor;

public class VetorTeste4 {
    public static void main(String[] args) {

        // buscando elemento pela posição
        Vetor vetor = new Vetor(10);

        vetor.adiciona("elemento 1");
        vetor.adiciona("elemento 2");
        vetor.adiciona("elemento 3");

        System.out.println(vetor.buscaPosicao(1));
        System.out.println(vetor.buscaPosicao(3));

    }
}

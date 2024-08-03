package Testes.Vetor;

import EstruturaDados.Vetor;

public class VetorTeste5 {
    public static void main(String[] args) {

        // buscando elemento pelo conteudo
        Vetor vetor = new Vetor(10);

        vetor.adiciona("elemento 1");
        vetor.adiciona("elemento 2");
        vetor.adiciona("elemento 3");

        System.out.println(vetor.buscaElementoRetornaBool("elemento 1"));
        System.out.println(vetor.buscaElementoRetornaBool("elemento 8"));
        System.out.println(vetor.buscaElementoRetornaPosicao("elemento 3"));
        System.out.println(vetor.buscaElementoRetornaPosicao("elemento 8"));

    }
}

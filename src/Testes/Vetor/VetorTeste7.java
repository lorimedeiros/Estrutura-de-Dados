package Testes.Vetor;

import EstruturaDados.Vetor;

public class VetorTeste7 {
    public static void main(String[] args) {

        // adicionando elemento com modificação do aumenta capacidade
        Vetor vetor = new Vetor(3);

        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("E");
        vetor.adiciona("F");
        vetor.adiciona("G");
        System.out.println(vetor);
        
    }
}

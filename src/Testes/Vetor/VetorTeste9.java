package Testes.Vetor;
import EstruturaDados.VetorDeObjetos;
import Testes.Contato;

public class VetorTeste9 {
    public static void main(String[] args) {

        // vetor de obj
        VetorDeObjetos v = new VetorDeObjetos(2);

        v.adiciona(new Contato("Lori", "9999-8888", "lori@leromail.com"));
        v.adiciona(new Contato("Yves", "9999-7777", "yves@leromail.com"));
        v.adiciona(new Contato("Pedroca", "9999-6666", "pedrok@leromail.com"));
        v.adiciona(new Contato("Leoçony", "9999-5555", "sonysta@leromail.com"));

        System.out.println(v);

    }
}

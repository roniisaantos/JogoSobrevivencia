package aplicacao;

import utilidades.Player;
import utilidades.Viloes;
import utilidades.Ferramentas;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws InterruptedException {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Vamos começar o jogo de sobrevivência em texto :)");
        Ferramentas.linhaEmBranco();

        System.out.print("Vamos começar com o nome do seu personagem: ");
        String nome = entrada.nextLine();
        Player jogador = new Player(nome);

        Thread.sleep(100);
        System.out.println("*** Personagem sendo criado ***");
        Thread.sleep(2000);

        System.out.println(jogador.exibirDados());

        Ferramentas.linhaPontilhada();

        System.out.println("*** Novo vilão sendo criado ***");
        Viloes vilao1 = new Viloes();
        Thread.sleep(2000);

        System.out.println(vilao1.exibirDados());

        Ferramentas.linhaEmBranco();

        Ferramentas.linhaPontilhada();
        System.out.println(jogador.getNome() + " está atacando " + vilao1.getNome());
        Ferramentas.linhaPontilhada();

        Thread.sleep(3000);

        Ferramentas.linhaEmBranco();
        Ferramentas.linhaEmBranco();

        jogador.atacar(vilao1);

        System.out.println(jogador.exibirDados());
        Ferramentas.linhaPontilhada();
        System.out.println(vilao1.exibirDados());



        entrada.close();
    }
}

package aplicacao;

import utilidades.*;

import java.util.Scanner;

public class Programa {

    public static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Vamos começar o jogo de sobrevivência em texto :)");
        Ferramentas.linhaEmBranco();

        System.out.print("Vamos começar com o nome do seu personagem: ");
        String nome = entrada.nextLine();
        Player jogador = new Player(nome);
        Mundo mundoAtual = new Mundo();

        Ferramentas.linhaEmBranco();
        Ferramentas.linhaPontilhada();

        Thread.sleep(500);
        System.out.println("*** Personagem sendo criado...");
        Thread.sleep(1000);
        System.out.printf("*** %s, pronto pro jogo!\n", jogador.getNome());
        Thread.sleep(500);
        System.out.printf("*** Você começou o jogo no mundo %s\n", mundoAtual.getNome());

        Ferramentas.linhaPontilhada();
        Ferramentas.linhaEmBranco();

        Menu.chamarMenu();

        entrada.close();
    }
}

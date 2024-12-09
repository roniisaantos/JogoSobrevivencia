package utilidades;

import aplicacao.Programa;

import java.util.InputMismatchException;

public class ModoLuta {

    public static void consultarViloes() throws InterruptedException {

        System.out.println("============== MODO LUTA ==============");
        Ferramentas.linhaEmBranco();

        if (Vilao.getListaDeViloes().isEmpty()) {
            System.out.println(" # Mundo sem vilões");
            Menu.chamarMenu();
        }
        else {
            Thread.sleep(1000);
            for (int i = 0; i < Vilao.getListaDeViloes().size(); i++) {
                System.out.printf("[%d] %s\n", i + 1, Vilao.getListaDeViloes().get(i));
            }

            menuLuta();

            Ferramentas.linhaPontilhada();
            Ferramentas.linhaEmBranco();
        }
    }

    public static void menuLuta() throws InterruptedException {

        while (true) {

            System.out.print("""
                =======================================
                [111] Lutar contra vilões
                [222] Voltar ao menu principal
                =======================================
                ====> Escolha uma ação desejada:""" + " ");

            try {

                int controle = Programa.entrada.nextInt();
                switch (controle) {
                    case 111:
                        System.out.print("Escolha o número do vilão = ");
                        int escolhaVilao = Programa.entrada.nextInt();

                        Player.lutar(Vilao.getListaDeViloes().get(escolhaVilao - 1));
                        Ferramentas.linhaEmBranco();

                        consultarViloes();

                    case 222:
                        Ferramentas.linhaEmBranco();
                        Menu.chamarMenu();

                    default:
                        System.out.println("Opção inválida! Por favor, escolha 111 ou 222.\n");
                }
            }
            catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("\nEscolha uma opção válida!\n");
                Programa.entrada.nextLine();
            }
        }
    }
}

package utilidades;

import aplicacao.Programa;

public class ModoLuta {

    public static void consultarViloes() throws InterruptedException {

        System.out.println("============== MODO LUTA ==============");
        Ferramentas.linhaEmBranco();

        if (Vilao.getListaDeViloes().isEmpty()) {
            System.out.println(" # Mundo sem vilões");
            Ferramentas.linhaPontilhada();
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
        System.out.print("""
                =======================================
                [111] Lutar contra vilões
                [222] Voltar ao menu principal
                =======================================
                ====> Escolha uma ação desejada:""" + " ");

        int controle = Programa.entrada.nextInt();

        if (controle == 111) {

            System.out.print("Escolha o número do vilão = ");
            int escolhaVilao = Programa.entrada.nextInt();

            Player.lutar(Vilao.getListaDeViloes().get(escolhaVilao - 1));
            Ferramentas.linhaEmBranco();

            consultarViloes();
        }
        else if (controle == 222) {
            Ferramentas.linhaEmBranco();
            Menu.chamarMenu();
        }
        else {
            System.out.println("ERRO! Digite uma opção válida!");
            Ferramentas.linhaEmBranco();
            menuLuta();
        }
    }
}

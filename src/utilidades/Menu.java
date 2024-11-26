package utilidades;

import aplicacao.Programa;

public class Menu {

    public static void chamarMenu() throws InterruptedException {

        //boolean controle = true;

        while (true) {

            System.out.print("""
                ============ MENU PRINCIPAL ============
                
                [1] Criar e explorar novo mundo
                [2] Ver vilões do mundo
                [3] Consultar inventário
                [4] Ver status do personagem
                [5] Encerrar o jogo
                ==> Escolha uma ação desejada:""" + " ");

            int opcao = Programa.entrada.nextInt();
            Ferramentas.linhaEmBranco();

            switch (opcao) {
                case 1:
                    Mundo.criarExplorarMundo();
                    Ferramentas.linhaEmBranco();
                    continue;

                case 2:
                    ModoLuta.consultarViloes();
                    continue;

                case 3:
                    Inventario.consultarInventario();
                    continue;

                case 4:
                    Ferramentas.linhaPontilhada();
                    System.out.println(Player.exibirDados());
                    Ferramentas.linhaPontilhada();
                    Ferramentas.linhaEmBranco();
                    continue;

                case 5:
                    System.exit(0);
            }
        }
    }
}

package utilidades;

import aplicacao.Programa;

import java.util.InputMismatchException;

public class Menu {

    public static void chamarMenu() throws InterruptedException {

        int opcao = 0;

        while(true) {

            System.out.print("""
            ============ MENU PRINCIPAL ============
            
            [1] Criar e explorar novo mundo
            [2] Ver vilões do mundo
            [3] Consultar inventário
            [4] Ver status do personagem
            [5] Encerrar o jogo
            ==> Escolha uma ação desejada:""" + " ");

            try {
                opcao = Programa.entrada.nextInt();
                Ferramentas.linhaEmBranco();

                switch (opcao) {
                    case 1:
                        if (Vilao.getListaDeViloes().isEmpty()) {
                            Mundo.criarExplorarMundo();
                            Ferramentas.linhaEmBranco();
                            continue;
                        } else {
                            System.out.println("Ops! Tem vilões vivos no mundo atual. Derrote-os primeiro!");
                            Thread.sleep(1000);
                            Ferramentas.linhaEmBranco();
                            continue;
                        }

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
                        System.out.println("Até logo! ;)");
                        Thread.sleep(500);
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida! Por favor, escolha entre 1 e 5.");
                        Ferramentas.linhaEmBranco();
                }

            }
            catch (InputMismatchException e) {
                System.out.println("Use somente números para navegar pelo menu! ;)");
                Programa.entrada.nextLine();
                Ferramentas.linhaEmBranco();
            }

        }
    }
}


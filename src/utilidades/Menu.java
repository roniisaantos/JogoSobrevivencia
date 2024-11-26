package utilidades;

import java.util.Scanner;

public class Menu {

    public static void chamarMenu() throws InterruptedException {

        Scanner entrada = new Scanner(System.in);
        int controle = 0;
        while (controle == 0) {

            System.out.println("============ MENU PRINCIPAL ============");
            Ferramentas.menuPrincipal();
            int opcao = entrada.nextInt();
            Ferramentas.linhaEmBranco();

            switch (opcao) {
                case 1:
                    Mundo.criarExplorarMundo();
                    Ferramentas.linhaEmBranco();
                    continue;

                case 2:
                    Inventario.consultarInventario();
                    continue;

                case 3:
                    Ferramentas.linhaPontilhada();
                    System.out.println(Player.exibirDados());
                    Ferramentas.linhaPontilhada();
                    Ferramentas.linhaEmBranco();
                    continue;

                case 4:
                    controle = 1;
                    break;
            }
        }
        entrada.close();
    }
}

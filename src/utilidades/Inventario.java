package utilidades;

import aplicacao.Programa;

import java.util.InputMismatchException;

public class Inventario {

    public static void consultarInventario() throws InterruptedException {

        System.out.println("============== INVENTÁRIO ==============");
        Ferramentas.linhaEmBranco();

        if (Comida.getListaDeComidas().isEmpty()) {
            System.out.println(" # Vazio");
            Ferramentas.linhaPontilhada();
            Menu.chamarMenu();
        } else {
            Thread.sleep(1000);
            for (int i = 0; i < Comida.getListaDeComidas().size(); i++) {
                System.out.printf("[%d] %s\n", i + 1, Comida.getListaDeComidas().get(i));
            }

            menuInventario();

            Ferramentas.linhaPontilhada();
            Ferramentas.linhaEmBranco();
        }
    }

    public static void menuInventario() throws InterruptedException {


        while (true) {

            System.out.print("""
                    =======================================
                    [111] Comer uma comida
                    [222] Voltar ao menu principal
                    =======================================
                    ====> Escolha uma ação desejada:""" + " ");

            try {

                int controle = Programa.entrada.nextInt();

                switch (controle) {

                    case 111:
                        System.out.print("Escolha o número da comida = ");
                        int escolhaComida = Programa.entrada.nextInt();
                        Player.comer(Comida.getListaDeComidas().get(escolhaComida - 1));

                        System.out.println("Comendo...");
                        Thread.sleep(1000);

                        System.out.printf("Vida atualizada para: %d\n", Player.getVida());

                        consultarInventario();

                    case 222:
                        Ferramentas.linhaEmBranco();
                        Menu.chamarMenu();

                    default:
                        System.out.println("Opção inválida! Por favor, escolha 111 ou 222.");
                        Ferramentas.linhaEmBranco();
                }

            } catch (InputMismatchException e) {
                System.out.println("Use somente números para navegar pelo menu! ;)");
                Programa.entrada.nextLine();
                Ferramentas.linhaEmBranco();
            }
        }
    }
}

package utilidades;

import java.util.Scanner;

public class Inventario {

    public static void consultarInventario() throws InterruptedException {

        System.out.println("============== INVENTÁRIO ==============");
        Ferramentas.linhaEmBranco();

        if (Comida.getListaDeComidas().isEmpty()) {
            System.out.println(" # Vazio");
            Ferramentas.linhaPontilhada();
            Menu.chamarMenu();
        }
        else {
            Thread.sleep(1000);
            for (int i = 0; i < Comida.getListaDeComidas().size(); i++) {
                System.out.printf("[%d] %s\n", i + 1, Comida.getListaDeComidas().get(i));
            }

            Ferramentas.linhaPontilhada();
            menuInventario();

            Ferramentas.linhaPontilhada();
            Ferramentas.linhaEmBranco();
        }
    }

    public static void menuInventario() throws InterruptedException {
        System.out.print("""
                [111] Comer uma comida
                [222] Voltar ao menu principal
                ====> Escolha uma ação desejada:""" + " ");

        Scanner entrada = new Scanner(System.in);
        int controle = entrada.nextInt();

        if (controle == 111) {
            System.out.print("Escolha o número da comida = ");
            int escolhaComida = entrada.nextInt();
            Player.comer(Comida.getListaDeComidas().get(escolhaComida - 1));

            System.out.println("Comendo...");
            Thread.sleep(1000);

            System.out.printf("Vida atualizada para: %d\n", Player.getVida());

            consultarInventario();
        }
        else if (controle == 222) {
            Ferramentas.linhaEmBranco();
            Menu.chamarMenu();
        }
        else {
            System.out.println("ERRO! Digite uma opção válida!");
            Ferramentas.linhaEmBranco();
            menuInventario();
        }
    }
}

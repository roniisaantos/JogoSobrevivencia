package utilidades;

public class Ferramentas {

    public static void linhaEmBranco() {
        System.out.println(" ");
    }

    public static void linhaPontilhada() {
        System.out.println("----------------------------------------");
    }

    public static void menuPrincipal() {
        System.out.print("""
                [1] Criar e explorar novo mundo
                [2] Consultar inventário
                [3] Ver status do personagem
                [4] Sair do jogo
                ==> Escolha uma ação desejada:""" + " ");
    }
}

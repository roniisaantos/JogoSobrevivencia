package utilidades;

import java.util.Random;

public class Mundo {

    private static String nome;
    private Integer qntdComidas;
    private Integer qntdViloes;


    Random sortear = new Random();

    public static String getNome() {
        return nome;
    }

    String[] planetas = {
            "Mercúrio", "Vênus", "Terra", "Marte",
            "Júpiter", "Saturno", "Urano", "Netuno"
    };

    public Mundo() {
        nome = planetas[sortear.nextInt(8)] + sortear.nextInt(999);
        qntdComidas = 4; //sortear.nextInt(4);
        qntdViloes = 4;//sortear.nextInt(3);
        definirComidas_Viloes(qntdComidas, qntdViloes);
    }

    public static void criarExplorarMundo() throws InterruptedException {
        Mundo novoMundo = new Mundo();
        System.out.print("*** Criando novo mundo...\n");
        Thread.sleep(1000);
        System.out.printf("==> %s criado!\n", novoMundo.getNome());
        System.out.print("*** Explorando novo mundo...");
        Ferramentas.linhaEmBranco();

        Thread.sleep(1000);
    }

    public void definirComidas_Viloes(int qntdComidas, int qntdViloes) {
        if (qntdComidas > 0) {
            for (int i = 0; i < qntdComidas; i++) {
                Comida.getListaDeComidas().add(new Comida());
                }
        }

        if (qntdViloes > 0) {
            for (int i = 0; i < qntdViloes; i++) {
                Vilao.getListaDeViloes().add(new Vilao());
            }
        }
    }
}

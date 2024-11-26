package utilidades;

import java.util.ArrayList;
import java.util.Random;

public class Mundo {

    private static String nome;
    private Integer qntdComidas;
    private Integer qntdViloes;
    private static ArrayList<Vilao> listaDeViloes = new ArrayList<>();

    Random sortear = new Random();

    public ArrayList<Vilao> getListaDeViloes() {
        return listaDeViloes;
    }

    public static String getNome() {
        return nome;
    }

    String[] planetas = {
            "Mercúrio", "Vênus", "Terra", "Marte",
            "Júpiter", "Saturno", "Urano", "Netuno"
    };

    public Mundo() {
        nome = planetas[sortear.nextInt(8)] + sortear.nextInt(999);
        qntdComidas = sortear.nextInt(4);
        qntdViloes = sortear.nextInt(3);
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
                listaDeViloes.add(new Vilao());
            }
        }
    }
}

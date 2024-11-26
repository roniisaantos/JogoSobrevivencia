package utilidades;

import java.util.ArrayList;
import java.util.Random;

public class Comida {

    private String nome;
    private Integer pontosDeVida;
    private static ArrayList<Comida> listaDeComidas = new ArrayList<>();

    Random sortear = new Random();

    String[] frutas = {
            "Maçã", "Banana", "Laranja", "Manga", "Abacaxi",
            "Melancia", "Uva", "Pera", "Cereja", "Kiwi",
            "Morango", "Pêssego", "Ameixa", "Mamão", "Maracujá"
    };

    public static ArrayList<Comida> getListaDeComidas() {
        return listaDeComidas;
    }

    public Integer getpontosDeVida() {
        return pontosDeVida;
    }

    public Comida() {
        this.nome = frutas[sortear.nextInt(15)];
        this.pontosDeVida = sortear.nextInt(10, 40);
    }

    @Override
    public String toString() {
        return String.format("%s te dará %d pontos de saúde", nome, pontosDeVida);
    }
}

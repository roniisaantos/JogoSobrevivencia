package utilidades;

public class Player {

    private static String nome;
    private static Integer level;
    private static Integer vida;
    private static Integer poder;

    public Player(String nome) {
        Player.nome = nome;
        level = 1;
        vida = 100;
        poder = 30;
    }

    public String getNome() {
        return nome;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        Player.level = level;
    }

    public static Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        Player.vida = vida;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoderAtaque(Integer poderAtaque) {
        Player.poder = poderAtaque;
    }

    public static void lutar(Vilao vilao) throws InterruptedException {


            System.out.printf("*** Atacando vilão %s...\n", vilao.getNome());
            Thread.sleep(1000);

            while (vilao.getVida() > 0) {

                vilao.setVida(vilao.getVida() - poder);

                if (vilao.getVida() < 0) {
                    vilao.setVida(0);
                }

                if (vilao.getVida() == 0) {
                    System.out.printf("%s foi derrotado!\n", vilao.getNome());
                    Vilao.getListaDeViloes().remove(vilao);
                    Ferramentas.linhaEmBranco();
                    break;
                }
                else {
                    System.out.printf("Você atacou com poder de %d, %s tem %d de vida.\n",
                            poder, vilao.getNome(), vilao.getVida());
                    Thread.sleep(800);
                }
            }
    }

    public void subirLevel(Player jogador) {
        long controle = 0;

    }

    public static void comer(Comida comida) {
        vida += comida.getpontosDeVida();
        Comida.getListaDeComidas().remove(comida);
    }

    public static String exibirDados() {
        return "Nome do jogador: " + nome + "\n" +
                "Level: " + level + "\n" +
                "Vida: " + vida + "\n" +
                "Poder de ataque: " + poder + "\n";
    }
}

package utilidades;

public class Player {

    private static String nome;
    private static Integer level;
    private static Integer vidaInicial;
    private static Integer poderInicial;

    public Player(String nome) {
        Player.nome = nome;
        level = 1;
        vidaInicial = 150;
        poderInicial = 25;
    }

    public String getNome() {
        return nome;
    }

    public static Integer getVidaInicial() {
        return vidaInicial;
    }

    public void setVida(Integer vida) {
        this.vidaInicial = vida;
    }

    public static void lutar(Vilao vilao) throws InterruptedException {

        System.out.printf("*** Atacando vilão %s...\n", vilao.getNome());
        Thread.sleep(1000);

        int vidaParcial_P = vidaInicial;
        int poderParcial_P = poderInicial;
        int vidaParcial_V = vilao.getVidaInicial();
        int poderParcial_V = vilao.getPoderInicial();

        while (vilao.getVidaInicial() > 0) {

            // Testa se a vida atual do player está entre 25% e 50% da vida inicial
            if (vidaParcial_P <= vidaInicial / 2 && vidaParcial_P > vidaInicial / 4) {
                poderParcial_P += poderInicial / 10; // Aumenta o poder atual em 10%
            } else if (vidaParcial_P < vidaInicial / 4) { // Testa se a vida atual do player está menor que 25% da vida inicial
                poderParcial_P += poderInicial / 5; // Aumenta o poder atual em 20%

            }

            vidaParcial_V -= poderParcial_P;
            if (vidaParcial_V <= 0) {

                vidaParcial_V = 0;
                System.out.printf("Você atacou com poder de %d, %s tem %d de vida.\n",
                        poderParcial_P, vilao.getNome(), vidaParcial_V);

                System.out.printf("%s foi derrotado!\n", vilao.getNome());
                Vilao.getListaDeViloes().remove(vilao);
                Ferramentas.linhaEmBranco();
                break;
            }
            else {
                System.out.printf("Você atacou com poder de %d, %s tem %d de vida.\n",
                        poderParcial_P, vilao.getNome(), vidaParcial_V);
                Thread.sleep(1500);
            }

            // Testa se a vida atual do vilão está entre 25% e 50% da vida inicial
            if (vidaParcial_V <= vilao.getVidaInicial() / 2 && vidaParcial_V > vilao.getVidaInicial() / 4) {
                poderParcial_V += vilao.getPoderInicial() / 10; // Aumenta o poder atual em 10%
            } else if (vidaParcial_V < vilao.getVidaInicial() / 4) { // Testa se a vida atual do vilão está menor que 25% da vida inicial
                poderParcial_V += vilao.getPoderInicial() / 5; // Aumenta o poder atual em 20%
            }

            vidaParcial_P -= poderParcial_V;
            if (vidaParcial_P <= 0) {

                vidaParcial_P = 0;
                System.out.printf("%s te atacou com poder de %d, te resta %d de vida.\n",
                        vilao.getNome(), poderParcial_V, vidaParcial_P);

                System.out.printf("Você foi derrotado por %s :(\n", vilao.getNome());
                System.exit(0);

            }
            else {
                System.out.printf("%s te atacou com poder de %d, te resta %d de vida.\n",
                        vilao.getNome(), poderParcial_V, vidaParcial_P);
                Thread.sleep(1500);
            }
        }
    }

    public void controleLevel(Player jogador) {
        long controle = 0;

    }

    public static void comer(Comida comida) {
        vidaInicial += comida.getpontosDeVida();
        Comida.getListaDeComidas().remove(comida);
    }

    public static String exibirDados() {
        return "Nome do jogador: " + nome + "\n" +
                "Level: " + level + "\n" +
                "Vida: " + vidaInicial + "\n" +
                "Poder de ataque: " + poderInicial + "\n";
    }
}

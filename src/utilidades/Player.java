package utilidades;

public class Player {

    private static String nome;
    private static Integer vida;
    private static Integer poder;
    private static Integer level = 1;
    private static Integer controleLevel = 0;

    public Player(String nome) {
        Player.nome = nome;
        vida = 150;
        poder = 25;
    }

    public String getNome() {
        return nome;
    }

    public static Integer getVida() {
        return vida;
    }

    public static void lutar(Vilao vilao) throws InterruptedException {

        System.out.printf("*** Atacando vilão %s...\n", vilao.getNome());
        Thread.sleep(1000);

        int vidaParcial_P = vida;
        int poderParcial_P = poder;
        int vidaParcial_V = vilao.getVida();
        int poderParcial_V = vilao.getPoder();

        while (vilao.getVida() > 0) {

            // Testa se a vida atual do player está entre 25% e 50% da vida inicial
            if (vidaParcial_P <= vida / 2 && vidaParcial_P > vida / 4) {
                poderParcial_P += poder / 10; // Aumenta o poder atual em 10%
            } else if (vidaParcial_P < vida / 4) { // Testa se a vida atual do player está menor que 25% da vida inicial
                poderParcial_P += poder / 5; // Aumenta o poder atual em 20%

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
            if (vidaParcial_V <= vilao.getVida() / 2 && vidaParcial_V > vilao.getVida() / 4) {
                poderParcial_V += vilao.getPoder() / 5; // Aumenta o poder atual em 20% durante a batalha
            } else if (vidaParcial_V < vilao.getVida() / 4) { // Testa se a vida atual do vilão está menor que 25% da vida inicial
                poderParcial_V += vilao.getPoder() / 3; // Aumenta o poder atual em mais de 33% durante a batalha
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

    public static void controleLevel(Comida comida) throws InterruptedException {

        controleLevel += comida.getpontosDeVida(); // Variável que identifica os pontos de vida ganhos com comidas.

        if (controleLevel >= 100) { // Verifica se o player consumiu 100 pontos de vida em comida.

            level++;
            controleLevel = 0;
            poder += (poder/10);

            for(Vilao vilao : Vilao.getListaDeViloes()) {
                vilao.setPoder(vilao.getPoder() + (vilao.getPoder() / 5)); // Aumentou 20% de poder em todos os vilões do mundo.
            }

            System.out.printf("Parabéns! Você subiu para o nível %d\n", level);
            Thread.sleep(500);
            System.out.println("Aumento de poder em 10%! Poder atual: " + poder);
            Thread.sleep(500);
            System.out.println("* Vilões do mundo atual ganham 20% de poder!");
            Ferramentas.linhaEmBranco();
        }
    }

    public static void comer(Comida comida) throws InterruptedException {
        vida += comida.getpontosDeVida();
        controleLevel(comida);
        Comida.getListaDeComidas().remove(comida);
    }

    public static String exibirDados() {
        return "Nome do jogador: " + nome + "\n" +
                "Level: " + level + "\n" +
                "Vida: " + vida + "\n" +
                "Poder de ataque: " + poder + "\n";
    }
}
package utilidades;

public class Player {

    private static String nome;
    private static Integer level;
    private static Integer vida;
    private static Integer poderAtaque;

    public Player(String nome) {
        Player.nome = nome;
        level = 1;
        vida = 100;
        poderAtaque = 30;
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

    public Integer getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(Integer poderAtaque) {
        Player.poderAtaque = poderAtaque;
    }

    public void atacar(Vilao vilao) {
        vilao.setVida(vilao.getVida() - poderAtaque);
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
                "Poder de ataque: " + poderAtaque + "\n";
    }
}

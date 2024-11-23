package utilidades;

public class Player {

    private String nome;
    private Integer level;
    private Integer vida;
    private Integer energia;
    private Integer poderAtaque;

    public Player(String nome) {
        this.nome = nome;
        this.level = 1;
        this.vida = 100;
        this.poderAtaque = 30;
        this.energia = 100;
    }

    public String getNome() {
        return nome;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Integer getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(Integer poderAtaque) {
        this.poderAtaque = poderAtaque;
    }

    public void atacar(Viloes vilao) {
        vilao.setVida(vilao.getVida() - this.poderAtaque);
    }

    //public andar() {

    //}

    public void comer(Comidas comida) {
        vida += comida.getVida();
    }

    public String exibirDados() {
        return "Nome do jogador: " + nome + "\n" +
                "Level: " + level + "\n" +
                "Vida: " + vida + "\n" +
                "Poder de ataque: " + poderAtaque + "\n" +
                "Energia: " + energia;
    }
}

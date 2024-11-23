package utilidades;

import java.util.Random;

public class Viloes {

    private String nome;
    private Integer level;
    private Integer vida;
    private Integer poderAtaque;

    Random random = new Random();

    String[] nomesViloes = {
            "Draekon", "Lord Umbra", "Morgath", "Zarok", "Venomshade", "Blightfang", "Ravenous", "Crimson Vex",
            "Nightmare", "Shadowbane", "Malakar", "Valkor the Cruel", "Infernis", "Spectrax", "Dreadclaw", "Grimthorn",
            "Oblivion", "Tormentra", "Nyxbane", "Abyssion", "Darkthorn", "Hellbringer", "Vilemaw", "Ravager",
            "Sorrowmancer", "Frostbite", "Necros", "Vortex", "Inferno", "Doombringer", "Bloodshadow", "Skulkrush",
            "Furyclaw", "Oblivionrider", "Styxmaster", "Phantomshade", "Wraithlord", "Reaper", "Dreadmist", "Maleficus",
            "Seraphox", "Ragnarok", "Drakonar", "Nightshade", "Vermis", "Hexer", "Vilefiend", "Tyrannus",
            "Abyssal Lord", "Zarathor", "Havoc", "Eclipse", "Onyxclaw", "Scourge", "Vandarr", "Hellstorm",
            "Venomfang", "Ravencroft", "Cryptmaster", "Bloodhunter", "Specterbane", "Voidfiend", "Dreadlord", "Shadewalker",
            "Stormbreaker", "Devourer", "Gorefiend", "Hellfire", "Blightmancer", "Darkwraith", "Gravekeeper", "Ruinlord",
            "Fallen Monarch", "Wormwood", "Vampirion", "Ironclaw", "Shiverstrike", "Phantasm", "Veldrax", "Zephyrus"
    };

    public Viloes(){
        // Sorteia um dos 64 nomes do array
        int escolhaNome = random.nextInt(64);
        this.nome = nomesViloes[escolhaNome];
        this.vida = random.nextInt(151) + 20; // vida inicial aleatória entre 20 e 150
        this.poderAtaque = random.nextInt(10) + 1; // poder inicial aleatório entre 1 e 10
        this.level = 1;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void atacar(Player personagem) {
        personagem.setVida(personagem.getVida() - this.poderAtaque);
    }

    public Integer getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(Integer poderAtaque) {
        this.poderAtaque = poderAtaque;
    }

    public String exibirDados() {
        return "Vilão: " + nome + "\n" +
                "Level: " + level + "\n" +
                "Vida: " + vida + "\n" +
                "Poder de ataque: " + poderAtaque + "\n";
    }
}

package utilidades;

import java.util.ArrayList;
import java.util.Random;

public class Vilao {

    private String nome;
    private Integer vida;
    private Integer poder;
    private static ArrayList<Vilao> listaDeViloes = new ArrayList<>();

    Random sortear = new Random();

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

    public Vilao(){
        // Sorteia um dos 64 nomes do array e acrescenta um número aleatório entre 0 e 99
        int escolhaNome = sortear.nextInt(64);
        nome = nomesViloes[escolhaNome] + sortear.nextInt(100);
        vida = sortear.nextInt(50, 201); // vida inicial aleatória entre 50 e 200
        poder = sortear.nextInt(5, 16); // poder inicial aleatório entre 5 e 15
    }

    public static ArrayList<Vilao> getListaDeViloes() {
        return listaDeViloes;
    }

    public Integer getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {
        return String.format("""
                Nome: %s | Vida: %d | Poder: %d""", nome, vida, poder);
    }
}

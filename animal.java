public interface Animal {
    void emitirSom();
    String getNome();
    int getIdade();
}


public abstract class AnimalBase implements Animal {
    private String nome;
    private int idade;

    public AnimalBase(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    protected String getNomePrivado() {
        return nome;
    }

    protected int getIdadePrivada() {
        return idade;
    }

    @Override
    public String getNome() {
        return getNomePrivado();
    }

    @Override
    public int getIdade() {
        return getIdadePrivada();
    }
}



public class Leão extends AnimalBase {
    public Leão(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom() {
        System.out.println("Rugido!");
    }
}
public class Elefante extends AnimalBase {
    public Elefante(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom() {
        System.out.println("Barrito!");
    }
}
public class Pássaro extends AnimalBase {
    public Pássaro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom() {
        System.out.println("Canto!");
    }
}


public class Main {
    public static void main(String[] args) {
        Animal leão = new Leão("Simba", 5);
        Animal elefante = new Elefante("Dumbo", 10);
        Animal pássaro = new Pássaro("Tweety", 2);

        Animal[] animais = {leão, elefante, pássaro};

        for (Animal animal : animais) {
            System.out.println("Nome: " + animal.getNome() + ", Idade: " + animal.getIdade());
            animal.emitirSom();
        }
    }
}




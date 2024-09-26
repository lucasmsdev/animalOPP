import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Animal {
    void emitirSom();
    String getNome();
    int getIdade();
}

abstract class AnimalBase implements Animal {
    private String nome;
    private int idade;

    public AnimalBase(String nome, int idade) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
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

    @Override
    public String toString() {
        return "Animal [Nome: " + nome + ", Idade: " + idade + "]";
    }
}

class Leão extends AnimalBase {
    public Leão(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom() {
        System.out.println("Rugido!");
    }
}

class Elefante extends AnimalBase {
    public Elefante(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom() {
        System.out.println("Barrito!");
    }
}

class Pássaro extends AnimalBase {
    public Pássaro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom() {
        System.out.println("Canto!");
    }
}

public class Main {
    private static List<Animal> animais = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar um Animal");
            System.out.println("2. Listar Animais");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    adicionarAnimal();
                    break;
                case 2:
                    listarAnimais();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarAnimal() {
        System.out.print("Digite o nome do animal: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do animal: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        System.out.print("Digite o tipo de animal (leão, elefante, pássaro): ");
        String tipo = scanner.nextLine().toLowerCase();

        try {
            Animal animal;
            switch (tipo) {
                case "leão":
                    animal = new Leão(nome, idade);
                    break;
                case "elefante":
                    animal = new Elefante(nome, idade);
                    break;
                case "pássaro":
                    animal = new Pássaro(nome, idade);
                    break;
                default:
                    System.out.println("Tipo de animal inválido.");
                    return;
            }
            animais.add(animal);
            System.out.println("Animal adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void listarAnimais() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }
        for (Animal animal : animais) {
            System.out.println(animal);
            animal.emitirSom();
        }
    }
}

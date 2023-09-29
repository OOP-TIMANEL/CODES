package pokemon;
import java.util.Random;
import java.util.Scanner;

public class Pokemon {

    String name;
    String type;
    int health;
    int attack;
    int totalt = 0;
    int restCount = 0;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
        this.health = 100; 
        this.attack = 20; 
    }

    public void displayInfo() {
        System.out.println("\nThe stats of this Pokemon");
        System.out.println("Name: " + name);
        System.out.println("Pokemon Type: " + type);
        System.out.println("Attack Power: " + attack);
        System.out.println("Health: " + health);
        System.out.println("Total Training Count: " + totalt);
        System.out.println("Total Rest Count: " + restCount);
    }

    public void train() {
        if (health > 0) {
            health -= 5;
            attack += 3;
            totalt++;
        } else {
            System.out.println("Your Pokemon is exhausted!! \n Please Rest!");
        }
    }

    public void attack(String Skills) {
        System.out.println(type + " type Pokemon " + name + " used " + Skills + "!");

       
        int damage = RandomDamage(Skills);
        System.out.println("Damage dealt: " + damage);
    }

    public void rest() {
        if (health < 100) {
            health += 3;
            restCount++;
            
            
            System.out.println("Your Pokemon is now resting.");
        } else {
            System.out.println("Your Pokemon is already fully rested.");
        }
    }

    
    private int RandomDamage(String Skill) {
        Random dom = new Random();
        int BaseDamage = 0;

        return BaseDamage + (totalt * 2);
    }

    
    public void SkillList() {
        // Implement this in the subclasses
    }

    public String Attacks() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your Attack: ");
        SkillList();
        
    return scan.nextLine();
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\tGreetings Pokemon Trainer!\n--------------------------------------------");
        System.out.println("Select Type of a Pokemon \n 1. Fire \n 2. Dark \n 3. Dragon");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String pokemonType = "";

        if (choice == 1) {
            pokemonType = "Fire";
        } else if (choice == 2) {
            pokemonType = "Dark";
        } else if (choice == 3) {
            pokemonType = "Dragon";
        } else {
            System.out.println(" Invalid!! \n  Please Select a Type");
            System.exit(0);
        }

        System.out.println("Enter the name of your Pokemon:");
        String pokemonName = sc.nextLine();

        
        Pokemon selectedPokemon = null;
        if ("Fire".equals(pokemonType)) {
            selectedPokemon = new Fire(pokemonName, pokemonType);
        } else if ("Dark".equals(pokemonType)) {
            selectedPokemon = new Dark(pokemonName, pokemonType);
        } else if ("Dragon".equals(pokemonType)) {
            selectedPokemon = new Dragon(pokemonName, pokemonType);
        }

        if (selectedPokemon != null) {
            System.out.println("\nCongratulations! You've choosen " + pokemonName + ", a " + pokemonType + " type of Pokemon");

            selectedPokemon.displayInfo();

            while (true) {
                System.out.println("\nWhat do you want to do with your Pokemon?");
                System.out.println("1. Train");
                System.out.println("2. Rest");
                System.out.println("3. Attack");
                System.out.println("4. Display Stats");
                System.out.println("5. Exit");

                int option = sc.nextInt();
                sc.nextLine(); 

                if (option == 1) {
                    selectedPokemon.train();
                } else if (option == 2) {
                    selectedPokemon.rest();
                } else if (option == 3) {
                    String skillName = selectedPokemon.Attacks();
                    selectedPokemon.attack(skillName);
                } else if (option == 4) {
                    selectedPokemon.displayInfo();
                } else if (option == 5) {
                    System.out.println("Goodbye, Pokemon Trainer!");
                    break;
                } else {
                    System.out.println("Invalid option. Please select a valid option.");
                }
            }
        }
    }
}
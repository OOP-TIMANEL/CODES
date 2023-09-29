package pokemon;

import java.util.Random;

    class Fire extends Pokemon {
    public Fire(String name, String type) {
        super(name, type);
    }

    @Override
    public void SkillList() {
        System.out.println("1. Iron Bash");
        System.out.println("2. Steel Strike");
        System.out.println("3. Metal Claw");
    }

    
    public void attack(String Skills) {
        System.out.println(type + " type Pokemon " + name + " used " + Skills + "!");
        
       
       
        int Min = 0; 
        int Max = 20; 
        int damage = new Random().nextInt(Max - Min + 1) + Min;
        
       
        int total = damage + (totalt * 2);
        
        System.out.println("Damage dealt: " + total);
    }

    
    public void train() {
        if (health > 0) {
            health -= 5;
            attack += 3;
            totalt++;
            System.out.println("Your Pokemon's attack power increased.");
        } else {
            System.out.println("Your Pokemon is exhausted!! \n Please Rest!");
        }
    }
}
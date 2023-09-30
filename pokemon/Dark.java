package pokemon;


import java.util.*;

    class Dark extends Pokemon {
    public Dark(String name, String type) {
        super(name, type);
    }

   
    public void SkillList() {
        System.out.println("Shadow Ball");
        System.out.println("Haunt");
        System.out.println("Shadow End");
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
            health -= 3;
            attack += 2;
            totalt++;
            System.out.println("Your Pokemon's attack power increased.");
        } else {
            System.out.println("Your Pokemon is exhausted!! \n Please Rest!");
        }
    }
}
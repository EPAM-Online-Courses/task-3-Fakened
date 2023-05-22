package efs.task.oop;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
	    Villager Kashya = new Villager("Kashya", 30);
        ExtraordinaryVillager Akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager Gheda = new Villager("Gheed", 50);
        ExtraordinaryVillager DeckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager Warriv = new Villager("Warriv", 35);
        Villager Flawia = new Villager("Flawia", 25);
        Villager[] villagers = {Kashya, Akara, Gheda, DeckardCain, Warriv, Flawia};
        

        Object objectDeckardCain = DeckardCain;
        Object objectAkara = Akara;

        printVillagers(villagers);

        boolean allVillagersDead = true;
        while (Monsters.monstersHealth > 0) {
            allVillagersDead = true;
            int villagerAttacker = drawCharacter(villagers.length);
            while (villagers[villagerAttacker].getHealth() <= 0) {
                villagerAttacker = drawCharacter(villagers.length);
            }
            Monster monsterAttacker = drawMonster();
            printAttacker(villagers, villagerAttacker);
            villagers[villagerAttacker].attack(monsterAttacker);
            monsterAttacker.attack(villagers[villagerAttacker]);
            printMonstersHealth();
            for (Villager villager : villagers) {
                if (villager.getHealth() > 0) {
                    allVillagersDead = false;
                }
            }
            if (allVillagersDead) {
                System.out.println("Wszyscy osadnicy nie zyja");
                break;
            }
        }
        if (Monsters.monstersHealth <= 0) {
            System.out.println("Obozowisko ocalone!");
        }
        DeckardCain = (ExtraordinaryVillager) objectDeckardCain;
        Akara = (ExtraordinaryVillager) objectAkara;

        DeckardCain.sayHello();
        Akara.sayHello();
    }


    public static void printVillagers(Villager[] villagers) {
        for (Villager villager : villagers) {
            villager.sayHello();
        }
    }

    public static int drawCharacter(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }

    public static Monster drawMonster() {
        Random random = new Random();
        int monster = random.nextInt(2);
        if (monster == 0) {
            if (Monsters.andariel.getHealth() <= 0) {
                return Monsters.blacksmith;
            }
            return Monsters.andariel;
        } else {
            if (Monsters.blacksmith.getHealth() <= 0) {
                return Monsters.andariel;
            }
            return Monsters.blacksmith;
        }
    }

    public static void printMonstersHealth() {
        System.out.println("Potwory posiadaja jeszcze " + Monsters.monstersHealth + " punkty zycia");
    }

    public static void printAttacker(Villager vill[], int attacker) {
        System.out.println("Aktualnie walczacy osadnik to " + vill[attacker].getName());
    }

}


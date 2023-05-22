package efs.task.oop;

public class Villager implements Fighter {
    private String name;
    private int age;
    private int health = 100;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit((int)(100-age*0.5)/10);
    }

    @Override
    public void takeHit(int damage) {
        if(getHealth() - damage < 0) {
            setHealth(0);
        } else {
            health -= damage;
        }
    }

}
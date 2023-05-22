package efs.task.oop;

public abstract class Monster implements Fighter{
    private int health;
    private int damage;

    public Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    int getHealth() {
        return health;
    }

    int getDamage() {
        return damage;
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        health -= damage;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }
}


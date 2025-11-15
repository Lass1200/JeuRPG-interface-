package com.example.rpg;

public class Monster extends Destructible {
    private String nom;
    private int xpRecompense;
    private int argentRecompense;

    public Monster(String nom, double vie, int xpRecompense, int argentRecompense) {
        this.nom = nom;
        this.life = vie;
        this.xpRecompense = xpRecompense;
        this.argentRecompense = argentRecompense;
    }

    public String getNom() { return nom; }
    public int getXpRecompense() { return xpRecompense; }
    public int getArgentRecompense() { return argentRecompense; }

    public boolean estMort() { return life <= 0; }
}

package com.example.rpg;

public class Obstacle extends Destructible {
    private String nom;

    public Obstacle(String nom, double resistance) {
        this.nom = nom;
        this.life = resistance;
    }

    public String getNom() { return nom; }
    public boolean estDetruit() { return life <= 0; }
}

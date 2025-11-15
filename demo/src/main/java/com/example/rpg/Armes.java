package com.example.rpg;

public abstract class Armes {

    protected String nom;
    protected int degats;
    protected int prix;

    public Armes(String nom, int degats, int prix) {
        this.nom = nom;
        this.degats = degats;
        this.prix = prix;
    }


    public abstract void attaquer(Monster m);
    public abstract void attaquer(Obstacle o);

    public String getNom() { return nom; }
    public int getDegats() { return degats; }
    public int getPrix() { return prix; }

    @Override
    public String toString() {
        return nom + " (Dégâts : " + degats + ", Prix : " + prix + ")";
    }
}
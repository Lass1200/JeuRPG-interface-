package com.example.rpg;

import java.util.ArrayList;
import java.util.List;

public class Personnage {
    private String nom;
    private int pv;
    private int mana;
    private int argent;
    private int xp;
    private String caste;
    private List<Armes> inventaire;

    public Personnage(String nom, String caste){
        this.nom = nom;
        this.caste = caste;
        this.xp = 0;
        this.argent = 50;
        this.inventaire = new ArrayList<>();

        switch(caste.toLowerCase()){
            case "sorcier": pv=100; mana=190; argent=12; xp=8; break;
            case "guerrier": pv=100; mana=190; argent=90; xp=8; break;
            case "elfe": pv=100; mana=170; argent=150; xp=8; break;
            default: pv=100; mana=80; argent=12; xp=8; break;
        }
    }

    public void ajouterArme(Armes arme){ if(arme!=null) inventaire.add(arme); }
    public List<Armes> getInventaire(){ return inventaire; }

    public String getNom(){ return nom; }
    public int getPv(){ return pv; }
    public int getMana(){ return mana; }
    public int getArgent(){ return argent; }
    public int getXp(){ return xp; }
    public String getCaste(){ return caste; }

    public void setPv(int pv){ this.pv=pv; }
    public void setMana(int mana){ this.mana=mana; }
    public void setArgent(int argent){ this.argent=argent; }
    public void setXp(int xp){ this.xp=xp; }
}

package com.example.rpg;

import java.util.ArrayList;
import java.util.List;

import com.example.rpg.sous.Axe;
import com.example.rpg.sous.Bow;
import com.example.rpg.sous.Hammer;

public class Magasin {
    private List<Armes> stock;

    public Magasin() {
        stock = new ArrayList<>();
        stock.add(new Axe());
        stock.add(new Bow());
        stock.add(new Hammer());
    }

    public List<Armes> getStock() {
        return stock;
    }

    public boolean AcheterArme(Personnage perso, int index) {
        if(index<0 || index>=stock.size()) return false;
        Armes a = stock.get(index);
        if(perso.getArgent()>=a.getPrix()) {
            perso.setArgent(perso.getArgent()-a.getPrix());
            perso.ajouterArme(a);
            return true;
        }
        return false;
    }
}

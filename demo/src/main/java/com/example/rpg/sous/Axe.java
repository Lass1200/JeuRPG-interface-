package com.example.rpg.sous;

import com.example.rpg.Armes;
import com.example.rpg.Monster;
import com.example.rpg.Obstacle;

public class Axe extends Armes {
    static final double ratiomonstre = 0.8, ratioobstacle = 1.2;

    public Axe() {
        super("Hache", 34, 20);
    }

    public void attaquer(Monster m) {
        m.hit(degats * ratiomonstre);
    }

    public void attaquer(Obstacle o) {
        o.hit(degats * ratioobstacle);
    }
}
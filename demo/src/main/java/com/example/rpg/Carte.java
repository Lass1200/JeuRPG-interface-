package com.example.rpg;

import java.util.Random;
import java.util.Scanner;

public class Carte {
    private final int taille;
    private char[][] grille;
    private int joueurX, joueurY;

    public Carte(int taille) {
        this.taille = taille;
        this.grille = new char[taille][taille];
        initialiserCarte();
    }

    private void initialiserCarte() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = '.';
            }
        }
        joueurX = 0;
        joueurY = 0;
        grille[joueurX][joueurY] = 'J';
        grille[taille-1][taille-1] = 'S';

        Random rand = new Random();
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if ((i != 0 || j != 0) && (i != taille-1 || j != taille-1)) {
                    int r = rand.nextInt(20);
                    if (r < 2) grille[i][j] = 'M';
                    else if (r < 4) grille[i][j] = 'O';
                }
            }
        }
    }

    public char getCase(int x, int y) {
        return grille[x][y];
    }

    public void afficherCarte() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean deplacer(String direction, Personnage joueur) {
        int nx = joueurX;
        int ny = joueurY;

        switch(direction.toLowerCase()) {
            case "haut": nx--; break;
            case "bas": nx++; break;
            case "gauche": ny--; break;
            case "droite": ny++; break;
            default: return false;
        }

        if (nx < 0 || ny < 0 || nx >= taille || ny >= taille) return false;

        char c = grille[nx][ny];
        if (c == 'M') combat(joueur, new Monster("Dragon", 50, 10, 5));
        else if (c == 'O') combat(joueur, new Obstacle("Roc", 30));
        else if (c == 'S') return true;

        grille[joueurX][joueurY] = '.';
        joueurX = nx;
        joueurY = ny;
        grille[joueurX][joueurY] = 'J';

        return false;
    }

    private void combat(Personnage joueur, Destructible cible) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vous rencontrez " + (cible instanceof Monster ? ((Monster)cible).getNom() : ((Obstacle)cible).getNom()));
        System.out.println("1. Combattre / Détruire\n2. Fuir");
        String choix = sc.nextLine();

        if (choix.equals("1")) {
            joueur.setXp(joueur.getXp() + 5);
            System.out.println("Vous gagnez 5 XP !");
            cible.hit(20); // inflige des dégâts fixes pour l'exemple
        } else {
            System.out.println("Vous fuyez !");
        }
    }
}

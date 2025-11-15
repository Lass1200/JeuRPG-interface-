package com.example.rpg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu RPG !");
        
        // Choix du nom et de la classe du personnage
        System.out.print("Entrez le nom de votre personnage : ");
        String nom = scanner.nextLine();
        
        System.out.print("Choisissez une caste (guerrier, sorcier, elfe) : ");
        String caste = scanner.nextLine();
        
        // Création du personnage
        Personnage joueur = new Personnage(nom, caste);
        System.out.println("Bienvenue " + joueur.getNom() + " ! Vous avez " + joueur.getPv() + " PV et " + joueur.getMana() + " mana.");
        
        // Création du magasin
        Magasin magasin = new Magasin();
        
        // Affichage de l'inventaire du joueur
        System.out.println("\nVotre inventaire : ");
        for (Armes arme : joueur.getInventaire()) {
            System.out.println(arme.getNom());
        }
        
        // Création de la carte
        Carte carte = new Carte(5); // Taille 5x5 de la carte
        carte.afficherCarte();
        
        // Boucle de jeu
        boolean jeuEnCours = true;
        while (jeuEnCours) {
            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1. Se déplacer");
            System.out.println("2. Acheter une arme");
            System.out.println("3. Quitter");
            
            String choix = scanner.nextLine();
            
            switch (choix) {
                case "1":
                    // Demander une direction pour se déplacer
                    System.out.print("Entrez une direction (haut, bas, gauche, droite) : ");
                    String direction = scanner.nextLine();
                    jeuEnCours = !carte.deplacer(direction, joueur);
                    carte.afficherCarte();
                    break;
                    
                case "2":
                    // Acheter une arme
                    magasin.afficherStock();
                    System.out.print("Choisissez l'index de l'arme à acheter : ");
                    int index = scanner.nextInt();
                    if (magasin.AcheterArme(joueur, index - 1)) {
                        System.out.println("Arme achetée avec succès !");
                    } else {
                        System.out.println("Vous n'avez pas assez d'argent ou choix invalide.");
                    }
                    scanner.nextLine();  // Consommer le \n restant
                    break;
                    
                case "3":
                    System.out.println("Merci d'avoir joué !");
                    jeuEnCours = false;
                    break;
                    
                default:
                    System.out.println("Choix invalide. Essayez à nouveau.");
                    break;
            }
        }
        
        scanner.close();
    }
}

package com.example.rpg.rpggui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.example.rpg.Carte;
import com.example.rpg.Personnage;

public class MainWindow extends JFrame {
    private Personnage joueur;
    private Carte carte;
    private JTextArea affichage;

    public MainWindow() {
        super("RPG Game");

        creerJoueur();
        carte = new Carte(5);

        affichage = new JTextArea(20, 40);
        affichage.setEditable(false);
        add(new JScrollPane(affichage), BorderLayout.CENTER);

        JPanel panelBoutons = new JPanel();
        String[] dirs = {"Haut","Bas","Gauche","Droite"};
        for(String d : dirs) {
            JButton b = new JButton(d);
            b.addActionListener(e -> deplacer(d.toLowerCase()));
            panelBoutons.add(b);
        }
        add(panelBoutons, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        miseAJourAffichage("Bienvenue " + joueur.getNom());
        afficherCarte();
    }

    private void creerJoueur() {
        String nom = JOptionPane.showInputDialog(this, "Nom du personnage :");
        String[] castes = {"guerrier","sorcier","elfe"};
        String caste = (String) JOptionPane.showInputDialog(this,"Choisissez votre caste :", "Caste",
                JOptionPane.QUESTION_MESSAGE,null,castes,castes[0]);
        joueur = new Personnage(nom, caste);
    }

    private void miseAJourAffichage(String texte) { affichage.append(texte+"\n"); }

    private void afficherCarte() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                sb.append(carte.getCase(i,j)).append(" ");
            }
            sb.append("\n");
        }
        miseAJourAffichage(sb.toString());
    }

    private void deplacer(String direction){
        boolean fin = carte.deplacer(direction,joueur);
        afficherCarte();
        if(fin) JOptionPane.showMessageDialog(this,"🎉 Vous avez atteint la sortie !");
    }
}

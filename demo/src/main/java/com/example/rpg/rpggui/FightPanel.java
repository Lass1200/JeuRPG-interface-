package com.example.rpg.rpggui;

import javax.swing.*;
import java.awt.*;
import com.example.rpg.*;

public class FightPanel extends JDialog {
    private Personnage joueur;
    private Destructible cible; // Monster ou Obstacle
    private MainWindow parent;

    public FightPanel(MainWindow parent, Personnage joueur, Destructible cible) {
        super(parent, "Combat", true);
        this.joueur = joueur;
        this.cible = cible;
        this.parent = parent;

        setLayout(new GridLayout(3,1,5,5));

        JLabel lbl = new JLabel("Vous rencontrez " + getNomCible() + " !");
        add(lbl);

        JButton attackBtn = new JButton("Attaquer");
        attackBtn.addActionListener(e -> {
            attaquer();
        });
        add(attackBtn);

        JButton fleeBtn = new JButton("Fuir");
        fleeBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,"Vous fuyez le combat !");
            dispose();
        });
        add(fleeBtn);

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private String getNomCible() {
        if(cible instanceof Monster) return ((Monster)cible).getNom();
        else if(cible instanceof Obstacle) return ((Obstacle)cible).getNom();
        return "???";
    }

    private void attaquer() {
        if(joueur.getInventaire().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Vous n'avez pas d'arme pour attaquer !");
            return;
        }

        // On attaque avec la première arme pour simplifier
        Armes arme = joueur.getInventaire().get(0);
        if(cible instanceof Monster) {
            arme.attaquer((Monster)cible);
            if(((Monster)cible).estMort()) {
                JOptionPane.showMessageDialog(this,"Vous avez tué le monstre !");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Monstre restant : " + ((Monster)cible).getLife());
            }
        } else if(cible instanceof Obstacle) {
            arme.attaquer((Obstacle)cible);
            if(((Obstacle)cible).estDetruit()) {
                JOptionPane.showMessageDialog(this,"Vous avez détruit l'obstacle !");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Obstacle restant : " + ((Obstacle)cible).getLife());
            }
        }
        parent.refreshInfo();
    }
}

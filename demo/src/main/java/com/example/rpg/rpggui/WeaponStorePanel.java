package com.example.rpg.rpggui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.example.rpg.Armes;
import com.example.rpg.Magasin;
import com.example.rpg.Personnage;

public class WeaponStorePanel extends JDialog {
    private Personnage joueur;
    private MainWindow parent;
    private Magasin magasin;

    public WeaponStorePanel(MainWindow parent, Personnage joueur) {
        super(parent, "Boutique d'armes", true);
        this.parent = parent;
        this.joueur = joueur;
        magasin = new Magasin();

        setLayout(new GridLayout(0,1));
        for(int i=0;i<magasin.getStock().size();i++) {
            Armes a = magasin.getStock().get(i);
            JButton b = new JButton(a.getNom() + " ("+a.getPrix()+"$)");
            int index = i;
            b.addActionListener(e -> {
                if(magasin.AcheterArme(joueur,index)) {
                    JOptionPane.showMessageDialog(this,"Achat réussi !");
                    parent.refreshInfo();
                } else {
                    JOptionPane.showMessageDialog(this,"Pas assez d'argent !");
                }
            });
            add(b);
        }

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}

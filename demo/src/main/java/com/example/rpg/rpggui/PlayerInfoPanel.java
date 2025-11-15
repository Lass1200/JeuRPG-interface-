package com.example.rpg.rpggui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.example.rpg.Personnage;

public class PlayerInfoPanel extends JPanel {
    private Personnage joueur;
    private JTextArea info;

    public PlayerInfoPanel(Personnage joueur) {
        this.joueur = joueur;
        setLayout(new BorderLayout());
        info = new JTextArea(20,15);
        info.setEditable(false);
        add(new JScrollPane(info), BorderLayout.CENTER);
        refresh();
    }

    public void refresh() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : ").append(joueur.getNom()).append("\n");
        sb.append("Caste : ").append(joueur.getCaste()).append("\n");
        sb.append("PV : ").append(joueur.getPv()).append("\n");
        sb.append("Mana : ").append(joueur.getMana()).append("\n");
        sb.append("Argent : ").append(joueur.getArgent()).append("\n");
        sb.append("XP : ").append(joueur.getXp()).append("\n\n");
        sb.append("Inventaire :\n");
        for(int i=0;i<joueur.getInventaire().size();i++) {
            sb.append("- ").append(joueur.getInventaire().get(i).getNom()).append("\n");
        }
        info.setText(sb.toString());
    }
}

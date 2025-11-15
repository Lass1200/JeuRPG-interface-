package com.example.rpg.rpggui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.example.rpg.Personnage;

public class MenuStartPanel {
    private JDialog dialog;
    private Personnage joueur;
    private JFrame parent;

    public MenuStartPanel(JFrame parent) {
        this.parent = parent;
    }

    public void showDialog() {
        dialog = new JDialog(parent, "Créer personnage", true);
        dialog.setLayout(new GridLayout(4,2,5,5));

        dialog.add(new JLabel("Nom :"));
        JTextField tfNom = new JTextField();
        dialog.add(tfNom);

        dialog.add(new JLabel("Caste :"));
        String[] castes = {"guerrier","sorcier","elfe"};
        JComboBox<String> cbCaste = new JComboBox<>(castes);
        dialog.add(cbCaste);

        JButton start = new JButton("Start");
        start.addActionListener(e -> {
            joueur = new Personnage(tfNom.getText(), (String)cbCaste.getSelectedItem());
            dialog.dispose();
        });

        JButton cancel = new JButton("Annuler");
        cancel.addActionListener(e -> {
            joueur = null;
            dialog.dispose();
        });

        dialog.add(start);
        dialog.add(cancel);

        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }

    public Personnage getJoueur() {
        return joueur;
    }
}

package com.example.rpg.rpggui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.example.rpg.Carte;

public class MapPanel extends JPanel {
    private Carte carte;

    public MapPanel(Carte carte) {
        this.carte = carte;
        setPreferredSize(new Dimension(300,300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = 50;
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                char c = carte.getCase(i,j);
                switch(c) {
                    case 'J': g.setColor(Color.BLUE); break;
                    case 'S': g.setColor(Color.GREEN); break;
                    case 'M': g.setColor(Color.RED); break;
                    case 'O': g.setColor(Color.GRAY); break;
                    default: g.setColor(Color.WHITE); break;
                }
                g.fillRect(j*size,i*size,size,size);
                g.setColor(Color.BLACK);
                g.drawRect(j*size,i*size,size,size);
            }
        }
    }
}

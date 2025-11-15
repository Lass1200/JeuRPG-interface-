package com.example.rpg;

import javax.swing.SwingUtilities;

import com.example.rpg.rpggui.MainWindow;

public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindow();
        });
    }
}

package com.damas.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Interface gráfica para representar uma casa do tabuleiro.
 */
public class CasaGUI extends JButton {
    public static final Color COR_CLARA = new Color(255, 255, 250);
    public static final Color COR_ESCURA = new Color(87, 168, 124);

    private int x;
    private int y;
    private Color cor;
    private TabuleiroGUI tabuleiro;

    public CasaGUI(int x, int y, Color cor, TabuleiroGUI tabuleiro) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        this.tabuleiro = tabuleiro;

        setBackground(cor);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(cor, 1));

        addActionListener(e -> tabuleiro.getJanela().reagir(this));
    }

    public int getPosicaoX() {
        return x;
    }

    public int getPosicaoY() {
        return y;
    }

    public void destacar() {
        setBackground(Color.GREEN);
    }

    public void atenuar() {
        setBackground(cor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}

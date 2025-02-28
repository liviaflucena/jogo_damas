package com.damas.gui;

import com.damas.objetos.Jogo;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Janela principal do jogo de damas.
 */
public class JanelaPrincipal extends JFrame {
    private Jogo jogo;
    private boolean primeiroClique;
    private CasaGUI casaOrigem;
    private TabuleiroGUI tabuleiroGUI;

    public JanelaPrincipal() {
        initComponents();
        criarNovoJogo();
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    public void reagir(CasaGUI casa) {
        if (primeiroClique) {
            if (casa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Clique em uma peça.");
            } else {
                casaOrigem = casa;
                casaOrigem.destacar();
                primeiroClique = false;
            }
        } else {
            jogo.moverPeca(casaOrigem.getPosicaoX(), casaOrigem.getPosicaoY(), casa.getPosicaoX(), casa.getPosicaoY());
            casaOrigem.atenuar();
            primeiroClique = true;
            atualizar();
        }
    }

    private void criarNovoJogo() {
        jogo = new Jogo();
        atualizar();
    }

    private void atualizar() {
        tabuleiroGUI.atualizar(jogo);
    }

    private void initComponents() {
        tabuleiroGUI = new TabuleiroGUI(this);
        add(tabuleiroGUI);
    }
}

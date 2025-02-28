package com.damas.gui;

import java.awt.Color;
import javax.swing.JPanel;
import com.damas.objetos.Casa;
import com.damas.objetos.Jogo;
import com.damas.objetos.Peca;

/**
 * Interface gráfica do tabuleiro.
 */
public class TabuleiroGUI extends JPanel {
    private CasaGUI[][] casas;
    private JanelaPrincipal janela;

    public TabuleiroGUI(JanelaPrincipal janela) {
        this.janela = janela;
        initComponents();
        criarCasas();
    }

    private void criarCasas() {
        casas = new CasaGUI[8][8];
        for (int y = 7; y >= 0; y--) {
            for (int x = 0; x < 8; x++) {
                Color cor = ((x + y) % 2 == 0) ? CasaGUI.COR_CLARA : CasaGUI.COR_ESCURA;
                casas[x][y] = new CasaGUI(x, y, cor, this);
                add(casas[x][y]);
            }
        }
    }

    public void atualizar(Jogo jogo) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                CasaGUI casaGUI = casas[x][y];
                Casa casa = jogo.getTabuleiro().getCasa(x, y);

                if (casa.possuiPeca()) {
                    Peca peca = casa.getPeca();
                    casaGUI.setText(peca.getCor() == com.damas.objetos.CorPeca.BRANCA ? "B" : "V");
                } else {
                    casaGUI.setText("");
                }
            }
        }
    }

    public JanelaPrincipal getJanela() {
        return janela;
    }

    private void initComponents() {
        setLayout(new java.awt.GridLayout(8, 8));
    }
}

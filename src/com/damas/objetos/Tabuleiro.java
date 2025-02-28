package com.damas.objetos;

/**
 * Classe representando o tabuleiro do jogo de damas
 */
public class Tabuleiro {
    private static final int TAMANHO = 8;
    private Casa[][] casas;
    
    public Tabuleiro() {
        casas = new Casa[TAMANHO][TAMANHO];
        for (int x = 0; x < TAMANHO; x++) {
            for (int y = 0; y < TAMANHO; y++) {
                casas[x][y] = new Casa(x, y);
            }
        }
    }
    
    public Casa getCasa(int x, int y) {
        if (x >= 0 && x < TAMANHO && y >= 0 && y < TAMANHO) {
            return casas[x][y];
        }
        return null;
    }
}

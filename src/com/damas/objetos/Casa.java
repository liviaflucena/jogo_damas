package com.damas.objetos;

/**
 * Representa uma Casa do tabuleiro.
 * Possui uma posição (x, y) e pode conter uma Peça.
 */
public class Casa {

    private final int x;
    private final int y;
    private Peca peca;

    public Casa(int x, int y) {
        this.x = x;
        this.y = y;
        this.peca = null;
    }

    /**
     * Coloca uma peça nesta casa.
     * @param peca a Peça a ser posicionada nesta Casa.
     * @throws IllegalStateException se a casa já contiver uma peça.
     */
    public void colocarPeca(Peca peca) {
        if (this.peca != null) {
            throw new IllegalStateException("A casa já contém uma peça.");
        }
        this.peca = peca;
    }

    /**
     * Remove a peça posicionada nesta casa, se houver.
     */
    public void removerPeca() {
        peca = null;
    }

    /**
     * @return a Peça posicionada nesta Casa, ou null se a casa estiver livre.
     */
    public Peca getPeca() {
        return peca;
    }

    /**
     * @return true se existe uma peça nesta casa, caso contrário false.
     */
    public boolean possuiPeca() {
        return peca != null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Casa (" + x + ", " + y + ")";
    }
}
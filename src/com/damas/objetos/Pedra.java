package com.damas.objetos;

/**
 * Classe representando uma Pedra no jogo de damas
 */
public class Pedra implements Peca {
    protected Casa casa;
    protected CorPeca cor;
    
    public Pedra(Casa casa, CorPeca cor) {
        this.casa = casa;
        this.cor = cor;
        casa.colocarPeca(this);
    }
    
    @Override
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }
    
    @Override
    public boolean isMovimentoValido(Casa destino) {
        int distanciaX = Math.abs(destino.getX() - casa.getX());
        int distanciaY = Math.abs(destino.getY() - casa.getY());
        return distanciaX == 1 && distanciaY == 1;
    }
    
    @Override
    public CorPeca getCor() {
        return cor;
    }
}

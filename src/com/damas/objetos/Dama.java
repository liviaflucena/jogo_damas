package com.damas.objetos;

/**
 * Classe representando uma Dama no jogo de damas
 */
public class Dama extends Pedra {
    public Dama(Casa casa, CorPeca cor) {
        super(casa, cor);
    }
    
    @Override
    public boolean isMovimentoValido(Casa destino) {
        int distanciaX = Math.abs(destino.getX() - casa.getX());
        int distanciaY = Math.abs(destino.getY() - casa.getY());
        return distanciaX == distanciaY;
    }
}

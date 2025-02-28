package com.damas.objetos;

/**
 * Interface representando uma peça no jogo de damas
 */
public interface Peca {
    void mover(Casa destino);
    boolean isMovimentoValido(Casa destino);
    CorPeca getCor();
}

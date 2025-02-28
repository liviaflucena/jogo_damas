package com.damas.objetos;

import java.util.List;

/**
 * Representa uma Peça do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 * @author José Alisson Rocha da Silva {@link jose.alisson2@academico.ufpb.br}
 */
public class Pedra implements Peca {

    protected Casa casa;
    protected CorPeca corPeca;
    protected String tipoPedra;
    protected int sentido;

    /**
     * @param casa Objeto Casa
     * @param tipo int tipo de peça (0 = Pedra Branca, 2 = Pedra vermelha) 
     */
    public Pedra(Casa casa, CorPeca corPeca) {
        this.casa = casa;
        this.corPeca = corPeca;
        this.tipoPedra = corPeca == CorPeca.BRANCA ? "pedra_branca":"pedra_vermelha";
        this.sentido =  corPeca == CorPeca.BRANCA ? 1 : -1;

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

        // SENTIDO UNITÁRIO E DISTANCIA X E Y DA CASA ATUAL ATÉ A CASA DE DESTINO
        int distanciaX = Math.abs(destino.getX() - casa.getX());
        int distanciaY = Math.abs(destino.getY() - casa.getY());

        if ((distanciaX == 0) || (distanciaY == 0)) return false;

        // REGRA DE MOVIMENTO NO CASO DA DISTÂNCIA SER DE 2 CASAS (MOVIMENTO DE COMER PEÇA)
        if ((distanciaX <= 2 || distanciaY <= 2) && (distanciaX == distanciaY)) {
            return true;
        }

        return false;
    }

    @Override
    public CorPeca getCorPeca() {
        return corPeca;
    }

    @Override
    public String getTipoPeca() {
        return tipoPedra;
    }

    public boolean ehDaMesmaCor(Pedra outraPedra){
        return this.corPeca == outraPedra.getCorPeca();
    }

    @Override
    public boolean ehMovimentoValido(Tabuleiro tabuleiro, Casa origem, Casa destino, List<Casa> pecasAComer) {
        if (destino.getPeca() != null) return false;

        int sentidoX = destino.getX() - origem.getX();
        int sentidoY = destino.getY() - origem.getY();
        int distanciaX = Math.abs(sentidoX);
        int distanciaY = Math.abs(sentidoY);

        if ((distanciaX == 0) || (distanciaY == 0)) return false;

        sentidoX /= distanciaX;
        sentidoY /= distanciaY;

        // REGRA DE MOVIMENTO DAS PEDRAS VERMELHAS
        if (distanciaX == 1 && distanciaY == 1 && sentidoY == this.sentido) {
            return true;
        }

        // REGRA DE MOVIMENTO DAS PEDRAS NO TABULEIRO CASO A DISTÂNCIA ATÉ A CASA CLICADA SEJA DE 2 BLOCOS
        if (distanciaX == 2 && distanciaY == 2) {
            Casa casa = tabuleiro.getCasa((origem.getX() + sentidoX), (origem.getY() + sentidoY));
            Pedra pecaIntermediaria = casa.getPeca();

            if (pecaIntermediaria != null && (!pecaIntermediaria.ehDaMesmaCor(this))) {
                pecasAComer.add(casa);
                return true;
            }
        }

        return false;
    }
    @Override
    public boolean podeTransformarParaDama(Casa destino) {
        return (corPeca == CorPeca.BRANCA && destino.getY() == 7) || 
               (corPeca == CorPeca.VERMELHA && destino.getY() == 0);
    }

    public Pedra transfomarEmDama(Casa casa){
        return new Dama(casa, this.corPeca);
    }
    @Override
    public boolean isPedra() {
        return true;
    }


}

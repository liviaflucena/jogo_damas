package com.damas.objetos;

import java.util.List;

/**
 * Interface com os métodos abstratos das peças
 * @author João Victor da S. Cirilo {@link joao.cirilo@academico.ufpb.br}
 */
public interface Peca {
    

    /**
     * Movimenta a peca para uma nova casa. Antes de trocar de casa a Peca armazena a casa no
     * campo ultimaCasa, isso servirá para verificar qual sentido em que a peça se moveu para
     * implementar a lógica de comer peças.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino);
    
    /**
     * Implementa a regra de movimento da peça
     * @param destino - tipo {@code Casa} destino da peça
     * @return {@code boolean}
     */
    public boolean isMovimentoValido(Casa destino);

    /**
     * Retorna o tipo da peça
     * @return
     * {@code int} 0 - {@code Pedra} branca
     * <li>{@code int} 1 - {@code Dama} branca</li>
     * <li>{@code int} 2 - {@code Pedra} vermelha</li>
     * <li>{@code int} 3 - {@code Dama} verelha</li>
     */
    public CorPeca getCorPeca();
    public String getTipoPeca();
    public boolean ehMovimentoValido(Tabuleiro tabuleiro, Casa origem, Casa destino, List<Casa> pecasAComer);
    public boolean podeTransformarParaDama(Casa destino);
    public boolean isPedra();
}

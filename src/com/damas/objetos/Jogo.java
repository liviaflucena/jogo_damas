package com.damas.objetos;

/**
 * Classe responsável por gerenciar a lógica do jogo de damas.
 */
public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogadorBranco;
    private Jogador jogadorVermelho;
    private int vezAtual; // 1 = Branco, 2 = Vermelho

    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        this.jogadorBranco = new Jogador("Jogador Branco");
        this.jogadorVermelho = new Jogador("Jogador Vermelho");
        this.vezAtual = 1;
        iniciarJogo();
    }

    private void iniciarJogo() {
        // Posiciona peças brancas e vermelhas
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 3; y++) {
                if ((x + y) % 2 == 1) {
                    tabuleiro.getCasa(x, y).colocarPeca(new Pedra(tabuleiro.getCasa(x, y), CorPeca.BRANCA));
                }
            }
            for (int y = 5; y < 8; y++) {
                if ((x + y) % 2 == 1) {
                    tabuleiro.getCasa(x, y).colocarPeca(new Pedra(tabuleiro.getCasa(x, y), CorPeca.VERMELHA));
                }
            }
        }
    }

    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();

        if (peca == null || !isTurnoValido(peca)) return;

        if (peca.isMovimentoValido(destino)) {
            origem.removerPeca();
            peca.mover(destino);
            verificarPromocao(destino);
            trocarDeVez();
        }
    }

    private boolean isTurnoValido(Peca peca) {
        return (vezAtual == 1 && peca.getCor() == CorPeca.BRANCA) ||
               (vezAtual == 2 && peca.getCor() == CorPeca.VERMELHA);
    }

    private void verificarPromocao(Casa casa) {
        Peca peca = casa.getPeca();
        if (peca instanceof Pedra && (casa.getY() == 7 || casa.getY() == 0)) {
            casa.removerPeca();
            new Dama(casa, peca.getCor());
        }
    }

    private void trocarDeVez() {
        vezAtual = (vezAtual == 1) ? 2 : 1;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public int getVezAtual() {
        return vezAtual;
    }

    public Jogador getJogadorBranco() {
        return jogadorBranco;
    }

    public Jogador getJogadorVermelho() {
        return jogadorVermelho;
    }
}

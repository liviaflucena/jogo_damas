package com.damas.objetos;

/**
 * Classe representando um jogador no jogo de damas
 */
public class Jogador {
    private String nome;
    private int pontos;
    
    public Jogador(String nome) {
        this.nome = (nome.length() > 16) ? "Anônimo" : nome;
        this.pontos = 0;
    }
    
    public void addPonto() {
        pontos++;
    }
    
    public int getPontos() {
        return pontos;
    }
    
    public String getNome() {
        return nome;
    }
}

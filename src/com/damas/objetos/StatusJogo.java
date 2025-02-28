package com.damas.objetos;

public class StatusJogo {
    private Jogo jogo;


    public StatusJogo(Jogo jogo) {
        this.jogo = jogo;
    }


    public String gerarStatus(){
        StringBuilder retorno = new StringBuilder();
         retorno.append("Vez: ") ;
        if (jogo.getVez() == 1) { 
            retorno.append(jogo.getNomeJogadorUm())  ;
            retorno.append("\n")  ;
        } else if (jogo.getVez() == 2) {
            retorno.append(jogo.getNomeJogadorDois())  ;
            retorno.append("\n")  ;
        }

        retorno.append("Nº de jogadas: ").append(jogo.getJogada()).append("\n");
        retorno.append("Jogadas sem comer peça: ").append(jogo.getJogadasSemComerPecas()).append("\n");
        retorno.append("\n");
       
        retorno.append("Informações do(a) jogador(a) ").append(jogo.getNomeJogadorUm()).append("\n");
        retorno.append("Pontos: " ).append(jogo.getPontosJogadorUm()).append("\n");
        retorno.append("Nº de peças restantes: ").append(12 - jogo.getPontosJogadorDois()).append("\n") ;
        retorno.append("\n");        
        retorno.append( "Informações do(a) jogador(a) ").append( jogo.getNomeJogadorDois()).append("\n");
        retorno.append("Pontos: ").append(jogo.getPontosJogadorDois()).append("\n");
        retorno.append("Nº de peças restantes: ").append((12 - jogo.getPontosJogadorUm())).append("\n");

        if (jogo.getCasaBloqueada() != null) {
            retorno.append("\n");
            retorno.append("Mova a peça na casa ").append(jogo.getCasaBloqueadaX()).append(":");
            retorno.append(jogo.getCasaBloqueadaY()).append("!");
        }
        return retorno.toString();

    }

}

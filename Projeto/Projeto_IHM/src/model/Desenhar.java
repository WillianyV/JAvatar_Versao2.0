/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.JogoPanel;
import view.Mensagens;
import Util.Util;
import view.Tela;

/**
 *
 * @author willi
 */
public class Desenhar extends Thread {

    private JogoPanel jogoPanel;
    private Tela tela;

    public Desenhar(Tela tela) {
        this.jogoPanel = tela.getJogoPanel();
        this.tela = tela;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if(Util.tempo % 470 == 0 && Util.efeitosSonorosMusica){
                    Sons.tocar(Util.MUSICA_TEMA);
                    Util.tempo++;
                }else{
                    Util.tempo++;
                }                
                Thread.sleep(1000 / 13);                
                
                if (jogoPanel.getPersonagem1().getHp() <= 0) {
                    jogoPanel.getRelogio().suspend();
                    jogoPanel.getPersonagem1().animacaoPerdeu();
                    tela.getJogoPanel().atualizarBarraVida(0, 1);
                    Util.flagPerdeu = true;

                } else if (jogoPanel.getPersonagem2().getHp() <= 0) {
                    jogoPanel.getRelogio().suspend();
                    jogoPanel.getPersonagem2().animacaoPerdeu();
                    tela.getJogoPanel().atualizarBarraVida(0, 2);
                    Util.flagGanhou = true;
                }
                GameLoop.draw(tela);

                jogoPanel.getPersonagem1().animaAtaque();
                jogoPanel.getPersonagem2().animaAtaque();
                
                if (Util.flagAtacandoPoder1) {
                    
                    jogoPanel.getPersonagem1().elementosAtaques();
                    if (jogoPanel.colide(jogoPanel.getPersonagem1().getAtaqueSprite(), jogoPanel.getPersonagem2().getPersonagem(), 
                            Util.DIREITA)) {
                        Util.flagFerido2 = true;
                        jogoPanel.getPersonagem1().inicializarElementoAtaque();
                        jogoPanel.getAtaqueJogador().aparencia = jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?11:13;
                                                
                    }
                  Util.VEZ_JOGADOR = true;
                }
                if (Util.flagAtacandoPoder2) {
                    jogoPanel.getPersonagem2().elementosAtaques();
                    if (jogoPanel.colide(jogoPanel.getPersonagem2().getAtaqueSprite(), jogoPanel.getPersonagem1().getPersonagem(), Util.ESQUERDA)) {
                        Util.flagFerido = true;
                        jogoPanel.getPersonagem2().inicializarElementoAtaque();
                    }
                }

                if (Util.flagFerido2) {
                    jogoPanel.getPersonagem2().ferido();
                    if (jogoPanel.getPersonagem2().getPersonagem().aparencia == 28) {
                        int dano = jogoPanel.getPersonagem2().getDefesa() - (jogoPanel.getPersonagem1().getAtaque());
                        if (dano <= 0) {
                            jogoPanel.getPersonagem2().setHp(jogoPanel.getPersonagem2().getHp() + dano);
                            jogoPanel.atualizarBarraVida(jogoPanel.getPersonagem2().getHp(), 2);
                            jogoPanel.getPersonagem2().setDefesa(0);
                            jogoPanel.getDefesaAdversario().aparencia = Util.SOKKA.equals(jogoPanel.getPersonagem2().getNomePersonagem())?11:13;
                            jogoPanel.getIconsAdversarioSprite().aparencia = Util.controleDeIconsAdversario(jogoPanel.getPersonagem2().getDefesa(), jogoPanel.getPersonagem2().getAtaque()); 
                        } else {
                            jogoPanel.getPersonagem2().setDefesa(dano);
                        }
                        jogoPanel.getPersonagem1().setAtaque(0);
                        jogoPanel.getIconsJogadorSprite().aparencia = Util.controleDeIcons(jogoPanel.getPersonagem1().getDefesa(), jogoPanel.getPersonagem1().getAtaque());
                        
                        
                    }
                }
                if (Util.flagFerido) {
                	jogoPanel.getAtaqueAdversario().aparencia = jogoPanel.getPersonagem2().getNomePersonagem().equals(Util.SOKKA)?11:13;
                	jogoPanel.getPersonagem1().ferido();
                    if (jogoPanel.getPersonagem1().getPersonagem().aparencia == 10) {
                        int danoP1 = jogoPanel.getPersonagem1().getDefesa() - (jogoPanel.getPersonagem2().getAtaque() * Util.multiplicador);
                        jogoPanel.getPersonagem1().setDefesa(0);
	                    if(!(jogoPanel.getDefesaJogador().aparencia == (Util.SOKKA.equals(jogoPanel.getPersonagem1().getNomePersonagem())?20:24))) {
	                    	 Util.MAGIA_ATIVA_DEFESA = false; 
	                    }
                       
                        jogoPanel.getIconsJogadorSprite().aparencia = Util.controleDeIcons(jogoPanel.getPersonagem1().getDefesa(), jogoPanel.getPersonagem1().getAtaque());
                        
                        if (danoP1 < 0) {
                            jogoPanel.getPersonagem1().setHp(jogoPanel.getPersonagem1().getHp() + danoP1);
                            jogoPanel.atualizarBarraVida(jogoPanel.getPersonagem1().getHp(), 1);
                        }
                        jogoPanel.getPersonagem2().setAtaque(0);
                        jogoPanel.getIconsAdversarioSprite().aparencia = Util.controleDeIconsAdversario(jogoPanel.getPersonagem2().getDefesa(), jogoPanel.getPersonagem2().getAtaque()); 
                        
                    }
                   Util.VEZ_JOGADOR = true;
                }
                if (Util.flagAtacandoPoder2) {

                    if (jogoPanel.colideAtaques(jogoPanel.getPersonagem2().getAtaqueSprite(), jogoPanel.getPersonagem1().getPersonagem(), Util.ESQUERDA)) {
                    	
                        if (jogoPanel.getPersonagem1().getDefesa() > 0) { 
                    		Util.flagDefedendo = true;
                            Util.flagAtacandoP1 = true;
                        }

                    }

                }

                if (Util.flagDefedendo) {

                    if (jogoPanel.colide(jogoPanel.getPersonagem1().getAtaqueSprite(), jogoPanel.getPersonagem2().getAtaqueSprite(), Util.DIREITA)) {
                       
                    	
                        Util.flagAtacandoP1 = false;
                        jogoPanel.getPersonagem1().inicializarElementoAtaque();
                        jogoPanel.getPersonagem2().inicializarElementoAtaque();
                        
                        Util.flagAtacandoPoder2 = false;
                        if(jogoPanel.getPersonagem1().getDefesa() <= jogoPanel.getPersonagem2().getAtaque() ){
                        	
                        	
                            jogoPanel.getDefesaJogador().aparencia = jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?11:13;
                            jogoPanel.getIconsJogadorSprite().aparencia = Util.controleDeIcons(jogoPanel.getPersonagem1().getDefesa(), jogoPanel.getPersonagem1().getAtaque());
                            Util.flagFerido = true; 
                        }
                        Util.flagDefedendo = false;
                        Util.flagAtacandoPoder1 = false;
                        
                        jogoPanel.getPersonagem1().getPersonagem().aparencia = 10;
                        
                    }
                    Util.VEZ_JOGADOR = true;
                }

            } catch (InterruptedException ex) {
                Mensagens.messagemErro("Erro ao desenhar jogo!\n" + ex);
            }
        }
    }

}

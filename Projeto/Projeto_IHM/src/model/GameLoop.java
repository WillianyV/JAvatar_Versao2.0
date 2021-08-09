/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import view.InicialPanel;
import view.JogoPanel;
import view.Tela;
import view.TutorialPanel;

/**
 *
 * @author willi
 */
public class GameLoop {

    public static void draw(Tela tela) {
        JogoPanel jogoPanel = tela.getJogoPanel();
        TutorialPanel tutorialPanel = tela.getTutorialPanel();
        InicialPanel inicialPanel = tela.getInicialPanel();

        Graphics2D graficos = (Graphics2D) jogoPanel.getGraphics();
        Graphics desenharBuffer = tela.getBuffer().getGraphics();
        graficos.drawImage(tela.getBuffer(), 0, 0, null);
         
        if(tutorialPanel.isVisible()) {
        	desenharBuffer.drawImage(tutorialPanel.getImagensAjudaSprite().sprites[tutorialPanel.getImagensAjudaSprite().aparencia],
        			tutorialPanel.getImagensAjudaSprite().posX,
        			tutorialPanel.getImagensAjudaSprite().posY, null);
            if((tutorialPanel.getImagensAjudaSprite().aparencia <6)) {
            	  desenharBuffer.drawImage(tutorialPanel.getIrSprite().sprites[tutorialPanel.getIrSprite().aparencia],
            			  tutorialPanel.getIrSprite().posX,
            			  tutorialPanel.getIrSprite().posY, null);
            }
            if(!(tutorialPanel.getImagensAjudaSprite().aparencia == 0)) {
            	desenharBuffer.drawImage(tutorialPanel.getVoltarSprite().sprites[tutorialPanel.getVoltarSprite().aparencia],
            			tutorialPanel.getVoltarSprite().posX,
            			tutorialPanel.getVoltarSprite().posY, null);
            }
            if(tutorialPanel.getImagensAjudaSprite().aparencia == 6) {
            	desenharBuffer.drawImage(tutorialPanel.getFinalizarSprite().sprites[tutorialPanel.getFinalizarSprite().aparencia],
            			tutorialPanel.getFinalizarSprite().posX,
            			tutorialPanel.getFinalizarSprite().posY, null);
            }  
            desenharBuffer.drawImage(tutorialPanel.getHomeSprite().sprites[tutorialPanel.getHomeSprite().aparencia],
            		tutorialPanel.getHomeSprite().posX,
            		tutorialPanel.getHomeSprite().posY, null);
            desenharBuffer.drawImage(tutorialPanel.getPularSprite().sprites[tutorialPanel.getPularSprite().aparencia],
            		tutorialPanel.getPularSprite().posX,
            		tutorialPanel.getPularSprite().posY, null);
           
        }
        
              
        if(Util.TUTORIAL && !tutorialPanel.isVisible()) {
        	 //Ajuda
            desenharBuffer.drawImage(jogoPanel.getImagensAjudaSprite().sprites[jogoPanel.getImagensAjudaSprite().aparencia],
                    jogoPanel.getImagensAjudaSprite().posX,
                    jogoPanel.getImagensAjudaSprite().posY, null);
            if((jogoPanel.getImagensAjudaSprite().aparencia <6)) {
            	  desenharBuffer.drawImage(jogoPanel.getIrSprite().sprites[jogoPanel.getIrSprite().aparencia],
                          jogoPanel.getIrSprite().posX,
                          jogoPanel.getIrSprite().posY, null);
            }
            if(!(jogoPanel.getImagensAjudaSprite().aparencia == 0)) {
            	desenharBuffer.drawImage(jogoPanel.getVoltarSprite().sprites[jogoPanel.getVoltarSprite().aparencia],
                        jogoPanel.getVoltarSprite().posX,
                        jogoPanel.getVoltarSprite().posY, null);
            }
            if(jogoPanel.getImagensAjudaSprite().aparencia == 6) {
            	desenharBuffer.drawImage(jogoPanel.getJogarSprite().sprites[jogoPanel.getJogarSprite().aparencia],
                        jogoPanel.getJogarSprite().posX,
                        jogoPanel.getJogarSprite().posY, null);
            }            
            desenharBuffer.drawImage(jogoPanel.getHomeSprite().sprites[jogoPanel.getHomeSprite().aparencia],
                    jogoPanel.getHomeSprite().posX,
                    jogoPanel.getHomeSprite().posY, null);
            desenharBuffer.drawImage(jogoPanel.getPularSprite().sprites[jogoPanel.getPularSprite().aparencia],
                    jogoPanel.getPularSprite().posX,
                    jogoPanel.getPularSprite().posY, null);
        }

        if (jogoPanel.isVisible() && !Util.TUTORIAL) {
            //imagem de fundo
            desenharBuffer.drawImage(jogoPanel.getImagemDeFundo().getImage(), 0, 0, null);

            //mostrar textos
            desenharBuffer.setFont(Util.chewy);
            desenharBuffer.setColor(Util.color);
            	//pontuação
            if(!Util.CARTA_MAO_VISIVEL) {
            	desenharBuffer.drawString("" + jogoPanel.getPersonagem1().getPontos(), 900, 600);
            }
            
            
            	//nick
            desenharBuffer.drawString(tela.getJogador().getNick() , 480, 650);            
            desenharBuffer.drawString(jogoPanel.getPersonagem2().getNomePersonagem() , 480, 150);
            
            //desenhar cronometro
            desenharBuffer.setColor(Color.BLACK);
            desenharBuffer.drawString(jogoPanel.getRelogio().getTexto(),865,280);
            
            //icones do jogadores
//            desenharBuffer.drawImage(jogoPanel.getJogador1Icon().getImage(), 480, 570, jogoPanel);
//            desenharBuffer.drawImage(jogoPanel.getJogador2Icon().getImage(), 480, 70, jogoPanel);
            
            //sprites
            //bordas            
            if(Util.VEZ_JOGADOR) {
            	desenharBuffer.drawImage(jogoPanel.getBordaJogadorSprite().sprites[jogoPanel.getBordaJogadorSprite().aparencia],
                		jogoPanel.getBordaJogadorSprite().posX,
                		jogoPanel.getBordaJogadorSprite().posY, null);
            }  
            //icones do jogadores
            desenharBuffer.drawImage(jogoPanel.getJogador1Icon().getImage(), 480, 570, jogoPanel);
            if(!Util.VEZ_JOGADOR){
            	desenharBuffer.drawImage(jogoPanel.getBordaAdversarioSprite().sprites[jogoPanel.getBordaAdversarioSprite().aparencia],
                		jogoPanel.getBordaAdversarioSprite().posX,
                		jogoPanel.getBordaAdversarioSprite().posY, null);
            }
            //icones do jogadores
            desenharBuffer.drawImage(jogoPanel.getJogador2Icon().getImage(), 480, 70, jogoPanel);
            
            //barra HP
            desenharBuffer.drawImage(jogoPanel.getHpJogador1Sprite().sprites[jogoPanel.getHpJogador1Sprite().aparencia],
                    jogoPanel.getHpJogador1Sprite().posX,
                    jogoPanel.getHpJogador1Sprite().posY, null);
            desenharBuffer.drawImage(jogoPanel.getHpJogador2Sprite().sprites[jogoPanel.getHpJogador2Sprite().aparencia],
                    jogoPanel.getHpJogador2Sprite().posX,
                    jogoPanel.getHpJogador2Sprite().posY, null);
            //icones de VS
            desenharBuffer.drawImage(jogoPanel.getVsEsquerda().getImage(), 770, 210, jogoPanel);
            desenharBuffer.drawImage(jogoPanel.getVsDireita().getImage(), 990, 210, jogoPanel);
            //sprites
            //botões do jogo:
            desenharBuffer.drawImage(jogoPanel.getBtnHomeSprite().sprites[jogoPanel.getBtnHomeSprite().aparencia],
            		jogoPanel.getBtnHomeSprite().posX,
            		jogoPanel.getBtnHomeSprite().posY, null);
            desenharBuffer.drawImage(jogoPanel.getBtnConfigSprite().sprites[jogoPanel.getBtnConfigSprite().aparencia],
            		jogoPanel.getBtnConfigSprite().posX,
            		jogoPanel.getBtnConfigSprite().posY, null);
            desenharBuffer.drawImage(jogoPanel.getBtnJogarNovamenteSprite().sprites[jogoPanel.getBtnJogarNovamenteSprite().aparencia],
            		jogoPanel.getBtnJogarNovamenteSprite().posX,
            		jogoPanel.getBtnJogarNovamenteSprite().posY, null);
            desenharBuffer.drawImage(jogoPanel.getSairJogoBtnSprite().sprites[jogoPanel.getSairJogoBtnSprite().aparencia],
            		jogoPanel.getSairJogoBtnSprite().posX,
            		jogoPanel.getSairJogoBtnSprite().posY, null);
            
            if(!Util.CARTA_MAO_VISIVEL) {
            	desenharBuffer.drawImage(jogoPanel.getBtnCartanaMaoSprite().sprites[jogoPanel.getBtnCartanaMaoSprite().aparencia],
            			jogoPanel.getBtnCartanaMaoSprite().posX,
            			jogoPanel.getBtnCartanaMaoSprite().posY, null);
            	
            	desenharBuffer.drawImage(jogoPanel.getBtnFimDeTurnoSprite().sprites[jogoPanel.getBtnFimDeTurnoSprite().aparencia],
            			jogoPanel.getBtnFimDeTurnoSprite().posX,
            			jogoPanel.getBtnFimDeTurnoSprite().posY, null);
            }
            
            //Jogador 1
            desenharBuffer.drawImage(jogoPanel.getPersonagem1().getPersonagem().sprites[jogoPanel.getPersonagem1().getPersonagem().aparencia],
                    jogoPanel.getPersonagem1().getPersonagem().posX,
                    jogoPanel.getPersonagem1().getPersonagem().posY, null);
            if (Util.flagAtacandoPoder1) {
                desenharBuffer.drawImage(jogoPanel.getPersonagem1().getAtaqueSprite().sprites[jogoPanel.getPersonagem1().getAtaqueSprite().aparencia],
                        jogoPanel.getPersonagem1().getAtaqueSprite().posX,
                        jogoPanel.getPersonagem1().getAtaqueSprite().posY, null);
            }
            //Jogador 2
            desenharBuffer.drawImage(jogoPanel.getPersonagem2().getPersonagem().sprites[jogoPanel.getPersonagem2().getPersonagem().aparencia],
                    jogoPanel.getPersonagem2().getPersonagem().posX,
                    jogoPanel.getPersonagem2().getPersonagem().posY, null);
            if (Util.flagAtacandoPoder2) {
                desenharBuffer.drawImage(jogoPanel.getPersonagem2().getAtaqueSprite().sprites[jogoPanel.getPersonagem2().getAtaqueSprite().aparencia],
                        jogoPanel.getPersonagem2().getAtaqueSprite().posX,
                        jogoPanel.getPersonagem2().getAtaqueSprite().posY, null);
            }
            //ataque e defesa jogador
            if(!Util.CARTA_MAO_VISIVEL) {
            	desenharBuffer.drawImage(jogoPanel.getAtaqueJogador().sprites[jogoPanel.getAtaqueJogador().aparencia],
                		jogoPanel.getAtaqueJogador().posX, 
                		jogoPanel.getAtaqueJogador().posY, null);
                
                desenharBuffer.drawImage(jogoPanel.getDefesaJogador().sprites[jogoPanel.getDefesaJogador().aparencia],
                		jogoPanel.getDefesaJogador().posX, 
                		jogoPanel.getDefesaJogador().posY, null);
            }
            
          //ataque e defesa adversario
            desenharBuffer.drawImage(jogoPanel.getAtaqueAdversario().sprites[jogoPanel.getAtaqueAdversario().aparencia],
            		jogoPanel.getAtaqueAdversario().posX, 
            		jogoPanel.getAtaqueAdversario().posY, null);
            
            desenharBuffer.drawImage(jogoPanel.getDefesaAdversario().sprites[jogoPanel.getDefesaAdversario().aparencia],
            		jogoPanel.getDefesaAdversario().posX, 
            		jogoPanel.getDefesaAdversario().posY, null);
            
            if(!Util.CARTA_MAO_VISIVEL && Util.ARRASTANDO) {
          	  desenharBuffer.drawImage(jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].sprites[jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].aparencia],
                  		jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posX, 
                  		jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posY, null);
            } 
            
            //cartas Mão
          if(Util.CARTA_MAO_VISIVEL) {
        	  for(int i = 0 ; i <5; i++ ) {
           	   desenharBuffer.drawImage(jogoPanel.getMaoJogadorSprite()[i].sprites[jogoPanel.getMaoJogadorSprite()[i].aparencia],
                  		jogoPanel.getMaoJogadorSprite()[i].posX, 
                  		jogoPanel.getMaoJogadorSprite()[i].posY, null);

              }
          }
                    
           //icones dos jogadores (dos poderes para ve se estão ativados)
          if(!Util.CARTA_MAO_VISIVEL) {
        	  desenharBuffer.drawImage(jogoPanel.getIconsJogadorSprite().sprites[jogoPanel.getIconsJogadorSprite().aparencia],
           		   jogoPanel.getIconsJogadorSprite().posX,
           		   jogoPanel.getIconsJogadorSprite().posY, null);
          }
           
           desenharBuffer.drawImage(jogoPanel.getIconsAdversarioSprite().sprites[jogoPanel.getIconsAdversarioSprite().aparencia],
        		   jogoPanel.getIconsAdversarioSprite().posX,
        		   jogoPanel.getIconsAdversarioSprite().posY, null);
           
           if(Util.CARTA_MAO_VISIVEL) {
               desenharBuffer.drawImage(jogoPanel.getBtnFecharCartasSprite().sprites[jogoPanel.getBtnFecharCartasSprite().aparencia],
               		jogoPanel.getBtnFecharCartasSprite().posX,
               		jogoPanel.getBtnFecharCartasSprite().posY, null);
           }
           
           if(Util.CONFIG_VISIVEL) {
        	   desenharBuffer.drawImage(jogoPanel.getBackPanelConfigSprite().sprites[jogoPanel.getBackPanelConfigSprite().aparencia],
                  		jogoPanel.getBackPanelConfigSprite().posX,
                  		jogoPanel.getBackPanelConfigSprite().posY, null);
        	   desenharBuffer.drawImage(jogoPanel.getBtnSairPanelConfigSprite().sprites[jogoPanel.getBtnSairPanelConfigSprite().aparencia],
                 		jogoPanel.getBtnSairPanelConfigSprite().posX,
                 		jogoPanel.getBtnSairPanelConfigSprite().posY, null);
        	   desenharBuffer.drawImage(jogoPanel.getBtnMusicaPanelConfigSprite().sprites[jogoPanel.getBtnMusicaPanelConfigSprite().aparencia],
                		jogoPanel.getBtnMusicaPanelConfigSprite().posX,
                		jogoPanel.getBtnMusicaPanelConfigSprite().posY, null);
        	   desenharBuffer.drawImage(jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().sprites[jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().aparencia],
               		jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().posX,
               		jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().posY, null);
        	   desenharBuffer.drawImage(jogoPanel.getBtnAjudaPanelConfigSprite().sprites[jogoPanel.getBtnAjudaPanelConfigSprite().aparencia],
                  		jogoPanel.getBtnAjudaPanelConfigSprite().posX,
                  		jogoPanel.getBtnAjudaPanelConfigSprite().posY, null);
        	   desenharBuffer.drawImage(jogoPanel.getBtnYouTubePanelConfigSprite().sprites[jogoPanel.getBtnYouTubePanelConfigSprite().aparencia],
                 		jogoPanel.getBtnYouTubePanelConfigSprite().posX,
                 		jogoPanel.getBtnYouTubePanelConfigSprite().posY, null);
           }
          
	         if(Util.CHAMAR_MSG_PANEL_JOGO) {
	        	 Util.CARTA_MAO_VISIVEL = false;
	         	 desenharBuffer.drawImage(jogoPanel.getMsgJogoPanelSprite().sprites[jogoPanel.getMsgJogoPanelSprite().aparencia],
	                		jogoPanel.getMsgJogoPanelSprite().posX,
	                		jogoPanel.getMsgJogoPanelSprite().posY, null);
	         	 
//	         	 desenharBuffer.drawImage(jogoPanel.getBtnOkaySprite().sprites[jogoPanel.getBtnOkaySprite().aparencia],
//	                		jogoPanel.getBtnOkaySprite().posX,
//	                		jogoPanel.getBtnOkaySprite().posY, null);	         	 
	         }
           
            //Panel de Perguntas          
            jogoPanel.getPerguntasPanel().repaint();

            //Imagens das perguntas
            if ((jogoPanel.getImagemPerguntas() != null) && jogoPanel.getPerguntasPanel().isVisible()) {
                desenharBuffer.drawImage(jogoPanel.getImagemPerguntas().getImage(), 20, 350, null);
            }

           // jogoPanel.getSairIcon().repaint();
           // jogoPanel.getBotaoFimTurno().repaint();
            
//            if(!Util.CARTA_MAO_VISIVEL) {
//            	jogoPanel.getBtnCartasNaMao().repaint();
//                jogoPanel.getBtnFimDeTurno().repaint();
//            }
            
            if (Util.flagGanhou) {
                desenharBuffer.drawImage(jogoPanel.getVcGanhouIcon().getImage(), 835, 350, null);
            } else if (Util.flagPerdeu) {
                desenharBuffer.drawImage(jogoPanel.getVcPerdeuIcon().getImage(), 835, 350, null);
            }
            

        } else if (tela.getInicialPanel().isVisible()) {
            desenharBuffer.drawImage(tela.getInicialPanel().getVcGanhouIcon().getImage(), 600, 400, null);
            desenharBuffer.drawImage(tela.getInicialPanel().getBackIcon().getImage(), 0, 0, null);
          
//            if(Util.MOSTRAR_PERSONAGEM) {
//            	desenharBuffer.drawImage(tela.getInicialPanel().getPersonagemAvatar().getImage(),100, 230, null);
//            	
//            }
            
            //icons do menu
            desenharBuffer.drawImage(tela.getInicialPanel().getSomBotaoIcon().getImage(), 1128, 7, null);
            desenharBuffer.drawImage(tela.getInicialPanel().getAjudaBotaoIcon().getImage(), 1173, 7, null);
            desenharBuffer.drawImage(tela.getInicialPanel().getYoutubeBotaoIcon().getImage(), 1218, 7, null);
            desenharBuffer.drawImage(tela.getInicialPanel().getInfoBotaoIcon().getImage(), 1263, 7, null);
            desenharBuffer.drawImage(tela.getInicialPanel().getBtnSairJogoPaginaInicialSprite().sprites[tela.getInicialPanel().getBtnSairJogoPaginaInicialSprite().aparencia],
          			tela.getInicialPanel().getBtnSairJogoPaginaInicialSprite().posX,
          			tela.getInicialPanel().getBtnSairJogoPaginaInicialSprite().posY, null);
            
            // desenhar som e info
            if(Util.CHAMAR_SOM_SPRITE||Util.CHAMAR_SOBRE_SPRITE){
            	desenharBuffer.drawImage(tela.getInicialPanel().getSobreSomSprite().sprites[tela.getInicialPanel().getSobreSomSprite().aparencia],
              			tela.getInicialPanel().getSobreSomSprite().posX,
              			tela.getInicialPanel().getSobreSomSprite().posY, null);
                desenharBuffer.drawImage(tela.getInicialPanel().getBotãoSairSobreSomSprite().sprites[tela.getInicialPanel().getBotãoSairSobreSomSprite().aparencia],
              			tela.getInicialPanel().getBotãoSairSobreSomSprite().posX,
              			tela.getInicialPanel().getBotãoSairSobreSomSprite().posY, null);
                if(Util.CHAMAR_SOM_SPRITE) {
                	desenharBuffer.drawImage(tela.getInicialPanel().getMusicaBotaoSprite().sprites[tela.getInicialPanel().getMusicaBotaoSprite().aparencia],
                  			tela.getInicialPanel().getMusicaBotaoSprite().posX,
                  			tela.getInicialPanel().getMusicaBotaoSprite().posY, null);
                	desenharBuffer.drawImage(tela.getInicialPanel().getEfeitoBotaoSprite().sprites[tela.getInicialPanel().getEfeitoBotaoSprite().aparencia],
                  			tela.getInicialPanel().getEfeitoBotaoSprite().posX,
                  			tela.getInicialPanel().getEfeitoBotaoSprite().posY, null);
                }
            }
            
            //desenhar carta (AVATAR) do personaguem
            desenharBuffer.drawImage(tela.getInicialPanel().getJogador1Sprite().sprites[tela.getInicialPanel().getJogador1Sprite().aparencia],
          			tela.getInicialPanel().getJogador1Sprite().posX,
          			tela.getInicialPanel().getJogador1Sprite().posY, null);
            desenharBuffer.drawImage(tela.getInicialPanel().getJogador2Sprite().sprites[tela.getInicialPanel().getJogador2Sprite().aparencia],
          			tela.getInicialPanel().getJogador2Sprite().posX,
          			tela.getInicialPanel().getJogador2Sprite().posY, null);
            
            desenharBuffer.setColor(Util.color);
        	desenharBuffer.setFont(Util.chewy);
        	desenharBuffer.drawString(Util.NOME_JOGADOR, 110, 515);
        	
            //desenhar cont
        	if(Util.DESENHAR_CONT) {
        		desenharBuffer.drawImage(tela.getInicialPanel().getContSprite().sprites[tela.getInicialPanel().getContSprite().aparencia],
              			tela.getInicialPanel().getContSprite().posX,
              			tela.getInicialPanel().getContSprite().posY, null);
        	} 
            
            // colocar spirtes em paneil inicial
          if(Util.CHAMAR_MSG_PANEL_INICIAL) {
          	desenharBuffer.drawImage(tela.getInicialPanel().getMsgSprite().sprites[tela.getInicialPanel().getMsgSprite().aparencia],
          			tela.getInicialPanel().getMsgSprite().posX,
          			tela.getInicialPanel().getMsgSprite().posY, null);
          	desenharBuffer.drawImage(inicialPanel.getBtnOkaySprite().sprites[tela.getInicialPanel().getBtnOkaySprite().aparencia],
          			tela.getInicialPanel().getBtnOkaySprite().posX,
          			tela.getInicialPanel().getBtnOkaySprite().posY, null);
          }
            
          	desenharBuffer.drawImage(tela.getInicialPanel().getCustomizarBotaoIcon().getImage(), 586, 530, null);
          	desenharBuffer.drawImage(tela.getInicialPanel().getJogarBotaoIcon().getImage(), 586, 470, null);
          	
//            tela.getInicialPanel().getCustomizarBotaoLabel().repaint();
//            tela.getInicialPanel().getJogarBotaoLabel().repaint();
//            tela.getInicialPanel().getSomLabel().repaint();
//            tela.getInicialPanel().getInfoLabel().repaint();
//            tela.getInicialPanel().getSobreLabel().repaint();

            if (tela.getInicialPanel().getSomPanel().isVisible()) {
                tela.getInicialPanel().getSomPanel().repaint();
            } else if (tela.getInicialPanel().getSobrePanel().isVisible()) {
                tela.getInicialPanel().getSobrePanel().repaint();
            } else if (tela.getInicialPanel().getInfoPanel().isVisible()) {
                tela.getInicialPanel().getInfoPanel().repaint();
            } else if (tela.getInicialPanel().getCustomizarPanel().isVisible()) {
                tela.getInicialPanel().getCustomizarPanel().repaint();
            }

            if ((tela.getJogador().getIcone() != null)) {
                if (tela.getJogador().getIcone().equals(Util.AANG)) {
                    tela.getInicialPanel().getMostrarAangLabel().repaint();
                } else if (tela.getJogador().getIcone().equals(Util.KATARA)) {
                    tela.getInicialPanel().getMostrarKataraLabel().repaint();
                } else if (tela.getJogador().getIcone().equals(Util.SOKKA)) {
                    tela.getInicialPanel().getMostrarSokkaLabel().repaint();
                } else if (tela.getJogador().getIcone().equals(Util.TOPH)) {
                    tela.getInicialPanel().getMostrarTophLabel().repaint();
                } else if (tela.getJogador().getIcone().equals(Util.ZUCO)) {
                    tela.getInicialPanel().getMostrarZucoLabel().repaint();
                }
              //  tela.getInicialPanel().getNomeJLabel().repaint();
            }
            

        }

    }

}

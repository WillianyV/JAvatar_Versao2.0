/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.Util;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Carta;
import model.Sons;
import view.InicialPanel;
import view.JogoPanel;
import view.Mensagens;
import view.Tela;

/**
 *
 * @author willi
 */
public class ControladorPanelJogo {

	private Tela tela;
	private JogoPanel jogoPanel;
	private ControladorJogo controladorJogo;
	private Color color;
	private ControladorPanelInicial controladorPanelInicial;


	public ControladorPanelJogo(Tela tela, ControladorPanelInicial controladorPanelInicial) {
		this.tela = tela;
		this.controladorPanelInicial = controladorPanelInicial;

		jogoPanel = tela.getJogoPanel();

		controladorJogo = new ControladorJogo();
		color = new Color(227, 229, 224);

		jogoPanel.getPerguntasPanel().getProximoButton().addActionListener(controladorJogo);
		jogoPanel.getPerguntasPanel().getPularButton().addActionListener(controladorJogo);
//		jogoPanel.getPerguntasPanel().getAnteriorButton().addActionListener(controladorJogo);
		jogoPanel.getPerguntasPanel().getAlternativaALabel().addMouseListener(controladorJogo);
		jogoPanel.getPerguntasPanel().getAlternativaBLabel().addMouseListener(controladorJogo);
		jogoPanel.getPerguntasPanel().getAlternativaCLabel().addMouseListener(controladorJogo);
		jogoPanel.getPerguntasPanel().getAlternativaDLabel().addMouseListener(controladorJogo);
		jogoPanel.getSairIcon().addMouseListener(controladorJogo);
		jogoPanel.getBtnCartasNaMao().addMouseListener(controladorJogo);
		jogoPanel.getBtnFimDeTurno().addMouseListener(controladorJogo);

		jogoPanel.addMouseListener(controladorJogo);
		jogoPanel.addMouseMotionListener(controladorJogo);


	}

	private class ControladorJogo implements ActionListener, MouseListener, MouseMotionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!(Util.flagGanhou || Util.flagPerdeu)) {
				if(!(Util.TURNO_ADVERSARIO)) {
					if (e.getSource() == jogoPanel.getPerguntasPanel().getProximoButton()) {
						if (jogoPanel.getPerguntasPanel().getAlternativaALabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaBLabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaCLabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaDLabel().getBackground() == color) {

							if(!Util.PERGUNTA_NAO_RESPONDIDA ) {
								jogoPanel.getPerguntasPanel().setVisible(false);
							}else {
								jogoPanel.getPerguntasPanel().setVisible(true);
							}
							inicializarP();
							if(Util.pular < 3) {
								jogoPanel.getPerguntasPanel().getPularButton().setVisible(true);
							}
						} 
					}
					else if(e.getSource() == jogoPanel.getPerguntasPanel().getPularButton()) {
						if (Util.pular < 3) {
							inicializarP();
							Util.pular++;
							Util.PULOU_QUESTAO = true;
//							jogoPanel.getPerguntasPanel().getAnteriorButton().setVisible(true);
							if(Util.pular == 3) {
								jogoPanel.getPerguntasPanel().getPularButton().setVisible(false);
							}
							
						}
						
					}
//					else if(e.getSource() == jogoPanel.getPerguntasPanel().getAnteriorButton()) {
//						if(Util.PULOU_QUESTAO) {
//							jogoPanel.getPerguntasPanel().voltarPergunta();
//						}
//						jogoPanel.getPerguntasPanel().getAnteriorButton().setVisible(false);
//						
//					}
				}

			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {

			if (!(Util.flagGanhou || Util.flagPerdeu)) {
				if(Util.TUTORIAL) {
					if(jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.IR_BOTAO_AJUDA) {
						if(jogoPanel.getImagensAjudaSprite().aparencia <= 5) {
							jogoPanel.getImagensAjudaSprite().aparencia++;
						}
					}else if(jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.VOLTAR_BOTAO_AJUDA){
						if(jogoPanel.getImagensAjudaSprite().aparencia > 0) {
							jogoPanel.getImagensAjudaSprite().aparencia--;
						}
					}else if(((jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.JOGAR_BOTAO_AJUDA)
							&& (jogoPanel.getImagensAjudaSprite().aparencia == 6))
							|| (jogoPanel.colidBotaoPular(e.getX(), e.getY()) == Util.PULAR_BOTAO_AJUDA)) {
						try {
							if(Util.TUTORIAL_POR_CONFIG) {
								jogoPanel.getRelogio().resume();
							}else {
								jogoPanel.getRelogio().start();
							}								
						} catch (Exception ex) {
							jogoPanel.getRelogio().initRelogio();
							jogoPanel.getRelogio().resume();                        
						}
						Util.TUTORIAL = false;
						Util.TUTORIAL_POR_CONFIG = false;
					}
				}

				if(jogoPanel.colisaoBotaoMsg(e.getX(), e.getY()) == Util.OK_BOTAO_MSG_PANEL_JOGO) {
					Util.CHAMAR_MSG_PANEL_JOGO = false;
				}

				if(jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.CONFIG_BTN) {
					if(Util.CONFIG_VISIVEL) {
						Util.CONFIG_VISIVEL = false;
						jogoPanel.getRelogio().resume();
					}else {
						Util.CONFIG_VISIVEL = true;
						jogoPanel.getRelogio().suspend();
					}
				}

				//sair do config
				if(Util.CONFIG_VISIVEL && jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.CONFIG_BTN_SAIR) {
					Util.CONFIG_VISIVEL = false;
					jogoPanel.getRelogio().resume();
				}
				//musica
				if(Util.CONFIG_VISIVEL && jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.CONFIG_BTN_MUSICA) {
					if(Util.efeitosSonorosMusica) {
						tela.getInicialPanel().getMusicaBotaoSprite().aparencia++;
						jogoPanel.getBtnMusicaPanelConfigSprite().aparencia++;
						Util.efeitosSonorosMusica = false;						
						Sons.pararDeTocar();
					}else {
						tela.getInicialPanel().getMusicaBotaoSprite().aparencia--;
						jogoPanel.getBtnMusicaPanelConfigSprite().aparencia--;
						Util.efeitosSonorosMusica = true;
						Sons.tocar(Util.MUSICA_TEMA);
					}
				}
				//efeitos sonoros
				if(Util.CONFIG_VISIVEL && jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.CONFIG_BTN_EFEITOS_SONOROS) {
					if(Util.efeitosSonoros) {
						jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().aparencia++;
						Util.efeitosSonoros = false;
						tela.getInicialPanel().getEfeitoBotaoSprite().aparencia++;
					}else {
						jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().aparencia--;
						Util.efeitosSonoros = true;
						tela.getInicialPanel().getEfeitoBotaoSprite().aparencia--;
					}
				}
				if(Util.CONFIG_VISIVEL && jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.CONFIG_BTN_AJUDA) {
					Util.TUTORIAL_POR_CONFIG = true;
					Util.CONFIG_VISIVEL = false;

					Util.TUTORIAL=true;
				}
				
				if(Util.CONFIG_VISIVEL && jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.YOUTUBE_BOTAO_PANEL_JOGO) {
					Util.abrirLink();
				}

				if((!Util.TURNO_ADVERSARIO) && Util.PERGUNTA_NAO_RESPONDIDA && !Util.TUTORIAL) {
					if (e.getSource() == jogoPanel.getPerguntasPanel().getAlternativaALabel()) {
						if (jogoPanel.getPerguntasPanel().getAlternativaBLabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaCLabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaDLabel().getBackground() == color) {
						} else {
							jogoPanel.getPerguntasPanel().getAlternativaALabel().setBackground(color);
							if (jogoPanel.getPerguntasPanel().correcao(jogoPanel.getPerguntasPanel().getAlternativaALabel().getText())) {
								jogoPanel.getPersonagem1().pontuacao();
								jogoPanel.verificarUtilizacao();
							}
						}
						Util.TURNO_FLAG = true;
						Util.PERGUNTA_NAO_RESPONDIDA = false;
						//botao voltar
						Util.PULOU_QUESTAO = false;
//						jogoPanel.getPerguntasPanel().getAnteriorButton().setVisible(false);
						jogoPanel.getPerguntasPanel().getPularButton().setVisible(false);

					} else if (e.getSource() == jogoPanel.getPerguntasPanel().getAlternativaBLabel()) {
						if (jogoPanel.getPerguntasPanel().getAlternativaALabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaCLabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaDLabel().getBackground() == color) {
						} else {
							jogoPanel.getPerguntasPanel().getAlternativaBLabel().setBackground(color);
							if (jogoPanel.getPerguntasPanel().correcao(jogoPanel.getPerguntasPanel().getAlternativaBLabel().getText())) {
								jogoPanel.getPersonagem1().pontuacao();
								jogoPanel.verificarUtilizacao();
							}
						}
						Util.TURNO_FLAG = true;
						Util.PERGUNTA_NAO_RESPONDIDA = false;
						Util.PULOU_QUESTAO = false;
//						jogoPanel.getPerguntasPanel().getAnteriorButton().setVisible(false);
						jogoPanel.getPerguntasPanel().getPularButton().setVisible(false);
					} else if (e.getSource() == jogoPanel.getPerguntasPanel().getAlternativaCLabel()) {
						if (jogoPanel.getPerguntasPanel().getAlternativaALabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaBLabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaDLabel().getBackground() == color) {
						} else {
							jogoPanel.getPerguntasPanel().getAlternativaCLabel().setBackground(color);
							if (jogoPanel.getPerguntasPanel().correcao(jogoPanel.getPerguntasPanel().getAlternativaCLabel().getText())) {
								jogoPanel.getPersonagem1().pontuacao();
								jogoPanel.verificarUtilizacao();
							} 
						}
						Util.TURNO_FLAG = true;
						Util.PERGUNTA_NAO_RESPONDIDA = false;
						Util.PULOU_QUESTAO = false;
//						jogoPanel.getPerguntasPanel().getAnteriorButton().setVisible(false);
						jogoPanel.getPerguntasPanel().getPularButton().setVisible(false);
					} else if (e.getSource() == jogoPanel.getPerguntasPanel().getAlternativaDLabel()) {
						if (jogoPanel.getPerguntasPanel().getAlternativaALabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaBLabel().getBackground() == color
								|| jogoPanel.getPerguntasPanel().getAlternativaCLabel().getBackground() == color) {
						} else {
							jogoPanel.getPerguntasPanel().getAlternativaDLabel().setBackground(color);
							if (jogoPanel.getPerguntasPanel().correcao(jogoPanel.getPerguntasPanel().getAlternativaDLabel().getText())) {
								jogoPanel.getPersonagem1().pontuacao();
								jogoPanel.verificarUtilizacao();
							} 
						}
						Util.TURNO_FLAG = true;
						Util.PERGUNTA_NAO_RESPONDIDA = false;
						Util.PULOU_QUESTAO = false;
//						jogoPanel.getPerguntasPanel().getAnteriorButton().setVisible(false);
						jogoPanel.getPerguntasPanel().getPularButton().setVisible(false);
					}
				}else {
					if(!Util.MOSTRAR_MSG_PERGUNTA) {
						Util.MOSTRAR_MSG_PERGUNTA = true;
					}

				}

			}
			if(jogoPanel.colidBotaoPular(e.getX(), e.getY()) == Util.SAIR_JOGO_PANEL_JOGO) {
				System.exit(0);
			}			
			
			if(jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.JOGAR_NOVAMENTE_PANEL_JOGO) {
				jogoPanel.reiniciar();
				jogoPanel.reiniciar();
				jogoPanel.getPerguntasPanel().setVisible(true);
				jogoPanel.getPerguntasPanel().getPularButton().setVisible(true);
				Util.pular = 0 ;
				jogoPanel.getRelogio().initRelogio();
			}
			
			if (e.getSource() == jogoPanel.getSairIcon()) {
				jogoPanel.setVisible(false);
				tela.getInicialPanel().setVisible(true);
				Util.JOGO_INICIADO = false;

			}
			// botoes novos nem entra
			if(!Util.TUTORIAL) {
				if(jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.SAIR_BOTAO_CARTAS) {
					Util.CARTA_MAO_VISIVEL = false;
				}				
			}

			if(!Util.TUTORIAL) {
				if(e.getSource() == jogoPanel.getBtnFimDeTurno() && !Util.CARTA_MAO_VISIVEL) {
					Util.VEZ_JOGADOR = false;
					if(Util.efeitosSonoros && !(Util.flagPerdeu || Util.flagGanhou)) {
						if(Util.efeitosSonoros) {
							Sons.tocar(Util.AGORA_MINHA_VEZ);
						}
					}
					jogoPanel.getPersonagem2().setPontos(jogoPanel.getPersonagem2().getPontos() + 10);
					Util.TURNO_ADVERSARIO_ATACANDO = true;
					Util.PERGUNTA_NAO_RESPONDIDA = true;
					jogoPanel.getPerguntasPanel().setVisible(true);
					jogoPanel.roboAdversario();
					// Util.VEZ_JOGADOR = true;
				}

				if((e.getSource() == jogoPanel.getBtnCartasNaMao()) && (!Util.CARTA_MAO_VISIVEL) && !(Util.flagPerdeu || Util.flagGanhou)) {
					if(Util.efeitosSonoros) {
						Sons.tocar(Util.SOM_CARTA);
					}
					Util.CARTA_MAO_VISIVEL = true;
				} else if(jogoPanel.colisaoCartas(e.getX(), e.getY()) == 5 && Util.CARTA_MAO_VISIVEL) {
					if(Util.efeitosSonoros) {
						Sons.tocar(Util.SOM_CARTA);
					}
					Util.CARTA_MAO_VISIVEL = false;
				}

				if(!Util.TUTORIAL) {
					Util.CARTA_CLICADA = jogoPanel.colisaoCartas(e.getX(), e.getY());
					if( Util.CARTA_CLICADA < 5) {
						if(jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA] != null) {
							if(!((jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA) && 
									jogoPanel.getMaoJogadorSprite()[Util.CARTA_CLICADA].aparencia == 8)
									|| (!jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA) && 
											jogoPanel.getMaoJogadorSprite()[Util.CARTA_CLICADA].aparencia ==10))) {


								Util.APARENCIA_CARTA = jogoPanel.getMaoJogadorSprite()[Util.CARTA_CLICADA].aparencia;

								switch (jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA].getTipo()) {
								case Util.ATAQUE: {
									//verificar se a carta poed ser invocada
									if(jogoPanel.invocar(jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA], true) && Util.TURNO_FLAG ) {

										//deixar a carta vazia
										//jogoPanel.getMaoJogadorSprite()[Util.CARTA_CLICADA].aparencia = jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?8:10;
										//aparencia da carta com mais 10
										if(jogoPanel.getAtaqueJogador().aparencia == (jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?19:23)) {
											//somar 12 ou 14 a mais na aparencia da carta
											jogoPanel.getAtaqueJogador().aparencia = Util.APARENCIA_CARTA + (jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?12:14);
											jogoPanel.getPersonagem1().setAtaque(jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA].getPontos() + 10);
										}else{
											jogoPanel.getAtaqueJogador().aparencia = Util.APARENCIA_CARTA; 
											jogoPanel.getPersonagem1().setAtaque(jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA].getPontos());
										}

										Util.flagAtacandoP1 = true;
										//										if(jogoPanel.getAtaqueJogador().aparencia == (jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?19:23)) {
										//											jogoPanel.getPersonagem1().setAtaque(jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA].getPontos() + 10);
										//										}
										//jogoPanel.getPersonagem1().setAtaque(jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA].getPontos() + (Util.MAGIA_ATIVA_ATAQUE?10:0));

										//Util.TURNO_FLAG = false;


										Util.CARTAS_NA_MAO--;
										jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA] = null;

										jogoPanel.colocarCartaNaMao();
										jogoPanel.verificarUtilizacao();
										jogoPanel.getIconsJogadorSprite().aparencia = Util.controleDeIcons(jogoPanel.getPersonagem1().getDefesa(), jogoPanel.getPersonagem1().getAtaque());

										Util.MAGIA_ATIVA_ATAQUE = false;
										Util.CARTA_MAO_VISIVEL = false;

										if(Util.efeitosSonoros) {
											Sons.tocar(Util.SOM_CARTA);
										}
									}


									break;
								}
								case Util.DEFESA: {

									if(jogoPanel.invocar(jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA], true) && Util.TURNO_FLAG) {
										if(jogoPanel.getPersonagem1().getDefesa() == 0) {

											jogoPanel.getMaoJogadorSprite()[Util.CARTA_CLICADA].aparencia = jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?11:13;
											if(jogoPanel.getDefesaJogador().aparencia == (jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?20:24)) {
												jogoPanel.getDefesaJogador().aparencia = Util.APARENCIA_CARTA + (jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?12:14);
											}else{
												jogoPanel.getDefesaJogador().aparencia = Util.APARENCIA_CARTA; 
											}
											Util.flagDefesaP1 = true;
											jogoPanel.getPersonagem1().setDefesa(jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA].getPontos() + (Util.MAGIA_ATIVA_DEFESA?10:0));
											//Util.MAGIA_ATIVA_DEFESA = false;
											//Util.TURNO_FLAG = false;


											Util.CARTAS_NA_MAO--;
											jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA] = null;

											jogoPanel.colocarCartaNaMao();
											jogoPanel.verificarUtilizacao();

											//modificar sprites icons Magia Ataque Defesa
											jogoPanel.getIconsJogadorSprite().aparencia = Util.controleDeIcons(jogoPanel.getPersonagem1().getDefesa(), jogoPanel.getPersonagem1().getAtaque());

											Util.CARTA_MAO_VISIVEL = false;
										}else {
											jogoPanel.getPersonagem1().setPontos(jogoPanel.getPersonagem1().getPontos() + jogoPanel.getCartaMaoJogador()[Util.CARTA_CLICADA].getPontos());
										}

										if(Util.efeitosSonoros) {
											Sons.tocar(Util.SOM_CARTA);
										}
									}


									break;
								}

								}




							}

						}

					}else if(Util.CARTA_CLICADA == 6) {
						jogoPanel.colocarCartaNaMao();
						jogoPanel.verificarUtilizacao();
					}
				}
			}

		}



		@Override
		public void mousePressed(MouseEvent me) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(Util.ARRASTANDO && !Util.TUTORIAL) {


				if(jogoPanel.colisaoCartas(e.getX(), e.getY()) == 7) {
					jogoPanel.getAtaqueJogador().aparencia = (Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?19:23;
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].aparencia = (Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?8:10;
					Util.MAGIA_ATIVA_ATAQUE = true;
					jogoPanel.getCartaMaoJogador()[Util.CARTA_ARRASTADA] = null;
					Util.CARTAS_NA_MAO--;

					jogoPanel.getIconsJogadorSprite().aparencia = Util.controleDeIcons(jogoPanel.getPersonagem1().getDefesa(), jogoPanel.getPersonagem1().getAtaque());
					jogoPanel.colocarCartaNaMao();
					jogoPanel.verificarUtilizacao();
					if(jogoPanel.getDefesaJogador().aparencia == ((Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?8:10)) {
						jogoPanel.getDefesaJogador().aparencia = ((Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?11:13);
					}					

					if(Util.efeitosSonoros) {
						Sons.tocar(Util.SOM_CARTA_MAGIA);
					}

				}else if(jogoPanel.colisaoCartas(e.getX(), e.getY()) == 8) {
					Util.MAGIA_ATIVA_DEFESA = true;
					if(jogoPanel.getDefesaJogador().aparencia == ((Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?8:10)) {
						jogoPanel.getDefesaJogador().aparencia = (Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?20:24;
					}else {
						jogoPanel.getDefesaJogador().aparencia += (Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?12:14;
						jogoPanel.getPersonagem1().setDefesa(jogoPanel.getCartaMaoJogador()[Util.CARTA_ARRASTADA].getPontos() + 10);
						//Util.MAGIA_ATIVA_DEFESA = false;
					}					
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].aparencia = (Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?8:10;

					jogoPanel.getCartaMaoJogador()[Util.CARTA_ARRASTADA] = null;
					Util.CARTAS_NA_MAO--;
					jogoPanel.colocarCartaNaMao();
					jogoPanel.verificarUtilizacao();
					jogoPanel.getAtaqueJogador().aparencia = ((Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?11:13);

					jogoPanel.getIconsJogadorSprite().aparencia = Util.controleDeIcons(jogoPanel.getPersonagem1().getDefesa(), jogoPanel.getPersonagem1().getAtaque());

					if(Util.efeitosSonoros) {
						Sons.tocar(Util.SOM_CARTA_MAGIA);
					}
				}else {
					jogoPanel.getAtaqueJogador().aparencia = (Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?11:13;
					jogoPanel.getDefesaJogador().aparencia = (Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?11:13;
				}



				switch (Util.CARTA_ARRASTADA) {
				case 0: {
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posX = Util.POS_X_CARTAS[0];
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posY = Util.CARTAS_POS_Y;

					break;
				}
				case 1: {
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posX = Util.POS_X_CARTAS[1];
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posY = Util.CARTAS_POS_Y;
					break;
				}
				case 2: {
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posX = Util.POS_X_CARTAS[2];
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posY = Util.CARTAS_POS_Y;
					break;
				}
				case 3: {
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posX = Util.POS_X_CARTAS[3];
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posY = Util.CARTAS_POS_Y;
					break;
				}
				case 4: {
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posX = Util.POS_X_CARTAS[4];
					jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posY = Util.CARTAS_POS_Y;
					break;
				}
				}

				Util.ARRASTANDO = false;

			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {

			if (e.getSource() == jogoPanel.getSairIcon()) {
				jogoPanel.getSairIcon().setCursor(new Cursor(Cursor.HAND_CURSOR));}
			if(!Util.TUTORIAL) {
				if(e.getSource() == jogoPanel.getBtnFimDeTurno()) {
					jogoPanel.getBtnFimDeTurno().setCursor(new Cursor(Cursor.HAND_CURSOR));}

				if(e.getSource() == jogoPanel.getBtnCartasNaMao()) {
					jogoPanel.getBtnCartasNaMao().setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

			}
		}

		@Override
		public void mouseExited(MouseEvent me) {

		}

		@Override
		public void mouseDragged(MouseEvent e) {

			if(!Util.TUTORIAL) {
				Util.CARTA_CLICADA = jogoPanel.colisaoCartas(e.getX(), e.getY());


				if(Util.CARTA_CLICADA < 5) {
					Util.CARTA_ARRASTADA = Util.CARTA_CLICADA;

				}

				if(jogoPanel.getCartaMaoJogador()[Util.CARTA_ARRASTADA] != null) {
					if(jogoPanel.getCartaMaoJogador()[Util.CARTA_ARRASTADA].getTipo().equals(Util.MAGIA)) {
						jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posX = e.getX();
						jogoPanel.getMaoJogadorSprite()[Util.CARTA_ARRASTADA].posY = e.getY();
						Util.ARRASTANDO = true;
						Util.CARTA_MAO_VISIVEL = false;
						if((jogoPanel.getDefesaJogador().aparencia == ((Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?8:10))
								|| (jogoPanel.getDefesaJogador().aparencia == ((Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?11:13))
								|| (jogoPanel.getDefesaJogador().aparencia == ((Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?23:27))
								|| (jogoPanel.getDefesaJogador().aparencia == ((Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?35:41))) {
							jogoPanel.getDefesaJogador().aparencia = (Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?8:10;
						}
						jogoPanel.getAtaqueJogador().aparencia = (Util.SOKKA).equals(jogoPanel.getPersonagem1().getNomePersonagem())?7:9;

					}
				}
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if(!Util.TUTORIAL) {
				Util.CARTA_MAO_SELECIONADA = jogoPanel.colisaoCartas(e.getX(), e.getY());
				if(Util.CARTA_MAO_SELECIONADA < 5) {
					if(jogoPanel.getMaoJogadorSprite()[Util.CARTA_MAO_SELECIONADA].aparencia <= (jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?8:10)) {
						jogoPanel.getVisualizarCarta().aparencia = jogoPanel.getMaoJogadorSprite()[Util.CARTA_MAO_SELECIONADA].aparencia;
					}else {
						jogoPanel.getVisualizarCarta().aparencia = jogoPanel.getMaoJogadorSprite()[Util.CARTA_MAO_SELECIONADA].aparencia - (jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?9:11);
					}
				}else {
					jogoPanel.getVisualizarCarta().aparencia = jogoPanel.getPersonagem1().getNomePersonagem().equals(Util.SOKKA)?11:13;
				}
			}

			if(Util.CONFIG_VISIVEL && jogoPanel.colisaoCartas(e.getX(), e.getY()) != 5) {
				jogoPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}else if(jogoPanel.colisaoCartas(e.getX(), e.getY()) == Util.CONFIG_BTN) {
				jogoPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}else {
				jogoPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		}

		public void inicializarP() {
			jogoPanel.getPerguntasPanel().inicializarPergunta();
			jogoPanel.getPerguntasPanel().getAlternativaALabel().setBackground(Color.WHITE);
			jogoPanel.getPerguntasPanel().getAlternativaBLabel().setBackground(Color.WHITE);
			jogoPanel.getPerguntasPanel().getAlternativaCLabel().setBackground(Color.WHITE);
			jogoPanel.getPerguntasPanel().getAlternativaDLabel().setBackground(Color.WHITE);
			jogoPanel.getPerguntasPanel().getCoretoGifjLabel().setVisible(false);
			jogoPanel.getPerguntasPanel().getErradoGifjLabel().setVisible(false);
		}
	}


}


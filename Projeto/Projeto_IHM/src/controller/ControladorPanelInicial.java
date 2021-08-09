/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import model.Jogador;
import view.InicialPanel;
import view.Tela;
import Util.Util;
import model.Desenhar;
import model.Sons;
import view.JogoPanel;
import view.Mensagens;

/**
 *
 * @author willi
 */
public class ControladorPanelInicial {

	Tela tela;
	InicialPanel inicialPanel;
	Controlador controlador;
	Jogador jogador;
	JogoPanel jogoPanel;
	Desenhar desenhar;

	public ControladorPanelInicial(Tela tela) {
		this.tela = tela;
		this.inicialPanel = tela.getInicialPanel();
		this.jogador = tela.getJogador();
		this.jogoPanel = tela.getJogoPanel();

		desenhar = new Desenhar(tela);

		controlador = new Controlador();

		/*
        Visualizar paneis ao Clicar 
		 */
		//        inicialPanel.getCustomizarBotaoLabel().addMouseListener(controlador);
		//        inicialPanel.getJogarBotaoLabel().addMouseListener(controlador);
		//        inicialPanel.getSomLabel().addMouseListener(controlador);
		//        inicialPanel.getInfoLabel().addMouseListener(controlador);
		//        inicialPanel.getSobreLabel().addMouseListener(controlador);

		/*
        Botões da tela inicial
		 */
		//Botoões jogar
		//Botoões musica e efeitos
		inicialPanel.getMusicaToggleButton().addActionListener(controlador);
		inicialPanel.getEfeitosToggleButton().addActionListener(controlador);
		//Botões do personagem
		inicialPanel.getAangButton().addActionListener(controlador);
		inicialPanel.getKataraButton().addActionListener(controlador);
		inicialPanel.getSokkaButton().addActionListener(controlador);
		inicialPanel.getTophButton().addActionListener(controlador);
		inicialPanel.getZucoButton().addActionListener(controlador);

		inicialPanel.addMouseListener(controlador);

		inicialPanel.getNickTextField().addKeyListener(controlador);

	}

	private class Controlador implements MouseListener, ActionListener,KeyListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Botoões para escolher o personagem
			if (e.getSource() == inicialPanel.getAangButton()) {
				if (inicialPanel.getNickTextField().getText().equals("")) {
					tela.getInicialPanel().getMsgSprite().aparencia = 0;
					Util.CHAMAR_MSG_PANEL_INICIAL = true;
					// Mensagens.messagemInfo("Insira o seu Nick.");
				} else {
					jogador.setNick(inicialPanel.getNickTextField().getText());
					jogador.setIcone(Util.AANG);
					//Personagem da tela
					//       personagensInivisiveis();
					//                    inicialPanel.getMostrarAangLabel().setVisible(true);
					//                    inicialPanel.getNomeJLabel().setText(inicialPanel.getNickTextField().getText());
					//                    inicialPanel.getNomeJLabel().setVisible(true);
					paineisInvisiveis();
					//                    inicialPanel.setPersonagemAvatar(new ImageIcon("javatar.files\\Imagens\\personagens\\AangMostrar.png"));
					//                    Util.MOSTRAR_PERSONAGEM = true;
					inicialPanel.getJogador1Sprite().aparencia=1;
					Util.NOME_JOGADOR = jogador.getNick();
				}
			}
			if (e.getSource() == inicialPanel.getKataraButton()) {
				if (inicialPanel.getNickTextField().getText().equals("")) {
					tela.getInicialPanel().getMsgSprite().aparencia = 0;
					Util.CHAMAR_MSG_PANEL_INICIAL = true;
					//Mensagens.messagemInfo("Insira o seu Nick.");
				} else {
					jogador.setNick(inicialPanel.getNickTextField().getText());
					jogador.setIcone(Util.KATARA);
					//Personagem da tela
					//  personagensInivisiveis();
					//                    inicialPanel.getMostrarKataraLabel().setVisible(true);
					//                    inicialPanel.getNomeJLabel().setText(inicialPanel.getNickTextField().getText());
					//                    inicialPanel.getNomeJLabel().setVisible(true);
					//                    //Personagem da tela
					paineisInvisiveis();
					//                    inicialPanel.setPersonagemAvatar(new ImageIcon("javatar.files\\Imagens\\personagens\\KataraMostrar.png"));
					//                    Util.MOSTRAR_PERSONAGEM = true;
					inicialPanel.getJogador1Sprite().aparencia=2;
					Util.NOME_JOGADOR = jogador.getNick();
				}
			}
			if (e.getSource() == inicialPanel.getSokkaButton()) {

				if (inicialPanel.getNickTextField().getText().equals("")) {
					tela.getInicialPanel().getMsgSprite().aparencia = 0;
					Util.CHAMAR_MSG_PANEL_INICIAL = true;
					//Mensagens.messagemInfo("Insira o seu Nick.");
				} else {
					jogador.setNick(inicialPanel.getNickTextField().getText());
					jogador.setIcone(Util.SOKKA);
					//Personagem da tela
					//  personagensInivisiveis();
					//                    inicialPanel.getMostrarSokkaLabel().setVisible(true);
					//                    inicialPanel.getNomeJLabel().setText(inicialPanel.getNickTextField().getText());
					//                    inicialPanel.getNomeJLabel().setVisible(true);
					paineisInvisiveis();
					//                    inicialPanel.setPersonagemAvatar(new ImageIcon("javatar.files\\Imagens\\personagens\\SokkaMostrar.png"));
					//                    Util.MOSTRAR_PERSONAGEM = true;
					inicialPanel.getJogador1Sprite().aparencia=3;
					Util.NOME_JOGADOR = jogador.getNick();
				}

			}
			if (e.getSource() == inicialPanel.getTophButton()) {

				if (inicialPanel.getNickTextField().getText().equals("")) {
					tela.getInicialPanel().getMsgSprite().aparencia = 0;
					Util.CHAMAR_MSG_PANEL_INICIAL = true;
					//Mensagens.messagemInfo("Insira o seu Nick.");
				} else {
					jogador.setNick(inicialPanel.getNickTextField().getText());
					jogador.setIcone(Util.TOPH);
					//Personagem da tela
					//                    personagensInivisiveis();
					//                    inicialPanel.getMostrarTophLabel().setVisible(true);
					//                    inicialPanel.getNomeJLabel().setText(inicialPanel.getNickTextField().getText());
					//                    inicialPanel.getNomeJLabel().setVisible(true);
					paineisInvisiveis();
					//                    inicialPanel.setPersonagemAvatar(new ImageIcon("javatar.files\\Imagens\\personagens\\TophMostrar.png"));
					//                    Util.MOSTRAR_PERSONAGEM = true;
					inicialPanel.getJogador1Sprite().aparencia=4;
					Util.NOME_JOGADOR = jogador.getNick();
				}

			}
			if (e.getSource() == inicialPanel.getZucoButton()) {

				if (inicialPanel.getNickTextField().getText().equals("")) {
					tela.getInicialPanel().getMsgSprite().aparencia = 0;
					Util.CHAMAR_MSG_PANEL_INICIAL = true;
					//Mensagens.messagemInfo("Insira o seu Nick.");
				} else {
					jogador.setNick(inicialPanel.getNickTextField().getText());
					jogador.setIcone(Util.ZUCO);
					//Personagem da tela
					//                    personagensInivisiveis();
					//                    inicialPanel.getMostrarZucoLabel().setVisible(true);
					//                    inicialPanel.getNomeJLabel().setText(inicialPanel.getNickTextField().getText());
					//                    inicialPanel.getNomeJLabel().setVisible(true);
					paineisInvisiveis();
					//                    inicialPanel.setPersonagemAvatar(new ImageIcon("javatar.files\\Imagens\\personagens\\ZucoMostrar.png"));
					//                    Util.MOSTRAR_PERSONAGEM = true;
					inicialPanel.getJogador1Sprite().aparencia=5;
					Util.NOME_JOGADOR = jogador.getNick();
				}

			}
			//Botões do panel de musica
			if (e.getSource() == inicialPanel.getMusicaToggleButton()) {
				if (inicialPanel.getMusicaToggleButton().isSelected()) {
					inicialPanel.getMusicaToggleButton().setText("OFF");
					Util.efeitosSonorosMusica = false;
					Sons.pararDeTocar();
					jogoPanel.getBtnMusicaPanelConfigSprite().aparencia = 1;
					//Util.playMusic();
				} else {
					Sons.tocar(Util.MUSICA_TEMA);
					jogoPanel.getBtnMusicaPanelConfigSprite().aparencia = 0;
					inicialPanel.getMusicaToggleButton().setText("ON");
					Util.efeitosSonorosMusica = true;
					Util.tempo = 0 ;

				}
			}
			if (e.getSource() == inicialPanel.getEfeitosToggleButton()) {
				if (inicialPanel.getEfeitosToggleButton().isSelected()) {
					inicialPanel.getEfeitosToggleButton().setText("OFF");
					jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().aparencia= 1;
					Util.efeitosSonoros = false;
				} else {
					jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().aparencia= 0;
					inicialPanel.getEfeitosToggleButton().setText("ON");
					Util.efeitosSonoros = true;
				}
			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			/*
            MOSTRAR PAINEIS
			 */
			//Customizar
			if ((inicialPanel.colisaoBotaoMsg(e.getX(), e.getY()) == Util.CUSTOMIZAR_PANEL_INICIAL)) {
				if (inicialPanel.getCustomizarPanel().isVisible()) {
					paineisInvisiveis();
				} else {
					paineisInvisiveis();
					inicialPanel.getCustomizarPanel().setVisible(true);
				}
			} //Jogar
			else if ((inicialPanel.colisaoBotaoMsg(e.getX(), e.getY()) == Util.JOGAR_PANEL_INICIAL)) {
				if (!(jogador.getIcone() != null && jogador.getNick() != null)) {
					tela.getInicialPanel().getMsgSprite().aparencia = 1;
					Util.CHAMAR_MSG_PANEL_INICIAL = true;
					//Mensagens.mensagemExibir("Por favor digite o seu Nick e escolha o personagem.\n Click no bot�o Customizar");
				} else {
					jogoPanel.getPerguntasPanel().getPularButton().setVisible(true);
					Util.pular = 0 ;
					Util.JOGAR_NOVAMENTE=false;
					jogoPanel.inicializar(Util.ESQUERDA, jogador.getIcone());


					inicialPanel.getJogador2Sprite().aparencia = Util.mapAparenciaAdversario(jogoPanel.getPersonagem2().getNomePersonagem());

					Util.DESENHAR_CONT = true;
					inicialPanel.contagem();

					inicialPanel.setVisible(false);
					Util.JOGO_INICIADO = true;
					iniciarJogo();


					try {						
						jogoPanel.getRelogio().start();

					} catch (Exception ex) {
						jogoPanel.getRelogio().initRelogio();
						jogoPanel.getRelogio().resume();                        
					}

				}
			} //Som
			else if (inicialPanel.colisaoBotaoConfig(e.getX(), e.getY()) == Util.SOM_BOTAO_PANEL_INICIAL) {
				//				if (inicialPanel.getSomPanel().isVisible()) {
				//					paineisInvisiveis();
				//				} else {
				//					paineisInvisiveis();
				//					inicialPanel.getSomPanel().setVisible(true);
				//				}
				Util.CHAMAR_SOM_SPRITE = true;
				inicialPanel.getSobreSomSprite().aparencia = 1;
			} //Info
			else if (inicialPanel.colisaoBotaoConfig(e.getX(), e.getY()) == Util.AJUDA_BOTAO_PANEL_INICIAL) {
				//                if (inicialPanel.getInfoPanel().isVisible()) {
				//                    paineisInvisiveis();
				//                } else {
				//                    paineisInvisiveis();
				//                    inicialPanel.getInfoPanel().setVisible(true);
				//                }
				paineisInvisiveis();
				inicialPanel.setVisible(false);
				tela.getTutorialPanel().setVisible(true);
			}
			else if (inicialPanel.colisaoBotaoConfig(e.getX(), e.getY()) == Util.YOUTUBE_BOTAO_PANEL_INICIAL) {
				Util.abrirLink();
			}
			else if (inicialPanel.colisaoBotaoConfig(e.getX(), e.getY()) == Util.SAIR_BOTAO_PANEL_JOGO) {
				System.exit(0);
			}
			else if (inicialPanel.colisaoBotaoConfig(e.getX(), e.getY()) == Util.SAIR_PANEL_SOM_SOBRE) {
				Util.CHAMAR_SOBRE_SPRITE = false;
				Util.CHAMAR_SOM_SPRITE = false;
			}
			else if ((Util.CHAMAR_SOM_SPRITE) && (inicialPanel.colisaoBotaoConfig(e.getX(), e.getY()) == Util.MUSICA_PANEL_SOM)) {
				if(Util.efeitosSonorosMusica) {
					inicialPanel.getMusicaBotaoSprite().aparencia++;
					jogoPanel.getBtnMusicaPanelConfigSprite().aparencia++;
					Util.efeitosSonorosMusica = false;

					Sons.pararDeTocar();
				}else {
					inicialPanel.getMusicaBotaoSprite().aparencia--;
					jogoPanel.getBtnMusicaPanelConfigSprite().aparencia--;
					Util.efeitosSonorosMusica = true;
					Sons.tocar(Util.MUSICA_TEMA);
				}

			}
			else if ((Util.CHAMAR_SOM_SPRITE) && (inicialPanel.colisaoBotaoConfig(e.getX(), e.getY()) == Util.MUSICA_PANEL_SOM)) {
				if(Util.efeitosSonoros) {
					jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().aparencia++;
					Util.efeitosSonoros = false;
					inicialPanel.getEfeitoBotaoSprite().aparencia++;
				}else {
					jogoPanel.getBtnEfeitosSonorosPanelConfigSprite().aparencia--;
					Util.efeitosSonoros = true;
					inicialPanel.getEfeitoBotaoSprite().aparencia--;
				}
			}

			//Sobre
			else if (inicialPanel.colisaoBotaoConfig(e.getX(), e.getY()) == Util.INFO_BOTAO_PANEL_INICIAL) {
				Util.CHAMAR_SOBRE_SPRITE = true;
				inicialPanel.getSobreSomSprite().aparencia = 0;
			}
			else if ((inicialPanel.colisaoBotaoMsg(e.getX(), e.getY()) == Util.OK_BOTAO_MSG_PANEL_INICIAL) || 
					(inicialPanel.colisaoBotaoMsg(e.getX(), e.getY()) == 5)){
				Util.CHAMAR_MSG_PANEL_INICIAL = false;
			}


		}

		@Override
		public void mousePressed(MouseEvent me) {

		}

		@Override
		public void mouseReleased(MouseEvent me) {

		}

		@Override
		public void mouseEntered(MouseEvent me) {

		}

		@Override
		public void mouseExited(MouseEvent me) {

		}

		public void iniciarJogo() {
			jogoPanel.setVisible(true);
			jogoPanel.getPerguntasPanel().setVisible(true);
		}

		public void paineisInvisiveis() {
			inicialPanel.getCustomizarPanel().setVisible(false);
			inicialPanel.getSomPanel().setVisible(false);
			inicialPanel.getSobrePanel().setVisible(false);
			inicialPanel.getInfoPanel().setVisible(false);
		}

		public void personagensInivisiveis() {
			inicialPanel.getMostrarAangLabel().setVisible(false);
			inicialPanel.getMostrarKataraLabel().setVisible(false);
			inicialPanel.getMostrarSokkaLabel().setVisible(false);
			inicialPanel.getMostrarTophLabel().setVisible(false);
			inicialPanel.getMostrarZucoLabel().setVisible(false);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {


		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public Desenhar getDesenhar() {
		return desenhar;
	}

	public void setDesenhar(Desenhar desenhar) {
		this.desenhar = desenhar;
	}

}

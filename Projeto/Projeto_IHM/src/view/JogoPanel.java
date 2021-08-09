/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Util.Util;
import dao.XML;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

import model.Carta;
import model.Deck;
import model.Personagem;
import model.Relogio;
import model.Sprite;

/**
 *
 * @author willi
 */
public class JogoPanel extends JPanel {

	private ImageIcon jogador1Icon, jogador2Icon, imagemDeFundo, vsEsquerda, vsDireita, atacarIcon, vcPerdeuIcon, vcGanhouIcon;
	private static ImageIcon imagemPerguntas;
	private JLabel nomeLabel, sairIcon;
	private PerguntasPanel perguntasPanel;

	private Relogio relogio;

	private Personagem personagem1, personagem2;
	private boolean flagColidir = false;

	private Sprite hpJogador1Sprite, hpJogador2Sprite;

	private ArrayList<String> vsPersonagens;

	//private BufferedImage buffer;

	//Nova Versão:    
	private Deck deckInimigo, deckJogador;
	private Carta[] cartaMaoJogador;
	private Carta[] cartaAdversario;
	private ImageIcon[] imagensCartaMaoJogador, imagensCartaMaoAdversario;
	//private JLabel[] maosJogadorLabel, maosAdversarioLabel;
	private JLabel deckJogadorLabel,deckAdversarioLabel;
	private Sprite ataqueJogador, defesaJogador, magiaJogador,ataqueAdversario, defesaAdversario, visualizarCarta, iconsJogadorSprite, iconsAdversarioSprite;

	private JLabel btnCartasNaMao, btnFimDeTurno;

	private Sprite[] maoJogadorSprite, maoAdversarioSprite;

	private Sprite irSprite, voltarSprite, jogarSprite, pularSprite,homeSprite, imagensAjudaSprite; 

	//BOTÕES DO PANEL JOGO: 
	private Sprite btnHomeSprite, btnConfigSprite,btnFecharCartasSprite, btnCartanaMaoSprite,btnFimDeTurnoSprite;
	//bordas
	private Sprite bordaJogadorSprite, bordaAdversarioSprite;
	//sairPanelconfig,musicaPanelConfig,efeitosSonorosSomPanelConfig,ajudaPanelcnfig,bsck
	private Sprite backPanelConfigSprite, btnSairPanelConfigSprite,btnMusicaPanelConfigSprite,btnEfeitosSonorosPanelConfigSprite,btnAjudaPanelConfigSprite, btnYouTubePanelConfigSprite, btnJogarNovamenteSprite;
	private Sprite msgJogoPanelSprite;
	private JButton botaoFimTurno;
	private Sprite sairJogoBtnSprite;

	public JogoPanel() {
		setLayout(null);
		//	buffer = new BufferedImage(Util.LARGURA, Util.ALTURA, BufferedImage.TYPE_INT_ARGB);

		relogio = new Relogio(this);

		vsPersonagens = new ArrayList<String>();

		vsPersonagens.add(Util.AANG);
		vsPersonagens.add(Util.KATARA);
		vsPersonagens.add(Util.SOKKA);
		vsPersonagens.add(Util.TOPH);
		vsPersonagens.add(Util.ZUCO);

		personagem1 = new Personagem(Util.AANG);
		personagem1.inicializarSprite();
		personagem2 = new Personagem(Util.TOPH);
		personagem2.setOrientacao(Util.DIREITA);
		personagem2.inicializarSprite();

		inicializarIconPersonagens(Util.AANG, Util.TOPH);

		//TUTORIAL:
		try {
			irSprite = new Sprite("javatar.files\\Imagens\\Sprites\\SpriteBotaoNovo.png", 0, 52, 52, 1, 5, 1270, 342);
			voltarSprite = new Sprite("javatar.files\\Imagens\\Sprites\\SpriteBotaoNovo.png", 1, 52, 52, 1, 5, 10, 342);
			jogarSprite = new Sprite("javatar.files\\Imagens\\Sprites\\btn-do-jogo.png", 0, 197, 53, 4, 1, 580, 342);	
			homeSprite = new Sprite("javatar.files\\Imagens\\Sprites\\SpriteBotaoNovo.png", 3, 52, 52, 1, 5, 1270, 10);
			pularSprite = new Sprite("javatar.files\\Imagens\\Sprites\\btn-do-jogo.png", 2, 197, 53, 4, 1, 1125, 695);
			imagensAjudaSprite = new Sprite("javatar.files\\Imagens\\Sprites\\SpriteAjuda.png", 0, 1366, 768, 1, 7, 0 ,0);
		} catch (IOException e1) {
			Mensagens.messagemErro("Erro ao carregar sprites de Ajuda");
		}

		//BOTOES DO JOGO:		
		try {
			btnHomeSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesIconGamePageSprite.png", 0, 37, 37, 4, 1, 1285, 20); 
			btnConfigSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesIconGamePageSprite.png", 1, 37, 37, 4, 1, 1238, 20); 
			btnFecharCartasSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesIconGamePageSprite.png", 2, 37, 37, 4, 1, 1245, 570);
			btnCartanaMaoSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoes-carta-mao-fim-de-turno.png", 0, 100, 50, 3, 1, 790, 660);
			btnFimDeTurnoSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoes-carta-mao-fim-de-turno.png", 1, 100, 50, 3, 1, 920, 660);	
			btnJogarNovamenteSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesIconGamePageSprite.png", 3,  37, 37, 4, 1, 1191, 20);
			sairJogoBtnSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesIconGamePageSprite.png", 2, 37, 37, 4, 1, 1328, 20);
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao carregar os botões do jogo");
		}
		//BORDAS DO JOGO:
		try {
			bordaJogadorSprite = new Sprite("javatar.files\\Imagens\\Sprites\\bordaPaginajogoSprite.png", 0, 70, 70, 2, 1, 470, 560);
			bordaAdversarioSprite = new Sprite("javatar.files\\Imagens\\Sprites\\bordaPaginajogoSprite.png",0, 70, 70, 2, 1, 470, 60);
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao carregar os bordas dos jogadores");
		}

		//Configuração:
		try {
			backPanelConfigSprite = new Sprite("javatar.files\\Imagens\\Sprites\\configJogoPanelSprite.png", 0, 420, 400, 1, 2, 700, 200);
			btnSairPanelConfigSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesIconGamePageSprite.png", 2,  37, 37, 4, 1, 1073, 210);
			btnMusicaPanelConfigSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesConfigGamePageSprite.png", 0,  37, 37, 4, 1, 1073, 257);
			btnEfeitosSonorosPanelConfigSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesConfigGamePageSprite.png", 0,  37, 37, 4, 1, 1073, 304);
			btnAjudaPanelConfigSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesConfigGamePageSprite.png", 2,  37, 37, 4, 1, 1073, 380);
			btnYouTubePanelConfigSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesConfigGamePageSprite.png", 3,  37, 37, 4, 1, 1073, 427);

		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao carregar as configurações do jogo");
		}
		//obs da pergutna: 
		try {
			msgJogoPanelSprite = new Sprite("javatar.files\\Imagens\\Sprites\\msgSprite.png", 4,  400, 215, 5, 1, 700, 100);
			//btnOkaySprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoes-carta-mao-fim-de-turno.png", 2, 100, 50, 3, 1, 850, 250);	
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao carregar msg: \nVOCÊ SÓ PODE RESPONDER UMA PERGUNTA POR TURNO. \nFinalize o Turno.");
		}

		cartaMaoJogador = new Carta[5];
		imagensCartaMaoJogador = new ImageIcon[5];  
		maoJogadorSprite = new Sprite[5];
		cartaAdversario = new Carta[5];
		maoAdversarioSprite = new Sprite[5];

		try {
			hpJogador1Sprite = new Sprite("javatar.files\\Imagens\\Telas\\barra.png", 9, 171, 37, 20, 1, 604, 210);
			hpJogador2Sprite = new Sprite("javatar.files\\Imagens\\Telas\\barra.png", 10, 171, 37, 20, 1, 1040, 210);
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao inicializar sprites da barra de vida.");
		}


		vcPerdeuIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\you_lose.png");
		vcGanhouIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\you_win.png");
		sairIcon = new JLabel(new ImageIcon(("javatar.files\\Imagens\\Telas\\sair.png")));
		botaoFimTurno = new JButton("Finalizar Turno");
		imagemDeFundo = new ImageIcon("javatar.files\\Imagens\\Background\\Background-Game.png");

		btnCartasNaMao = new JLabel(new ImageIcon("javatar.files\\Imagens\\Telas\\btn-cartasDaMao.png"));
		btnFimDeTurno = new JLabel(new ImageIcon("javatar.files\\Imagens\\Telas\\btn-fimDeTurno.png"));

		perguntasPanel = new PerguntasPanel();

		perguntasPanel.setVisible(false);

		add(btnCartasNaMao).setBounds(790, 660, 100, 50); 
		add(btnFimDeTurno).setBounds(920, 660, 100, 50); 

		add(sairIcon).setBounds(1285, 20, 37, 37);

		add(perguntasPanel).setBounds(10, 0, 460, 340);

		setSize(Util.LARGURA, Util.ALTURA);
		setVisible(false);
	}



	public void initUtil() {
		if(Util.flagGanhou || Util.flagPerdeu) {
			this.relogio.resume();
		}
		
		Util.TURNO_FLAG = false; 		
		Util.TURNO_ADVERSARIO_ATACANDO = false; 
		Util.TURNO_ADVERSARIO_DEFENDENDO = false;		
		Util.PERGUNTA_NAO_RESPONDIDA = true; 		
		Util.MAGIA_ATIVA_ATAQUE = false;
		Util.MAGIA_ATIVA_DEFESA = false;			
		Util.TURNO_ADVERSARIO = false; 
		Util.CARTAS_NA_MAO_ADVERSARIO = 5;
		Util.CARTAS_NA_MAO = 5;
		Util.CHAMAR_MSG_PANEL_JOGO = false;
		Util.PULOU_QUESTAO = false;		
		Util.flagGanhou = false;
		Util.flagPerdeu = false;
		Util.CARTA_MAO_VISIVEL=false;
		Util.CONFIG_VISIVEL = false;
		
	}
	
	public void initHP() {
		personagem1.setHp(100);
		personagem2.setHp(100);
		personagem1.setPontos(0);
		personagem1.setDefesa(0);
		personagem1.setAtaque(0);
		atualizarBarraVida(100, 1);
		atualizarBarraVida(100, 2);
	}
	
	public void initPerguntas() {
		perguntasPanel.getPerguntasSorteadas().clear();

		perguntasPanel.inicializarPergunta();
		perguntasPanel.getAlternativaALabel().setBackground(Color.WHITE);
		perguntasPanel.getAlternativaBLabel().setBackground(Color.WHITE);
		perguntasPanel.getAlternativaCLabel().setBackground(Color.WHITE);
		perguntasPanel.getAlternativaDLabel().setBackground(Color.WHITE);
		perguntasPanel.getCoretoGifjLabel().setVisible(false);
		perguntasPanel.getErradoGifjLabel().setVisible(false);
	}

	public void reiniciar() {
		initUtil();
		Util.controleDeIcons(0, 0);
		Util.controleDeIconsAdversario(0, 0);
		personagem1.inicializarPersonagem(Util.ESQUERDA, personagem1.getNomePersonagem());
		personagem1.inicializarSprite();
		personagem2.inicializarPersonagem(Util.DIREITA, personagem2.getNomePersonagem());
		personagem2.inicializarSprite();

		inicializarIconPersonagens(personagem1.getNomePersonagem(), personagem2.getNomePersonagem());
		
		initHP();
		
		initPerguntas();
		
		try {
			ataqueJogador = new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem1.getNomePersonagem() + "Grande3.png", personagem1.getNomePersonagem().equals(Util.SOKKA)?11:13, 140, 140, 3, personagem1.getNomePersonagem().equals(Util.SOKKA)?12:14, 650, 570);

			defesaJogador = new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem1.getNomePersonagem() + "Grande3.png", personagem1.getNomePersonagem().equals(Util.SOKKA)?11:13, 140, 140, 3,  personagem1.getNomePersonagem().equals(Util.SOKKA)?12:14, 1090, 570);

			ataqueAdversario = new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem2.getNomePersonagem() + "Grande3.png", personagem2.getNomePersonagem().equals(Util.SOKKA)?11:13, 140, 140, 3, personagem2.getNomePersonagem().equals(Util.SOKKA)?12:14, 650, 10);
			defesaAdversario = new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem2.getNomePersonagem() + "Grande3.png", personagem2.getNomePersonagem().equals(Util.SOKKA)?11:13, 140, 140, 3,  personagem2.getNomePersonagem().equals(Util.SOKKA)?12:14, 1090, 10);
			
			deckJogador = new Deck(XML.leArquivoCartas(personagem1.getNomePersonagem()), new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem1.getNomePersonagem() + "Grande3.png", Util.isSokka(personagem1.getNomePersonagem()), 140, 140, 3,  personagem1.getNomePersonagem().equals(Util.SOKKA)?12:14, 1170, 570));
			
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao exibir novas cartas do jogador");
		}
		
		try {
			deckInimigo = new Deck(XML.leArquivoCartas(personagem2.getNomePersonagem()), new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem2.getNomePersonagem() + "Grande3.png", personagem2.getNomePersonagem().equals(Util.SOKKA)?10:12, 140, 140, 3,  personagem1.getNomePersonagem().equals(Util.SOKKA)?12:14, 1170, 10));
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao exibir novas cartas do adversário");
		}
		
		for(int i = 0; i < 5; i++) {

			cartaMaoJogador[i] = deckJogador.pegarCarta();

			//imagensCartaMaoJogador[i] = new ImageIcon(cartaMaoJogador[i].getImagem());
			maoJogadorSprite[i] = initCartaSprite(personagem1.getNomePersonagem(), cartaMaoJogador[i], i, true);
			//maosJogadorLabel[i] =  new JLabel(imagensCartaMaoJogador[i]);

			//adversario
			cartaAdversario[i] = deckInimigo.pegarCarta();
			maoAdversarioSprite[i] = initCartaSprite(personagem2.getNomePersonagem(), cartaAdversario[i], i, false);

		}


		verificarUtilizacao();
		
	}

	public void inicializar(String orientacao, String nomeLutador) {
		initUtil();
		int index = sortearPersonagem2();

		personagem1.inicializarPersonagem(orientacao, nomeLutador);
		personagem1.inicializarSprite();
		personagem2.inicializarPersonagem(Util.DIREITA, vsPersonagens.get(index));
		personagem2.inicializarSprite();

		inicializarIconPersonagens(nomeLutador, vsPersonagens.get(index));

		initHP();
		
		initPerguntas();

		try {

			iconsJogadorSprite = new Sprite("javatar.files\\Imagens\\Sprites\\iconsMTD.png", 0, 260, 57, 1, 8, 780, 600);
			iconsAdversarioSprite = new Sprite("javatar.files\\Imagens\\Sprites\\iconsMTD-adversario.png", 0, 260, 57, 1, 8, 780, 60);

			visualizarCarta = new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem1.getNomePersonagem() + "Grande3.png", personagem1.getNomePersonagem().equals(Util.SOKKA)?11:13, 140, 140, 3, personagem1.getNomePersonagem().equals(Util.SOKKA)?12:14, 855, 320);

			//Cartas jogarr
			ataqueJogador = new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem1.getNomePersonagem() + "Grande3.png", personagem1.getNomePersonagem().equals(Util.SOKKA)?11:13, 140, 140, 3, personagem1.getNomePersonagem().equals(Util.SOKKA)?12:14, 650, 570);

			defesaJogador = new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem1.getNomePersonagem() + "Grande3.png", personagem1.getNomePersonagem().equals(Util.SOKKA)?11:13, 140, 140, 3,  personagem1.getNomePersonagem().equals(Util.SOKKA)?12:14, 1090, 570);

			ataqueAdversario = new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem2.getNomePersonagem() + "Grande3.png", personagem2.getNomePersonagem().equals(Util.SOKKA)?11:13, 140, 140, 3, personagem2.getNomePersonagem().equals(Util.SOKKA)?12:14, 650, 10);
			defesaAdversario = new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem2.getNomePersonagem() + "Grande3.png", personagem2.getNomePersonagem().equals(Util.SOKKA)?11:13, 140, 140, 3,  personagem2.getNomePersonagem().equals(Util.SOKKA)?12:14, 1090, 10);

			deckJogador = new Deck(XML.leArquivoCartas(personagem1.getNomePersonagem()), new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem1.getNomePersonagem() + "Grande3.png", Util.isSokka(personagem1.getNomePersonagem()), 140, 140, 3,  personagem1.getNomePersonagem().equals(Util.SOKKA)?12:14, 1170, 570));

			deckInimigo = new Deck(XML.leArquivoCartas(personagem2.getNomePersonagem()), new Sprite("javatar.files\\Imagens\\Sprites\\Sprite" + 
					personagem2.getNomePersonagem() + "Grande3.png", personagem2.getNomePersonagem().equals(Util.SOKKA)?10:12, 140, 140, 3,  personagem1.getNomePersonagem().equals(Util.SOKKA)?12:14, 1170, 10));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for(int i = 0; i < 5; i++) {

			cartaMaoJogador[i] = deckJogador.pegarCarta();

			//imagensCartaMaoJogador[i] = new ImageIcon(cartaMaoJogador[i].getImagem());
			maoJogadorSprite[i] = initCartaSprite(personagem1.getNomePersonagem(), cartaMaoJogador[i], i, true);
			//maosJogadorLabel[i] =  new JLabel(imagensCartaMaoJogador[i]);

			//adversario
			cartaAdversario[i] = deckInimigo.pegarCarta();
			maoAdversarioSprite[i] = initCartaSprite(personagem2.getNomePersonagem(), cartaAdversario[i], i, false);

		}


		verificarUtilizacao();


	}

	public int sortearPersonagem2() {
		Random r = new Random();
		return r.nextInt(vsPersonagens.size());
	}

	public void inicializarIconPersonagens(String nomeP1, String nomeP2) {
		if (nomeP1.equals(Util.AANG)) {
			jogador1Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\aang.png");
			vsEsquerda = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_ang_left.png");
		} else if (nomeP1.equals(Util.KATARA)) {
			jogador1Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\katara.png");
			vsEsquerda = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_katara_left.png");
		} else if (nomeP1.equals(Util.SOKKA)) {
			jogador1Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\sokka.png");
			vsEsquerda = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_sokka_left.png");
		} else if (nomeP1.equals(Util.TOPH)) {
			jogador1Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\toph.png");
			vsEsquerda = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_toph_left.png");
		} else if (nomeP1.equals(Util.ZUCO)) {
			jogador1Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\zuko.png");
			vsEsquerda = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_zuko_left.png");
		}

		if (nomeP2.equals(Util.AANG)) {
			jogador2Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\aang.png");
			vsDireita = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_ang_right.png");
		} else if (nomeP2.equals(Util.KATARA)) {
			jogador2Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\katara.png");
			vsDireita = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_katara_right.png");
		} else if (nomeP2.equals(Util.SOKKA)) {
			jogador2Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\sokka.png");
			vsDireita = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_sokka_right.png");
		} else if (nomeP2.equals(Util.TOPH)) {
			jogador2Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\toph.png");
			vsDireita = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_toph_right.png");
		} else if (nomeP2.equals(Util.ZUCO)) {
			jogador2Icon = new ImageIcon("javatar.files\\Imagens\\Telas\\zuko.png");
			vsDireita = new ImageIcon("javatar.files\\Imagens\\Telas\\vs_zuko_right.png");
		}
	}

	//verificar o mvc com Rycharlisson
	public boolean colide(Sprite sprite1, Sprite sprite2, String orientacao) {
		Rectangle r1;
		Rectangle r2;
		if (orientacao.equals(Util.DIREITA)) {
			r1 = new Rectangle(sprite1.posX, sprite1.posY, sprite1.width, sprite1.height);
			r2 = new Rectangle(sprite2.posX + 80, sprite2.posY, sprite2.width, sprite2.height);
		} else {
			r1 = new Rectangle(sprite1.posX, sprite1.posY, sprite1.width, sprite1.height);
			r2 = new Rectangle(sprite2.posX - 80, sprite2.posY, sprite2.width, sprite2.height);
		}

		if (r1.intersects(r2)) {
			return true;
		}		

		return false;
	}

	public boolean colideAtaques(Sprite sprite1, Sprite sprite2, String orientacao) {
		Rectangle r1;
		Rectangle r2;
		if (orientacao.equals(Util.DIREITA)) {
			r1 = new Rectangle(sprite1.posX, sprite1.posY, sprite1.width, sprite1.height);
			r2 = new Rectangle(sprite2.posX - 80, sprite2.posY, sprite2.width, sprite2.height);
		} else {
			r1 = new Rectangle(sprite1.posX, sprite1.posY, sprite1.width, sprite1.height);
			r2 = new Rectangle(sprite2.posX + 160, sprite2.posY, sprite2.width, sprite2.height);
		}

		if (r1.intersects(r2)) {
			return true;
		}

		return false;
	}

	public boolean colideDefesa(Sprite sprite1, Sprite sprite2) {
		Rectangle r1 = new Rectangle(sprite1.posX, sprite1.posY, sprite1.width, sprite1.height);
		Rectangle r2 = new Rectangle(sprite2.posX, sprite2.posY, sprite2.width, sprite2.height);

		if (r1.intersects(r2)) {
			return true;
		}

		return false;
	}

	public void atualizarBarraVida(int hp, int personagem) {
		if (personagem == 1) {
			if (hp == 100) {
				hpJogador1Sprite.aparencia = 9;
			} else if (hp == 90) {
				hpJogador1Sprite.aparencia = 8;
			} else if (hp == 80) {
				hpJogador1Sprite.aparencia = 7;
			} else if (hp == 70) {
				hpJogador1Sprite.aparencia = 6;
			} else if (hp == 60) {
				hpJogador1Sprite.aparencia = 5;
			} else if (hp == 50) {
				hpJogador1Sprite.aparencia = 4;
			} else if (hp == 40) {
				hpJogador1Sprite.aparencia = 3;
			} else if (hp == 30) {
				hpJogador1Sprite.aparencia = 2;
			} else if (hp == 20) {
				hpJogador1Sprite.aparencia = 1;
			} else if (hp == 10) {
				hpJogador1Sprite.aparencia = 1;
			} else if (hp == 0) {
				hpJogador1Sprite.aparencia = 0;
			}
		} else {
			if (hp == 100) {
				hpJogador2Sprite.aparencia = 10;
			} else if (hp == 90) {
				hpJogador2Sprite.aparencia = 11;
			} else if (hp == 80) {
				hpJogador2Sprite.aparencia = 12;
			} else if (hp == 70) {
				hpJogador2Sprite.aparencia = 13;
			} else if (hp == 60) {
				hpJogador2Sprite.aparencia = 14;
			} else if (hp == 50) {
				hpJogador2Sprite.aparencia = 15;
			} else if (hp == 40) {
				hpJogador2Sprite.aparencia = 16;
			} else if (hp == 30) {
				hpJogador2Sprite.aparencia = 17;
			} else if (hp == 20) {
				hpJogador2Sprite.aparencia = 18;
			} else if (hp == 10) {
				hpJogador2Sprite.aparencia = 18;
			} else if (hp == 0) {
				hpJogador2Sprite.aparencia = 19;
			}
		}
	}


	public static void carregarImagemPerguntas(String url) {
		imagemPerguntas = new ImageIcon(url);
	}

	public int mapCartasSprites(String nomePersonagem, Carta carta) {
		switch (nomePersonagem) {
		case Util.AANG: {
			if(carta.getId().equals("aangAtaque1")){
				return 0;
			}else if(carta.getId().equals("aangAtaque2")){
				return 1;
			}else if(carta.getId().equals("aangAtaque3")){
				return 2;
			}else if(carta.getId().equals("aangAtaque4")){
				return 3;
			}else if(carta.getId().equals("aangDefesa1")){
				return 4;
			}else if(carta.getId().equals("aangDefesa2")){
				return 5;
			}else if(carta.getId().equals("aangDefesa3")){
				return 6;
			}else if(carta.getId().equals("aangDefesa4")){
				return 7;
			}else{
				return 8;
			}				
		}
		case Util.KATARA: {
			if(carta.getId().equals("kataraAtaque1")){
				return 0;
			}else if(carta.getId().equals("kataraAtaque2")){
				return 1;
			}else if(carta.getId().equals("kataraAtaque3")){
				return 2;
			}else if(carta.getId().equals("kataraAtaque4")){
				return 3;
			}else if(carta.getId().equals("kataraDefesa1")){
				return 4;
			}else if(carta.getId().equals("kataraDefesa2")){
				return 5;
			}else if(carta.getId().equals("kataraDefesa3")){
				return 6;
			}else if(carta.getId().equals("kataraDefesa4")){
				return 7;
			}else{
				return 8;
			}
		}
		case Util.SOKKA: {

			if(carta.getId().equals("sokkaAtaque1")){
				return 0;
			}else if(carta.getId().equals("sokkaAtaque2")){
				return 1;
			}else if(carta.getId().equals("sokkaAtaque3")){
				return 2;
			}else if(carta.getId().equals("sokkaDefesa1")){
				return 3;
			}else if(carta.getId().equals("sokkaDefesa2")){
				return 4;
			}else if(carta.getId().equals("sokkaDefesa3")){
				return 5;
			}else{
				return 6;
			}
		}
		case Util.TOPH: {
			if(carta.getId().equals("tophAtaque1")){
				return 0;
			}else if(carta.getId().equals("tophAtaque2")){
				return 1;
			}else if(carta.getId().equals("tophAtaque3")){
				return 2;
			}else if(carta.getId().equals("tophAtaque4")){
				return 3;
			}else if(carta.getId().equals("tophDefesa1")){
				return 4;
			}else if(carta.getId().equals("tophDefesa2")){
				return 5;
			}else if(carta.getId().equals("tophDefesa3")){
				return 6;
			}else if(carta.getId().equals("tophDefesa4")){
				return 7;
			}else{
				return 8;
			}
		}
		case Util.ZUCO: {
			if(carta.getId().equals("zucoAtaque1")){
				return 0;
			}else if(carta.getId().equals("zucoAtaque2")){
				return 1;
			}else if(carta.getId().equals("zucoAtaque3")){
				return 2;
			}else if(carta.getId().equals("zucoAtaque4")){
				return 3;
			}else if(carta.getId().equals("zucoDefesa1")){
				return 4;
			}else if(carta.getId().equals("zucoDefesa2")){
				return 5;
			}else if(carta.getId().equals("zucoDefesa3")){
				return 6;
			}else if(carta.getId().equals("zucoDefesa4")){
				return 7;
			}else{
				return 8;
			}
		}
		}
		return 0;
	}

	public Sprite initCartaSprite(String nomePersonagem,Carta carta, int posCarta, boolean jogador ) {

		int aparencia = mapCartasSprites(nomePersonagem, carta);

		switch (nomePersonagem) {
		case Util.AANG: {	
			try {
				return new Sprite(enderecoSprite(Util.TAMANHO_GRANDE, nomePersonagem), jogador?aparencia:24 , 140, 140, 3, 14, Util.POS_X_CARTAS[posCarta], jogador?Util.CARTAS_POS_Y:10);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		case Util.KATARA: {
			try {
				return new Sprite(enderecoSprite(Util.TAMANHO_GRANDE, nomePersonagem), jogador?aparencia:24, 140, 140, 3, 14, Util.POS_X_CARTAS[posCarta], Util.CARTAS_POS_Y);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		case Util.SOKKA: {
			try {
				return new Sprite(enderecoSprite(Util.TAMANHO_GRANDE, nomePersonagem), jogador?aparencia:22, 140, 140, 3, 12, Util.POS_X_CARTAS[posCarta] ,jogador?Util.CARTAS_POS_Y:10);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		case Util.TOPH: {
			try {
				return new Sprite(enderecoSprite(Util.TAMANHO_GRANDE, nomePersonagem), jogador?aparencia:24, 140, 140, 3, 14, Util.POS_X_CARTAS[posCarta] , jogador?Util.CARTAS_POS_Y:10);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		case Util.ZUCO: {
			try {
				return new Sprite(enderecoSprite(Util.TAMANHO_GRANDE, nomePersonagem), jogador?aparencia:24, 140, 140, 3, 14, Util.POS_X_CARTAS[posCarta] , jogador?Util.CARTAS_POS_Y:10);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		return null;
	}

	public String enderecoSprite(String tamanho, String nomePersonagem) {
		switch (tamanho) {
		case Util.TAMANHO_GRANDE: {
			return "javatar.files\\Imagens\\Sprites\\Sprite" + nomePersonagem + "Grande3.png";
		}
		case Util.TAMANHO_PEQUENO: {
			return "javatar.files\\Imagens\\Sprites\\Sprite" + nomePersonagem + "Pequena2.png";
		}
		}
		return null;
	}

	public int colisaoBotaoMsg(int x, int y) {
		Rectangle okBotao = new Rectangle(850, 250,100, 50);
		Rectangle m = new Rectangle(x, y, 1, 1);

		if(okBotao.intersects(m)) {
			return Util.OK_BOTAO_MSG_PANEL_JOGO;
		}
		return 5;
	}

	public int colidBotaoPular(int x, int y) {
		Rectangle pularBotao = new Rectangle(1125, 695,197, 53);
		Rectangle sairJogoBotao = new Rectangle(1328, 20,37, 37);
		Rectangle m = new Rectangle(x, y, 1, 1);
		
		//sairJogoBtnSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesIconGamePageSprite.png", 2, 37, 37, 4, 1, 1270, 10);

		if(pularBotao.intersects(m)) {			
			return Util.PULAR_BOTAO_AJUDA;
		}
		else if(sairJogoBotao.intersects(m)) {			
			return Util.SAIR_JOGO_PANEL_JOGO;
		}
		return 5;
	}

	public int colisaoCartas(int x, int y) {
		Rectangle r1 = new Rectangle(Util.POS_X_CARTAS[0], Util.CARTAS_POS_Y, 100, 140);
		Rectangle r2 = new Rectangle(Util.POS_X_CARTAS[1], Util.CARTAS_POS_Y, 100, 140);
		Rectangle r3 = new Rectangle(Util.POS_X_CARTAS[2], Util.CARTAS_POS_Y, 100, 140);
		Rectangle r4 = new Rectangle(Util.POS_X_CARTAS[3], Util.CARTAS_POS_Y, 100, 140);
		Rectangle r5 = new Rectangle(Util.POS_X_CARTAS[4], Util.CARTAS_POS_Y, 100, 140);
		Rectangle ataque = new Rectangle( Util.POS_X_CARTAS[0], 570, 160, 160);
		Rectangle defesa = new Rectangle( Util.POS_X_CARTAS[4], 570, 160, 160);

		Rectangle irBotao = new Rectangle(1270,342,52,52);
		Rectangle voltarBotao = new Rectangle(10,342,52,52);

		Rectangle jogarBotao = new Rectangle(580, 342,197, 53);
		//	Rectangle pularBotao = new Rectangle(1125, 665,197, 53);

		Rectangle configSairBotao = new Rectangle(1073, 210,37, 37);
		Rectangle configMusicaBotao = new Rectangle( 1073, 257,37, 37);
		Rectangle configEfeitosSonorosBotao = new Rectangle(1073, 304,37, 37);
		Rectangle configAjudaBotao = new Rectangle(1073, 380,37, 37);
		Rectangle youTubeAjudaBotao = new Rectangle(1073, 427,37, 37);


		Rectangle configBotao = new Rectangle(1238, 20,37, 37);
		Rectangle jogarNovamente = new Rectangle(1191, 20,37,37);

		Rectangle okBotaoPergunta = new Rectangle(850, 350, 100, 50);

		Rectangle m = new Rectangle(x, y, 1, 1);
		if (r1.intersects(m) && Util.CARTA_MAO_VISIVEL) {
			return 0 ;
		}else if (r2.intersects(m) && Util.CARTA_MAO_VISIVEL) {
			return 1 ;
		}else if (r3.intersects(m) && Util.CARTA_MAO_VISIVEL) {
			return 2 ;
		}else if (r4.intersects(m) && Util.CARTA_MAO_VISIVEL) {
			return 3 ;
		}else if (r5.intersects(m) && Util.CARTA_MAO_VISIVEL) {
			return 4 ;
		}else if (ataque.intersects(m)) {
			return 7 ;
		}else if (defesa.intersects(m)) {
			return 8;
		}else if(irBotao.intersects(m)) {
			return Util.IR_BOTAO_AJUDA;
		}else if(voltarBotao.intersects(m)) {
			return Util.VOLTAR_BOTAO_AJUDA;
		}else if(jogarBotao.intersects(m)) {
			return Util.JOGAR_BOTAO_AJUDA;
		}else if(configSairBotao.intersects(m)) {
			return Util.CONFIG_BTN_SAIR;
		}
		else if(configMusicaBotao.intersects(m)) {
			return Util.CONFIG_BTN_MUSICA;
		}
		else if(configEfeitosSonorosBotao.intersects(m)) {
			return Util.CONFIG_BTN_EFEITOS_SONOROS;
		}
		else if(configAjudaBotao.intersects(m)) {
			return Util.CONFIG_BTN_AJUDA;
		}
		else if(configBotao.intersects(m)) {
			return Util.CONFIG_BTN;
		}
		else if(youTubeAjudaBotao.intersects(m)) {
			return Util.YOUTUBE_BOTAO_PANEL_JOGO;
		}
		else if(jogarNovamente.intersects(m)) {
			return Util.JOGAR_NOVAMENTE_PANEL_JOGO;
		}
		//		else if(okBotaoPergunta.intersects(m)) {
		//			return Util.OK_BOTAO_MSG_PERGUNTAS;
		//		}
		//		else if(sairBotao.intersects(m)) {
		//			return Util.SAIR_BOTAO_CARTAS;
		//		}
		return 5;
	}

	public void colocarCartaNaMao() {
		boolean flag = true;
		int cont = 0;
		while (flag) {
			if(Util.CARTAS_NA_MAO >= 5) {
				flag = false;
			}else {
				if(cartaMaoJogador[cont] != null) {
					cont++;
				}else if(cont < 5){
					cartaMaoJogador[cont] = deckJogador.pegarCarta();
					//quando no deck não houver mais cartas
					//FZAER QUANDO NA MAO NAO HOUVER MAIS CARTAS
					if(!(cartaMaoJogador[cont] != null)) {
						Util.flagPerdeu = verificarDerrota(cartaMaoJogador);
						personagem1.animacaoPerdeu();
						personagem1.setHp(0);

						//Mensagens.mensagemExibir("Com as cartas que você tem, não é possível ganhar o jogo");
						msgJogoPanelSprite.aparencia = 2;
						Util.CHAMAR_MSG_PANEL_JOGO = true;

					}

					maoJogadorSprite[cont] = initCartaSprite(personagem1.getNomePersonagem(), cartaMaoJogador[cont], cont,true );
					flag=false;
					Util.CARTAS_NA_MAO++;
				}else {
					flag = false;
				}
			}
		}
	}
	public void colocarCartaNaMaoAdversario() {
		boolean flag = true;
		int cont = 0;
		while (flag) {
			if(Util.CARTAS_NA_MAO_ADVERSARIO >= 5) {
				flag = false;
			}else {
				if(cartaAdversario[cont] != null) {
					cont++;
				}else if(cont < 5){
					cartaAdversario[cont] = deckInimigo.pegarCarta();

					if(!(cartaAdversario[cont] != null)) {
						Util.flagGanhou = verificarDerrota(cartaAdversario);
						personagem2.animacaoPerdeu();
						personagem2.setHp(0);
						//Mensagens.mensagemExibir("Com as cartas que o adversário tem, não é possível ele ganhar o jogo");
						msgJogoPanelSprite.aparencia = 3;
						Util.CHAMAR_MSG_PANEL_JOGO = true;
					}

					maoAdversarioSprite[cont] = initCartaSprite(personagem2.getNomePersonagem(), cartaAdversario[cont], cont,false );
					flag=false;
					Util.CARTAS_NA_MAO_ADVERSARIO++;
				}else {
					flag = false;
				}
			}
		}
	}

	public boolean verificarDerrota(Carta[] cartas) {

		int qtdCartasAtaque = 0;

		for(Carta c: cartas) {
			if(c != null) {
				if(c.getTipo() == Util.ATAQUE) {
					qtdCartasAtaque++;
				}
			}
		}
		if(qtdCartasAtaque > 0 ) {
			return false;
		}
		return true;
	}

	public boolean invocar(Carta carta, boolean jogador) {
		if(jogador) {
			if(carta.getPontos() <= this.getPersonagem1().getPontos()){

				this.getPersonagem1().setPontos(this.getPersonagem1().getPontos() - carta.getPontos());
				return true;

			}
		}else {
			if(carta.getPontos() <= this.getPersonagem2().getPontos()){
				this.getPersonagem2().setPontos(this.getPersonagem2().getPontos() - carta.getPontos());
				return true;
			}
		}

		return false;
	}


	public void verificarUtilizacao() {
		int aparencia = 0;

		for(int i=0; i<5; i++ ) {
			if(this.getCartaMaoJogador()[i]!=null) {
				aparencia = this.getMaoJogadorSprite()[i].aparencia;

				if(invocar(this.getCartaMaoJogador()[i], true)) {
					if(aparencia > (Util.SOKKA.equals(this.getPersonagem1().getNomePersonagem())?23:27)) {
						this.getMaoJogadorSprite()[i].aparencia = aparencia - (Util.SOKKA.equals(this.getPersonagem1().getNomePersonagem())?24:28);
					}
					this.getPersonagem1().setPontos(this.getPersonagem1().getPontos() + this.getCartaMaoJogador()[i].getPontos());
				}else{
					if((aparencia < (Util.SOKKA.equals(this.getPersonagem1().getNomePersonagem())?12:14)) && (aparencia != (Util.SOKKA.equals(this.getPersonagem1().getNomePersonagem())?6:8) &&
							(aparencia != (Util.SOKKA.equals(this.getPersonagem1().getNomePersonagem())?20:24) &&
							(aparencia != (Util.SOKKA.equals(this.getPersonagem1().getNomePersonagem())?34:26))))) {
						this.getMaoJogadorSprite()[i].aparencia = aparencia + (Util.SOKKA.equals(this.getPersonagem1().getNomePersonagem())?24:28);					
					}				
				}
			}
		}
	}

	public void roboAdversario() {
		int cont = 0;
		if(Util.CARTAS_NA_MAO_ADVERSARIO<5) {
			colocarCartaNaMaoAdversario();
		}

		if(personagem2.getPontos() > 0) {
			if(Util.TURNO_ADVERSARIO_ATACANDO) {
				for(int i=0; i<5;i++){
					if(cartaAdversario[i] !=null) {
						if(cartaAdversario[i].getTipo().equals(Util.ATAQUE) && (cartaAdversario[i].getPontos() >= personagem1.getDefesa())) {
							if(invocar(cartaAdversario[i], false)) {
								ataqueAdversario.aparencia = mapCartasSprites(personagem2.getNomePersonagem(), cartaAdversario[i]);

								maoAdversarioSprite[i].aparencia = Util.SOKKA.equals(personagem2.getNomePersonagem())?8:10;

								personagem2.setAtaque(cartaAdversario[i].getPontos());

								Util.flagAtacandoP2 = true;
								cartaAdversario[i] = null;
								Util.CARTAS_NA_MAO_ADVERSARIO--;							
								Util.ADVERSARIO_JOGOU_CARTA = true;
								iconsAdversarioSprite.aparencia = Util.controleDeIconsAdversario(personagem2.getDefesa(), personagem2.getAtaque());
							}

						}
					}					
				}
				Util.TURNO_ADVERSARIO_ATACANDO = false;
				Util.TURNO_ADVERSARIO_DEFENDENDO = true;
				cont=0;
			}
			if (Util.TURNO_ADVERSARIO_DEFENDENDO) {

				while(Util.TURNO_ADVERSARIO_DEFENDENDO) {
					if(cartaAdversario[cont] !=null) {
						if(cartaAdversario[cont].getTipo().equals(Util.DEFESA) && (cartaAdversario[cont].getPontos() <= personagem2.getPontos())) {

							if((this.getDefesaJogador().aparencia != (Util.SOKKA.equals(this.getPersonagem1().getNomePersonagem())?8:10))
									&& defesaAdversario.aparencia == (Util.SOKKA.equals(personagem2.getNomePersonagem())?11:13)) {
								if(invocar(cartaAdversario[cont], false)) {
									defesaAdversario.aparencia = mapCartasSprites(personagem2.getNomePersonagem(), cartaAdversario[cont]);
									maoAdversarioSprite[cont].aparencia = Util.SOKKA.equals(personagem2.getNomePersonagem())?8:10;

									personagem2.setDefesa(cartaAdversario[cont].getPontos());

									cartaAdversario[cont] = null;
									Util.CARTAS_NA_MAO_ADVERSARIO--;	
									iconsAdversarioSprite.aparencia = Util.controleDeIconsAdversario(personagem2.getDefesa(), personagem2.getAtaque());
									//Util.ADVERSARIO_JOGOU_CARTA = true;
								}
								Util.TURNO_ADVERSARIO_DEFENDENDO = false;
							}else {
								personagem2.setPontos(personagem2.getPontos() + cartaAdversario[cont].getPontos());
							}


						}
					}					
					if(cont < 4) {
						cont++;
					}else {
						Util.TURNO_ADVERSARIO_DEFENDENDO = false;
					}

				}
			}
			Util.TURNO_ADVERSARIO = false;
		}else {
			Util.TURNO_ADVERSARIO = false;
		}
		if(!Util.ADVERSARIO_JOGOU_CARTA) {
			Util.VEZ_JOGADOR = true;
		}
		Util.ADVERSARIO_JOGOU_CARTA = false;
	}

	public ArrayList<Carta> cartasDisponiveisAdversario(int pontos){
		ArrayList<Carta> cartas = new ArrayList<>();

		for(Carta c : cartaAdversario) {
			if(c != null) {
				if(c.getPontos() <= personagem2.getPontos()) {
					cartas.add(c);
				}
			}			
		}

		return cartas;		
	}

	//	public BufferedImage getBuffer() {
	//		return buffer;
	//	}
	//
	//	public void setBuffer(BufferedImage buffer) {
	//		this.buffer = buffer;
	//	}

	public ImageIcon getImagemDeFundo() {
		return imagemDeFundo;
	}

	public void setImagemDeFundo(ImageIcon imagemDeFundo) {
		this.imagemDeFundo = imagemDeFundo;
	}

	public PerguntasPanel getPerguntasPanel() {
		return perguntasPanel;
	}

	public void setPerguntasPanel(PerguntasPanel perguntasPanel) {
		this.perguntasPanel = perguntasPanel;
	}

	public static ImageIcon getImagemPerguntas() {
		return imagemPerguntas;
	}

	public static void setImagemPerguntas(ImageIcon imagemPerguntas) {
		JogoPanel.imagemPerguntas = imagemPerguntas;
	}

	public Personagem getPersonagem1() {
		return personagem1;
	}

	public void setPersonagem1(Personagem personagem1) {
		this.personagem1 = personagem1;
	}

	public ImageIcon getJogador1Icon() {
		return jogador1Icon;
	}

	public void setJogador1Icon(ImageIcon jogador1Icon) {
		this.jogador1Icon = jogador1Icon;
	}

	public ImageIcon getAtacarIcon() {
		return atacarIcon;
	}

	public void setAtacarIcon(ImageIcon atacarIcon) {
		this.atacarIcon = atacarIcon;
	}

	public ImageIcon getVsEsquerda() {
		return vsEsquerda;
	}

	public void setVsEsquerda(ImageIcon vsEsquerda) {
		this.vsEsquerda = vsEsquerda;
	}

	public Personagem getPersonagem2() {
		return personagem2;
	}

	public void setPersonagem2(Personagem personagem2) {
		this.personagem2 = personagem2;
	}

	public boolean isFlagColidir() {
		return flagColidir;
	}

	public void setFlagColidir(boolean flagColidir) {
		this.flagColidir = flagColidir;
	}

	public ImageIcon getJogador2Icon() {
		return jogador2Icon;
	}

	public void setJogador2Icon(ImageIcon jogador2Icon) {
		this.jogador2Icon = jogador2Icon;
	}

	public ImageIcon getVsDireita() {
		return vsDireita;
	}

	public void setVsDireita(ImageIcon vsDireita) {
		this.vsDireita = vsDireita;
	}

	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public void setNomeLabel(JLabel nomeLabel) {
		this.nomeLabel = nomeLabel;
	}

	public Sprite getHpJogador1Sprite() {
		return hpJogador1Sprite;
	}

	public void setHpJogador1Sprite(Sprite hpJogador1Sprite) {
		this.hpJogador1Sprite = hpJogador1Sprite;
	}

	public Sprite getHpJogador2Sprite() {
		return hpJogador2Sprite;
	}

	public void setHpJogador2Sprite(Sprite hpJogador2Sprite) {
		this.hpJogador2Sprite = hpJogador2Sprite;
	}

	public ImageIcon getVcPerdeuIcon() {
		return vcPerdeuIcon;
	}

	public void setVcPerdeuIcon(ImageIcon vcPerdeuIcon) {
		this.vcPerdeuIcon = vcPerdeuIcon;
	}

	public ImageIcon getVcGanhouIcon() {
		return vcGanhouIcon;
	}

	public void setVcGanhouIcon(ImageIcon vcGanhouIcon) {
		this.vcGanhouIcon = vcGanhouIcon;
	}

	public JLabel getSairIcon() {
		return sairIcon;
	}

	public void setSairIcon(JLabel sairIcon) {
		this.sairIcon = sairIcon;
	}

	public Relogio getRelogio() {
		return relogio;
	}

	public void setRelogio(Relogio relogio) {
		this.relogio = relogio;
	}

	public ArrayList<String> getVsPersonagens() {
		return vsPersonagens;
	}

	public void setVsPersonagens(ArrayList<String> vsPersonagens) {
		this.vsPersonagens = vsPersonagens;
	}

	public Deck getDeckInimigo() {
		return deckInimigo;
	}

	public void setDeckInimigo(Deck deckInimigo) {
		this.deckInimigo = deckInimigo;
	}

	public Deck getDeckJogador() {
		return deckJogador;
	}

	public void setDeckJogador(Deck deckJogador) {
		this.deckJogador = deckJogador;
	}

	public Carta[] getCartaMaoJogador() {
		return cartaMaoJogador;
	}

	public void setCartaMaoJogador(Carta[] cartaMaoJogador) {
		this.cartaMaoJogador = cartaMaoJogador;
	}

	public Carta[] getCartaAdversario() {
		return cartaAdversario;
	}

	public void setCartaAdversario(Carta[] cartaAdversario) {
		this.cartaAdversario = cartaAdversario;
	}

	public ImageIcon[] getImagensCartaMaoJogador() {
		return imagensCartaMaoJogador;
	}

	public void setImagensCartaMaoJogador(ImageIcon[] imagensCartaMaoJogador) {
		this.imagensCartaMaoJogador = imagensCartaMaoJogador;
	}

	public ImageIcon[] getImagensCartaMaoAdversario() {
		return imagensCartaMaoAdversario;
	}

	public void setImagensCartaMaoAdversario(ImageIcon[] imagensCartaMaoAdversario) {
		this.imagensCartaMaoAdversario = imagensCartaMaoAdversario;
	}

	//	public JLabel[] getMaosJogadorLabel() {
	//		return maosJogadorLabel;
	//	}
	//
	//	public void setMaosJogadorLabel(JLabel[] maosJogadorLabel) {
	//		this.maosJogadorLabel = maosJogadorLabel;
	//	}
	//
	//	public JLabel[] getMaosAdversarioLabel() {
	//		return maosAdversarioLabel;
	//	}
	//
	//	public void setMaosAdversarioLabel(JLabel[] maosAdversarioLabel) {
	//		this.maosAdversarioLabel = maosAdversarioLabel;
	//	}

	public JLabel getDeckJogadorLabel() {
		return deckJogadorLabel;
	}

	public void setDeckJogadorLabel(JLabel deckJogadorLabel) {
		this.deckJogadorLabel = deckJogadorLabel;
	}

	public JLabel getDeckAdversarioLabel() {
		return deckAdversarioLabel;
	}

	public void setDeckAdversarioLabel(JLabel deckAdversarioLabel) {
		this.deckAdversarioLabel = deckAdversarioLabel;
	}

	public Sprite getAtaqueJogador() {
		return ataqueJogador;
	}

	public void setAtaqueJogador(Sprite ataqueJogador) {
		this.ataqueJogador = ataqueJogador;
	}

	public Sprite getDefesaJogador() {
		return defesaJogador;
	}

	public void setDefesaJogador(Sprite defesaJogador) {
		this.defesaJogador = defesaJogador;
	}

	public Sprite getMagiaJogador() {
		return magiaJogador;
	}

	public void setMagiaJogador(Sprite magiaJogador) {
		this.magiaJogador = magiaJogador;
	}

	public Sprite getAtaqueAdversario() {
		return ataqueAdversario;
	}

	public void setAtaqueAdversario(Sprite ataqueAdversario) {
		this.ataqueAdversario = ataqueAdversario;
	}

	public Sprite getDefesaAdversario() {
		return defesaAdversario;
	}

	public void setDefesaAdversario(Sprite defesaAdversario) {
		this.defesaAdversario = defesaAdversario;
	}

	public Sprite[] getMaoJogadorSprite() {
		return maoJogadorSprite;
	}

	public void setMaoJogadorSprite(Sprite[] maoJogadorSprite) {
		this.maoJogadorSprite = maoJogadorSprite;
	}

	public Sprite[] getMaoAdversarioSprite() {
		return maoAdversarioSprite;
	}

	public void setMaoAdversarioSprite(Sprite[] maoAdversarioSprite) {
		this.maoAdversarioSprite = maoAdversarioSprite;
	}

	public JButton getBotaoFimTurno() {
		return botaoFimTurno;
	}

	public void setBotaoFimTurno(JButton botaoFimTurno) {
		this.botaoFimTurno = botaoFimTurno;
	}

	public Sprite getVisualizarCarta() {
		return visualizarCarta;
	}

	public void setVisualizarCarta(Sprite visualizarCarta) {
		this.visualizarCarta = visualizarCarta;
	}

	public Sprite getIconsJogadorSprite() {
		return iconsJogadorSprite;
	}

	public void setIconsJogadorSprite(Sprite iconsJogadorSprite) {
		this.iconsJogadorSprite = iconsJogadorSprite;
	}

	public Sprite getIconsAdversarioSprite() {
		return iconsAdversarioSprite;
	}

	public void setIconsAdversarioSprite(Sprite iconsAdversarioSprite) {
		this.iconsAdversarioSprite = iconsAdversarioSprite;
	}

	public JLabel getBtnCartasNaMao() {
		return btnCartasNaMao;
	}

	public void setBtnCartasNaMao(JLabel btnCartasNaMao) {
		this.btnCartasNaMao = btnCartasNaMao;
	}

	public JLabel getBtnFimDeTurno() {
		return btnFimDeTurno;
	}

	public void setBtnFimDeTurno(JLabel btnFimDeTurno) {
		this.btnFimDeTurno = btnFimDeTurno;
	}

	public Sprite getIrSprite() {
		return irSprite;
	}

	public void setIrSprite(Sprite irSprite) {
		this.irSprite = irSprite;
	}

	public Sprite getVoltarSprite() {
		return voltarSprite;
	}

	public void setVoltarSprite(Sprite voltarSprite) {
		this.voltarSprite = voltarSprite;
	}

	public Sprite getJogarSprite() {
		return jogarSprite;
	}

	public void setJogarSprite(Sprite jogarSprite) {
		this.jogarSprite = jogarSprite;
	}

	public Sprite getPularSprite() {
		return pularSprite;
	}

	public void setPularSprite(Sprite pularSprite) {
		this.pularSprite = pularSprite;
	}

	public Sprite getHomeSprite() {
		return homeSprite;
	}

	public void setHomeSprite(Sprite homeSprite) {
		this.homeSprite = homeSprite;
	}

	public Sprite getImagensAjudaSprite() {
		return imagensAjudaSprite;
	}

	public void setImagensAjudaSprite(Sprite imagensAjudaSprite) {
		this.imagensAjudaSprite = imagensAjudaSprite;
	}

	public Sprite getBtnHomeSprite() {
		return btnHomeSprite;
	}

	public void setBtnHomeSprite(Sprite btnHomeSprite) {
		this.btnHomeSprite = btnHomeSprite;
	}

	public Sprite getBtnConfigSprite() {
		return btnConfigSprite;
	}

	public void setBtnConfigSprite(Sprite btnConfigSprite) {
		this.btnConfigSprite = btnConfigSprite;
	}

	public Sprite getBtnFecharCartasSprite() {
		return btnFecharCartasSprite;
	}

	public void setBtnFecharCartasSprite(Sprite btnFecharCartasSprite) {
		this.btnFecharCartasSprite = btnFecharCartasSprite;
	}

	public Sprite getBtnCartanaMaoSprite() {
		return btnCartanaMaoSprite;
	}

	public void setBtnCartanaMaoSprite(Sprite btnCartanaMaoSprite) {
		this.btnCartanaMaoSprite = btnCartanaMaoSprite;
	}

	public Sprite getBtnFimDeTurnoSprite() {
		return btnFimDeTurnoSprite;
	}

	public void setBtnFimDeTurnoSprite(Sprite btnFimDeTurnoSprite) {
		this.btnFimDeTurnoSprite = btnFimDeTurnoSprite;
	}

	public Sprite getBordaJogadorSprite() {
		return bordaJogadorSprite;
	}

	public void setBordaJogadorSprite(Sprite bordaJogadorSprite) {
		this.bordaJogadorSprite = bordaJogadorSprite;
	}

	public Sprite getBordaAdversarioSprite() {
		return bordaAdversarioSprite;
	}

	public void setBordaAdversarioSprite(Sprite bordaAdversarioSprite) {
		this.bordaAdversarioSprite = bordaAdversarioSprite;
	}

	public Sprite getBackPanelConfigSprite() {
		return backPanelConfigSprite;
	}

	public void setBackPanelConfigSprite(Sprite backPanelConfigSprite) {
		this.backPanelConfigSprite = backPanelConfigSprite;
	}

	public Sprite getBtnSairPanelConfigSprite() {
		return btnSairPanelConfigSprite;
	}

	public void setBtnSairPanelConfigSprite(Sprite btnSairPanelConfigSprite) {
		this.btnSairPanelConfigSprite = btnSairPanelConfigSprite;
	}

	public Sprite getBtnMusicaPanelConfigSprite() {
		return btnMusicaPanelConfigSprite;
	}

	public void setBtnMusicaPanelConfigSprite(Sprite btnMusicaPanelConfigSprite) {
		this.btnMusicaPanelConfigSprite = btnMusicaPanelConfigSprite;
	}

	public Sprite getBtnEfeitosSonorosPanelConfigSprite() {
		return btnEfeitosSonorosPanelConfigSprite;
	}

	public void setBtnEfeitosSonorosPanelConfigSprite(Sprite btnEfeitosSonorosPanelConfigSprite) {
		this.btnEfeitosSonorosPanelConfigSprite = btnEfeitosSonorosPanelConfigSprite;
	}

	public Sprite getBtnAjudaPanelConfigSprite() {
		return btnAjudaPanelConfigSprite;
	}

	public void setBtnAjudaPanelConfigSprite(Sprite btnAjudaPanelConfigSprite) {
		this.btnAjudaPanelConfigSprite = btnAjudaPanelConfigSprite;
	}

	public Sprite getMsgJogoPanelSprite() {
		return msgJogoPanelSprite;
	}

	public void setMsgJogoPanelSprite(Sprite msgJogoPanelSprite) {
		this.msgJogoPanelSprite = msgJogoPanelSprite;
	}

	public Sprite getBtnYouTubePanelConfigSprite() {
		return btnYouTubePanelConfigSprite;
	}

	public void setBtnYouTubePanelConfigSprite(Sprite btnYouTubePanelConfigSprite) {
		this.btnYouTubePanelConfigSprite = btnYouTubePanelConfigSprite;
	}

	public Sprite getBtnJogarNovamenteSprite() {
		return btnJogarNovamenteSprite;
	}

	public void setBtnJogarNovamenteSprite(Sprite btnJogarNovamenteSprite) {
		this.btnJogarNovamenteSprite = btnJogarNovamenteSprite;
	}


	public Sprite getSairJogoBtnSprite() {
		return sairJogoBtnSprite;
	}


	public void setSairJogoBtnSprite(Sprite sairJogoBtnSprite) {
		this.sairJogoBtnSprite = sairJogoBtnSprite;
	}

}

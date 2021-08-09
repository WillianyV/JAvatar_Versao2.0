package view;

import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JPanel;

import Util.Util;
import model.Sprite;

public class TutorialPanel extends JPanel{
	private Sprite irSprite, voltarSprite, finalizarSprite, pularSprite,homeSprite, imagensAjudaSprite; 

	public TutorialPanel() {
		//TUTORIAL:
		try {
			irSprite = new Sprite("javatar.files\\Imagens\\Sprites\\SpriteBotaoNovo.png", 0, 52, 52, 1, 5, 1270, 342);
			voltarSprite = new Sprite("javatar.files\\Imagens\\Sprites\\SpriteBotaoNovo.png", 1, 52, 52, 1, 5, 10, 342);				
			homeSprite = new Sprite("javatar.files\\Imagens\\Sprites\\SpriteBotaoNovo.png", 3, 52, 52, 1, 5, 1270, 10);	
			
			finalizarSprite = new Sprite("javatar.files\\Imagens\\Sprites\\btn-do-jogo.png", 1, 197, 53, 4, 1, 580, 342);	
			pularSprite = new Sprite("javatar.files\\Imagens\\Sprites\\btn-do-jogo.png", 2, 197, 53, 4, 1, 1125, 695);
			
			imagensAjudaSprite = new Sprite("javatar.files\\Imagens\\Sprites\\SpriteAjuda.png", 0, 1366, 768,1, 7, 0 ,0);
		} catch (IOException e1) {
			Mensagens.messagemErro("Erro ao carregar sprites de Ajuda");
		}

		setSize(Util.LARGURA, Util.ALTURA);
		setVisible(false);
	}
	
	public int colisaoCartas(int x, int y) {
		Rectangle irBotao = new Rectangle(1270,342,52,52);
		Rectangle voltarBotao = new Rectangle(10,342,52,52);		
		Rectangle homeBotao = new Rectangle(1270, 10,52,52);
		
		Rectangle jogarBotao = new Rectangle(580, 342,197, 53);
		Rectangle pularBotao = new Rectangle(1125, 695,197, 53);
		
		Rectangle m = new Rectangle(x, y, 1, 1);
		if(irBotao.intersects(m)) {
			return Util.IR_BOTAO_AJUDA;
		}else if(voltarBotao.intersects(m)) {
			return Util.VOLTAR_BOTAO_AJUDA;
		}else if(jogarBotao.intersects(m)) {
			return Util.FINALIZAR_BOTAO_TUTORIAL;
		}else if(pularBotao.intersects(m)) {
			return Util.PULAR_BOTAO_TUTORIAL;
		}else if(homeBotao.intersects(m)) {
			return Util.HOME_BOTAO_AJUDA;
		}
		return 5;
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

	public Sprite getFinalizarSprite() {
		return finalizarSprite;
	}

	public void setFinalizarSprite(Sprite finalizarSprite) {
		this.finalizarSprite = finalizarSprite;
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
	
	
}

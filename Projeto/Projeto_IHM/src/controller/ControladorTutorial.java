package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Util.Util;
import view.Tela;
import view.TutorialPanel;

public class ControladorTutorial {
	private Tela tela;
	Controlador controlador;
	TutorialPanel tutorialPanel;
	
	public ControladorTutorial(Tela tela) {
		this.tela = tela;
		tutorialPanel = tela.getTutorialPanel();
		
		controlador = new Controlador();
		
		tutorialPanel.addMouseListener(controlador);
		
	}

	 private class Controlador implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(tutorialPanel.colisaoCartas(e.getX(), e.getY()) == Util.IR_BOTAO_AJUDA) {
				if(tutorialPanel.getImagensAjudaSprite().aparencia < 6) {
					tutorialPanel.getImagensAjudaSprite().aparencia++;
				}
			}else if(tutorialPanel.colisaoCartas(e.getX(), e.getY()) == Util.VOLTAR_BOTAO_AJUDA){
				if(tutorialPanel.getImagensAjudaSprite().aparencia > 0) {
					tutorialPanel.getImagensAjudaSprite().aparencia--;
				}
			}else if(tutorialPanel.colisaoCartas(e.getX(), e.getY()) == Util.HOME_BOTAO_AJUDA ||
					tutorialPanel.colisaoCartas(e.getX(), e.getY()) == Util.PULAR_BOTAO_TUTORIAL||
					((tutorialPanel.colisaoCartas(e.getX(), e.getY()) == Util.FINALIZAR_BOTAO_TUTORIAL) &&
							(tutorialPanel.getImagensAjudaSprite().aparencia == 6))){
				tutorialPanel.setVisible(false);
				tela.getInicialPanel().setVisible(true);
			}
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		 
	 }
}

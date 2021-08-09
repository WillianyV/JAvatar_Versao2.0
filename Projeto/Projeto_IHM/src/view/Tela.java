/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.Util;

import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import model.Jogador;
import model.Sons;

/**
 *
 * @author willi
 */
public class Tela extends JFrame {

	private BufferedImage buffer;
    /*
    Telas:
     */
    private InicialPanel inicialPanel;
    private JogoPanel jogoPanel;
    private TutorialPanel tutorialPanel;
    
    /*
    Modelos:
     */
    private Jogador jogador, jogador2;
    private Scanner leitor;
    private PrintWriter escrever;

    //Construtor
    public Tela(InicialPanel inicialPanel, JogoPanel jogoPanel,TutorialPanel tutorialPanel) {

        this.inicialPanel = inicialPanel;
        this.jogoPanel = jogoPanel;
        this.tutorialPanel = tutorialPanel;
        
        this.jogador = new Jogador();
        this.jogador2 = new Jogador();

        buffer = new BufferedImage(Util.LARGURA, Util.ALTURA, BufferedImage.TYPE_INT_ARGB);
        
        setSize(Util.LARGURA, Util.ALTURA);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("JAvatar Quiz");
        setIconImage(new ImageIcon("javatar.files\\Imagens\\Telas\\icone.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        add(inicialPanel).setBounds(0, 0, Util.LARGURA, Util.ALTURA);
        add(tutorialPanel).setBounds(0, 0, Util.LARGURA, Util.ALTURA);
        add(jogoPanel).setBounds(0, 0, Util.LARGURA, Util.ALTURA);

        setUndecorated(true);
        setVisible(true);
    }

    public InicialPanel getInicialPanel() {
        return inicialPanel;
    }

    public void setInicialPanel(InicialPanel inicialPanel) {
        this.inicialPanel = inicialPanel;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public JogoPanel getJogoPanel() {
        return jogoPanel;
    }

    public void setJogoPanel(JogoPanel jogoPanel) {
        this.jogoPanel = jogoPanel;
    }

    public Scanner getLeitor() {
        return leitor;
    }

    public PrintWriter getEscrever() {
        return escrever;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

	public BufferedImage getBuffer() {
		return buffer;
	}

	public void setBuffer(BufferedImage buffer) {
		this.buffer = buffer;
	}

	public TutorialPanel getTutorialPanel() {
		return tutorialPanel;
	}

	public void setTutorialPanel(TutorialPanel tutorialPanel) {
		this.tutorialPanel = tutorialPanel;
	}
	
}

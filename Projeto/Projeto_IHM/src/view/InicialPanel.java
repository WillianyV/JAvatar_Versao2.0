/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Rectangle;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.accessibility.AccessibleContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

import Util.Util;
import model.DocumentoLimitado;
import model.Sprite;

/**
 *
 * @author willi
 */
public class InicialPanel extends javax.swing.JPanel {
    
    private ImageIcon backIcon,vcGanhouIcon;
    private Sprite msgSprite, btnOkaySprite;
    private ImageIcon personagemAvatar, nickText,jogarBotaoIcon, customizarBotaoIcon,somBotaoIcon,ajudaBotaoIcon,youtubeBotaoIcon,infoBotaoIcon;
    private Sprite jogador1Sprite, jogador2Sprite, contSprite;
    private Sprite btnSairJogoPaginaInicialSprite, botãoSairSobreSomSprite, sobreSomSprite, musicaBotaoSprite, efeitoBotaoSprite;

    /**
     * Creates new form InicialPanel
     */
    public InicialPanel(){
    	
    	
        backIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\Menu2.png");
        vcGanhouIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\you_win.png");
        personagemAvatar = new ImageIcon("javatar.files\\Imagens\\personagens\\AangMostrar.png");
        jogarBotaoIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\jogar.png"); 
        customizarBotaoIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\customizar2.png");
        somBotaoIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\Som.png");
        ajudaBotaoIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\sobre.png");
        youtubeBotaoIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\youtube.png");
        infoBotaoIcon = new ImageIcon("javatar.files\\Imagens\\Telas\\info.png");
        
        //botoes 
        try {
        	btnSairJogoPaginaInicialSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesIconGamePageSprite.png", 2,  37, 37, 4, 1, 1320, 7);
        	botãoSairSobreSomSprite = new Sprite("javatar.files\\Imagens\\Sprites\\botoesIconGamePageSprite.png", 2,  37, 37, 4, 1, 843, 300);
        	 musicaBotaoSprite= new Sprite("javatar.files\\Imagens\\Sprites\\Som-SemSomSprite.png", 0,  35, 35, 3, 1, 843, 345); 
        	 efeitoBotaoSprite= new Sprite("javatar.files\\Imagens\\Sprites\\Som-SemSomSprite.png", 0,  35, 35, 3, 1, 843, 385);
        } catch (IOException e) {
			Mensagens.messagemErro("Erro ao exibir botao de sair");
		}
        //sobre e som
        try {
			sobreSomSprite = new Sprite("javatar.files\\Imagens\\Sprites\\somInfoSprite.png", 0, 400, 170, 3, 1, 490, 290);
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao exibir Panel");
		}
        //msg
        try {
			msgSprite = new Sprite("javatar.files\\Imagens\\Sprites\\msgSprite.png", 0,  400, 215, 5, 1, 480, 70);
			btnOkaySprite =  new Sprite("javatar.files\\Imagens\\Sprites\\btn-do-jogo.png", 3, 197, 53, 4, 1, 580, 218);	
			
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao exibir mensagens");
		}
        //avatares
        try {
        	jogador1Sprite =  new Sprite("javatar.files\\Imagens\\Sprites\\EscolherJogadorNomeSprite.png", 0, 150, 234, 6, 1, 100, 290);	
			jogador2Sprite =  new Sprite("javatar.files\\Imagens\\Sprites\\EscolherAdversarioNomeSprite.png", 0, 150, 234, 6, 1, 1100, 290);	
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao exibir os jogador e adversário");
		}
        // 5 4 3 2 1
        try {
        	contSprite =  new Sprite("javatar.files\\Imagens\\Sprites\\contSprit.png", 0, 100, 100, 6, 1, 629, 290);
		} catch (IOException e) {
			Mensagens.messagemErro("Erro ao iniciar a sprite de números");
		}
        initComponents();
                
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        mostrarZucoLabel = new javax.swing.JLabel();
        mostrarTophLabel = new javax.swing.JLabel();
        mostrarSokkaLabel = new javax.swing.JLabel();
        mostrarAangLabel = new javax.swing.JLabel();
        mostrarKataraLabel = new javax.swing.JLabel();
        nomeJLabel = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        acoesjLabel = new javax.swing.JLabel();
        customizarPanel = new javax.swing.JPanel();
        nickLabel = new javax.swing.JLabel();
        personagemjLabel = new javax.swing.JLabel();
        nickTextField = new javax.swing.JTextField();
        nickTextField.setDocument(new DocumentoLimitado(10));
        aangButton = new javax.swing.JButton();
        kataraButton = new javax.swing.JButton();
        sokkaButton = new javax.swing.JButton();
        tophButton = new javax.swing.JButton();
        zucoButton = new javax.swing.JButton();
        sobrePanel = new javax.swing.JPanel();
        tituloSobrejLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoSobrejTextArea = new javax.swing.JTextArea();
        somPanel = new javax.swing.JPanel();
        musicaLabel = new javax.swing.JLabel();
        efeitosLabel = new javax.swing.JLabel();
        musicaToggleButton = new javax.swing.JToggleButton();
        efeitosToggleButton = new javax.swing.JToggleButton();
//        somLabel = new javax.swing.JLabel();
//        infoLabel = new javax.swing.JLabel();
//        sobreLabel = new javax.swing.JLabel();
//        customizarBotaoLabel = new javax.swing.JLabel();
//        jogarBotaoLabel = new javax.swing.JLabel();
//        imagemDeFundojLabel = new javax.swing.JLabel();

        setLayout(null);

        mostrarZucoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/ZucoMostrar.png"))); // NOI18N
        add(mostrarZucoLabel);
        mostrarZucoLabel.setBounds(90, 230, 180, 210);
        mostrarZucoLabel.setVisible(false);

        mostrarTophLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/TophMostrar.png"))); // NOI18N
        add(mostrarTophLabel);
        mostrarTophLabel.setBounds(120, 230, 120, 210);
        mostrarTophLabel.setVisible(false);

        mostrarSokkaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/sokkaMostrar.png"))); // NOI18N
        add(mostrarSokkaLabel);
        mostrarSokkaLabel.setBounds(100, 230, 140, 210);
        mostrarSokkaLabel.setVisible(false);

        mostrarAangLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/AangMostrar.png"))); // NOI18N
        add(mostrarAangLabel);
        mostrarAangLabel.setBounds(90, 230, 170, 210);
        mostrarAangLabel.setVisible(false);

        mostrarKataraLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/KataraMostrar.png"))); // NOI18N
        add(mostrarKataraLabel);
        mostrarKataraLabel.setBounds(100, 230, 150, 210);
        mostrarKataraLabel.setVisible(false);

        nomeJLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        nomeJLabel.setForeground(new java.awt.Color(255, 255, 255));
        nomeJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeJLabel.setText("TOPH");
        add(nomeJLabel);
        nomeJLabel.setBounds(90, 450, 180, 34);
        nomeJLabel.setVisible(false);

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        acoesjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/ajuda3.png"))); // NOI18N

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(acoesjLabel)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(acoesjLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(infoPanel);
        infoPanel.setBounds(470, 290, 420, 380);
        infoPanel.setVisible(false);

        customizarPanel.setBackground(new java.awt.Color(255, 255, 255));

        nickLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nickLabel.setForeground(new java.awt.Color(87, 61, 28));
        nickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/icons8-editar-utilizador-20.png"))); // NOI18N
        nickLabel.setText("Nick:");

        personagemjLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        personagemjLabel.setForeground(new java.awt.Color(87, 61, 28));
        personagemjLabel.setText("Escolha o Personagem:");

        nickTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        nickTextField.setForeground(new java.awt.Color(87, 61, 28));
        nickTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        aangButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/head_aang.png"))); // NOI18N
        aangButton.setBorder(null);
        aangButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        kataraButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/head_katara.png"))); // NOI18N
        kataraButton.setBorder(null);
        kataraButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        sokkaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/head_sokka.png"))); // NOI18N
        sokkaButton.setBorder(null);
        sokkaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tophButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/head_toph.png"))); // NOI18N
        tophButton.setBorder(null);
        tophButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        zucoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/head_zuko.png"))); // NOI18N
        zucoButton.setBorder(null);
        zucoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout customizarPanelLayout = new javax.swing.GroupLayout(customizarPanel);
        customizarPanel.setLayout(customizarPanelLayout);
        customizarPanelLayout.setHorizontalGroup(
            customizarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(customizarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customizarPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(customizarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(customizarPanelLayout.createSequentialGroup()
                            .addComponent(nickLabel)
                            .addGap(18, 18, 18)
                            .addComponent(nickTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(personagemjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(customizarPanelLayout.createSequentialGroup()
                            .addComponent(aangButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(kataraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(sokkaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(tophButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(zucoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        customizarPanelLayout.setVerticalGroup(
            customizarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
            .addGroup(customizarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customizarPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(customizarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nickLabel)
                        .addComponent(nickTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addComponent(personagemjLabel)
                    .addGap(21, 21, 21)
                    .addGroup(customizarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(aangButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kataraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sokkaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tophButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(zucoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(customizarPanel);
        customizarPanel.setBounds(470, 290, 420, 170);
        customizarPanel.setVisible(false);

        sobrePanel.setBackground(new java.awt.Color(255, 255, 255));

        tituloSobrejLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tituloSobrejLabel.setForeground(new java.awt.Color(87, 61, 28));
        tituloSobrejLabel.setText("Sobre");

        jScrollPane1.setEnabled(false);

        textoSobrejTextArea.setEditable(false);
        textoSobrejTextArea.setColumns(20);
        textoSobrejTextArea.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        textoSobrejTextArea.setForeground(new java.awt.Color(87, 61, 28));
        textoSobrejTextArea.setRows(5);
       // textoSobrejTextArea.setText("PCC do curso de BSI  da UAST/UFRPE, da aluna Williany ");
        textoSobrejTextArea.setText("   Este jogo é pertencente ao Projeto de Conclusão de Curso\n"
        						  + "  de Williany Veras, graduanda em Bacharelado em Sistemas\n"
        						  + "   de Informação da UAST/UFRPE sob orientação do Prof. Dr.\n"
        						  + "\t         Richarlyson D'EMery.");
        jScrollPane1.setViewportView(textoSobrejTextArea);

        javax.swing.GroupLayout sobrePanelLayout = new javax.swing.GroupLayout(sobrePanel);
        sobrePanel.setLayout(sobrePanelLayout);
        sobrePanelLayout.setHorizontalGroup(
            sobrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sobrePanelLayout.createSequentialGroup()
                .addGroup(sobrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sobrePanelLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(tituloSobrejLabel))
                    .addGroup(sobrePanelLayout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        sobrePanelLayout.setVerticalGroup(
            sobrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sobrePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloSobrejLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        add(sobrePanel);
        sobrePanel.setBounds(470, 290, 420, 170);
        sobrePanel.setVisible(false);

        somPanel.setBackground(new java.awt.Color(255, 255, 255));

        musicaLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        musicaLabel.setForeground(new java.awt.Color(87, 61, 28));
        musicaLabel.setText("Musica:");

        efeitosLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        efeitosLabel.setForeground(new java.awt.Color(87, 61, 28));
        efeitosLabel.setText("Efeitos:");

        musicaToggleButton.setBackground(new java.awt.Color(217, 174, 97));
        musicaToggleButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        musicaToggleButton.setForeground(new java.awt.Color(87, 61, 28));
        musicaToggleButton.setText("ON");
        musicaToggleButton.setBorder(null);
        musicaToggleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        musicaToggleButton.setMaximumSize(new java.awt.Dimension(22, 19));
        musicaToggleButton.setPreferredSize(new java.awt.Dimension(22, 19));

        efeitosToggleButton.setBackground(new java.awt.Color(217, 174, 97));
        efeitosToggleButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        efeitosToggleButton.setForeground(new java.awt.Color(87, 61, 28));
        efeitosToggleButton.setText("ON");
        efeitosToggleButton.setBorder(null);
        efeitosToggleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        efeitosToggleButton.setPreferredSize(new java.awt.Dimension(22, 19));

        javax.swing.GroupLayout somPanelLayout = new javax.swing.GroupLayout(somPanel);
        somPanel.setLayout(somPanelLayout);
        somPanelLayout.setHorizontalGroup(
            somPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(somPanelLayout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(somPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(efeitosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musicaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(somPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(efeitosToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(musicaToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        somPanelLayout.setVerticalGroup(
            somPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(somPanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(somPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(musicaLabel)
                    .addComponent(musicaToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(somPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(efeitosLabel)
                    .addComponent(efeitosToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        add(somPanel);
        somPanel.setBounds(470, 290, 420, 130);
        somPanel.setVisible(false);

//        somLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/Som.png"))); // NOI18N
//        somLabel.setToolTipText("");
//        somLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        add(somLabel);
//        somLabel.setBounds(1138, 7, 35, 35);
//
//        infoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/sobre.png"))); // NOI18N
//        infoLabel.setToolTipText("");
//        infoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        add(infoLabel);
//        infoLabel.setBounds(1194, 7, 35, 35);
//
//        sobreLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/info.png"))); // NOI18N
//        sobreLabel.setToolTipText("");
//        sobreLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        add(sobreLabel);
//        sobreLabel.setBounds(1250, 7, 35, 35);

//        customizarBotaoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/customizar.png"))); // NOI18N
//        customizarBotaoLabel.setText("jLabel1");
//        customizarBotaoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        add(customizarBotaoLabel);
//        customizarBotaoLabel.setBounds(1110, 230, 197, 185);
//
//        jogarBotaoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/jogar.png"))); // NOI18N
//        jogarBotaoLabel.setText("jLabel1");
//        jogarBotaoLabel.setToolTipText("");
//        jogarBotaoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        add(jogarBotaoLabel);
//        jogarBotaoLabel.setBounds(1110, 450, 197, 55);
//
//        imagemDeFundojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/imagens/Menu2.png"))); // NOI18N
//        imagemDeFundojLabel.setAlignmentY(0.0F);
//        add(imagemDeFundojLabel);
//        imagemDeFundojLabel.setBounds(0, 0, 1366, 768);
//        imagemDeFundojLabel.setVisible(true);
//   
    
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration
    private javax.swing.JButton aangButton;
    private javax.swing.JLabel acoesjLabel;
  //  private javax.swing.JLabel customizarBotaoLabel;
    private javax.swing.JPanel customizarPanel;
    private javax.swing.JLabel efeitosLabel;
    private javax.swing.JToggleButton efeitosToggleButton;
  //  private javax.swing.JLabel imagemDeFundojLabel;
  //  private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
 //   private javax.swing.JLabel jogarBotaoLabel;
    private javax.swing.JButton kataraButton;
    private javax.swing.JLabel mostrarAangLabel;
    private javax.swing.JLabel mostrarKataraLabel;
    private javax.swing.JLabel mostrarSokkaLabel;
    private javax.swing.JLabel mostrarTophLabel;
    private javax.swing.JLabel mostrarZucoLabel;
    private javax.swing.JLabel musicaLabel;
    private javax.swing.JToggleButton musicaToggleButton;
    private javax.swing.JLabel nickLabel;
    private javax.swing.JTextField nickTextField;
    private javax.swing.JLabel nomeJLabel;
    private javax.swing.JLabel personagemjLabel;
  //  private javax.swing.JLabel sobreLabel;
    private javax.swing.JPanel sobrePanel;
    private javax.swing.JButton sokkaButton;
   // private javax.swing.JLabel somLabel;
    private javax.swing.JPanel somPanel;
    private javax.swing.JTextArea textoSobrejTextArea;
    private javax.swing.JLabel tituloSobrejLabel;
    private javax.swing.JButton tophButton;
    private javax.swing.JButton zucoButton;
    // End of variables declaration//GEN-END:variables

    //Pegar ip da maquina
    
    public String pegarIP(){
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
            return ip;
        } catch (UnknownHostException e) {
            Mensagens.messagemErro("Erro ao adquirir ip.\n" + e);
            return null;
        }
    }
    
//    desenharBuffer.drawImage(tela.getInicialPanel().getSomBotaoIcon().getImage(), 1128, 7, null);
//    desenharBuffer.drawImage(tela.getInicialPanel().getAjudaBotaoIcon().getImage(), 1173, 7, null);
//    desenharBuffer.drawImage(tela.getInicialPanel().getYoutubeBotaoIcon().getImage(), 1218, 7, null);
//    desenharBuffer.drawImage(tela.getInicialPanel().getInfoBotaoIcon().getImage(), 1263, 7, null);
    
    
    
    public int colisaoBotaoConfig(int x, int y) {
		Rectangle somBotao = new Rectangle(1128, 7, 35, 35);
		Rectangle ajudaBotao = new Rectangle(1173, 7, 35, 35);
		Rectangle youtubeBotao = new Rectangle( 1218, 7, 35, 35);
		Rectangle infotubeBotao = new Rectangle( 1263, 7, 35, 35);
		Rectangle sairJogoBotao = new Rectangle( 1320, 7, 37, 37);
		Rectangle sairSomSobreBotao = new Rectangle( 843, 300, 37, 37);
		Rectangle musicaBotao = new Rectangle( 843, 345, 35, 35);
		Rectangle efeitoBotao = new Rectangle( 843, 385, 35, 35);
//		
//  	 musicaBotaoSprite= new Sprite("javatar.files\\Imagens\\Sprites\\Som-SemSomSprite.png", 0,  35, 35, 3, 1, 843, 345); 
//  	 efeitoBotaoSprite= new Sprite("javatar.files\\Imagens\\Sprites\\Som-SemSomSprite.png", 0,  35, 35, 3, 1, 843, 385);
		Rectangle m = new Rectangle(x, y, 1, 1);
		
		if(somBotao.intersects(m)) {
			return Util.SOM_BOTAO_PANEL_INICIAL;
		}
		else if(ajudaBotao.intersects(m)) {
			return Util.AJUDA_BOTAO_PANEL_INICIAL;
		}
		else if(youtubeBotao.intersects(m)) {
			return Util.YOUTUBE_BOTAO_PANEL_INICIAL;
		}
		else if(infotubeBotao.intersects(m)) {
			return Util.INFO_BOTAO_PANEL_INICIAL;
		}
		else if(sairJogoBotao.intersects(m)) {
			return Util.SAIR_BOTAO_PANEL_JOGO;
		}
		else if(sairSomSobreBotao.intersects(m)) {
			return Util.SAIR_PANEL_SOM_SOBRE;
		}		
		else if(musicaBotao.intersects(m)) {
			return Util.MUSICA_PANEL_SOM;
		}
		else if(efeitoBotao.intersects(m)) {
			return Util.EFEITOS_PANEL_SOM;
		}	
		return 5;
	}
    
    
    public int colisaoBotaoMsg(int x, int y) {
		Rectangle okBotao = new Rectangle(580, 218,197, 53);
		Rectangle customizarBotao = new Rectangle(586, 530, 197, 55);
		Rectangle jogarBotao = new Rectangle( 586, 470, 197, 55);
		Rectangle m = new Rectangle(x, y, 1, 1);
		
		if(okBotao.intersects(m)) {
			return Util.OK_BOTAO_MSG_PANEL_INICIAL;
		}
		else if(customizarBotao.intersects(m)) {
			return Util.CUSTOMIZAR_PANEL_INICIAL;
		}
		else if(jogarBotao.intersects(m)) {
			return Util.JOGAR_PANEL_INICIAL;
		}
		return 5;
	}
    
    public void contagem() {
    	while (Util.DESENHAR_CONT) {
    		if(contSprite.aparencia < 6) {
    			try {    				
					Thread.sleep(1000);
					contSprite.aparencia++;
					if(contSprite.aparencia == 5) {
						contSprite.aparencia=0;
						Util.DESENHAR_CONT= false;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    	}

    }
   
    public JButton getAangButton() {
        return aangButton;
    }

    public void setAangButton(JButton aangButton) {
        this.aangButton = aangButton;
    }

    public JLabel getAcoesjLabel() {
        return acoesjLabel;
    }

    public void setAcoesjLabel(JLabel acoesjLabel) {
        this.acoesjLabel = acoesjLabel;
    }

//    public JLabel getCustomizarBotaoLabel() {
//        return customizarBotaoLabel;
//    }
//
//    public void setCustomizarBotaoLabel(JLabel customizarBotaoLabel) {
//        this.customizarBotaoLabel = customizarBotaoLabel;
//    }

    public JPanel getCustomizarPanel() {
        return customizarPanel;
    }

    public void setCustomizarPanel(JPanel customizarPanel) {
        this.customizarPanel = customizarPanel;
    }

    public JLabel getEfeitosLabel() {
        return efeitosLabel;
    }

    public void setEfeitosLabel(JLabel efeitosLabel) {
        this.efeitosLabel = efeitosLabel;
    }

    public JToggleButton getEfeitosToggleButton() {
        return efeitosToggleButton;
    }

    public void setEfeitosToggleButton(JToggleButton efeitosToggleButton) {
        this.efeitosToggleButton = efeitosToggleButton;
    }
//
//    public JLabel getImagemDeFundojLabel() {
//        return imagemDeFundojLabel;
//    }
//
//    public void setImagemDeFundojLabel(JLabel imagemDeFundojLabel) {
//        this.imagemDeFundojLabel = imagemDeFundojLabel;
//    }
//
//    public JLabel getInfoLabel() {
//        return infoLabel;
//    }
//
//    public void setInfoLabel(JLabel infoLabel) {
//        this.infoLabel = infoLabel;
//    }

    public JPanel getInfoPanel() {
        return infoPanel;
    }

    public void setInfoPanel(JPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

//    public JLabel getJogarBotaoLabel() {
//        return jogarBotaoLabel;
//    }
//
//    public void setJogarBotaoLabel(JLabel jogarBotaoLabel) {
//        this.jogarBotaoLabel = jogarBotaoLabel;
//    }

    public JButton getKataraButton() {
        return kataraButton;
    }

    public void setKataraButton(JButton kataraButton) {
        this.kataraButton = kataraButton;
    }

    public JLabel getMusicaLabel() {
        return musicaLabel;
    }

    public void setMusicaLabel(JLabel musicaLabel) {
        this.musicaLabel = musicaLabel;
    }

    public JToggleButton getMusicaToggleButton() {
        return musicaToggleButton;
    }

    public void setMusicaToggleButton(JToggleButton musicaToggleButton) {
        this.musicaToggleButton = musicaToggleButton;
    }

    public JLabel getNickLabel() {
        return nickLabel;
    }

    public void setNickLabel(JLabel nickLabel) {
        this.nickLabel = nickLabel;
    }

    public JTextField getNickTextField() {
        return nickTextField;
    }

    public void setNickTextField(JTextField nickTextField) {
        this.nickTextField = nickTextField;
    }

    public JLabel getPersonagemjLabel() {
        return personagemjLabel;
    }

    public void setPersonagemjLabel(JLabel personagemjLabel) {
        this.personagemjLabel = personagemjLabel;
    }

//    public JLabel getSobreLabel() {
//        return sobreLabel;
//    }
//
//    public void setSobreLabel(JLabel sobreLabel) {
//        this.sobreLabel = sobreLabel;
//    }

    public JPanel getSobrePanel() {
        return sobrePanel;
    }

    public void setSobrePanel(JPanel sobrePanel) {
        this.sobrePanel = sobrePanel;
    }

    public JButton getSokkaButton() {
        return sokkaButton;
    }

    public void setSokkaButton(JButton sokkaButton) {
        this.sokkaButton = sokkaButton;
    }

//    public JLabel getSomLabel() {
//        return somLabel;
//    }
//
//    public void setSomLabel(JLabel somLabel) {
//        this.somLabel = somLabel;
//    }

    public JPanel getSomPanel() {
        return somPanel;
    }

    public void setSomPanel(JPanel somPanel) {
        this.somPanel = somPanel;
    }

    public JTextArea getTextoSobrejTextArea() {
        return textoSobrejTextArea;
    }

    public void setTextoSobrejTextArea(JTextArea textoSobrejTextArea) {
        this.textoSobrejTextArea = textoSobrejTextArea;
    }

    public JLabel getTituloSobrejLabel() {
        return tituloSobrejLabel;
    }

    public void setTituloSobrejLabel(JLabel tituloSobrejLabel) {
        this.tituloSobrejLabel = tituloSobrejLabel;
    }

    public JButton getTophButton() {
        return tophButton;
    }

    public void setTophButton(JButton tophButton) {
        this.tophButton = tophButton;
    }

    public JButton getZucoButton() {
        return zucoButton;
    }

    public void setZucoButton(JButton zucoButton) {
        this.zucoButton = zucoButton;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }


    public JLabel getMostrarKataraLabel() {
        return mostrarKataraLabel;
    }

    public void setMostrarKataraLabel(JLabel mostrarKataraLabel) {
        this.mostrarKataraLabel = mostrarKataraLabel;
    }

    public JLabel getNomeJLabel() {
        return nomeJLabel;
    }

    public void setNomeJLabel(JLabel nomeJLabel) {
        this.nomeJLabel = nomeJLabel;
    }

    public JLabel getMostrarAangLabel() {
        return mostrarAangLabel;
    }

    public void setMostrarAangLabel(JLabel mostrarAangLabel) {
        this.mostrarAangLabel = mostrarAangLabel;
    }

    public JLabel getMostrarSokkaLabel() {
        return mostrarSokkaLabel;
    }

    public void setMostrarSokkaLabel(JLabel mostrarSokkaLabel) {
        this.mostrarSokkaLabel = mostrarSokkaLabel;
    }

    public JLabel getMostrarTophLabel() {
        return mostrarTophLabel;
    }

    public void setMostrarTophLabel(JLabel mostrarTophLabel) {
        this.mostrarTophLabel = mostrarTophLabel;
    }

    public JLabel getMostrarZucoLabel() {
        return mostrarZucoLabel;
    }

    public void setMostrarZucoLabel(JLabel mostrarZucoLabel) {
        this.mostrarZucoLabel = mostrarZucoLabel;
    }

    public ImageIcon getBackIcon() {
        return backIcon;
    }

    public void setBackIcon(ImageIcon backIcon) {
        this.backIcon = backIcon;
    }

    public ImageIcon getVcGanhouIcon() {
        return vcGanhouIcon;
    }

    public void setVcGanhouIcon(ImageIcon vcGanhouIcon) {
        this.vcGanhouIcon = vcGanhouIcon;
    }

	public Sprite getMsgSprite() {
		return msgSprite;
	}

	public void setMsgSprite(Sprite msgSprite) {
		this.msgSprite = msgSprite;
	}

	public Sprite getBtnOkaySprite() {
		return btnOkaySprite;
	}

	public void setBtnOkaySprite(Sprite btnOkaySprite) {
		this.btnOkaySprite = btnOkaySprite;
	}

	public ImageIcon getPersonagemAvatar() {
		return personagemAvatar;
	}

	public void setPersonagemAvatar(ImageIcon personagemAvatar) {
		this.personagemAvatar = personagemAvatar;
	}

	public ImageIcon getNickText() {
		return nickText;
	}

	public void setNickText(ImageIcon nickText) {
		this.nickText = nickText;
	}

	public ImageIcon getJogarBotaoIcon() {
		return jogarBotaoIcon;
	}

	public void setJogarBotaoIcon(ImageIcon jogarBotaoIcon) {
		this.jogarBotaoIcon = jogarBotaoIcon;
	}

	public ImageIcon getCustomizarBotaoIcon() {
		return customizarBotaoIcon;
	}

	public void setCustomizarBotaoIcon(ImageIcon customizarBotaoIcon) {
		this.customizarBotaoIcon = customizarBotaoIcon;
	}

	public Sprite getJogador1Sprite() {
		return jogador1Sprite;
	}

	public void setJogador1Sprite(Sprite jogador1Sprite) {
		this.jogador1Sprite = jogador1Sprite;
	}

	public Sprite getJogador2Sprite() {
		return jogador2Sprite;
	}

	public void setJogador2Sprite(Sprite jogador2Sprite) {
		this.jogador2Sprite = jogador2Sprite;
	}

	public Sprite getContSprite() {
		return contSprite;
	}

	public void setContSprite(Sprite contSprite) {
		this.contSprite = contSprite;
	}

	public ImageIcon getSomBotaoIcon() {
		return somBotaoIcon;
	}

	public void setSomBotaoIcon(ImageIcon somBotaoIcon) {
		this.somBotaoIcon = somBotaoIcon;
	}

	public ImageIcon getAjudaBotaoIcon() {
		return ajudaBotaoIcon;
	}

	public void setAjudaBotaoIcon(ImageIcon ajudaBotaoIcon) {
		this.ajudaBotaoIcon = ajudaBotaoIcon;
	}

	public ImageIcon getYoutubeBotaoIcon() {
		return youtubeBotaoIcon;
	}

	public void setYoutubeBotaoIcon(ImageIcon youtubeBotaoIcon) {
		this.youtubeBotaoIcon = youtubeBotaoIcon;
	}

	public ImageIcon getInfoBotaoIcon() {
		return infoBotaoIcon;
	}

	public void setInfoBotaoIcon(ImageIcon infoBotaoIcon) {
		this.infoBotaoIcon = infoBotaoIcon;
	}

	public Sprite getBtnSairJogoPaginaInicialSprite() {
		return btnSairJogoPaginaInicialSprite;
	}

	public void setBtnSairJogoPaginaInicialSprite(Sprite btnSairJogoPaginaInicialSprite) {
		this.btnSairJogoPaginaInicialSprite = btnSairJogoPaginaInicialSprite;
	}

	public Sprite getSobreSomSprite() {
		return sobreSomSprite;
	}

	public void setSobreSomSprite(Sprite sobreSomSprite) {
		this.sobreSomSprite = sobreSomSprite;
	}

	public Sprite getBotãoSairSobreSomSprite() {
		return botãoSairSobreSomSprite;
	}

	public void setBotãoSairSobreSomSprite(Sprite botãoSairSobreSomSprite) {
		this.botãoSairSobreSomSprite = botãoSairSobreSomSprite;
	}

	public Sprite getMusicaBotaoSprite() {
		return musicaBotaoSprite;
	}

	public void setMusicaBotaoSprite(Sprite musicaBotaoSprite) {
		this.musicaBotaoSprite = musicaBotaoSprite;
	}

	public Sprite getEfeitoBotaoSprite() {
		return efeitoBotaoSprite;
	}

	public void setEfeitoBotaoSprite(Sprite efeitoBotaoSprite) {
		this.efeitoBotaoSprite = efeitoBotaoSprite;
	}
	
}

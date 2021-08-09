/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.ControladorPanelInicial;
import controller.ControladorPanelJogo;
import controller.ControladorTutorial;
import dao.XML;
import model.Desenhar;
import model.GerarCartas;
import model.GerarPerguntas;
import model.Jogador;
import view.InicialPanel;
import view.JogoPanel;
import view.Tela;
import view.TutorialPanel;

/**
 *
 * @author willi
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        GerarPerguntas gerarPerguntas = new GerarPerguntas();
        XML.gerarArquivo(XML.gerarXML(gerarPerguntas.quiz)); 
        XML.leArquivo();
         */
    	
    	
       //GerarCartas gerarcartas = new GerarCartas();
        //XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasAangGrandes()),"AangGrandes");         
        //XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasAangPequenas()),"AangPequenas"); 
        //XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasKataraGrandes()),"KataraGrandes");         
       // XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasKataraPequenas()),"KataraPequenas");
        //XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasSokkaGrandes()),"SokkaGrandes");         
        //XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasSokkaPequenas()),"SokkaPequenas");
        //XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasTophGrandes()),"TophGrandes");         
        //XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasTophPequenas()),"TophPequenas");
        //XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasZucoGrandes()),"ZucoGrandes");         
        //XML.gerarArquivoCartas(XML.gerarXMLCartas(gerarcartas.GerarCartasZucoPequenas()),"ZucoPequenas"); 
    	
    	    
        InicialPanel inicialPanel = new InicialPanel();
        JogoPanel jogoPanel = new JogoPanel();
        TutorialPanel tutorialPanel = new TutorialPanel();

        Tela tela = new Tela(inicialPanel, jogoPanel,tutorialPanel);

        ControladorPanelInicial controladorPanelInicial = new ControladorPanelInicial(tela);
        ControladorPanelJogo controladorPanelJogo = new ControladorPanelJogo(tela, controladorPanelInicial);
        ControladorTutorial controladorTutorial = new ControladorTutorial(tela);
        
        Desenhar desenhar = new Desenhar(tela);
        desenhar.start();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;
import view.Tela;
import Util.Util;

/**
 *
 * @author willi
 */
public class ThreadReceberPacotes extends Thread{
   private Scanner msgScanner;
   private Tela tela;
   
   public ThreadReceberPacotes(Scanner msgScanner, Tela tela){
       this.msgScanner = msgScanner;
       this.tela = tela;
   }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        String linha="";
        
        while (msgScanner.hasNext()) {            
            linha = msgScanner.nextLine();
            interpretarPacotes(linha);
        }
    }
    
    public void interpretarPacotes(String instrucoes){
        if(instrucoes.contains("nick:")){
            tela.getJogador2().setNick(instrucoes.replace("nick:", ""));
        }else if(instrucoes.contains("icon:")){
            tela.getJogador2().setIcone(instrucoes.replace("icon:", ""));
        }else if(instrucoes.contains("atacando")){
            Util.flagAtacandoP2 = true;            
        }else if(instrucoes.contains("defendendo")){
            Util.flagDefesaP2 = true;
        }
    }
   
    
   
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class Mensagens {
    	public static void mensagemExibir(String mensagem){
            JOptionPane.showMessageDialog(null, mensagem);
	}
        public static void messagemErro(String mensagem){            
            JOptionPane.showMessageDialog(null, mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        public static void messagemInfo(String mensagem){            
            JOptionPane.showMessageDialog(null, mensagem, "INFO", JOptionPane.INFORMATION_MESSAGE);
        }
}

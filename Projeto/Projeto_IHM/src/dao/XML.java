/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Carta;
import model.Perguntas;
import view.Mensagens;

/**
 *
 * @author willi
 */
public class XML {
    
    private static XStream xStream = new XStream(new DomDriver());
    
    public static String gerarXML(ArrayList<Perguntas> perguntas){
      return xStream.toXML(perguntas);
    }
    
    public static void gerarArquivo(String Xml){
        try {
            File arquivo = new File("javatar.files\\XML\\perguntas.xml");
            try (PrintWriter escrever = new PrintWriter(arquivo)) {
                escrever.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                escrever.write(Xml);
                escrever.flush();
            }
            
        } catch (FileNotFoundException e) {
            Mensagens.messagemErro("Erro ao gerar o arquivo xml das perguntas\n" + e );
           }        
    }
    
    public static ArrayList<Perguntas>  leArquivo(){
        try {
            BufferedReader arqIn = null;
            try {
                arqIn = new BufferedReader(new InputStreamReader(
                        new FileInputStream("javatar.files\\XML\\perguntas.xml"), "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Mensagens.messagemErro("Erro ao lê o arquivo xml das perguntas\n" + ex );
            }

            ArrayList<Perguntas> perguntas = (ArrayList<Perguntas>)xStream.fromXML(arqIn);
            return perguntas;   
            
        } catch (FileNotFoundException ex) {
            Mensagens.messagemErro("Erro ao lê o arquivo xml das perguntas\n" + ex );
            return null;            
        }
     }
    
    public static String gerarXMLCartas(ArrayList<Carta> cartas){
        return xStream.toXML(cartas);
      }
    
    public static void gerarArquivoCartas(String Xml, String nome){
        try {
            File arquivo = new File("javatar.files\\XML\\Cartas\\"+nome+".xml");
            try (PrintWriter escrever = new PrintWriter(arquivo)) {
                escrever.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                escrever.write(Xml);
                escrever.flush();
            }
            
        } catch (FileNotFoundException e) {
            Mensagens.messagemErro("Erro ao gerar o arquivo xml das perguntas\n" + e );
           }        
    }
    
    public static ArrayList<Carta>  leArquivoCartas(String nomeArquivo){
    	
    	try {
            BufferedReader arqIn = null;
            try {
                arqIn = new BufferedReader(new InputStreamReader(
                        new FileInputStream("javatar.files\\XML\\Cartas\\"+nomeArquivo+"Pequenas.xml"), "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Mensagens.messagemErro("Erro ao ler o arquivo xml das cartas\n" + ex );
            }

            ArrayList<Carta> cartas = (ArrayList<Carta>)xStream.fromXML(arqIn);
                      
            return cartas;   
            
        } catch (FileNotFoundException ex) {
            Mensagens.messagemErro("Erro ao ler o arquivo xml das cartas\n" + ex );
            return null;            
        }
     }
}

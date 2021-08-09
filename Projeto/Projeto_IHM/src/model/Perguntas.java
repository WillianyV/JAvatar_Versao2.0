/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author willi
 */

public class Perguntas {
    private String pergunta;
    private String[] multiplaEscolha = new String[4];
    private String[] certoErrado = new String [2];
    private String resposta;
    private String enderecoImagem;

    public Perguntas(String pergunta, String resposta, String enderecoImagem, String[] multiplaEscolha) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.enderecoImagem = enderecoImagem;
        this.multiplaEscolha = multiplaEscolha;
    }
    public Perguntas(String pergunta, String resposta, String enderecoImagem) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.enderecoImagem = enderecoImagem;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String[] getMultiplaEscolha() {
        return multiplaEscolha;
    }

    public void setMultiplaEscolha(String[] multiplaEscolha) {
        this.multiplaEscolha = multiplaEscolha;
    }

    public String[] getCertoErrado() {
        return certoErrado;
    }

    public void setCertoErrado(String[] certoErrado) {
        this.certoErrado = certoErrado;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getEnderecoImagem() {
        return enderecoImagem;
    }

    public void setEnderecoImagem(String enderecoImagem) {
        this.enderecoImagem = enderecoImagem;
    }
    
}

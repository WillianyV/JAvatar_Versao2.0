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
public class Jogador {
    
    private String nick;
    private String icone;

    public Jogador() {
    }

    public Jogador(String nick, String icone) {
        this.nick = nick;
        this.icone = icone;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }
    
}

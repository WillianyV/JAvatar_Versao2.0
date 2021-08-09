/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Util;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Mensagens;

/**
 *
 * @author willi
 */
public class Personagem {

    private Sprite personagem, barraHp, ataqueSprite;
    private int hp, defesa, ataque, pontos;
    private String orientacao, nomePersonagem = "";
    

    public Personagem(String nome) {
        hp = 100;
        defesa = 0;
        ataque = 0;
        pontos = 0;
        orientacao = Util.ESQUERDA;
        nomePersonagem = nome;
    }

    public void pontuacao() {
    	
        pontos += 10;
    }
    public void inicializarPersonagem(String orientacao,String nome){
        hp = 10;
        defesa = 0;
        ataque = 0;
        pontos = 0;
        orientacao = orientacao;
        nomePersonagem = nome;
    }

    public void inicializarSprite() {
        if (orientacao.equals(Util.ESQUERDA)) {
            if (nomePersonagem.equals(Util.AANG)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\AangLuta.png", 10, 172, 112, 8, 4, 654, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 0, 32, 32, 6, 2, 789, 430);
                } catch (IOException e) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Aang.\n" + e);
                }
            } else if (nomePersonagem.equals(Util.KATARA)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\KataraLuta.png", 10, 135, 122, 8, 4, 674, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 4, 32, 32, 6, 2, 789, 430);
                } catch (IOException e) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Katara.\n" + e);
                }
            } else if (nomePersonagem.equals(Util.SOKKA)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\SokkaLuta.png", 10, 123, 123, 8, 4, 674, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 1, 32, 32, 6, 2, 789, 430);
                } catch (IOException e) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Sokka.\n" + e);
                }
            } else if (nomePersonagem.equals(Util.TOPH)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\TophLuta.png", 10, 136, 123, 8, 4, 674, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 5, 32, 32, 6, 2, 789, 430);
                } catch (IOException ex) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Toph.\n" + ex);
                }
            } else if (nomePersonagem.equals(Util.ZUCO)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\ZucoLuta.png", 10, 132, 115, 8, 4, 674, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 7, 32, 32, 6, 2, 789, 430);
                } catch (IOException e) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Zuco.\n" + e);
                }
            }
        } else if (orientacao.equals(Util.DIREITA)) {
            if (nomePersonagem.equals(Util.AANG)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\AangLuta.png", 28, 172, 112, 8, 4, 1054, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 18, 32, 32, 10, 2, 1024, 430);
                } catch (IOException e) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Aang.\n" + e);
                }
            } else if (nomePersonagem.equals(Util.KATARA)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\KataraLuta.png", 28, 135, 122, 8, 4, 1054, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 14, 32, 32, 10, 2, 1024, 430);
                } catch (IOException e) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Aang.\n" + e);
                }
            } else if (nomePersonagem.equals(Util.SOKKA)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\SokkaLuta.png", 28, 123, 123, 8, 4, 1054, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 19, 32, 32, 10, 2, 1024, 430);
                } catch (IOException e) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Aang.\n" + e);
                }
            } else if (nomePersonagem.equals(Util.TOPH)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\TophLuta.png", 28, 136, 123, 8, 4, 1034, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 15, 32, 32, 10, 2, 1024, 430);
                } catch (IOException e) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Aang.\n" + e);
                }
            } else if (nomePersonagem.equals(Util.ZUCO)) {
                try {
                    personagem = new Sprite("javatar.files\\Imagens\\Telas\\ZucoLuta.png", 28, 132, 115, 8, 4, 1054, 400);
                    ataqueSprite = new Sprite("javatar.files\\Imagens\\Telas\\ataques.png", 13, 32, 32, 10, 2, 1024, 430);
                } catch (IOException e) {
                    Mensagens.messagemErro("Erro ao exibir as Sprites de Aang.\n" + e);
                }
            }
        }

    }

    public void animaAtaque() {

        if (Util.flagAtacandoP1) {
            if (orientacao.equals(Util.ESQUERDA)) {
                if (personagem.aparencia == 10) {
                    personagem.aparencia = 7;
                } else if (personagem.aparencia == 7) {
                    personagem.aparencia = 11;
                } else if (personagem.aparencia == 11) {
                    personagem.aparencia = 15;
                } else {
                    personagem.aparencia = 10;
                    Util.flagAtacandoPoder1 = true;
                    Util.flagAtacandoP1 = false;
                }
            }

        }
        if (Util.flagAtacandoP2) {
            if (orientacao.equals(Util.DIREITA)) {
                if (personagem.aparencia == 28) {
                    personagem.aparencia = 27;
                } else if (personagem.aparencia == 27) {
                    personagem.aparencia = 23;
                } else if (personagem.aparencia == 23) {
                    personagem.aparencia = 19;
                } else {
                    personagem.aparencia = 28;
                    Util.flagAtacandoP2 = false;
                    Util.flagAtacandoPoder2 = true;
                }
            }
        }
       

    }
    public void animacaoPerdeu(){
        if(orientacao.equals(Util.ESQUERDA)){
            personagem.aparencia = 3;
        }else{
            personagem.aparencia = 31;
        }
    }

    public void elementosAtaques() {

        if (orientacao.equals(Util.ESQUERDA)) {
            if (nomePersonagem.equals(Util.AANG)) {
                if (Util.efeitosSonoros) {
                    Sons.tocar(Util.AANG_ATTACK);
                }
                if (ataqueSprite.aparencia == 0) {
                    ataqueSprite.aparencia = 2;
                     if (Util.efeitosSonoros) {
                        if(Util.flagSomAnimacaoAtaque){
                            Sons.tocar(Util.AANG_ATTACK);
                        }                        
                    }                    
                    ataqueSprite.posX += 30;
                } else if (ataqueSprite.aparencia == 2) {
                    ataqueSprite.aparencia = 0;
                    ataqueSprite.posX += 30;
                }
            } else if (nomePersonagem.equals(Util.KATARA)) {
                if (Util.efeitosSonoros) {
                    Sons.tocar(Util.KATARA_ATTACK);
                }
                ataqueSprite.posX += 30;
            } else if (nomePersonagem.equals(Util.SOKKA)) {
                if (ataqueSprite.aparencia == 1) {
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.SOKKA_ATTACK);
                    }
                    ataqueSprite.aparencia = 3;
                    ataqueSprite.posX += 30;
                } else if (ataqueSprite.aparencia == 3) {
                    ataqueSprite.aparencia = 6;
                    ataqueSprite.posX += 30;
                } else if (ataqueSprite.aparencia == 6) {
                    ataqueSprite.aparencia = 8;
                    ataqueSprite.posX += 30;
                } else if (ataqueSprite.aparencia == 8) {
                    ataqueSprite.aparencia = 1;
                    ataqueSprite.posX += 30;
                }
            } else if (nomePersonagem.equals(Util.TOPH)) {
                if (Util.efeitosSonoros) {
                    Sons.tocar(Util.TOPH_ATTACK);
                }
                ataqueSprite.posX += 30;
            } else if (nomePersonagem.equals(Util.ZUCO)) {
                if (ataqueSprite.aparencia == 7) {
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.ZUCO_ATTACK);
                    }
                    ataqueSprite.aparencia = 9;
                    ataqueSprite.posX += 30;
                } else if (ataqueSprite.aparencia == 9) {
                    ataqueSprite.aparencia = 7;
                    ataqueSprite.posX += 30;
                }
            }

        } else if (orientacao.equals(Util.DIREITA)) {
            if (nomePersonagem.equals(Util.AANG)) {
                if (Util.efeitosSonoros) {
                    Sons.tocar(Util.AANG_ATTACK);
                }
                if (ataqueSprite.aparencia == 18) {
                    ataqueSprite.aparencia = 16;
                    ataqueSprite.posX -= 30;
                } else if (ataqueSprite.aparencia == 16) {
                    ataqueSprite.aparencia = 18;
                    ataqueSprite.posX -= 30;
                }
            } else if (nomePersonagem.equals(Util.KATARA)) {
                if (Util.efeitosSonoros) {
                    Sons.tocar(Util.KATARA_ATTACK);
                }
                ataqueSprite.posX -= 30;
            } else if (nomePersonagem.equals(Util.SOKKA)) {
                if (ataqueSprite.aparencia == 19) {
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.SOKKA_ATTACK);
                    }
                    ataqueSprite.aparencia = 17;
                    ataqueSprite.posX -= 30;
                } else if (ataqueSprite.aparencia == 17) {
                    ataqueSprite.aparencia = 12;
                    ataqueSprite.posX -= 30;
                } else if (ataqueSprite.aparencia == 12) {
                    ataqueSprite.aparencia = 10;
                    ataqueSprite.posX -= 30;
                } else if (ataqueSprite.aparencia == 10) {
                    ataqueSprite.aparencia = 19;
                    ataqueSprite.posX -= 30;
                }
            } else if (nomePersonagem.equals(Util.TOPH)) {
                if (Util.efeitosSonoros) {
                        Sons.tocar(Util.TOPH_ATTACK);                      
                    }  
                ataqueSprite.posX -= 30;
            } else if (nomePersonagem.equals(Util.ZUCO)) {

                if (ataqueSprite.aparencia == 13) {
                    ataqueSprite.aparencia = 11;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.ZUCO_ATTACK);                   
                    }   
                    ataqueSprite.posX -= 30;
                } else if (ataqueSprite.aparencia == 11) {
                    ataqueSprite.aparencia = 13;
                    ataqueSprite.posX -= 30;
                }
                
            }
        }
        
                
    }

    public void ferido() {
        if (orientacao.equals(Util.ESQUERDA)) {
            if (nomePersonagem.equals(Util.AANG)) {
                if (personagem.aparencia != 1) {
                    personagem.aparencia = 1;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.AANG_HIT);
                    }
                } else {
                    personagem.aparencia = 10;
                    Util.flagFerido = false;
                }
            } else if (nomePersonagem.equals(Util.KATARA)) {
                if (personagem.aparencia != 1) {
                    personagem.aparencia = 1;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.KATARA_HIT);
                    }
                } else {
                    personagem.aparencia = 10;
                    Util.flagFerido = false;
                }
            } else if (nomePersonagem.equals(Util.SOKKA)) {
                if (personagem.aparencia != 1) {
                    personagem.aparencia = 1;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.SOKKA_HIT);
                    }
                } else {
                    personagem.aparencia = 10;
                    Util.flagFerido = false;
                }
            } else if (nomePersonagem.equals(Util.TOPH)) {
                if (personagem.aparencia != 1) {
                    personagem.aparencia = 1;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.TOPH_HIT);
                    }
                } else {
                    personagem.aparencia = 10;
                    Util.flagFerido = false;
                }
            } else if (nomePersonagem.equals(Util.ZUCO)) {
                if (personagem.aparencia != 1) {
                    personagem.aparencia = 1;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.ZUCO_HIT);
                    }
                } else {
                    personagem.aparencia = 10;
                    Util.flagFerido = false;
                }
            }
        } else if (orientacao.equals(Util.DIREITA)) {
            if (nomePersonagem.equals(Util.AANG)) {
                if (personagem.aparencia != 29) {
                    personagem.aparencia = 29;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.AANG_HIT);
                    }
                } else {
                    personagem.aparencia = 28;
                    Util.flagFerido2 = false;
                }
            } else if (nomePersonagem.equals(Util.KATARA)) {
                if (personagem.aparencia != 29) {
                    personagem.aparencia = 29;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.KATARA_HIT);
                    }
                } else {
                    personagem.aparencia = 28;
                    Util.flagFerido2 = false;
                }
            } else if (nomePersonagem.equals(Util.SOKKA)) {
                if (personagem.aparencia != 29) {
                    personagem.aparencia = 29;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.SOKKA_HIT);
                    }
                } else {
                    personagem.aparencia = 28;
                    Util.flagFerido2 = false;
                }
            } else if (nomePersonagem.equals(Util.TOPH)) {
                if (personagem.aparencia != 29) {
                    personagem.aparencia = 29;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.TOPH_HIT);
                    }
                } else {
                    personagem.aparencia = 28;
                    Util.flagFerido2 = false;
                }
            } else if (nomePersonagem.equals(Util.ZUCO)) {
                if (personagem.aparencia != 29) {
                    personagem.aparencia = 29;
                    if (Util.efeitosSonoros) {
                        Sons.tocar(Util.ZUCO_HIT);
                    }
                } else {
                    personagem.aparencia = 28;
                    Util.flagFerido2 = false;
                }
            }
        }
    }

    public void inicializarElementoAtaque() {
        if (orientacao.equals(Util.ESQUERDA)) {
            ataqueSprite.posX = 799;
            Util.flagAtacandoPoder1 = false;
        }else{
            ataqueSprite.posX = 1014;
            Util.flagAtacandoPoder2 = false;
        }
    }

    public void animaPersonagemDefesa() {
        for (int i = 0; i < 2; i++) {
            if (orientacao.equals(Util.ESQUERDA)) {

                if (personagem.aparencia == 10) {
                    personagem.aparencia = 2;
                } else if (personagem.aparencia == 2) {
                    personagem.aparencia = 6;
                } else {
                    personagem.aparencia = 10;
                }

            } else {
                if (personagem.aparencia == 28) {
                    personagem.aparencia = 30;
                } else if (personagem.aparencia == 30) {
                    personagem.aparencia = 26;
                } else {
                    personagem.aparencia = 28;
                }
            }

            try {
                Thread.sleep(1000 / 5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Sprite getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Sprite personagem) {
        this.personagem = personagem;
    }

    public Sprite getBarraHp() {
        return barraHp;
    }

    public void setBarraHp(Sprite barraHp) {
        this.barraHp = barraHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public String getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(String orientacao) {
        this.orientacao = orientacao;
    }

    public Sprite getAtaqueSprite() {
        return ataqueSprite;
    }

    public void setAtaqueSprite(Sprite ataqueSprite) {
        this.ataqueSprite = ataqueSprite;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

}

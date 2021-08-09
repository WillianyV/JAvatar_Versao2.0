/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Util;
import view.JogoPanel;

/**
 *
 * @author willi
 */
public class Relogio extends Thread {

    private int dezenaMinuto, unidadeMinuto, dezenaSegundo, unidadeSegundo;
    private int tempo;
    private String texto = "";
    private JogoPanel jogoPanel;

    public Relogio(JogoPanel jogoPanel) {
        tempo = Util.TEMPO_JOGO_SEG;
        this.jogoPanel = jogoPanel;
    }

    public Relogio(int tempo) {
        this.tempo = tempo;
    }

    public void initRelogio() {
        tempo = Util.TEMPO_JOGO_SEG;
    }

    @Override
    public void run() {
        int[] relogio;
        while (true) {
            try {
                relogio = calcularHora(tempo);
                Thread.sleep(1000);

                if (tempo != -1) {
                    if (tempo % 2 == 0) {
                        texto = relogio[0] + "" + relogio[1] + ":" + relogio[2] + "" + relogio[3];
                    } else {
                        texto = relogio[0] + "" + relogio[1] + " " + relogio[2] + "" + relogio[3];
                    }

                    tempo--;
                } else {
                    jogoPanel.getPersonagem1().setHp(0);
                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public int[] calcularHora(int tempo) {
        int auxTempo = tempo;
        int dezMin = tempo / 600;
        auxTempo = dezMin * 600;
        int unidMin = (tempo - auxTempo) / 60;
        auxTempo += unidMin * 60;
        int dezSeg = (tempo - auxTempo) / 10;
        auxTempo += dezSeg * 10;
        int unidSeg = (tempo - auxTempo) / 1;

        int[] relogio = {dezMin, unidMin, dezSeg, unidSeg};

        return relogio;
    }

    public int getDezenaMinuto() {
        return dezenaMinuto;
    }

    public void setDezenaMinuto(int dezenaMinuto) {
        this.dezenaMinuto = dezenaMinuto;
    }

    public int getUnidadeMinuto() {
        return unidadeMinuto;
    }

    public void setUnidadeMinuto(int unidadeMinuto) {
        this.unidadeMinuto = unidadeMinuto;
    }

    public int getDezenaSegundo() {
        return dezenaSegundo;
    }

    public void setDezenaSegundo(int dezenaSegundo) {
        this.dezenaSegundo = dezenaSegundo;
    }

    public int getUnidadeSegundo() {
        return unidadeSegundo;
    }

    public void setUnidadeSegundo(int unidadeSegundo) {
        this.unidadeSegundo = unidadeSegundo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getTexto() {
        return texto;
    }

}

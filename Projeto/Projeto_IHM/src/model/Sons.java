package model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import view.Mensagens;


public class Sons {
	public static Clip clip;
	public static void tocar(String urlSom){
		try {
                    File soundFile = new File(urlSom);
                    AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
                    DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
                    clip = (Clip) AudioSystem.getLine(info);
                    clip.open(sound);
                    clip.start();
                    } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                    Mensagens.messagemErro("Erro ao reproduzir audio.\n" + e);
		}
	}
    public static void pararDeTocar(){
       clip.close();
    }
}

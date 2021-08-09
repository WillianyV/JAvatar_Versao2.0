package model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import Util.Util;

public class Deck {

	private ArrayList<Carta> cartas;
	private Sprite imagemVerso;
	private int qtdCartas;

	public Deck(ArrayList<Carta> cartas, Sprite imagemVerso) {
		super();
		this.cartas = cartas;
		this.imagemVerso = imagemVerso;
		this.qtdCartas = 15;
		embaralhar();
		
	
	}

	public void embaralhar() {
		ArrayList<Carta> cartaEmbaralhadas = new ArrayList<Carta>();
		Random random = new Random();
		int index;
		int contDefesa10 = 4, contDefesa20 = 2, contAtaque20 = 2, contAtaque10 = 5;

		while(cartaEmbaralhadas.size() < 15 ) {
			index = random.nextInt(cartas.size());

			switch (cartas.get(index).getTipo()) {
			case Util.MAGIA: {
				cartaEmbaralhadas.add(cartas.get(index));
				cartas.remove(index);
				break;
			}
			case Util.ATAQUE:{
				if(cartas.get(index).getPontos() == 10) {
					if(contAtaque10 == 0) {
						cartas.remove(index);
					}else {
						cartaEmbaralhadas.add(cartas.get(index));
						contAtaque10--;
					}
				} else if(cartas.get(index).getPontos() == 20) {
					if(contAtaque20 == 0) {
						cartas.remove(index);
					}else {
						cartaEmbaralhadas.add(cartas.get(index));
						contAtaque20--;
					}
				}else {
					cartaEmbaralhadas.add(cartas.get(index));
					cartas.remove(index);					
				}				
				break;
			}
			case Util.DEFESA:{
				if(cartas.get(index).getPontos() == 10) {
					if(contDefesa10 == 0) {
						cartas.remove(index);
					}else {
						cartaEmbaralhadas.add(cartas.get(index));
						contDefesa10--;
					}
				} else {
					if(contDefesa20 == 0) {
						cartas.remove(index);
					}else {
						cartaEmbaralhadas.add(cartas.get(index));
						contDefesa20--;
					}
				}

				break;
			}
			}
			
		}
		cartas = cartaEmbaralhadas;	
	}

	public Carta pegarCarta() {
		
		if(cartas.size() > 0) {
			Carta carta = cartas.get(0);
			cartas.remove(0);
			qtdCartas--;

			return carta;
		}
		return null;

	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public Sprite getImagemVerso() {
		return imagemVerso;
	}

	public void setImagemVerso(Sprite imagemVerso) {
		this.imagemVerso = imagemVerso;
	}

	public int getQtdCartas() {
		return qtdCartas;
	}
	public void setQtdCartas(int qtdCartas) {
		this.qtdCartas = qtdCartas;
	}

}

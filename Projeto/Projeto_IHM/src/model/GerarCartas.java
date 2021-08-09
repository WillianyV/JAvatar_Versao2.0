package model;


import java.util.ArrayList;

import javax.swing.ImageIcon;

import Util.Util;

public class GerarCartas {

	private ArrayList<Carta> cartas;
	
	public GerarCartas(){
		cartas = new ArrayList<>();
	}
	
	public ArrayList<Carta> GerarCartasAangPequenas() {

		cartas.add(new Carta(Util.ATAQUE, 20, Util.CAMINHO_CARTAS + "Aang\\Ataque\\1 (2).png", false,"aangAtaque1"));
		cartas.add(new Carta(Util.ATAQUE, 10, Util.CAMINHO_CARTAS + "Aang\\Ataque\\2 (2).png", false,"aangAtaque2"));
		cartas.add(new Carta(Util.ATAQUE, 10, Util.CAMINHO_CARTAS + "Aang\\Ataque\\3 (2).png", false,"aangAtaque3"));
		cartas.add(new Carta(Util.ATAQUE, 30, Util.CAMINHO_CARTAS + "Aang\\Ataque\\4 (2).png", false,"aangAtaque4"));
		
		cartas.add(new Carta(Util.DEFESA, 20, Util.CAMINHO_CARTAS + "Aang\\Defesa\\1 (2).png", false,"aangDefesa1"));
		cartas.add(new Carta(Util.DEFESA, 10, Util.CAMINHO_CARTAS + "Aang\\Defesa\\2 (2).png", false,"aangDefesa2"));
		cartas.add(new Carta(Util.DEFESA, 10, Util.CAMINHO_CARTAS + "Aang\\Defesa\\3 (2).png", false,"aangDefesa3"));
		cartas.add(new Carta(Util.DEFESA, 20, Util.CAMINHO_CARTAS + "Aang\\Defesa\\4 (2).png", false,"aangDefesa4"));
			
		cartas.add(new Carta(Util.MAGIA, 10, Util.CAMINHO_CARTAS + "Magia\\magiaPequena.png", false));	
		
		return cartas;
	}
	
	public ArrayList<Carta> GerarCartasKataraPequenas() {

		cartas.add(new Carta(Util.ATAQUE, 20, Util.CAMINHO_CARTAS + "Katara\\Ataque\\1 (2).png", false,"kataraAtaque1"));
		cartas.add(new Carta(Util.ATAQUE, 10, Util.CAMINHO_CARTAS + "Katara\\Ataque\\2 (2).png", false,"kataraAtaque2"));
		cartas.add(new Carta(Util.ATAQUE, 30, Util.CAMINHO_CARTAS + "Katara\\Ataque\\3 (2).png", false,"kataraAtaque3"));
		cartas.add(new Carta(Util.ATAQUE, 10, Util.CAMINHO_CARTAS + "Katara\\Ataque\\4 (2).png", false,"kataraAtaque4"));
		
		cartas.add(new Carta(Util.DEFESA, 20, Util.CAMINHO_CARTAS + "Katara\\Defesa\\1 (2).png", false,"kataraDefesa1"));
		cartas.add(new Carta(Util.DEFESA, 10, Util.CAMINHO_CARTAS + "Katara\\Defesa\\2 (2).png", false,"kataraDefesa2"));
		cartas.add(new Carta(Util.DEFESA, 20, Util.CAMINHO_CARTAS + "Katara\\Defesa\\3 (2).png", false,"kataraDefesa3"));
		cartas.add(new Carta(Util.DEFESA, 10, Util.CAMINHO_CARTAS + "Katara\\Defesa\\4 (2).png", false,"kataraDefesa4"));
		
		cartas.add(new Carta(Util.MAGIA, 10, Util.CAMINHO_CARTAS + "Magia\\magiaPequena.png", false));	
		
		return cartas;
	}
		
	public ArrayList<Carta> GerarCartasSokkaPequenas() {

		cartas.add(new Carta(Util.ATAQUE, 20, Util.CAMINHO_CARTAS + "Sokka\\Ataque\\1 (2).png", false,"sokkaAtaque1"));
		cartas.add(new Carta(Util.ATAQUE, 30, Util.CAMINHO_CARTAS + "Sokka\\Ataque\\2 (2).png", false,"sokkaAtaque2"));
		cartas.add(new Carta(Util.ATAQUE, 10, Util.CAMINHO_CARTAS + "Sokka\\Ataque\\3 (2).png", false,"sokkaAtaque3"));
		
		cartas.add(new Carta(Util.DEFESA, 20, Util.CAMINHO_CARTAS + "Sokka\\Defesa\\1 (2).png", false,"sokkaDefesa1"));
		cartas.add(new Carta(Util.DEFESA, 30, Util.CAMINHO_CARTAS + "Sokka\\Defesa\\2 (2).png", false,"sokkaDefesa2"));
		cartas.add(new Carta(Util.DEFESA, 10, Util.CAMINHO_CARTAS + "Sokka\\Defesa\\3 (2).png", false,"sokkaDefesa3"));
			
		cartas.add(new Carta(Util.MAGIA, 10, Util.CAMINHO_CARTAS + "Magia\\magiaPequena.png", false));	
		
		return cartas;
	}
		
	public ArrayList<Carta> GerarCartasTophPequenas() {

		cartas.add(new Carta(Util.ATAQUE, 30, Util.CAMINHO_CARTAS + "Toph\\Ataque\\1 (2).png", false,"tophAtaque1"));
		cartas.add(new Carta(Util.ATAQUE, 10, Util.CAMINHO_CARTAS + "Toph\\Ataque\\2 (2).png", false,"tophAtaque2"));
		cartas.add(new Carta(Util.ATAQUE, 10, Util.CAMINHO_CARTAS + "Toph\\Ataque\\3 (2).png", false,"tophAtaque3"));
		cartas.add(new Carta(Util.ATAQUE, 20, Util.CAMINHO_CARTAS + "Toph\\Ataque\\4 (2).png", false,"tophAtaque4"));
		
		cartas.add(new Carta(Util.DEFESA, 20, Util.CAMINHO_CARTAS + "Toph\\Defesa\\1 (2).png", false,"tophDefesa1"));
		cartas.add(new Carta(Util.DEFESA, 10, Util.CAMINHO_CARTAS + "Toph\\Defesa\\2 (2).png", false,"tophDefesa2"));
		cartas.add(new Carta(Util.DEFESA, 20, Util.CAMINHO_CARTAS + "Toph\\Defesa\\3 (2).png", false,"tophDefesa3"));
		cartas.add(new Carta(Util.DEFESA, 10, Util.CAMINHO_CARTAS + "Toph\\Defesa\\4 (2).png", false,"tophDefesa4"));

		cartas.add(new Carta(Util.MAGIA, 10, Util.CAMINHO_CARTAS + "Magia\\magiaPequena.png", false));	
		
		return cartas;
	}
	
	public ArrayList<Carta> GerarCartasZucoPequenas() {

		cartas.add(new Carta(Util.ATAQUE, 10, Util.CAMINHO_CARTAS + "Zuco\\Ataque\\1 (2).png", false,"zucoAtaque1"));
		cartas.add(new Carta(Util.ATAQUE, 10, Util.CAMINHO_CARTAS + "Zuco\\Ataque\\2 (2).png", false,"zucoAtaque2"));
		cartas.add(new Carta(Util.ATAQUE, 20, Util.CAMINHO_CARTAS + "Zuco\\Ataque\\3 (2).png", false,"zucoAtaque3"));
		cartas.add(new Carta(Util.ATAQUE, 30, Util.CAMINHO_CARTAS + "Zuco\\Ataque\\4 (2).png", false,"zucoAtaque4"));
		
		cartas.add(new Carta(Util.DEFESA, 10, Util.CAMINHO_CARTAS + "Zuco\\Defesa\\1 (2).png", false,"zucoDefesa1"));
		cartas.add(new Carta(Util.DEFESA, 10, Util.CAMINHO_CARTAS + "Zuco\\Defesa\\2 (2).png", false,"zucoDefesa2"));
		cartas.add(new Carta(Util.DEFESA, 20, Util.CAMINHO_CARTAS + "Zuco\\Defesa\\3 (2).png", false,"zucoDefesa3"));
		cartas.add(new Carta(Util.DEFESA, 30, Util.CAMINHO_CARTAS + "Zuco\\Defesa\\4 (2).png", false,"zucoDefesa4"));
		
		cartas.add(new Carta(Util.MAGIA, 10, Util.CAMINHO_CARTAS + "Magia\\magiaPequena.png", false));	
		
		return cartas;
	}
}

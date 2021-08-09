package model;

import javax.swing.ImageIcon;

public class Carta {

	private String tipo;
	private int pontos;
	private String imagem;
	private boolean ativadaStatus;
	private String id;
	
	public Carta(String tipo, int pontos, String imagem, boolean ativadaStatus, String id) {
		super();
		this.tipo = tipo;
		this.pontos = pontos;
		this.imagem = imagem;
		this.ativadaStatus = ativadaStatus;
		this.id = id;
	}
	
	public Carta(String tipo, int pontos, String imagem, boolean ativadaStatus) {
		super();
		this.tipo = tipo;
		this.pontos = pontos;
		this.imagem = imagem;
		this.ativadaStatus = ativadaStatus;
		this.id = "magia";
	}
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public boolean isAtivadaStatus() {
		return ativadaStatus;
	}
	public void setAtivadaStatus(boolean ativadaStatus) {
		this.ativadaStatus = ativadaStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Carta [tipo=" + tipo + ", pontos=" + pontos + ", imagem=" + imagem + ", ativadaStatus=" + ativadaStatus
				+ ", id=" + id + "]";
	}
	
	
	
}

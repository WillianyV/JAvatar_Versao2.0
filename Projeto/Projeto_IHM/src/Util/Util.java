package Util;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import view.Mensagens;

/**
 * @author willi
 */
public class Util {

	public static final String ATAQUE = "Ataque";
	public static final String DEFESA = "Defesa";
	public static final String MAGIA = "Magia";
	public static final String CAMINHO_CARTAS = "javatar.files\\Imagens\\Cartas\\";
	
	public static final String TAMANHO_GRANDE = "Grande";
	public static final String TAMANHO_PEQUENO = "Pequeno";
	
	public static final int CARTA_1_POS_X = 800;
	public static final int CARTA_2_POS_X = 860;
	public static final int CARTA_3_POS_X = 920;
	public static final int CARTA_4_POS_X = 980;
	public static final int CARTA_5_POS_X = 1040;
	public static final int CARTAS_POS_Y = 570 ;
	
	public static final int IR_BOTAO_AJUDA =  9;
	public static final int VOLTAR_BOTAO_AJUDA =  10; 
	public static final int JOGAR_BOTAO_AJUDA =  11;
	public static final int PULAR_BOTAO_AJUDA =  12;
	
	
	public static final int SAIR_BOTAO_CARTAS =  13;
	public static final int CONFIG_BOTAO =  14;
	
	public static final int HOME_BOTAO_AJUDA =  15;
	
	public static final int CONFIG_BTN_SAIR = 16;
	public static final int CONFIG_BTN_MUSICA= 17;
	public static final int CONFIG_BTN_EFEITOS_SONOROS= 18;
	public static final int CONFIG_BTN_AJUDA= 19;
	public static final int CONFIG_BTN= 20;
	
	public static final int FINALIZAR_BOTAO_TUTORIAL = 21;
	public static final int PULAR_BOTAO_TUTORIAL = 22;
	
	public static final int OK_BOTAO_MSG_PANEL_JOGO = 23;
	
	public static final int OK_BOTAO_MSG_PANEL_INICIAL = 24;
	
	public static final int CUSTOMIZAR_PANEL_INICIAL = 25;
	public static final int JOGAR_PANEL_INICIAL = 26;
	
	public static final int SOM_BOTAO_PANEL_INICIAL = 27;
	public static final int AJUDA_BOTAO_PANEL_INICIAL = 28;
	public static final int YOUTUBE_BOTAO_PANEL_INICIAL = 29;
	public static final int INFO_BOTAO_PANEL_INICIAL = 30;
	
	public static final int YOUTUBE_BOTAO_PANEL_JOGO = 31;
	
	public static final int JOGAR_NOVAMENTE_PANEL_JOGO = 32;
	
	public static final int SAIR_BOTAO_PANEL_JOGO = 33;
	
	public static final int SAIR_PANEL_SOM_SOBRE = 34;
	public static final int MUSICA_PANEL_SOM = 35;
	public static final int EFEITOS_PANEL_SOM = 36;
	
	public static final int SAIR_JOGO_PANEL_JOGO = 35;
	
	public static final int[] POS_X_CARTAS = {650,760,870,980,1090};
	
	public static boolean DEFENDENDO_ADVERSARIO = false;
	
	public static boolean CHAMAR_SOM_SPRITE = false;
	public static boolean CHAMAR_SOBRE_SPRITE = false;
	
	public static boolean PULOU_QUESTAO = false;
	
	public static boolean JOGAR_NOVAMENTE = false;
	
	public static boolean MOSTRAR_PERSONAGEM = false;
	public static String NOME_JOGADOR = "";
	
	public static boolean JOGO_INICIADO = false;
	
	public static boolean CHAMAR_MSG_PANEL_INICIAL = false;
	public static boolean CHAMAR_MSG_PANEL_JOGO = false;
	
	public static int CARTA_CLICADA = 0;
	public static int APARENCIA_CARTA = 0;
	
	public static int CARTAS_NA_MAO = 5 ;
	public static int CARTAS_NA_MAO_ADVERSARIO = 5 ;
	public static int CARTA_ARRASTADA;
	public static boolean ARRASTANDO = false;
	
	public static boolean TURNO_FLAG = false; 
	
	public static boolean TUTORIAL_POR_CONFIG = false;
	
	public static boolean CONFIG_VISIVEL = false;	
	
	public static boolean TURNO_ADVERSARIO_ATACANDO = false; 
	public static boolean TURNO_ADVERSARIO_DEFENDENDO = false; 
	
	public static boolean PERGUNTA_NAO_RESPONDIDA = true; 
	
	public static boolean MAGIA_ATIVA_ATAQUE = false;
	public static boolean MAGIA_ATIVA_DEFESA = false;	
	
	public static boolean TURNO_ADVERSARIO = false; 
	
	public static int CARTA_MAO_SELECIONADA;
	
	public static boolean CARTA_MAO_VISIVEL = false;
	
	public static int INDEX_MAGIA = 5;
	
	public static boolean TUTORIAL = true;
	public static boolean TUTORIAL_PANEL_INICIAL = false;
	
	public static boolean VEZ_JOGADOR = true;
	public static boolean ADVERSARIO_JOGOU_CARTA = false;
	
	public static boolean MOSTRAR_MSG_PERGUNTA = false;
	
	public static boolean DESENHAR_CONT = false;
	
    public static final String AANG = "Aang";
    public static final String KATARA = "Katara";
    public static final String TOPH = "Toph";
    public static final String ZUCO = "Zuco";
    public static final String SOKKA = "Sokka";
    public static final int PORTA_SERVIDOR = 3333;
    public static final int ALTURA = 768;
    public static final int LARGURA = 1366;
    public static final String DIREITA = "direita";
    public static final String ESQUERDA = "esquerda";

    public static final String MUSICA_TEMA = "javatar.files\\Sons\\01 Main Title.wav";

    public static final String AANG_HIT = "javatar.files\\Sons\\aang_hit.wav";
    public static final String KATARA_HIT = "javatar.files\\Sons\\katara_hit.wav";
    public static final String SOKKA_HIT = "javatar.files\\Sons\\sokka_hit.wav";
    public static final String TOPH_HIT = "javatar.files\\Sons\\toph_hit.wav";
    public static final String ZUCO_HIT = "javatar.files\\Sons\\zuko_hit.wav";

    public static final String AANG_ATTACK = "javatar.files\\Sons\\aang_attack.wav";
    public static final String KATARA_ATTACK = "javatar.files\\Sons\\katara_attack2.wav";
    public static final String SOKKA_ATTACK = "javatar.files\\Sons\\sokka_attack.wav";
    public static final String TOPH_ATTACK = "javatar.files\\Sons\\toph_attack4.wav";
    public static final String ZUCO_ATTACK = "javatar.files\\Sons\\zuko_attack4.wav";
	public static final String VERSO = "Verso";
	
	public static final String SOM_CARTA = "javatar.files\\Sons\\Cartas_ataque_defesa.wav";
	public static final String SOM_CARTA_MAGIA = "javatar.files\\Sons\\Magia.wav";
	public static final String AGORA_MINHA_VEZ = "javatar.files\\Sons\\export.wav";

    public static int multiplicador = 1, erros = 0;

    public static boolean efeitosSonoros = true;
    public static boolean efeitosSonorosMusica = true;
    
    public static int tempo=0;
    
    public static int TEMPO_JOGO_SEG = 600;
    
    public static int pular = 0;    

    public static boolean flagAtacandoPoder1 = false;
    public static boolean flagAtacandoPoder2 = false;
    public static boolean flagAtacandoP1 = false;
    public static boolean flagAtacandoP2 = false;

    public static boolean flagDefesaP1 = false;
    public static boolean flagDefesaP2 = false;
    public static boolean flagDefedendo = false;

    public static boolean flagElementosP1 = false;
    public static boolean flagElementosP2 = false;

    public static boolean flagFerido = false;
    public static boolean flagFerido2 = false;

    public static boolean flagSomAnimacaoAtaque = true;

    public static boolean flagGanhou = false;
    public static boolean flagPerdeu = false;

    public static Font sansSerif = new Font("Sans Serif", Font.PLAIN, 12);
    public static Color color = new Color(143, 110, 57);
    public static Font chewy = getFont("Chewy", 26);

    public static Font getFont(String nomeFonte, int tamanho) {
        Font font = null;
        try {
        	
            font = Font.createFont(Font.TRUETYPE_FONT, new File("javatar.files/Fontes/" + nomeFonte + ".ttf"));
        } catch (Exception e) {
            //Mensagem.mostrar("Erro ao carregar fonte!", Util.ERRRO);
        }
        font = font.deriveFont(Font.PLAIN, tamanho);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        return font;
    }
    
    public static int isSokka(String nome) {
    		
    	return nome.equals(SOKKA)? 10:12;
    }
    
    public static int controleDeIcons(int defesa, int ataque) {
    	// todos os icons desativados
    	if(defesa == 0 && ataque == 0 && !(Util.MAGIA_ATIVA_ATAQUE || Util.MAGIA_ATIVA_DEFESA)) {
    		return 0;
    	}//defesa ativa
    	else if(defesa>0 && ataque == 0 && !(Util.MAGIA_ATIVA_ATAQUE || Util.MAGIA_ATIVA_DEFESA)){
    		return 1;
    	}//defesa e ataque ativa
    	else if(defesa > 0 && ataque > 0 && !(Util.MAGIA_ATIVA_ATAQUE || Util.MAGIA_ATIVA_DEFESA)) {
			return 2;
		}// defesa e magia ativos
    	//else if(defesa>0 && ataque == 0 || (Util.MAGIA_ATIVA_ATAQUE || Util.MAGIA_ATIVA_DEFESA) ) {
    	else if(ataque==0 && Util.MAGIA_ATIVA_DEFESA) {
    		return 3;
		}//magia e ataque ativa
    	//defesa , magia  e ataque ativos
    	//else if(defesa > 0 && ataque > 0 || (Util.MAGIA_ATIVA_ATAQUE || Util.MAGIA_ATIVA_DEFESA) ) {
    	else if((Util.MAGIA_ATIVA_ATAQUE && defesa > 0) || (Util.MAGIA_ATIVA_DEFESA && ataque > 0) ) {
    		return 6;
    	}//ataque e magia
    	else if(Util.MAGIA_ATIVA_ATAQUE){
			return 5;
		}
    	//ataque ativo
    	else if(ataque > 0){
			return 4;
		}
    	return 0;
    }
    
    public static int controleDeIconsAdversario(int defesa, int ataque) {
    	System.out.println("defesa : " + defesa +"| ataque: " + ataque + "| Magia Defesa: " + MAGIA_ATIVA_DEFESA + "| Magia Atque: " + MAGIA_ATIVA_ATAQUE);
    	// todos os icons desativados
    	if(defesa == 0 && ataque == 0) {
    		return 0;
    	}//defesa ativa
    	else if(defesa>0 && ataque == 0){
    		return 1;
    	}//defesa e ataque ativa
    	else if(defesa > 0 && ataque > 0) {
			return 2;
		}
    	//ataque ativo
    	else if(ataque > 0){
			return 4;
		}
    	return 0;
    }
    
    public static int mapAparenciaAdversario(String nomeAdversario) {
    	switch (nomeAdversario) {
			case AANG: {
				return 1;
			}
			case KATARA: {
				return 2;
			}
			case SOKKA: {
				return 3;
			}
			case TOPH: {
				return 4;
			}
			case ZUCO: {
				return 5;
			}
		}
    	return 0;
    }
    
    public static void abrirLink() {
    	try {
			URI link = new URI("https://youtu.be/IgshgGaFkQk");
			Desktop.getDesktop().browse(link);
		} catch (URISyntaxException |IOException e) {
			Mensagens.messagemErro("Não foi possível abrir o tutorial no YouTube");
		} 
    }
}

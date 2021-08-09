/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class GerarPerguntas {
    public ArrayList<Perguntas> quiz = new ArrayList<>();
    
  //PERGUNTAS:
    public GerarPerguntas() {
    //1    
    quiz.add(new Perguntas("Considere o seguinte trecho de c�digo na linguagem de programa��o Java.", 
            "Encapsulamento", 
            "Arquivos/Imagens/Perguntas/1.png", 
            new String[]{
                "Generaliza��o",
                "Heran�a",
                "Encapsulamento",
                "Sobrecarga"}));
    //2
    quiz.add(new Perguntas("Em uma aplica��o Java orientada a objetos que usa rela��es de heran�a, "
            + "uma subclasse n�o pode ter mais que um construtor, mesmo que receba par�metros diferentes.", 
            "subclasse normalmente usa a anota��o @Override para indicar que um m�todo da superclasse foi "
            + "sobrescrito.", 
            null, new String[]{
                "superclasse n�o pode ter m�todos sobrecarregados ou sobrescritos.",
                "subclasse n�o pode sobrescrever um m�todo da superclasse, mas o contr�rio � permitido.",
                "subclasse herda somente os atributos e os m�todos privados da superclasse.",
                "subclasse normalmente usa a anota��o @Override para indicar que um m�todo da superclasse foi sobrescrito."}));
    //3
    quiz.add(new Perguntas("Na linguagem Java ao se usar uma constante num�rica, no c�digo fonte, ela ser� um int. O "
            + "tamanho desse tipo num�rico � de:", 
            "32 bits (valores de -2.147.483.648 a +2.147.483.647).", 
            null, new String[]{
                "16 bits (valores de -32.768 a +32.767).",
                "32 bits (valores de -2.147.483.648 a +2.147.483.647).",
                "32 bits (valores de -32.768 a +32.767).",
                "64 bits (valores de -2.147.483.648 a +2.147.483.647)."}));
    //4
    quiz.add(new Perguntas("Pacotes s�o basicamente pastas ou diret�rios do sistema operacional que ficam armazenados "
            + "os arquivos fonte de Java e s�o essenciais para o conceito de encapsulamento, no qual s�o dados n�veis "
            + "de acesso �s classes. Para tanto, a sequ�ncia correta de utiliza��o de todos esses elementos envolvidos �:",
            "package - import - class", 
            null, new String[] {
                "package - import - class",
                "import - package - class",
                "package - class - import",
                "class - import - package"}));
    //5
    quiz.add(new Perguntas("A M�quina Virtual Java ______ o c�digo fonte para c�digo de m�quina espec�fico de uma plataforma "
            + "e sistema operacional�. Qual alternativa completa corretamente a lacuna?", 
            "Compila.", 
            null, new String[] {
                "Compila.",
                "Deleta.",
                "Separa.",
                "Reorganiza."}));
    //6
    quiz.add(new Perguntas("Acerca de linguagens de programa��o e J2EE e portais corporativos, julgue o seguinte item.\n" +
            "O seguinte trecho de c�digo em Java exibe uma estrutura de controle de fluxo representativa das senten�as de itera��o e fornece "
            + "desvios impl�citos no final de seus segmentos de c�digo.", 
            "Errado", 
            "Arquivos/Imagens/Perguntas/6.png"));
    //7
    quiz.add(new Perguntas("Em JAVA, existe um m�todo que pertence � biblioteca nativa, onde n�o � capaz de bloquear a execu��o de uma "
            + "determinada thread. Com rela��o a esse assunto, marque a alternativa correta.", 
            "Thread.yield()", 
            null, new String[] {
                "Thread.join()",
                "Thread.insert()",
                "Thread.block()",
                "Thread.yield()"}));
    //8
    quiz.add(new Perguntas("Ao compilar um arquivo salvo com a extens�o .java, h� a necessidade de transforma��o do c�digo em bytecodes para "
            + "que ele possa ser executado e reconhecido pela M�quina Virtual Java. Nesse caso, assinale a alternativa que indica a extens�o gerada.", 
            ".class", 
            null, new String[] {
                ".css",
                ".jar",
                ".exe",
                ".class"}));
    //9
    quiz.add(new Perguntas("Em Java, um m�todo do tipo �void� significa que", 
            "ele n�o retorna valor algum.", 
            null, new String[] {
                "ele retorna o valor de uma vari�vel.",
                "ele n�o retorna valor algum.",
                "o m�todo � inst�ncia de um objeto.",
                "o m�todo � uma fun��o."}));
    //10
    quiz.add(new Perguntas("A M�quina Virtual que carrega e executa os aplicativos Java, convertendo os bytecodes em c�digo execut�vel de m�quina, � conhecida pela "
            + "sigla em ingl�s:", 
            "JVM", 
            null, new String[] {
                "SDK",
                "JDK",
                "JVM",
                "JRE"}));
    //11
    quiz.add(new Perguntas("Na programa��o orientada a objetos utilizam-se conceitos como classes, objetos e m�todos. Na linguagem Java, um m�todo", 
            "n�o pode ser sobrecarregado na mesma classe.", 
            null, new String[] {
                "n�o pode ser sobrecarregado na mesma classe.",
                "pode receber par�metros de tipos diferentes.",
                "pode ser sobrescrito na mesma classe.",
                "deve ser abstrato nas classes, mas n�o nas interfaces."}));
    //12
    quiz.add(new Perguntas("Em rela��o � linguagem de programa��o Java, qual o m�todo est�tico que apenas exibe uma caixa de di�logo contendo uma mensagem?", 
            "JOptionPane.showMessageDialog", 
            null, new String[] {
                "Graphics.showMessage",
                "JFrame.showMessage",
                "JOptionPane.showInputDialog",
                "JOptionPane.showMessageDialog"}));
    //13
    quiz.add(new Perguntas("Em um programa na linguagem Java, um T�cnico declarou uma vari�vel e atribuiu a ela um valor inteiro por meio do comando short a = 32768;. Ao tentar executar "
            + "a aplica��o, este comando gerou uma exce��o porque vari�veis do tipo short s� podem conter valores na faixa de:", 
            "-32768 a 32767.", 
            null, new String[]{
                "-128 a 127.",
                "0 a 256.",
                "-32768 a 32767.",
                "-2048 a 2047."
            }));
    //14
    quiz.add(new Perguntas("Os operadores possuem regras que s�o aplicadas nas express�es aritm�ticas do Java, que s�o as mesmas seguidas em �lgebra. Quando dizemos que os operadores s�o "
            + "aplicados da esquerda para a direita, estamos nos referindo � sua associatividade",
            "0 2 1 0 2 1 0 2 1", 
            "Arquivos/Imagens/Perguntas/14.png", 
            new String[] {
                "0 2 1 0 2 1 0 2 1",
                "0 0 1 0 0 1 0 0 1",
                "0 1 2 0 1 2 0 1 2",
                "0 1 0 1 0 1 0 1 0"}));
    //15
    quiz.add(new Perguntas("Em Orienta��o a Objetos, Heran�a M�ltipla ocorre quando uma classe herdar de duas ou mais classes. Java n�o permite Heran�a M�ltipla entre classes, ou seja, "
            + "em Java uma classe s� pode herdar de no m�ximo uma outra classe. Entretanto, normalmente os desenvolvedores Java utilizam-se de outra estrutura para simular Heran�a M�ltipla. "
            + "Que estrutura � essa?", 
            "Interface.", 
            null, new String[] {
                "Classe Abstrata.","Classe Aninhada.","Annotation.","Interface."}));
    //16
    quiz.add(new Perguntas("A linguagem de programa��o Java permite a cria��o de programas que fa�am uso de recursividade. Isto posto, analise a classe Java, denominada X, abaixo.", 
            "quando compilada e executada, o console apresentar� o valor 120.", 
            "Arquivos/Imagens/Perguntas/16.png", 
            new String[] {
                "quando compilada e executada, o console apresentar� o valor 120.",
                "quando compilada e executada, a classe entrar� em loop infinito.",
                "quando compilada e executada, o console apresentar� o valor 720.",
                "quando compilada e executada, o console apresentar� uma exce��o."}));
    //17
    quiz.add(new Perguntas("Com rela��o aos conceitos de programa��o orientada a objetos, um objeto �:", 
    		"uma inst�ncia de uma classe.", 
    		null,
    		new String[]{
    				"uma inst�ncia de uma classe.",
    				"usado para instanciar classes ou outros objetos.",
    				"uma vari�vel de um tipo primitivo ou uma refer�ncia.",
    				"uma refer�ncia para uma classe ou para outros objetos."}));
    //18
    quiz.add(new Perguntas("Utilizando Java 8, qual o resultado do c�digo abaixo?", 
            "Erro de compila��o devido as linhas 1 e 2", 
            "Arquivos/Imagens/Perguntas/18.png", 
            new String[] {
                "Erro de compila��o devido as linhas 1 e 2",
                "Erro de compila��o devido � linha 1",
                "�554123�",
                "677"}));
    //19
    quiz.add(new Perguntas("Utilizando Java 8, sobre a classe Cliente abaixo, o que podemos afirmar corretamente?", 
            "Subclasses concretas de Cliente devem implementar o m�todo compra().", 
            "Arquivos/Imagens/Perguntas/19.png",  
            new String[] {
                "A classe Cliente n�o pode ser estendida.",
                "Subclasses de Cliente devem implementar o m�todo compra().",
                "Subclasses concretas de Cliente devem utilizar um construtor padr�o.",
                "Subclasses concretas de Cliente devem implementar o m�todo compra()."}));
    //20
    quiz.add(new Perguntas("Em Java 8, qual modificador de acesso torna um membro dispon�vel somente para classes "
            + "dentro do mesmo pacote ou subclasses?", 
            "protected", 
            null, new String[] {
                "public",
                "default",
                "private",
                "protected"}));
    //21
    quiz.add(new Perguntas("Analise as linhas de c�digo em Java a seguir. Qual � a linha que apresenta erro?", 
            "Linha 2", 
            "Arquivos/Imagens/Perguntas/21.png",
            new String[] {
                "Linha 2",
                "Linha 3",
                "Linha 4",
                "Linha 6"}));
    //22
    quiz.add(new Perguntas("Embora n�o sejam objetos, os valores dos tipos primitivos escalares s�o suportados por Java.", 
            "Certo", null));
    //23
    quiz.add(new Perguntas("A vincula��o est�tica permite a sobrescrita, se o m�todo for est�tico ou privado.", 
           "Errado", null));
    //24
    quiz.add(new Perguntas("Uma das vantagens da linguagem Java em rela��o a outras linguagens � a f�cil implementa��o de heran�a m�ltipla.", 
            "Errado", null));
    //25
    quiz.add(new Perguntas("A linguagem Java prov�, de forma nativa, a capacidade de multithreading, ou seja, a execu��o de mais de um "
            + "fluxo de instru��es em paralelo e com a mesma prioridade.", "Errado", null));
    //26
    quiz.add(new Perguntas("Na linguagem Java, o conceito de heran�a est� vinculado � cria��o de uma nova classe a partir de uma classe "
            + "j� existente, em que essa nova classe herda os atributos e comportamentos da classe anterior.", 
            "Certo", null));
    //27
    quiz.add(new Perguntas("Uma classe final n�o pode ser herdada, um m�todo final n�o pode ser sobrescrito, e o valor de um atributo "
            + "final n�o pode ser alterado.",  "Certo", null));
    //28
    quiz.add(new Perguntas("A palavra reservada interface � utilizada sempre que se quer criar uma nova tela com interface gr�fica.",
            "Errado", null));
    //29
    quiz.add(new Perguntas("Devido � linguagem de programa��o Java ser fortemente tipada, n�o � poss�vel haver convers�o "
            + "entre tipos de dados diferentes.", "Errado", null));
    //30
    quiz.add(new Perguntas("Caso queira lan�ar uma exce��o em seu programa, o programador dever� utilizar a palavra "
            + "reservada throw seguida da exce��o a ser lan�ada.", 
            "Certo", null));
    //31
    quiz.add(new Perguntas("A classe n�o compilar�, pois houve erro durante a convers�o dos tipos de dados na linha 7.", 
            "Errado", "Arquivos/Imagens/Perguntas/31.png"));
    //32
    quiz.add(new Perguntas("A classe n�o ir� compilar, por causa do operador \"+=\", utilizado na linha 8.", 
            "Errado", "Arquivos/Imagens/Perguntas/32.png"));
    //33
    quiz.add(new Perguntas("O tipo int � um tipo primitivo Java.", 
            "Certo", null));
    //34
    quiz.add(new Perguntas("Com refer�ncia � linguagem de programa��o Java, julgue o item a seguir.\n" +
            "S�o estruturas de repeti��es Java: while, for, for-while e repeat.", 
            "Errado", null));
    //35
    quiz.add(new Perguntas("Com base na imagem da classe Java apresentada. A classe ir� compilar, mas n�o executar�, "
            + "porque apresentar� erro em tempo de execu��o.", 
            "Errado", "Arquivos/Imagens/Perguntas/35.png"));
    //36
    quiz.add(new Perguntas("Acerca da linguagem Java, julgue o pr�ximo item.\n" +
            "O m�todo no c�digo\n" +
            "System.out.println(valor.charAt(0));\n" +
            "retornar� todos os caracteres referentes � string avaliada", 
            "Errado", null));
    //37
    quiz.add(new Perguntas("Acerca da linguagem Java, julgue o pr�ximo item.\n" +
            "O m�todo no c�digo\n" +
            "System.out.println(valor.codePointAt(0));\n" +
            "retornar� a compara��o entre duas strings em formato unicode", 
            "Errado", null));
    //38
    quiz.add(new Perguntas("Julgue o item a seguir, a respeito da linguagem de programa��o Java.", 
            "Errado", "Arquivos/Imagens/Perguntas/38.png"));
    //39
    quiz.add(new Perguntas("Arquivo JAR cont�m recursos relacionados ao Java, como bibliotecas e classes, e pode conter "
            + "qualquer arquivo que n�o seja relacionado a aplica��o Java, como .txt, .doc, .gif.", 
            "Certo", null));
    //40
    quiz.add(new Perguntas("Para a cria��o de objetos utilizando a linguagem Java, devem-se usar express�es contendo "
            + "a palavra-chave new.", 
            "Certo", null));
    }
 
}

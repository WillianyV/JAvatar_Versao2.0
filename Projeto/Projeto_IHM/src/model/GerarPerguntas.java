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
    quiz.add(new Perguntas("Considere o seguinte trecho de código na linguagem de programação Java.", 
            "Encapsulamento", 
            "Arquivos/Imagens/Perguntas/1.png", 
            new String[]{
                "Generalização",
                "Herança",
                "Encapsulamento",
                "Sobrecarga"}));
    //2
    quiz.add(new Perguntas("Em uma aplicação Java orientada a objetos que usa relações de herança, "
            + "uma subclasse não pode ter mais que um construtor, mesmo que receba parâmetros diferentes.", 
            "subclasse normalmente usa a anotação @Override para indicar que um método da superclasse foi "
            + "sobrescrito.", 
            null, new String[]{
                "superclasse não pode ter métodos sobrecarregados ou sobrescritos.",
                "subclasse não pode sobrescrever um método da superclasse, mas o contrário é permitido.",
                "subclasse herda somente os atributos e os métodos privados da superclasse.",
                "subclasse normalmente usa a anotação @Override para indicar que um método da superclasse foi sobrescrito."}));
    //3
    quiz.add(new Perguntas("Na linguagem Java ao se usar uma constante numérica, no código fonte, ela será um int. O "
            + "tamanho desse tipo numérico é de:", 
            "32 bits (valores de -2.147.483.648 a +2.147.483.647).", 
            null, new String[]{
                "16 bits (valores de -32.768 a +32.767).",
                "32 bits (valores de -2.147.483.648 a +2.147.483.647).",
                "32 bits (valores de -32.768 a +32.767).",
                "64 bits (valores de -2.147.483.648 a +2.147.483.647)."}));
    //4
    quiz.add(new Perguntas("Pacotes são basicamente pastas ou diretórios do sistema operacional que ficam armazenados "
            + "os arquivos fonte de Java e são essenciais para o conceito de encapsulamento, no qual são dados níveis "
            + "de acesso às classes. Para tanto, a sequência correta de utilização de todos esses elementos envolvidos é:",
            "package - import - class", 
            null, new String[] {
                "package - import - class",
                "import - package - class",
                "package - class - import",
                "class - import - package"}));
    //5
    quiz.add(new Perguntas("A Máquina Virtual Java ______ o código fonte para código de máquina específico de uma plataforma "
            + "e sistema operacional”. Qual alternativa completa corretamente a lacuna?", 
            "Compila.", 
            null, new String[] {
                "Compila.",
                "Deleta.",
                "Separa.",
                "Reorganiza."}));
    //6
    quiz.add(new Perguntas("Acerca de linguagens de programação e J2EE e portais corporativos, julgue o seguinte item.\n" +
            "O seguinte trecho de código em Java exibe uma estrutura de controle de fluxo representativa das sentenças de iteração e fornece "
            + "desvios implícitos no final de seus segmentos de código.", 
            "Errado", 
            "Arquivos/Imagens/Perguntas/6.png"));
    //7
    quiz.add(new Perguntas("Em JAVA, existe um método que pertence à biblioteca nativa, onde não é capaz de bloquear a execução de uma "
            + "determinada thread. Com relação a esse assunto, marque a alternativa correta.", 
            "Thread.yield()", 
            null, new String[] {
                "Thread.join()",
                "Thread.insert()",
                "Thread.block()",
                "Thread.yield()"}));
    //8
    quiz.add(new Perguntas("Ao compilar um arquivo salvo com a extensão .java, há a necessidade de transformação do código em bytecodes para "
            + "que ele possa ser executado e reconhecido pela Máquina Virtual Java. Nesse caso, assinale a alternativa que indica a extensão gerada.", 
            ".class", 
            null, new String[] {
                ".css",
                ".jar",
                ".exe",
                ".class"}));
    //9
    quiz.add(new Perguntas("Em Java, um método do tipo “void” significa que", 
            "ele não retorna valor algum.", 
            null, new String[] {
                "ele retorna o valor de uma variável.",
                "ele não retorna valor algum.",
                "o método é instância de um objeto.",
                "o método é uma função."}));
    //10
    quiz.add(new Perguntas("A Máquina Virtual que carrega e executa os aplicativos Java, convertendo os bytecodes em código executável de máquina, é conhecida pela "
            + "sigla em inglês:", 
            "JVM", 
            null, new String[] {
                "SDK",
                "JDK",
                "JVM",
                "JRE"}));
    //11
    quiz.add(new Perguntas("Na programação orientada a objetos utilizam-se conceitos como classes, objetos e métodos. Na linguagem Java, um método", 
            "não pode ser sobrecarregado na mesma classe.", 
            null, new String[] {
                "não pode ser sobrecarregado na mesma classe.",
                "pode receber parâmetros de tipos diferentes.",
                "pode ser sobrescrito na mesma classe.",
                "deve ser abstrato nas classes, mas não nas interfaces."}));
    //12
    quiz.add(new Perguntas("Em relação à linguagem de programação Java, qual o método estático que apenas exibe uma caixa de diálogo contendo uma mensagem?", 
            "JOptionPane.showMessageDialog", 
            null, new String[] {
                "Graphics.showMessage",
                "JFrame.showMessage",
                "JOptionPane.showInputDialog",
                "JOptionPane.showMessageDialog"}));
    //13
    quiz.add(new Perguntas("Em um programa na linguagem Java, um Técnico declarou uma variável e atribuiu a ela um valor inteiro por meio do comando short a = 32768;. Ao tentar executar "
            + "a aplicação, este comando gerou uma exceção porque variáveis do tipo short só podem conter valores na faixa de:", 
            "-32768 a 32767.", 
            null, new String[]{
                "-128 a 127.",
                "0 a 256.",
                "-32768 a 32767.",
                "-2048 a 2047."
            }));
    //14
    quiz.add(new Perguntas("Os operadores possuem regras que são aplicadas nas expressões aritméticas do Java, que são as mesmas seguidas em álgebra. Quando dizemos que os operadores são "
            + "aplicados da esquerda para a direita, estamos nos referindo à sua associatividade",
            "0 2 1 0 2 1 0 2 1", 
            "Arquivos/Imagens/Perguntas/14.png", 
            new String[] {
                "0 2 1 0 2 1 0 2 1",
                "0 0 1 0 0 1 0 0 1",
                "0 1 2 0 1 2 0 1 2",
                "0 1 0 1 0 1 0 1 0"}));
    //15
    quiz.add(new Perguntas("Em Orientação a Objetos, Herança Múltipla ocorre quando uma classe herdar de duas ou mais classes. Java não permite Herança Múltipla entre classes, ou seja, "
            + "em Java uma classe só pode herdar de no máximo uma outra classe. Entretanto, normalmente os desenvolvedores Java utilizam-se de outra estrutura para simular Herança Múltipla. "
            + "Que estrutura é essa?", 
            "Interface.", 
            null, new String[] {
                "Classe Abstrata.","Classe Aninhada.","Annotation.","Interface."}));
    //16
    quiz.add(new Perguntas("A linguagem de programação Java permite a criação de programas que façam uso de recursividade. Isto posto, analise a classe Java, denominada X, abaixo.", 
            "quando compilada e executada, o console apresentará o valor 120.", 
            "Arquivos/Imagens/Perguntas/16.png", 
            new String[] {
                "quando compilada e executada, o console apresentará o valor 120.",
                "quando compilada e executada, a classe entrará em loop infinito.",
                "quando compilada e executada, o console apresentará o valor 720.",
                "quando compilada e executada, o console apresentará uma exceção."}));
    //17
    quiz.add(new Perguntas("Com relação aos conceitos de programação orientada a objetos, um objeto é:", 
    		"uma instância de uma classe.", 
    		null,
    		new String[]{
    				"uma instância de uma classe.",
    				"usado para instanciar classes ou outros objetos.",
    				"uma variável de um tipo primitivo ou uma referência.",
    				"uma referência para uma classe ou para outros objetos."}));
    //18
    quiz.add(new Perguntas("Utilizando Java 8, qual o resultado do código abaixo?", 
            "Erro de compilação devido as linhas 1 e 2", 
            "Arquivos/Imagens/Perguntas/18.png", 
            new String[] {
                "Erro de compilação devido as linhas 1 e 2",
                "Erro de compilação devido à linha 1",
                "”554123”",
                "677"}));
    //19
    quiz.add(new Perguntas("Utilizando Java 8, sobre a classe Cliente abaixo, o que podemos afirmar corretamente?", 
            "Subclasses concretas de Cliente devem implementar o método compra().", 
            "Arquivos/Imagens/Perguntas/19.png",  
            new String[] {
                "A classe Cliente não pode ser estendida.",
                "Subclasses de Cliente devem implementar o método compra().",
                "Subclasses concretas de Cliente devem utilizar um construtor padrão.",
                "Subclasses concretas de Cliente devem implementar o método compra()."}));
    //20
    quiz.add(new Perguntas("Em Java 8, qual modificador de acesso torna um membro disponível somente para classes "
            + "dentro do mesmo pacote ou subclasses?", 
            "protected", 
            null, new String[] {
                "public",
                "default",
                "private",
                "protected"}));
    //21
    quiz.add(new Perguntas("Analise as linhas de código em Java a seguir. Qual é a linha que apresenta erro?", 
            "Linha 2", 
            "Arquivos/Imagens/Perguntas/21.png",
            new String[] {
                "Linha 2",
                "Linha 3",
                "Linha 4",
                "Linha 6"}));
    //22
    quiz.add(new Perguntas("Embora não sejam objetos, os valores dos tipos primitivos escalares são suportados por Java.", 
            "Certo", null));
    //23
    quiz.add(new Perguntas("A vinculação estática permite a sobrescrita, se o método for estático ou privado.", 
           "Errado", null));
    //24
    quiz.add(new Perguntas("Uma das vantagens da linguagem Java em relação a outras linguagens é a fácil implementação de herança múltipla.", 
            "Errado", null));
    //25
    quiz.add(new Perguntas("A linguagem Java provê, de forma nativa, a capacidade de multithreading, ou seja, a execução de mais de um "
            + "fluxo de instruções em paralelo e com a mesma prioridade.", "Errado", null));
    //26
    quiz.add(new Perguntas("Na linguagem Java, o conceito de herança está vinculado à criação de uma nova classe a partir de uma classe "
            + "já existente, em que essa nova classe herda os atributos e comportamentos da classe anterior.", 
            "Certo", null));
    //27
    quiz.add(new Perguntas("Uma classe final não pode ser herdada, um método final não pode ser sobrescrito, e o valor de um atributo "
            + "final não pode ser alterado.",  "Certo", null));
    //28
    quiz.add(new Perguntas("A palavra reservada interface é utilizada sempre que se quer criar uma nova tela com interface gráfica.",
            "Errado", null));
    //29
    quiz.add(new Perguntas("Devido à linguagem de programação Java ser fortemente tipada, não é possível haver conversão "
            + "entre tipos de dados diferentes.", "Errado", null));
    //30
    quiz.add(new Perguntas("Caso queira lançar uma exceção em seu programa, o programador deverá utilizar a palavra "
            + "reservada throw seguida da exceção a ser lançada.", 
            "Certo", null));
    //31
    quiz.add(new Perguntas("A classe não compilará, pois houve erro durante a conversão dos tipos de dados na linha 7.", 
            "Errado", "Arquivos/Imagens/Perguntas/31.png"));
    //32
    quiz.add(new Perguntas("A classe não irá compilar, por causa do operador \"+=\", utilizado na linha 8.", 
            "Errado", "Arquivos/Imagens/Perguntas/32.png"));
    //33
    quiz.add(new Perguntas("O tipo int é um tipo primitivo Java.", 
            "Certo", null));
    //34
    quiz.add(new Perguntas("Com referência à linguagem de programação Java, julgue o item a seguir.\n" +
            "São estruturas de repetições Java: while, for, for-while e repeat.", 
            "Errado", null));
    //35
    quiz.add(new Perguntas("Com base na imagem da classe Java apresentada. A classe irá compilar, mas não executará, "
            + "porque apresentará erro em tempo de execução.", 
            "Errado", "Arquivos/Imagens/Perguntas/35.png"));
    //36
    quiz.add(new Perguntas("Acerca da linguagem Java, julgue o próximo item.\n" +
            "O método no código\n" +
            "System.out.println(valor.charAt(0));\n" +
            "retornará todos os caracteres referentes à string avaliada", 
            "Errado", null));
    //37
    quiz.add(new Perguntas("Acerca da linguagem Java, julgue o próximo item.\n" +
            "O método no código\n" +
            "System.out.println(valor.codePointAt(0));\n" +
            "retornará a comparação entre duas strings em formato unicode", 
            "Errado", null));
    //38
    quiz.add(new Perguntas("Julgue o item a seguir, a respeito da linguagem de programação Java.", 
            "Errado", "Arquivos/Imagens/Perguntas/38.png"));
    //39
    quiz.add(new Perguntas("Arquivo JAR contém recursos relacionados ao Java, como bibliotecas e classes, e pode conter "
            + "qualquer arquivo que não seja relacionado a aplicação Java, como .txt, .doc, .gif.", 
            "Certo", null));
    //40
    quiz.add(new Perguntas("Para a criação de objetos utilizando a linguagem Java, devem-se usar expressões contendo "
            + "a palavra-chave new.", 
            "Certo", null));
    }
 
}

package banco;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Teste {
    /*public static void main(String[] args) {
        final String NOMEARQ = "contas.txt";
        ArrayList<Conta> contas = new ArrayList<>();
        ArrayList<Operacao> operacoes = null;
        Formatter saida;
        Scanner entrada = null;
        Scanner contasScanner = null;
        Scanner operacoesScanner = null;

        GerenciarArquivo.setNomeArq(NOMEARQ);
        GerenciarArquivo.abrirLeitura();
        if (entrada != null) {
            GerenciarArquivo.lerArquivo(contas,contasScanner, operacoes, operacoesScanner);
            GerenciarArquivo.fecharArquivo(entrada);
        } else {
            System.out.println("Erro: Leitura");
        }
        exibeContas(contas);
        Conta conta = new Conta("Ias Silveira", 1,5000);
        contas.add(conta);
        String nomeArq = null;
        saida = GerenciarArquivo.abrirGravacao(nomeArq);
        GerenciarArquivo.gravarConta(saida, contas);
        GerenciarArquivo.fecharArquivo(saida);
    }

    private static void exibeContas(ArrayList<Conta> contas) {
        for (Conta conta : contas) {
            System.out.println(contas);
        }
    }

    public static void criaContas(ArrayList<Conta> contas) {

        contas.add(new Conta ("Mim Furtado", 2,1000));
        contas.add(new Conta ("Lua Bandeira", 3,2000));
        contas.add(new Conta ("Sol Miranda", 4,3000));
    }

    public static void verificaArquivo(){
        final String NOMEARQ = "/Users/Mesa/BancoAt 4";
        File arq = new File(NOMEARQ);

        if (arq.exists()){
            System.out.println(arq.getName());
            System.out.println(arq.getPath());
            System.out.println(arq.length()+ "bytes");
            System.out.println(arq.isFile());
        } else {
            System.out.println("Arquivo não existe");
        }
    }*/
}

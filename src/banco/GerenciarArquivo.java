package banco;

import auxiliar.TipoDeContaEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class GerenciarArquivo {
    public static Scanner abrirLeitura(String nomeArq) {
        Scanner entrada = null;

        try {
            entrada = new Scanner(new File(nomeArq));
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: abertura do arquivo");
        }
        return entrada;
    }

    public static Scanner abrirLeitura2(String nomeArq) {
        Scanner entrada = null;

        try {
            entrada = new Scanner(new File(nomeArq));
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: abertura do arquivo");
        }
        return entrada;
    }

    public static void lerArquivoOperacao(ArrayList<Conta> contas, Scanner entrada) {
        String linha;
        String[] campos;

        while (entrada.hasNext()) {
            linha = entrada.nextLine();
            campos = linha.split(";");
            for (Conta conta : contas) {
                if (campos[0].equals(String.valueOf(conta.getNumConta()))) {
                    Operacao operacao = new Operacao(campos[1], campos[2], Double.parseDouble(campos[3]));
                    conta.getOperacoes().add(operacao);
                }
            }
        }
    }

    public static void lerArquivo( ArrayList<Conta> contas,Scanner contasScanner, ArrayList<Operacao> operacoes, Scanner operacoesScanner) {
        String linha;
        String[] campos;

        while (contasScanner.hasNext()) {
            linha = contasScanner.nextLine();
            campos = linha.split(";");
            if (campos[0] == TipoDeContaEnum.PF.toString()) {
                ContaPF accountPF = new ContaPF(campos[1], Integer.parseInt(campos[2]), Double.parseDouble(campos[3]), campos[4], Double.parseDouble(campos[5]));
                contas.add(accountPF);
            } else {
                ContaPJ contaPJ = new ContaPJ(campos[1], Integer.parseInt(campos[2]), Double.parseDouble(campos[3]), campos[4]);
                contas.add(contaPJ);
            }
        }
        lerArquivoOperacao(contas, operacoesScanner);
    }


    public static Formatter abrirGravacao(String nomeArq) {
        Formatter saida = null;

        try {
            saida = new Formatter(nomeArq);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: arquivo não encontrado");
        }
        return saida;
    }

    public static void gravarConta(Formatter exit, ArrayList<Conta> contas) {
        for (Conta conta : contas) {
            if (conta instanceof ContaPF) {
                exit.format("%s;%s;%s;%s;%s;%s\n", TipoDeContaEnum.PF, conta.getNome(), conta.getNumConta(), conta.getSaldo(),/*((ContaPF) conta).getCpf(),*/ ((ContaPF) conta).getChequeEspecial());
            } else if (conta instanceof ContaPJ) {
                exit.format("%s;%s;%s;%s;%s\n", TipoDeContaEnum.PJ, conta.getNome(), conta.getNumConta(), conta.getSaldo(), ((ContaPJ) conta).getCnpj());
            }
        }
    }

    public static void gravarOperacao(Formatter exit, ArrayList<Conta> contas) {
        for (Conta conta : contas) {
            for (Operacao operacao : conta.getOperacoes()) {
                exit.format("%s;%s;%s;%s\n", conta.getNumConta(), operacao.getTipoDeOperacao(), operacao.getDataDaOperacao(), operacao.getValorDaOperacao());
            }
        }
    }

    public static void fecharArquivo(Formatter saida) {
        if (saida != null) {
            saida.close();
        }
    }

    public static void fecharArquivo(Scanner entrada) {
        if (entrada != null) {
            entrada.close();
        }
    }

    public static void lerArquivo(ArrayList<Conta> contas, Scanner contasScanner, Scanner operacoesScanner) {
    }
}

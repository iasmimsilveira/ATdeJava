package banco;

import auxiliar.*;
import auxiliar.Util;
import auxiliar.Validacao;
import auxiliar.Constants;
import auxiliar.MenuEnum;
import auxiliar.TipoDeMsgEnum;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import metodos.AlterarSaldo;
import metodos.ExcluirConta;
import metodos.IncluirConta;
import metodos.MostrarRelatorio;

public class ExecutarSistema {
    public static void main(String[] args) {
        final int FIM = 5;
        int opcao;
        String data = Util.getDate();
        System.out.println(data);
        ArrayList<Conta> contas = new ArrayList<>();

        //contruirArquivo(contas);
        opcao = menu(MenuEnum.OPCOES_DO_USUARIO);
        while (opcao != FIM) {
            iniciar(opcao, contas);
            Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.EMPTY_MESSAGE);
            opcao = menu(MenuEnum.OPCOES_DO_USUARIO);
        }
        updateArquivoContas(contas);
    }

    private static void contruirArquivo(ArrayList<Conta> contas) {
        Scanner contasScanner;
        Scanner operacoesScanner;

        contasScanner = GerenciarArquivo.abrirLeitura(Constants.CONTAS_TXT);
        operacoesScanner = GerenciarArquivo.abrirLeitura(Constants.OPERACOES_TXT);
        Formatter exitContas = GerenciarArquivo.abrirGravacao(Constants.CONTAS_TXT);
        Formatter exitOperacoes = GerenciarArquivo.abrirGravacao(Constants.OPERACOES_TXT);

        if (contasScanner != null) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.ERRO_LER_ARQUIVO);
            return;
        }
        GerenciarArquivo.lerArquivo(contas, contasScanner, operacoesScanner);
        GerenciarArquivo.fecharArquivo(contasScanner);
        GerenciarArquivo.fecharArquivo(operacoesScanner);
    }

    private static void updateArquivoContas(ArrayList<Conta> contas) {
        Formatter exitContas = GerenciarArquivo.abrirGravacao(Constants.CONTAS_TXT);
        Formatter exitOperacoes = GerenciarArquivo.abrirGravacao(Constants.OPERACOES_TXT);

        GerenciarArquivo.gravarConta(exitContas, contas);
        GerenciarArquivo.gravarConta(exitOperacoes, contas);
        GerenciarArquivo.fecharArquivo(exitContas);
        GerenciarArquivo.fecharArquivo(exitOperacoes);
    }

    public static int menu(MenuEnum tiposDeOpcao) {
        int opcao;
        String menuOpcao = "";

        switch (tiposDeOpcao) {
            case OPCOES_DO_USUARIO:
                menuOpcao = Constants.MENU_PRINCIPAL;
                break;
            case MENU_TIPO_DE_CONTA:
                menuOpcao = Constants.TIPO_DE_CONTA;
                break;
            case GERENCIADOR_DE_RELATORIO:
                menuOpcao = Constants.MENU_RELATORIO;
                break;
            default:
                Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.INVALID_MESSAGE_TYPE);
                break;
        }
        opcao = Util.lerValorInt(menuOpcao);
        return opcao;
    }

    private static void iniciar(int opcao, ArrayList<Conta> contas) {
        switch (opcao) {
            case 1:
                IncluirConta.incluirConta(contas);
                break;
            case 2:
                AlterarSaldo.alterarSaldo(contas);
                break;
            case 3:
                ExcluirConta.excluirConta(contas);
                break;
            case 4:
                MostrarRelatorio.mostrarRelatorio(contas);
                break;
            default:
                Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.INVALID_OPERACAO);
                break;
        }
    }
}



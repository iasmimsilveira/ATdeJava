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

public class ExecutarSistema {
    public static void main(String[] args) {
        final int FIM = 5;
        int opcao;
        ArrayList<Conta> contas = new ArrayList<>();
        //ArrayList<Operacao> operacoes = new ArrayList<>();

        contruirArquivo(contas);
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

        contasScanner = GerenciarArquivo.abrirLeitura(Constants.CONTAS_NOME_ARQUIVO);
        operacoesScanner = GerenciarArquivo.abrirLeitura(Constants.OPERACOES_NOME_ARQUIVO);
        if (contasScanner != null) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.ERRO_LER_ARQUIVO);
            return;
        }
        GerenciarArquivo.lerArquivo(contas, contasScanner, operacoesScanner);
        GerenciarArquivo.fecharArquivo(contasScanner);
        GerenciarArquivo.fecharArquivo(operacoesScanner);
    }

    private static void updateArquivoContas(ArrayList<Conta> contas) {
        Formatter exit = GerenciarArquivo.abrirGravacao(Constants.CONTAS_NOME_ARQUIVO);
        GerenciarArquivo.gravarConta(exit, contas);
        GerenciarArquivo.fecharArquivo(exit);
    }
    /*private static void updateArquivoOperacoes(ArrayList<Operacao> operacoes) {
        Formatter exit = GerenciarArquivo.abrirGravacao(Constants.OPERACOES_NOME_ARQUIVO);
        GerenciarArquivo.gravarOperacao(exit, operacoes);
        GerenciarArquivo.fecharArquivo(exit);
    }*/

    private static int menu(MenuEnum tiposDeOpcao) {
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
        opcao = Util.lerIntValue(menuOpcao);
        return opcao;
    }

    private static void iniciar(int opcao, ArrayList<Conta> contas) {
        switch (opcao) {
            case 1:
                incluirConta(contas);
                break;
            case 2:
                alterarSaldo(contas);
                break;
            case 3:
                excluirConta(contas);
                break;
            case 4:
                mostrarRelatorio(contas);
                break;
            case 5:
            default:
                Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.INVALID_OPERACAO);
                break;
        }
    }

    private static void incluirConta(ArrayList<Conta> contas) {
        int tipoDeConta;
        int numConta;

        numConta = Util.lerIntValue(Constants.ENTER_NUMCONTA);
        if (Validacao.contaRepetida(numConta, contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.CONTA_EXISTE);
            return;
        }
        tipoDeConta = menu(MenuEnum.MENU_TIPO_DE_CONTA);
        switch (tipoDeConta) {
            case 1:
                setDadosContaPF(contas, numConta);
                break;
            case 2:
                setDadosContaPJ(contas, numConta);
                break;
            default:
                Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.INVALID_OPERATION);
                break;
        }
    }

    private static void setDadosContaPF(ArrayList<Conta> contas, int numConta) {
        ContaPF contaPF = new ContaPF();

        contaPF.setNumConta(Util.lerIntValue(Constants.ENTER_NUMCONTA));
        contaPF.setNome(Util.lerNome(Constants.ENTER_TITULAR));
        contaPF.setCpf(String.valueOf(Util.lerIntValue(Constants.ENTER_CPF)));
        contaPF.setSaldo(Util.lerDoubleValue(Constants.ENTER_SALDO));
        contaPF.setChequeEspecial(Util.lerDoubleValue(Constants.ENTER_CHEQUE));
        System.out.println(contaPF);
        contas.add(contaPF);
        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_REGISTRADA);
        }


    private static void setDadosContaPJ(ArrayList<Conta> contas, int numConta) {
        ContaPJ contaPJ = new ContaPJ();

        contaPJ.setNumConta(Util.lerIntValue(Constants.ENTER_NUMCONTA));
        contaPJ.setNome(Util.lerNome(Constants.ENTER_EMPRESA));
        contaPJ.setCnpj(String.valueOf(Util.lerIntValue(Constants.ENTER_CNPJ)));
        contaPJ.setSaldo(Util.lerDoubleValue(Constants.ENTER_SALDO));
        contas.add(contaPJ);
        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_REGISTRADA);

    }

    private static void alterarSaldo(ArrayList<Conta> contas) {
        int numConta;
        double valorDaOperaca = 0;
        TipoDeOperacaoEnum tipoDeOperacao;
        Conta conta;

        if (!Validacao.contaJaExiste(contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.EMPTY_LIST);
            return;
        }
        numConta = Util.lerIntValue(Constants.ENTER_NUMCONTA);
        if(!Validacao.contaRepetida(numConta, contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.CONTA_NOT_FOUND);
            return;
        }
        conta = Util.getConta(numConta, contas);
        tipoDeOperacao = Util.getTipoDeOperacao();

        switch (tipoDeOperacao) {
            case CREDITO:
                valorDaOperaca = Util.lerDoubleValue(Constants.ENTER_SACAR);
                conta.setSaldo(conta.getSaldo() + valorDaOperaca);
                setDadoDaOperacao(numConta, Constants.CREDITO, valorDaOperaca,contas);
                double saldoAtualizado = conta.getSaldo() + valorDaOperaca;
                System.out.println("VALOR DA OPERAÇÃO..." + valorDaOperaca);
                System.out.println("SALDO ATUALIZADO...." + saldoAtualizado);
                break;
            case DEBITO:
                valorDaOperaca = Util.lerDoubleValue(Constants.ENTER_SACAR);
                if (conta instanceof ContaPF) {
                    if (!Validacao.debitar(valorDaOperaca, valorDaOperaca, valorDaOperaca)) {
                        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.INVALID_DEBIT_OPERATION_SPECIAL_CHECK);
                        return;
                    }
                    conta.setSaldo(conta.getSaldo() - valorDaOperaca);
                    setDadoDaOperacao(numConta, Constants.DEBITO, valorDaOperaca,contas);
                } else {
                    if (!Validacao.contaPossuiSaldo(conta)) {
                        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.INVALID_DEBIT_OPERATION);
                        return;
                    }
                    conta.setSaldo(conta.getSaldo() - valorDaOperaca);
                    setDadoDaOperacao(numConta, Constants.DEBITO, valorDaOperaca,contas);
                }
                break;
        }
    }

    private static void setDadoDaOperacao(int numConta, String tipoDeOperacao, double valorDaOperacao, ArrayList<Conta> contas) {
        Operacao operacao = new Operacao();

        operacao.setDataDaOperacao(Util.getDate());
        operacao.setTipoDeOperacao(tipoDeOperacao);
        operacao.setValorDaOperacao(valorDaOperacao);

        for (Conta conta : contas) {
            if (conta.getNumConta() == numConta) {
                conta.getOperacoes().add(operacao);
            }
        }
    }

    private static void excluirConta(ArrayList<Conta> contas) {
        int numConta;
        int contaIndice;

        if (!Validacao.contaJaExiste(contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.EMPTY_LIST);
            return;
        }
        numConta = Util.lerIntValue(Constants.ENTER_NUMCONTA);
        if (!Validacao.contaRepetida(numConta, contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.ACCOUNT_NOT_FOUND);
            return;
        }
        if (!Validacao.removerConta(numConta, contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.CONTA_DELETADA);
            return;
        }
        contaIndice = Util.getIndexConta(numConta, contas);
        contas.remove(contaIndice);
        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_DELETADA);
    }



    private static void mostrarRelatorio(ArrayList<Conta> contas) {
        int opcao;

        if (!Validacao.contaJaExiste(contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.EMPTY_LIST);
            return;
        }
        opcao = menu(MenuEnum.GERENCIADOR_DE_RELATORIO);
        switch (opcao) {
            case 1:
                contasSaldoNegativo(contas);
                break;
            case 2:
                saldoAcimaDeX(contas);
                break;
            case 3:
                tipoDeConta(contas);
                break;
            case 4:
                opRealizadaEmConta(contas);
                break;
            case 5:
                break;
            }
    }

    private static void contasSaldoNegativo(ArrayList<Conta> contas) {
        for (Conta conta : contas) {
            if (conta.getSaldo() < 0) {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, conta.toString());
            }
        }
    }

    private static void saldoAcimaDeX(ArrayList<Conta> contas) {
        for (Conta conta : contas) {
            if (conta.getSaldo() > 2000) {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, conta.toString());
            }
        }
    }

    private static void tipoDeConta(ArrayList<Conta> contas) {
        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_PF);
        for (Conta conta : contas) {
            if (conta instanceof ContaPF) {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, conta.toString());
            }
        }
        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_PF);
        for (Conta conta : contas) {
            if (conta instanceof ContaPJ) {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, conta.toString());
            }
        }
    }

    private static void opRealizadaEmConta(ArrayList<Conta> contas) {
        int numConta;

        numConta = Util.lerIntValue(Constants.ENTER_NUMCONTA);
        if (!Validacao.contaRepetida(numConta, contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.ACCOUNT_NOT_FOUND);
            return;
        }
        for (Conta conta : contas) {
            if (conta.getNumConta() == numConta) {
                for (Operacao operation : conta.getOperacoes()) {
                    Util.mostrarMsg(TipoDeMsgEnum.OUT, operation.toString());
                }
            }
        }
    }
}

    /*private static void showMessage(String type, String msg) {
        switch (type) {
            case Constants.OUT: System.out.println(msg); break;
            case Constants.ERR: System.err.println(msg); break;
            default: System.err.println(Constants.INVALID_MESSAGE_TYPE); break;
        }*/



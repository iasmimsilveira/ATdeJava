package metodos;

import auxiliar.*;
import banco.Conta;
import banco.ContaPF;
import banco.ExecutarSistema;

import java.util.ArrayList;

public class AlterarSaldo {
    public static void alterarSaldo(ArrayList<Conta> contas) {
        int numConta;
        double valorDaOperacao = 0;
        TipoDeOperacaoEnum tipoDeOperacao;
        Conta conta;

        if(contas.isEmpty()) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.EMPTY_LIST);
            return;
        }
        numConta = Util.lerValorInt(Constants.ENTER_NUMCONTA);
        if(!Validacao.pesquisaDeConta(numConta, contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.CONTA_NOT_FOUND);
            return;
        }
        conta = Util.getConta(numConta, contas);
        tipoDeOperacao = Util.getTipoDeOperacao();

        switch (tipoDeOperacao) {
            case CREDITO:
                valorDaOperacao = Util.lerValorDouble(Constants.ENTER_VALOR);
                conta.setSaldo(conta.getSaldo() + valorDaOperacao);
                SetDadosDaOperacao.setDadoDaOperacao(numConta, Constants.CREDITO, valorDaOperacao,contas);
                double saldoAtualizado = conta.getSaldo() + valorDaOperacao;
                System.out.println("VALOR DA OPERAÇÃO..." + valorDaOperacao);
                System.out.println("SALDO ATUALIZADO...." + saldoAtualizado);
                break;
            case DEBITO:
                valorDaOperacao = Util.lerValorDouble(Constants.ENTER_VALOR);
                if (conta instanceof ContaPF) {
                    if (!Validacao.debitar(valorDaOperacao, valorDaOperacao, valorDaOperacao)) {
                        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.INVALID_DEBIT_OPERATION_SPECIAL_CHECK);
                        return;
                    }
                    conta.setSaldo(conta.getSaldo() - valorDaOperacao);
                    SetDadosDaOperacao.setDadoDaOperacao(numConta, Constants.DEBITO, valorDaOperacao,contas);
                } else {
                    if (!Validacao.contaPossuiSaldo(conta)) {
                        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.INVALID_DEBIT_OPERATION);
                        return;
                    }
                    conta.setSaldo(conta.getSaldo() - valorDaOperacao);
                    SetDadosDaOperacao.setDadoDaOperacao(numConta, Constants.DEBITO, valorDaOperacao,contas);
                }
                break;
        }
    }
}

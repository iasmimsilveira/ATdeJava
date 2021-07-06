package metodos;

import auxiliar.Util;
import banco.Conta;
import banco.Operacao;

import java.util.ArrayList;

public class SetDadosDaOperacao {
    public static void setDadoDaOperacao(int numConta, String tipoDeOperacao, double valorDaOperacao, ArrayList<Conta> contas) {
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
}

package metodos;

import auxiliar.Constants;
import auxiliar.TipoDeMsgEnum;
import auxiliar.Util;
import auxiliar.Validacao;
import banco.Conta;
import banco.Operacao;

import java.util.ArrayList;

public class OPRealizadaEmConta {
    public static void opRealizadaEmConta(ArrayList<Conta> contas) {
        int numConta;

        numConta = Util.lerValorInt(Constants.ENTER_NUMCONTA);
        if (!Validacao.pesquisaDeConta(numConta, contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.ACCOUNT_NOT_FOUND);
            return;
        }
        for (Conta conta : contas) {
            if (conta.getNumConta() == numConta) {
                for (Operacao operacao : conta.getOperacoes()) {
                    Util.mostrarMsg(TipoDeMsgEnum.OUT, operacao.toString());
                }
            }
        }
    }
}

package metodos;

import auxiliar.Constants;
import auxiliar.TipoDeMsgEnum;
import auxiliar.Util;
import banco.Conta;
import banco.ContaPF;

import java.util.ArrayList;

public class SetDadosPF {
    public static void setDadosContaPF(ArrayList<Conta> contas, int numConta) {
        ContaPF contaPF = new ContaPF();

        contaPF.setNumConta(Util.lerValorInt(Constants.ENTER_NUMCONTA));
        contaPF.setNome(Util.lerNome(Constants.ENTER_TITULAR));
        contaPF.setCpf(String.valueOf(Util.lerValorInt(Constants.ENTER_CPF)));
        contaPF.setSaldo(Util.lerValorDouble(Constants.ENTER_SALDO));
        contaPF.setChequeEspecial(Util.lerValorDouble(Constants.ENTER_CHEQUE));
        System.out.println(contaPF);
        contas.add(contaPF);
        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_REGISTRADA);
    }
}

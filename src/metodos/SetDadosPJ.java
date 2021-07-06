package metodos;

import auxiliar.Constants;
import auxiliar.TipoDeMsgEnum;
import auxiliar.Util;
import banco.Conta;
import banco.ContaPJ;

import java.util.ArrayList;

public class SetDadosPJ {
    public static void setDadosContaPJ(ArrayList<Conta> contas, int numConta) {
        ContaPJ contaPJ = new ContaPJ();

        contaPJ.setNumConta(Util.lerValorInt(Constants.ENTER_NUMCONTA));
        contaPJ.setNome(Util.lerNome(Constants.ENTER_EMPRESA));
        contaPJ.setCnpj(String.valueOf(Util.lerValorInt(Constants.ENTER_CNPJ)));
        contaPJ.setSaldo(Util.lerValorDouble(Constants.ENTER_SALDO));
        contas.add(contaPJ);
        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_REGISTRADA);

    }
}

package metodos;

import auxiliar.*;
import banco.Conta;
import auxiliar.Constants;
import auxiliar.TipoDeContaEnum;
import auxiliar.MenuEnum;
import banco.ExecutarSistema;

import java.util.ArrayList;

public class IncluirConta {
    public static void incluirConta(ArrayList<Conta> contas) {
        int tipoDeConta;
        int numConta;

        //Verifição para saber se a conta já existe
        numConta = Util.lerValorInt(Constants.ENTER_NUMCONTA);
        if (Validacao.pesquisaDeConta(numConta, contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.CONTA_EXISTE);
            return;
        }
        tipoDeConta = ExecutarSistema.menu(MenuEnum.MENU_TIPO_DE_CONTA);
        switch (tipoDeConta) {
            case 1:
                SetDadosPF.setDadosContaPF(contas, numConta);
                break;
            case 2:
                SetDadosPJ.setDadosContaPJ(contas, numConta);
                break;
            default:
                Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.INVALID_OPERATION);
                break;
        }
    }
}

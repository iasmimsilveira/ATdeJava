package metodos;

import auxiliar.Constants;
import auxiliar.TipoDeMsgEnum;
import auxiliar.Util;
import banco.Conta;
import banco.ContaPF;
import banco.ContaPJ;

import java.util.ArrayList;

public class TipoDeConta {
    public static void tipoDeConta(ArrayList<Conta> contas) {
        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_PF);
        for (Conta conta : contas) {
            if (conta instanceof ContaPF) {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, conta.toString());
            }
        }
        Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_PJ);
        for (Conta conta : contas) {
            if (conta instanceof ContaPJ) {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, conta.toString());
            }
        }
    }
}

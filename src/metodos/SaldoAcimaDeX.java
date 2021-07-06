package metodos;

import auxiliar.TipoDeMsgEnum;
import auxiliar.Util;
import banco.Conta;

import java.util.ArrayList;

public class SaldoAcimaDeX {
    public static void saldoAcimaDeX(ArrayList<Conta> contas) {
        for (Conta conta : contas) {
            if (conta.getSaldo() > 1000) {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, conta.toString());
            }
        }
    }
}

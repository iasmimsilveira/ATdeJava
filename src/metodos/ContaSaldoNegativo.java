package metodos;

import auxiliar.TipoDeMsgEnum;
import auxiliar.Util;
import banco.Conta;

import java.util.ArrayList;

public class ContaSaldoNegativo {
    public static void contasSaldoNegativo(ArrayList<Conta> contas) {
        for (Conta conta : contas) {
            if (conta.getSaldo() < 0) {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, conta.toString());
            }
        }
    }
}

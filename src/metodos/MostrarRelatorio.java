package metodos;

import auxiliar.*;
import banco.Conta;
import banco.ExecutarSistema;
import auxiliar.MenuEnum;
import auxiliar.TipoDeContaEnum;

import java.util.ArrayList;

public class MostrarRelatorio {
    public static void mostrarRelatorio(ArrayList<Conta> contas) {
        int opcao;

        if (!Validacao.contaJaExiste(contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.EMPTY_LIST);
            return;
        }
        opcao = ExecutarSistema.menu(MenuEnum.GERENCIADOR_DE_RELATORIO);
        switch (opcao) {
            case 1:
                ContaSaldoNegativo.contasSaldoNegativo(contas);
                break;
            case 2:
                SaldoAcimaDeX.saldoAcimaDeX(contas);
                break;
            case 3:
                TipoDeConta.tipoDeConta(contas);
                break;
            case 4:
                OPRealizadaEmConta.opRealizadaEmConta(contas);
                break;
            case 5:
                break;
        }
    }
}

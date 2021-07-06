package metodos;

import auxiliar.Constants;
import auxiliar.TipoDeMsgEnum;
import auxiliar.Util;
import auxiliar.Validacao;
import banco.Conta;
import banco.ExecutarSistema;

import java.util.ArrayList;

public class ExcluirConta {
    public static void excluirConta(ArrayList<Conta> contas) {
        int numConta;

        //Primeiro verifica se a lista está vazia
        if(contas.isEmpty()) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.EMPTY_LIST);
            return;
        }
        //Lê a conta, se já existe, mensagem de erro
        if (!Validacao.contaJaExiste(contas)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.CONTA_EXISTE);
            return;
        }
        numConta = Util.lerValorInt(Constants.ENTER_NUMCONTA);
        Conta conta_atual = Util.getConta(numConta, contas);
        if (conta_atual.getSaldo() == 0) {
            contas.remove(conta_atual);
            Util.mostrarMsg(TipoDeMsgEnum.OUT, Constants.CONTA_REMOVIDA);
        }
    }
}

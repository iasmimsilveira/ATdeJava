package auxiliar;

import banco.Conta;
import java.util.ArrayList;

public final class Validacao {

    public static boolean validarTipoDeOperacao(int opcao) {
        boolean opcaoValida = false;

        if ((opcao == 1) || (opcao == 2)) {
            opcaoValida = true;
        }
        return opcaoValida;
    }

    public static boolean nomeValido(String nome) {
        String[] separaNome = nome.split(" ");
        return separaNome.length >= 2;
    }

    public static boolean numeroPositivo(double numero) {
        return !(numero >= 0);
    }

    public static boolean contaPossuiSaldo(Conta conta) {
        return conta.getSaldo() > 0;
    }

    public static boolean contaRepetida(int numConta, ArrayList<Conta> contas) {
        boolean possuiConta = false;

        for (Conta conta : contas) {
            if (conta.getNumConta() == numConta) {
                possuiConta = true;
                break;
            }
        }
        return possuiConta;
    }

    public static boolean removerConta(int numConta, ArrayList<Conta> contas) {
        boolean removeConta = false;

        for (Conta conta : contas) {
            if ((conta.getNumConta() == numConta) && (conta.getSaldo() == 0)) {
                removeConta = true;
            }
        }
        return removeConta;
    }

    public static boolean debitar(double saldo, double chequeEspecial, double valorDaOperacao) {
        boolean debita = false;

        if (valorDaOperacao <= (chequeEspecial + saldo)) {
            debita = true;
        }
        return debita;
    }

    public static boolean contaJaExiste(ArrayList<Conta> contas) {
        boolean possuiConta = false;

        if (contas.size() > 0) {
            possuiConta = true;
        }
        return possuiConta;
    }
}

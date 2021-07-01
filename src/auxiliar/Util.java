package auxiliar;

import java.util.*;

import banco.Conta;
import auxiliar.Constants;
import auxiliar.TipoDeMsgEnum;
import auxiliar.Validacao;
import auxiliar.TipoDeOperacaoEnum;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Util {
    public static String getDate() {
        String formattedDate;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = calendar.getTime();

        formattedDate = simpleDateFormat.format(date);
        return formattedDate;
    }

    public static TipoDeOperacaoEnum getTipoDeOperacao() {
        int opcao;
        TipoDeOperacaoEnum tipo = null;

        opcao = Util.lerIntValue(Constants.TIPO_OPERACOES_MENU);
        while (!Validacao.validarTipoDeOperacao(opcao)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.INVALID_OPERACAO);
            opcao = Util.lerIntValue(Constants.TIPO_OPERACOES_MENU);
        }
        switch (opcao) {
            case 1 -> tipo = TipoDeOperacaoEnum.CREDITO;
            case 2 -> tipo = TipoDeOperacaoEnum.DEBITO;
        }
        return tipo;
    }

    public static int getIndexConta(int numConta, ArrayList<Conta> contas) {
        int index = 0;

        for (Conta conta : contas) {
            if (conta.getNumConta() == numConta) {
                index = contas.indexOf(conta);
            }
        }
        return index;
    }

    public static Conta getConta (int numConta, ArrayList<Conta> contas) {
        Conta conta = null;

        for (Conta each : contas) {
            if (each.getNumConta() == numConta) {
                conta = each;
            }
        }
        return conta;
    }

    public static String lerNome(String msg) {
        String value;
        Scanner scanner = new Scanner(System.in);

        Util.mostrarMsg(TipoDeMsgEnum.OUT, msg);
        value = scanner.nextLine();
        while(!Validacao.nomeValido(value)) {
            Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.NOME_INVALIDO);
            Util.mostrarMsg(TipoDeMsgEnum.OUT, msg);
            value = scanner.nextLine();
        }
        return value;
    }

    public static int lerIntValue(String menuOpcao) {
        int value = 0;
        boolean isValidInput = false;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, menuOpcao);
                value = scanner.nextInt();
                while (Validacao.numeroPositivo(value)) {
                    Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.NUMERO_INVALIDO);
                    Util.mostrarMsg(TipoDeMsgEnum.OUT, menuOpcao);
                    value = scanner.nextInt();
                }
                isValidInput = true;
            } catch (InputMismatchException e) {
                Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.DADO_INVALIDO);
                scanner.next();
            }
        } while (!isValidInput);
        return value;
    }

    public  static double lerDoubleValue(String msg) {
        double value = 0;
        boolean isValidInput = false;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                Util.mostrarMsg(TipoDeMsgEnum.OUT, msg);
                value = scanner.nextDouble();
                while (Validacao.numeroPositivo(value)) {
                    Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.SALDO_INVALIDO);
                    Util.mostrarMsg(TipoDeMsgEnum.OUT, msg);
                    value = scanner.nextDouble();
                }
                isValidInput = true;
            } catch (InputMismatchException e) {
                Util.mostrarMsg(TipoDeMsgEnum.ERR, Constants.DADO_INVALIDO);
                scanner.next();
            }
        } while (!isValidInput);
        return value;
    }

    public static void mostrarMsg(TipoDeMsgEnum type, String msg) {
        switch (type) {
            case OUT -> System.out.println(msg);
            case ERR -> System.err.println(msg);
            default -> System.err.println(Constants.INVALID_MESSAGE_TYPE);
        }
    }
}

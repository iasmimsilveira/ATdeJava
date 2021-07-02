package auxiliar;

public class Constants {
    //Color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    // Nome dos arquivos txt
    public static final String CONTAS_TXT = "contas.txt";
    public static final String OPERACOES_TXT = "operacoes.txt";

    //Tipo de Mensagem
    public static final String OUT = "out";
    public static final String ERR = "err";


    // Tipo de Operação
    public static final String CREDITO = "Crédito";
    public static final String DEBITO = "Débito";


    // OUT Messages
    public static final String EMPTY_MESSAGE = "";
    public static final String OPERACAO_REALIZADA = "OPERAÇÃO REALIZADA COM SUCESSO!!!";
    public static final String CONTA_REMOVIDA= "CONTA REMOVIDA COM SUCESSO!!!";
    public static final String CONTA_REGISTRADA = "SEJA BEM-VINDO!\n"+ "CONTA CADASTRADA COM SUCESSO!!!";
    public static final String CONTA_PF = "CONTAS - PESSOAS FÍSICAS";
    public static final String CONTA_PJ = "CONTAS - PESSOAS JURÍDICAS";
    public static final String ESCOLHA = "Escolha a opção desejada: ";

    // ERR Messages
    public static final String ERRO_LER_ARQUIVO = "ERRO: não foi possível ler o arquivo";
    public static final String FILE_OPEN_ERROR = "ERRO: abertura do arquivo";
    public static final String FILE_NOT_FOUND = "ERRO: arquivo não encontrado";
    public static final String NOME_INVALIDO = "ERRO: o nome precisa ter pelo menos dois campos";
    public static final String INVALID_OPERACAO = "OPERAÇÃO INVÁLIDA!";
    public static final String INVALID_MESSAGE_TYPE = "TIPO DE MENSAGEM INVÁLIDA!";
    public static final String DADO_INVALIDO = "ERRO: dado inválido!";
    public static final String SALDO_INVALIDO = "ERRO: saldo precisa ser maior ou igual a 0";
    public static final String NUMERO_INVALIDO = "ERRO: número precisa ser um inteiro";
    public static final String CONTA_EXISTE = "ERRO: conta já existe";
    public static final String CONTA_NOT_FOUND = "Nenhuma conta encontrada";
    public static final String NAO_PODE_REMOVER = "ESSA CONTA NÃO PODE SER REMOVIDA";
    public static final String INVALID_DEBIT_OPERATION = "Débito inválido, a conta não possui saldo";
    public static final String INVALID_DEBIT_OPERATION_SPECIAL_CHECK = "Débito inválido, a conta não possui saldo";

    // Input Messages
    public static final String ENTER_SALDO = "ENTRE COM O SALDO DA CONTA: ";
    public static final String ENTER_NUMCONTA = "ENTRE COM O NÚMERO DA CONTA: ";

    // ContatPF Input Messages
    public static final String ENTER_TITULAR = "ENTRE COM O NOME DO TITULAR: ";
    public static final String ENTER_CPF = "ENTRE COM SEU CPF: ";
    public static final String ENTER_CHEQUE = "ENTRE COM SEU SALDO ESPECIAL: ";
    public static final String ENTER_VALOR = "ENTRE COM O VALOR DO OPERAÇÃO: ";
    // ContaPJ Input Messages
    public static final String ENTER_EMPRESA = "ENTRE COM O NOME DA EMPRESA: ";
    public static final String ENTER_CNPJ = "ENTRE COM SEU CNPJ: ";

    //ERR Messages
    public static final String INVALID_OPERATION = "Operação inválida!";
    //public static final String INVALID_MESSAGE_TYPE = "O tipo da mensagem é inválido!";
    public static final String INVALID_DATA = "Erro: dado inválido!";
    public static final String ACCOUNT_NOT_FOUND = "Nenhuma conta encontrada!";
    public static final String EMPTY_LIST = "Lista Vazia!";

    //OPÇÕES DE MENU
    public static final String MENU_PRINCIPAL = Constants.ANSI_PURPLE + "BANCO AT \n" + Constants.ANSI_RESET
            + Constants.ANSI_GREEN + "[1] INCLUIR CONTA\n"
            + "[2] ALTERAR SALDO\n"
            + "[3] EXCLUIR CONTA\n"
            + "[4] RELATÓRIOS GERENCIAIS\n"
            + "[5] SAIR\n" + Constants.ANSI_RESET
            + ESCOLHA;

    public static final String TIPO_DE_CONTA = Constants.ANSI_BLUE + "[1] CONTA PF\n"
            + "[2] CONTA PJ\n" + Constants.ANSI_RESET
            + "[3] VOLTAR AO MENU ANTERIOR";

    public static final String TIPO_OPERACOES_MENU = "[1] Crédito\n"
            + "[2] Débito\n";

    public static final String MENU_RELATORIO = Constants.ANSI_BLUE + "LISTAR \n" + Constants.ANSI_RESET
            + Constants.ANSI_GREEN + "[1] CLIENTES COM SALDO NEGATIVO\n"
            + "[2] CLIENTES COM SALDO ACIMA DE 1000\n"
            + "[3] CONTAS SEPARADAS POR TIPO\n"
            + "[4] OPERAÇOES REALIZADAS EM DETERMINADA CONTA\n"+ Constants.ANSI_RESET
            + "[5] VOLTAR AO MENU ANTERIOR";
}

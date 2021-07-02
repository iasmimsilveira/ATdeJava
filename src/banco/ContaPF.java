package banco;

public class ContaPF extends Conta {
    private String cpf;
    private double chequeEspecial;

    public ContaPF(){}

    public ContaPF(String nome, int numConta, double saldo, String cpf, double chequeEspecial) {
        super(nome, numConta, saldo);
        this.cpf = cpf;
        this.chequeEspecial = chequeEspecial;
    }
    public String getCpf(String cpf) {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Cheque especial: ").append(chequeEspecial).append("\n");
        return super.toString() + sb.toString();
    }
}


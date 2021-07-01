package banco;

public class ContaPJ extends Conta{
    private String cnpj;

    public ContaPJ() {
    }

    public ContaPJ(String nome, int numConta,double saldo, String cnpj) {
        super(nome, numConta, saldo);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cnpj: ").append(cnpj).append("\n");
        return super.toString() + sb.toString();
    }

    @Override
    public void add(Operacao operacao) {

    }
}



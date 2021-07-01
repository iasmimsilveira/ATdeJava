package banco;

public class Operacao  {
    private String tipoDeOperacao;
    private String dataDaOperacao;
    private double valorDaOperacao;

    public Operacao() {
    }

    public Operacao( String tipoDeOperacao, String dataDaOperacao, double valorDaOperacao) {
        this.tipoDeOperacao = tipoDeOperacao;
        this.dataDaOperacao = dataDaOperacao;
        this.valorDaOperacao = valorDaOperacao;
    }

    public void setTipoDeOperacao(String tipoDeOperacao) {
        this.tipoDeOperacao = tipoDeOperacao;
    }

    public String getTipoDeOperacao() {
        return tipoDeOperacao;
    }

    public void setDataDaOperacao(String dataDaOperacao) {
        this.dataDaOperacao = dataDaOperacao;
    }

    public String getDataDaOperacao() {
        return dataDaOperacao;
    }

    public void setValorDaOperacao(double valorDaOperacao) {
        this.valorDaOperacao = valorDaOperacao;
    }

    public double getValorDaOperacao() {
        return valorDaOperacao;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("TIPO DE OPERAÇÃO: ").append(tipoDeOperacao).append("\n");;
        sb.append("DATA DA OPERAÇÃO: ").append(dataDaOperacao).append("\n");;
        sb.append("VALOR: ").append(valorDaOperacao).append("\n");;
        return sb.toString();
    }

}

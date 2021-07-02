package banco;

import java.util.ArrayList;

public class Conta {
    private String nome;
    private int numConta;
    private double saldo;
    private ArrayList<Operacao> operacoes;

    public Conta(){
        this.operacoes = new ArrayList<Operacao>();
    }

    public Conta(String nome, int numConta, double saldo) {
        this.nome = nome;
        this.numConta = numConta;
        this.saldo = saldo;
        this.operacoes = new ArrayList<Operacao>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(ArrayList<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NOME: ").append(nome).append("\n");
        sb.append("NÚMERO DA CONTA: ").append(numConta).append("\n");
        sb.append("SALDO: ").append(saldo).append("\n");
        return sb.toString()+ sb.toString();
    }
}

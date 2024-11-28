package exercicios;

import java.util.ArrayList;

public class Conta {
	private String numeroConta;
	private String agencia;
	private String nomeCliente;
	private String dataNascimento;
    private double saldo;
    private boolean ativa;

    public Conta(String conta, String agencia, String nome, String nascimento, double saldo){
        this.numeroConta = conta;
        this.agencia = agencia;
        this.nomeCliente = nome;
        this.dataNascimento = nascimento;
        this.saldo = saldo;
        this.ativa = true;
    }
    
    public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void sacar(double valor){
        if(valor > this.saldo || this.saldo == 0){
            System.out.println("Saldo insuficiente");
        }else{
            this.saldo -= valor;
            System.out.println("Saque efetuado!");
        }
    }

    public void consultarSaldo(){
        System.out.println("O seu saldo atual é " + this.saldo);
    }

    public void transferir(Conta alvo, double valor){
        if(this.saldo >= 0 && this.saldo >= valor){
            this.saldo -= valor;
            alvo.saldo += valor;
            System.out.println("Transferência efetuada!");
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void fecharConta(String justificativa){
        System.out.println("Motivo do cancelamento da conta: " + justificativa);
        this.ativa = false;
    }
    
    public ArrayList<String> consutarExtrato() {
    	return null;
    }
}

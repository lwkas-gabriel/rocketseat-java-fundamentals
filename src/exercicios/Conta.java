package exercicios;

public class Conta {
    public String numeroConta;
    public String agencia;
    public String nomeCliente;
    public String dataNascimento;
    public double Saldo;

    public Conta(String conta, String agencia, String nome, String nascimento, double saldo){
        this.numeroConta = conta;
        this.agencia = agencia;
        this.nomeCliente = nome;
        this.dataNascimento = nascimento;
        this.Saldo = saldo;
    }

    public void Sacar(double valor){
        if(valor > this.Saldo){
            System.out.println("Saldo insuficiente");
        }else{
            this.Saldo -= valor;
            System.out.println("Saque efetuado!");
        }
    }

    public void ConsultarSaldo(){
        System.out.println("O seu saldo atual é " + this.Saldo);
    }

    public void Transferir(Conta alvo, double valor){
        if(this.Saldo >= 0 && this.Saldo >= valor){
            this.Saldo -= valor;
            alvo.Saldo += valor;
            System.out.println("Transferência efetuada!");
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void FecharConta(String justificativa){
        System.out.println("Motivo do cancelamento da conta: " + justificativa);
    }
}

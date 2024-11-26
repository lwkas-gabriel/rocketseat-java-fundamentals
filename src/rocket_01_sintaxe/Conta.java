package rocket_01_sintaxe;

public class Conta {

    double saldo = 10.0;

    public void sacar(Double valor){
        saldo = saldo - valor;
    }

    public void imprimirSaldo(){
        System.out.println(saldo);
    }
}

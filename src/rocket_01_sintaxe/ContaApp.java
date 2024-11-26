package rocket_01_sintaxe;

public class ContaApp {

    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.sacar(5.0);
        conta.imprimirSaldo();
    }
}

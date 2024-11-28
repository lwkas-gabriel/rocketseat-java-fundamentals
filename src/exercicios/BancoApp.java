package exercicios;

public class BancoApp {
    public static void main(String[] args) {
        Conta conta1 = new Conta("1000", "1", "teste1", "12/11/1992", 1000);
        Conta conta2 = new Conta("1001", "1", "teste2", "12/11/1993", 400);

        conta1.Sacar(100);
        conta1.ConsultarSaldo();

        conta2.Sacar(100);
        conta2.ConsultarSaldo();

        conta1.Transferir(conta2, 1000);
        conta1.Transferir(conta2, 600);

        conta1.ConsultarSaldo();
        conta2.ConsultarSaldo();
    }
}

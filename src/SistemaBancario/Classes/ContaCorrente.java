package SistemaBancario.Classes;

public class ContaCorrente extends Conta {

    public ContaCorrente(int id, String idUsuario) {
        super(id, idUsuario);
    }

    @Override
    public void sacar(double valor) {
        double valorFinal = valor;
        if (valor > getSaldo()) {
            System.out.println("Saldo Insuficiente");
            return;
        }
        setSaldo(getSaldo() - valorFinal);
        System.out.println("Saque realizado com sucesso.");
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito realizado com sucesso.");
    }

    @Override
    public void transferir(double valor, String usuarioDestino) {
        if (valor > getSaldo()) {
            System.out.println("Saldo Insuficiente");
            return;
        }
        setSaldo(getSaldo() - valor);
        System.out.println("Transferência realizada com sucesso.");
    }

    @Override
    public void investir(double valor) {

    }

    @Override
    public double consultarSaldo() {
        return getSaldo();
    }
}


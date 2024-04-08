package SistemaBancario.Classes;

public class ContaInvestimento extends Conta {
    private double rendimentoMensal;

    public ContaInvestimento(int id, String idUsuario, double rendimentoMensal) {
        super(id, idUsuario);
        this.rendimentoMensal = rendimentoMensal;
    }

    @Override
    public void sacar(double valor) {
        if (valor > getSaldo()) {
            System.out.println("Saldo Insuficiente");
            return;
        }
        setSaldo(getSaldo() - valor);
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
        System.out.println("Não é possível fazer investimento em conta investimento.");
    }

    @Override
    public double consultarSaldo() {
        return getSaldo();
    }

    public void calcularRendimento() {
        double rendimento = getSaldo() * rendimentoMensal;
        setSaldo(getSaldo() + rendimento);
    }
}


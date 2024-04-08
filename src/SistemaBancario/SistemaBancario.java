package SistemaBancario;

import SistemaBancario.Classes.Cliente;
import SistemaBancario.Classes.ContaCorrente;
import SistemaBancario.Classes.ContaPoupanca;

import java.util.Scanner;

import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar;

        do {
            System.out.print("Informe o CPF/CNPJ do cliente: ");
            String id = scanner.next();

            System.out.print("Informe a classificação do cliente (PF/PJ): ");
            String classificacao = scanner.next();

            System.out.print("Informe o nome do cliente: ");
            String nome = scanner.next();

            Cliente cliente = new Cliente(id, classificacao, nome);

            ContaCorrente contaCorrente = new ContaCorrente(1, cliente.getId());
            System.out.println("Conta Corrente criada com sucesso. ID da Conta Corrente: " + contaCorrente.getId());

            if (cliente.getClassificacao().equalsIgnoreCase("PF")) {
                System.out.print("Deseja criar uma conta poupança? (S/N): ");
                String resposta = scanner.next();

                if (resposta.equalsIgnoreCase("S")) {
                    ContaPoupanca contaPoupanca = new ContaPoupanca(2, cliente.getId());
                    System.out.println("Conta Poupança criada com sucesso. ID da Conta Poupança: " + contaPoupanca.getId());
                }
            }

            do {
                System.out.println("Menu de Operações:");
                System.out.println("1. Saldo");
                System.out.println("2. Saque");
                System.out.println("3. Depósito");
                System.out.println("4. Transferência");
                if (!cliente.getClassificacao().equalsIgnoreCase("PF")) {
                    System.out.println("5. Investimento");
                }
                System.out.print("Escolha a operação: ");
                int opcaoOperacao = scanner.nextInt();

                switch (opcaoOperacao) {
                    case 1:
                        System.out.println("Saldo: " + contaCorrente.consultarSaldo());
                        break;
                    case 2:
                        System.out.print("Valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        contaCorrente.sacar(valorSaque);
                        break;
                    case 3:
                        System.out.print("Valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        contaCorrente.depositar(valorDeposito);
                        break;
                    case 4:
                        System.out.print("Valor da transferência: ");
                        double valorTransferencia = scanner.nextDouble();
                        System.out.print("ID do destinatário: ");
                        String idDestinatario = scanner.next();

                        break;
                    case 5:
                        if (!cliente.getClassificacao().equalsIgnoreCase("PF")) {
                            System.out.print("Valor do investimento: ");
                            double valorInvestimento = scanner.nextDouble();

                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                System.out.print("Deseja realizar outra operação? (S/N): ");
                String resposta = scanner.next();
                continuar = resposta.equalsIgnoreCase("S");
            } while (continuar);

            System.out.print("Deseja voltar para o menu de clientes? (S/N): ");
            String resposta = scanner.next();
            continuar = resposta.equalsIgnoreCase("S");
        } while (continuar);

        System.out.println("Até a próxima!");
        scanner.close();
    }
}
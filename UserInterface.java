import java.util.InputMismatchException;
import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        double deposito;
        int retornoMenu;
        do {
            System.out.println("Digite o valor do deposito para ativar sua conta: ");
            try {
                deposito = scanner.nextDouble();  
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números.");
                scanner.next();
                deposito = 0.0;
            }
        } while (deposito <= 0);
        Account conta = new Account(deposito);
        System.out.println("Conta criada com sucesso.");
        do {
            System.out.println("Consultar saldo - 1");
            System.out.println("Consultar cheque especial - 2");
            System.out.println("Deposito - 3");
            System.out.println("Saque - 4");
            System.out.println("Pagar boleto - 5");
            System.out.println("Status cheque especial - 6");
            System.out.println("Encerrar - 7");
            try {
                retornoMenu = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                retornoMenu = 0;
            }
            switch (retornoMenu) {
                case 1:
                    System.out.printf("O saldo disponivel é de R$ %.2f%n.", conta.getSaldo());
                    break;
                case 2:
                    System.out.printf("O cheque especial disponivel é de R$ %.2f%n.", conta.getChequeEspecial());
                    break;
                case 3:
                    System.out.println("Digite o valor do deposito: ");
                    try {
                        conta.depositar(scanner.nextDouble());
                    } catch (InputMismatchException e) {
                        System.out.println("Digite apenas números.");
                        scanner.next();
                    }
                    break;
                case 4:
                    System.out.println("Digite o valor do saque: ");
                    try {
                        conta.transacao(scanner.nextDouble());
                    } catch (InputMismatchException e) {
                        System.out.println("Digite apenas números.");
                        scanner.next();
                    }
                    break;
                case 5:
                    System.out.println("Digite o valor do pagamento: ");
                    try {
                        conta.transacao(scanner.nextDouble());
                    } catch (InputMismatchException e) {
                        System.out.println("Digite apenas números.");
                        scanner.next();
                    }
                    break;
                case 6:
                    conta.statusCheque();
                    break;
                case 7:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (retornoMenu != 7);
    }
}

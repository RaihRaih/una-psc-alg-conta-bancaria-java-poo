import java.util.Scanner;

public class ContaBancaria {
  private String nomePessoa;
  private String numeroConta;
  private double saldoInicial;


  public ContaBancaria(String nomePessoa, String numeroConta, double saldoInicial) {
    this.nomePessoa = nomePessoa;
    this.numeroConta = numeroConta;
    this.saldoInicial = saldoInicial;
  }

  public void depositar(double valor) {
    this.saldoInicial += valor;
  }

  public void sacar(double valor) {
    if (valor > saldoInicial) {
      System.out.println("Saldo insuficiente para realizar a operação.");

    } else if (valor > 5000) {
      System.out.println("Valor do saque acima do permitido.");
    } else {
      this.saldoInicial -= valor;
    }
  }

  public void obterSaldo() {
    System.out.println("Saldo disponível: R$ " + saldoInicial);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Informe o nome da pessoa: ");
    String nomePessoa = scanner.nextLine();

    System.out.print("Informe o número da conta: ");
    String numeroConta = scanner.nextLine();

    System.out.print("Informe o saldo inicial: R$");
    double saldoInicial = scanner.nextDouble();

    // Criando a conta bancária
    ContaBancaria conta = new ContaBancaria(nomePessoa, numeroConta, saldoInicial);

    System.out.println("Conta bancária criada com sucesso.");

    // menu de opcao
    int opcao;
    do {
      System.out.println("\nEscolha uma opção:");
      System.out.println("1. Depositar valor");
      System.out.println("2. Sacar valor");
      System.out.println("3. Obter saldo disponível");
      System.out.println("4. Sair");

      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.print("Digite o valor a ser depositado: ");
          double valorDeposito = scanner.nextDouble();
          conta.depositar(valorDeposito);
          break;
        case 2:
          System.out.print("Digite o valor a ser sacado: ");
          double valorSaque = scanner.nextDouble();
          conta.sacar(valorSaque);
          break;
        case 3:
          conta.obterSaldo();
          break;
        case 4:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
          break;
      }
    } while (opcao != 4);

    scanner.close();
  }
}
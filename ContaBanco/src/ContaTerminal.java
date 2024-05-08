import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        int numeroConta;
        String agencia, nomeCliente;
        Double saldo;

        System.out.println("Por favor, digite o numero da conta : ");
        numeroConta = leitor.nextInt();
        System.out.println("Agora, digite o numero da conta : ");
        agencia = leitor.next();
        System.out.println("Me diz seu nome completo: ");
        nomeCliente = leitor.next();
        System.out.println("Por fim, digite o saldo que possui ! ");
        saldo = leitor.nextDouble();

        leitor.close();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque", nomeCliente,agencia,numeroConta,saldo);
    }
}

import java.util.Scanner;

public class CadastroNovo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Pessoa p = new Pessoa();
        int ano = 2025;

        System.out.print("Digite seu nome: ");
        p.nome = entrada.nextLine();

        System.out.print("Digite seu sobrenome: ");
        p.sobrenome = entrada.nextLine();

        System.out.print("Digite seu CPF: ");
        p.cpf = entrada.nextLine();

        System.out.print("Digite seu endereço: ");
        p.endereco = entrada.nextLine();

        System.out.print("Digite seu ano de nascimento: ");
        p.anoNascimento = Integer.parseInt(entrada.nextLine());

        int idade = p.calcularIdade(ano);

        System.out.println("\nResumo dos dados informados:");
        System.out.println("Nome completo: " + p.nome + " " + p.sobrenome);
        System.out.println("CPF: " + p.cpf);
        System.out.println("Endereço: " + p.endereco);
        System.out.println("Idade em " + ano + ": " + idade + " anos");

        PessoaDAO dao = new PessoaDAO();
        dao.salvarPessoa(p);
    }
}

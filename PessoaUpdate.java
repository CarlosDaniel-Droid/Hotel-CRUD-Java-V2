import java.util.Scanner;

public class PessoaUpdate {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        PessoaUpdateDAO pessoaUpdateDAO = new PessoaUpdateDAO();
        Pessoa pessoa = new Pessoa();

        System.out.print("Digite o ID da pessoa a ser atualizada: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite o novo nome: ");
        pessoa.nome = entrada.nextLine();

        System.out.print("Digite o novo sobrenome: ");
        pessoa.sobrenome = entrada.nextLine();

        System.out.print("Digite o novo CPF: ");
        pessoa.cpf = entrada.nextLine();

        System.out.print("Digite o novo endereço: ");
        pessoa.endereco = entrada.nextLine();

        System.out.print("Digite o novo ano de nascimento: ");
        pessoa.anoNascimento = Integer.parseInt(entrada.nextLine());

        pessoaUpdateDAO.atualizarPessoa(id, pessoa);
    }
}
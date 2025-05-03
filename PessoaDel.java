import java.util.Scanner;

public class PessoaDel {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        PessoaDeleteDAO pessoaDeleteDAO = new PessoaDeleteDAO();

        System.out.print("Digite o ID da pessoa a ser deletada: ");
        int id = entrada.nextInt();

        pessoaDeleteDAO.deletarPessoa(id);
    }
}
import java.util.Scanner;

public class QuartoDel {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        QuartoDeleteDAO quartoDeleteDAO = new QuartoDeleteDAO();

        System.out.print("Digite o ID do quarto a ser deletado: ");
        int id = entrada.nextInt();

        quartoDeleteDAO.deletarQuarto(id);
    }
}
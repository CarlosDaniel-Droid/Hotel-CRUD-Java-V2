import java.util.Scanner;

public class QuartoUpdate {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        QuartoUpdateDAO quartoUpdateDAO = new QuartoUpdateDAO();
        Quarto q = new Quarto();

        System.out.print("Digite o ID do quarto a ser atualizado: ");
        q.id_quarto = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite o novo número do quarto: ");
        q.numero_quarto = entrada.nextInt();

        quartoUpdateDAO.atualizarQuarto(q);
    }
}
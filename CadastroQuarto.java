import java.util.Scanner;

public class CadastroQuarto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Quarto q = new Quarto();

        System.out.print("Digite ID do quarto: ");
        q.id_quarto = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite numero do quarto: ");
        q.numero_quarto = entrada.nextInt();
        entrada.nextLine();
        
        System.out.println("ID:" + q.id_quarto);
        System.out.println("Número: " + q.numero_quarto);

        QuartoDAO qd = new QuartoDAO();
        qd.salvarQuarto(q);
    }
}
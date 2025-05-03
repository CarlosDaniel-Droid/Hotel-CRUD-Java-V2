import java.util.Scanner;

public class ReservaDel {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ReservaDeleteDAO reservaDeleteDAO = new ReservaDeleteDAO();

        System.out.print("Digite o ID da reserva a ser deletada: ");
        int id = entrada.nextInt();

        reservaDeleteDAO.deletarReserva(id);
    }
}
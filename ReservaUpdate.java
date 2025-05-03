import java.util.Scanner;

public class ReservaUpdate {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ReservaUpdateDAO reservaUpdateDAO = new ReservaUpdateDAO();
        Reserva r = new Reserva();

        System.out.print("Digite o ID da reserva a ser atualizada: ");
        r.idres = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite a data inicial da reserva: ");
        r.data_ini = entrada.nextLine();

        System.out.print("Digite a data final da reserva: ");
        r.data_fim = entrada.nextLine();

        reservaUpdateDAO.atualizarReserva(r);
    }
}
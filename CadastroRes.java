import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroRes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o ID da reserva: ");
        int idReserva = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite a data de início da reserva (DIA/MÊS/ANO): ");
        String dataInicio = entrada.nextLine();

        System.out.print("Digite a data de fim da reserva (DIA/MÊS/ANO): ");
        String dataFim = entrada.nextLine();

        System.out.print("Digite o ID da pessoa: ");
        int idPessoa = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite o ID do quarto: ");
        int idQuarto = entrada.nextInt();
        entrada.nextLine();

        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound",
                "venomsnake",
                "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE"
            );

            String sql = "INSERT INTO reserva (id_res, data_ini, data_fim, id_pessoa, id_quarto) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idReserva);
            stmt.setString(2, dataInicio);
            stmt.setString(3, dataFim);
            stmt.setInt(4, idPessoa);
            stmt.setInt(5, idQuarto);

            stmt.executeUpdate();
            System.out.println("Reserva salva com sucesso!");

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar a reserva: " + e.getMessage());
        }
    }
}
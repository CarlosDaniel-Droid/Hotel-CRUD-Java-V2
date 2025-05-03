import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ConsultaRel {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound",
                "venomsnake",
                "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE"
            );

            String sql = "SELECT " +
                         "    r.id_res AS id_reserva, " +
                         "    r.data_ini AS data_inicio_reserva, " +
                         "    r.data_fim AS data_fim_reserva, " +
                         "    q.numero_quarto AS numero_quarto, " +
                         "    p.nome AS nome_pessoa, " +
                         "    p.cpf AS cpf_pessoa " +
                         "FROM reserva r " +
                         "JOIN quarto q ON r.id_quarto = q.id_quarto " +
                         "JOIN pessoa p ON r.id_pessoa = p.id";

            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Dados Detalhados da Reserva:");
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s | %-12s | %-12s | %-13s | %-20s | %-15s%n",
                            "ID Reserva", "Data Início", "Data Fim", "Número Quarto", "Nome Pessoa", "CPF Pessoa");
            System.out.println("--------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                int idReserva = rs.getInt("id_reserva");
                String dataInicioReserva = rs.getString("data_inicio_reserva");
                String dataFimReserva = rs.getString("data_fim_reserva");
                int numeroQuarto = rs.getInt("numero_quarto");
                String nomePessoa = rs.getString("nome_pessoa");
                String cpfPessoa = rs.getString("cpf_pessoa");

                System.out.printf("%-10d | %-12s | %-12s | %-13d | %-20s | %-15s%n",
                                  idReserva, dataInicioReserva, dataFimReserva, numeroQuarto, nomePessoa, cpfPessoa);
            }

            System.out.println("--------------------------------------------------------------------------------------------------");


            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
    }
}
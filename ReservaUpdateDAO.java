import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaUpdateDAO {

    private static final String URL = "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound";
    private static final String USUARIO = "venomsnake";
    private static final String SENHA = "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE";

    public void atualizarReserva(Reserva r) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "UPDATE reserva SET data_ini = ?, data_fim = ? WHERE id_res = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, r.data_ini);
                stmt.setString(1, r.data_fim);
                stmt.setInt(2, r.idres);
                stmt.executeUpdate();
                System.out.println("Reserva atualizada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
}
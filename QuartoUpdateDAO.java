import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuartoUpdateDAO {

    private static final String URL = "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound";
    private static final String USUARIO = "venomsnake";
    private static final String SENHA = "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE";

    public void atualizarQuarto(Quarto q) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "UPDATE quarto SET numero_quarto = ? WHERE id_quarto = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, q.numero_quarto);
                stmt.setInt(3, q.id_quarto);
                stmt.executeUpdate();
                System.out.println("Quarto atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
}
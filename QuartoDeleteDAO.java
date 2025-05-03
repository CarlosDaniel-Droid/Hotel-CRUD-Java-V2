import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuartoDeleteDAO {

    private static final String URL = "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound";
    private static final String USUARIO = "venomsnake";
    private static final String SENHA = "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE";

    public void deletarQuarto(int idQuarto) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "DELETE FROM quarto WHERE id_quarto = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, idQuarto);
                stmt.executeUpdate();
                System.out.println("Quarto deletado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
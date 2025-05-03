import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuartoDAO {

    public void salvarQuarto(Quarto q) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound",
                "venomsnake",
                "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE"
            );

            String sqlVeri = "SELECT COUNT(*) FROM quarto WHERE id_quarto = ?";
            PreparedStatement stmtVerificar = conexao.prepareStatement(sqlVeri);
            stmtVerificar.setInt(1, q.id_quarto);
            ResultSet rs = stmtVerificar.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                System.out.println("Quarto já reservado!");
            } else {
                String sqlq = "INSERT INTO quarto (id_quarto, numero_quarto) VALUES (?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sqlq);
                stmt.setInt(1, q.id_quarto);
                stmt.setInt(2, q.numero_quarto);

                stmt.executeUpdate();
                System.out.println("Quarto reservado com sucesso!");
                stmt.close();
            }

            stmtVerificar.close();
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
}
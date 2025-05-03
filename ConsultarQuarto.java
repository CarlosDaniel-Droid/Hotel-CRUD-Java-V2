import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ConsultarQuarto {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound",
                "venomsnake",
                "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE"
            );

            String sqlq = "SELECT * FROM quarto";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sqlq);

            System.out.println("Dados da tabela quarto:");
            while (rs.next()) {
                int id = rs.getInt("id_quarto");
                int nq = rs.getInt("numero_quarto");

                System.out.println("ID:" + id + "|numero:" + nq);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
    }
}
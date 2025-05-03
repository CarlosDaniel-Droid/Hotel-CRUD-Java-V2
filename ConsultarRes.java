import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ConsultarRes {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound",
                "venomsnake",
                "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE"
            );

            String sqlr = "SELECT * FROM reserva";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sqlr);

            System.out.println("Dados da tabela reserva:");
            while (rs.next()) {
                int id = rs.getInt("id_res");
                String dti = rs.getString("data_ini");
                String dtf = rs.getString("data_fim");

                System.out.println("ID:" + id + "|data de início:" + dti + "|data de encerramento:" + dtf);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
    }
}
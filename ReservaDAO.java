import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {

    public void salvarReserva(Reserva r) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound",
                "venomsnake",
                "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE"
            );

            String sqlr = "INSERT INTO reserva (id_res, data_ini, data_fim) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sqlr);
            stmt.setInt(1, r.idres);
            stmt.setString(2, r.data_ini);
            stmt.setString(3, r.data_fim);

            stmt.executeUpdate();
            System.out.println("Reserva salva com sucesso!");

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaUpdateDAO {

    private static final String URL = "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound";
    private static final String USUARIO = "venomsnake";
    private static final String SENHA = "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE";

    public void atualizarPessoa(int id, Pessoa p) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "UPDATE pessoa SET nome = ?, sobrenome = ?, cpf = ?, endereco = ?, ano_nascimento = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, p.nome);
                stmt.setString(2, p.sobrenome);
                stmt.setString(3, p.cpf);
                stmt.setString(4, p.endereco);
                stmt.setInt(5, p.anoNascimento);
                stmt.setInt(6, id);
                stmt.executeUpdate();
                System.out.println("Pessoa atualizada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
}
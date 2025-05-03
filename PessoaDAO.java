import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PessoaDAO {

    public void salvarPessoa(Pessoa p) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound",
                "venomsnake",
                "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE"
            );

            String sql = "INSERT INTO pessoa (nome, sobrenome, cpf, endereco, ano_nascimento) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p.nome);
            stmt.setString(2, p.sobrenome);
            stmt.setString(3, p.cpf);
            stmt.setString(4, p.endereco);
            stmt.setInt(5, p.anoNascimento);

            stmt.executeUpdate();
            System.out.println("Pessoa salva com sucesso!");

            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
}

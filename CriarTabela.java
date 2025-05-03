import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CriarTabela {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://dpg-cvrbs3euk2gs73fbl3k0-a.oregon-postgres.render.com/foxhound",
                "venomsnake",
                "TSjzLzfY7ShWjwasN95N4vXdyDMQuqrE"
            );

            Statement stmt = conexao.createStatement();

            String sqlpessoa = "CREATE TABLE IF NOT EXISTS pessoa (" +
                                "id SERIAL PRIMARY KEY," +
                                "nome VARCHAR(100)," +
                                "sobrenome VARCHAR(100)," +
                                "cpf VARCHAR(20)," +
                                "endereco VARCHAR(150)," +
                                "ano_nascimento INT" +
                                ");";

            stmt.executeUpdate(sqlpessoa);
            System.out.println("Tabela 'pessoa' criada com sucesso!");

            String sqlquarto = "CREATE TABLE IF NOT EXISTS quarto(" +
                                "id_quarto INT PRIMARY KEY," +
                                "numero_quarto INT" +
                                ");";

            stmt.executeUpdate(sqlquarto);
            System.out.println("Tabela 'quarto' criada com sucesso!");

            String sqlres = "CREATE TABLE IF NOT EXISTS reserva(" +
                                "id_res INT PRIMARY KEY," +
                                "data_ini varchar(10)," +
                                "data_fim varchar(10)," +
                                "id_pessoa INT," +
                                "id_quarto INT," +
                                "FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)," +
                                "FOREIGN KEY (id_quarto) REFERENCES quarto(id_quarto)" +
                                ");";

            stmt.executeUpdate(sqlres);
            System.out.println("Tabela 'reserva' criada com sucesso!");

            
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
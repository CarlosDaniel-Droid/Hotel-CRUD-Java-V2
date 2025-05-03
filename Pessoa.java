public class Pessoa {
    String nome;
    String sobrenome;
    String cpf;
    String endereco;
    int anoNascimento;

    int calcularIdade(int anoAtual) {
        return anoAtual - anoNascimento;
    }
}

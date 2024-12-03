package rocket_03_java_beans;

public class Aluno {
    private String nome;
    private int idade = 0;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        if(idade < 0){
            throw new IllegalArgumentException("Valor da idade é não pode ser menor que zero");
        }
        this.idade = idade;
    }
}

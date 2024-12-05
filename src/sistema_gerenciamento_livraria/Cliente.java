package sistema_gerenciamento_livraria;

import java.time.LocalDate;
import java.util.Random;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public Cliente(String nome, String email, String dataNascimento) {
        this.id = new Random().nextInt(Integer.MAX_VALUE);
        this.nome = nome;
        this.email = email;
        this.dataNascimento = LocalDate.parse(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }
}

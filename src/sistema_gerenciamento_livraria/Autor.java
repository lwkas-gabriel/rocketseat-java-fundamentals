package sistema_gerenciamento_livraria;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(String nome, String dataNascimento, String data) {
        this.id = new Random().nextInt(Integer.MAX_VALUE);
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

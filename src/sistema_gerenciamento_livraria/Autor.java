package sistema_gerenciamento_livraria;

import java.util.Date;

public class Autor {
    private int id;
    private String nome;
    private Date dataNascimento;

    public Autor(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
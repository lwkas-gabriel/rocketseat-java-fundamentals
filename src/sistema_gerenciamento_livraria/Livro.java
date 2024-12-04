package sistema_gerenciamento_livraria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean isDisponivel;
    private LocalDate dataCadastro;
    private LocalDateTime dataAtualizacao;

    public Livro(String titulo, String autor){
        this.id = new Random().nextInt(Integer.MAX_VALUE);
        this.titulo = titulo;
        this.autor = autor;
        this.isDisponivel = true; // se true = disponivel, se false = não disponível
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public int getId(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public boolean getIsDisonivel(){
        return this.isDisponivel;
    }

    public void setIsDisponivel(){
        this.isDisponivel = !this.isDisponivel;
    }

    public LocalDate getDataCadastro(){
        return this.dataCadastro;
    }

    public void setDataAtualizacao(){
        this.dataAtualizacao = LocalDateTime.now();

    }

    public LocalDateTime getDataAtualizacao(){
        return this.dataAtualizacao;
    }
}

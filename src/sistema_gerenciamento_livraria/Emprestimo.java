package sistema_gerenciamento_livraria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Emprestimo {
    private Livro livroEmprestado;
    private Cliente cliente;
    private LocalDateTime horarioEmprestimo;
    private LocalDateTime horarioDevolucao;
    private boolean isDevolvido;

    public Emprestimo(Livro livro, Cliente cliente){
        this.cliente = cliente;
        this.livroEmprestado = livro;
        this.horarioEmprestimo = LocalDateTime.now();
        this.horarioDevolucao = null;
        this.isDevolvido = false; // se true, devolvido, se false, não
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public String getHorarioEmprestimo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dataFormatada = horarioEmprestimo.format(formatter);
        return dataFormatada;
    }

    public boolean isDevolvido() {
        return isDevolvido;
    }

    public void setLivroEmprestado(Livro livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }

    public void setDevolvido() {
        this.isDevolvido = !isDevolvido;
    }

    public String getHorarioDevolucao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dataFormatada = horarioDevolucao.format(formatter);
        return dataFormatada;
    }

    public void setHorarioDevolucao() {
        this.horarioDevolucao = LocalDateTime.now();
    }
}

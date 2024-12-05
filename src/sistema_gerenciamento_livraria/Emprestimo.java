package sistema_gerenciamento_livraria;

import java.time.LocalDateTime;
import java.util.Date;

public class Emprestimo {
    private Livro livroEmprestado;
    private Cliente cliente;
    private LocalDateTime horarioEmprestimo;
    private LocalDateTime horarioDevolucao;
    private boolean isDevolvido;

    public Emprestimo(Livro livro, Cliente cliente){
        this.livroEmprestado = livro;
        this.horarioEmprestimo = LocalDateTime.now();
        this.horarioDevolucao = null;
        this.isDevolvido = false; // se true, devolvido, se false, não
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public LocalDateTime getHorarioEmprestimo() {
        return horarioEmprestimo;
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

    public LocalDateTime getHorarioDevolucao() {
        return horarioDevolucao;
    }

    public void setHorarioDevolucao() {
        this.horarioDevolucao = LocalDateTime.now();
    }
}

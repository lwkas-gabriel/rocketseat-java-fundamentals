package sistema_gerenciamento_livraria;

import java.util.Date;

public class Emprestimo {
    private Livro livroEmprestado;
    //private Cliente cliente;
    private Date horarioEmprestimo;
    private boolean isDevolvido;

    public Emprestimo(Livro livro, Date dataEmprestimo){
        this.livroEmprestado = livro;
        this.horarioEmprestimo = dataEmprestimo;
        this.isDevolvido = false; // se true, devolvido, se false, não
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public Date getHorarioEmprestimo() {
        return horarioEmprestimo;
    }

    public boolean isDevolvido() {
        return isDevolvido;
    }

    public void setLivroEmprestado(Livro livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }

    public void setHorarioEmprestimo(Date horarioEmprestimo) {
        this.horarioEmprestimo = horarioEmprestimo;
    }

    public void setDevolvido(boolean devolvido) {
        isDevolvido = devolvido;
    }
}

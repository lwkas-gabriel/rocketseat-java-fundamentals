package sistema_gerenciamento_livraria;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void adicionarLivro(Livro novoLivro){
        this.livros.add(novoLivro);
    }

    public void listarLivrosDisponiveis(){
        for(Livro livro : this.livros){
            if(livro.getIsDisonivel()){
                System.out.println(livro.getId() + " - " + livro.getAutor() + " : " + livro.getTitulo());
            }else{
                continue;
            }
        }
    }

    public void listarEmprestimos(){
        for(Livro livro : this.livros){
            if(!livro.getIsDisonivel()){
                System.out.println(livro.getId() + " - " + livro.getAutor() + " : " + livro.getTitulo());
            }else{
                continue;
            }
        }
    }
}

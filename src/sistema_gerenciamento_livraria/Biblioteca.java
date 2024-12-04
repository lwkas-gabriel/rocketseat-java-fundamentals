package sistema_gerenciamento_livraria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                System.out.println(livro.getId() + " - " + livro.getTitulo() + " (" +livro.getAutor() + ")");
            }else{
                continue;
            }
        }
    }

    public void listarEmprestimos(){
        for(Livro livro : this.livros){
            if(!livro.getIsDisonivel()){
                System.out.println(livro.getId() + " - " + livro.getTitulo() + " (" +livro.getAutor() + ")");
            }else{
                continue;
            }
        }
    }

    public void iniciarAtendimento(){
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("Bem-vindo ao sistema!");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar livros disponíveis");
            System.out.println("3 - Fazer emprestimo!");
            menu = s.nextInt();

            switch (menu){
                case 1:
                    String nomeAutor;
                    String tituloLivro;
                    //String dataNascimento;
                    System.out.println("Inserir nome do autor:");
                    nomeAutor = s1.nextLine();
                    System.out.println("Inserir titulo do livro:");
                    tituloLivro = s1.nextLine();
                    //System.out.println("Inserir data de nascimento do autor:");
                    //dataNascimento = s.nextLine();
                    adicionarLivro(new Livro(tituloLivro, nomeAutor));
                    break;
                case 2:
                    System.out.println("Livros Disponíveis para empréstimo");
                    listarLivrosDisponiveis();
                    break;
                case 3:
                    //System.out.println("Livros Emprestados");
                    //listarEmprestimos();
                    break;
            }
        }while(menu != 0);
    }
}

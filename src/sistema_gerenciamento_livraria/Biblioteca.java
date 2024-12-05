package sistema_gerenciamento_livraria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros;
    private List<Autor> autores;
    private List<Cliente> clientes;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.autores = new ArrayList<>();
        this.emprestimos = new ArrayList<>();;
        this.livros = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

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

    public Cliente getClienteById(int codigo){
        for(Cliente cliente : this.clientes){
            if(cliente.getId() == codigo){
                return cliente;
            }
        }
        return null;
    }

    public Livro getLivroById(int codigo){
        for(Livro livro : this.livros){
            if(livro.getId() == codigo){
                return livro;
            }
        }
        return null;
    }

    public void cadastrarCliente(Cliente novoCliente){
        this.clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void adicionarLivro(Livro novoLivro){
        this.livros.add(novoLivro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void listarClientes(){
        if (this.clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado!");
        }else{
            for(Cliente cliente : this.clientes){
                System.out.println(cliente.getId() + " - " + cliente.getNome() + " (" +cliente.getEmail() + ")" + " - Data de Nascimento: " + cliente.getDataNascimento());
            }
        }
    }

    public void listarLivrosDisponiveis(){
        if (this.livros.isEmpty()){
            System.out.println("Sinto muito, mas não temos livros disponíveis para empréstimo.");
        }else{
            for(Livro livro : this.livros){
                if(livro.getIsDisonivel()){
                    System.out.println(livro.getId() + " - " + livro.getTitulo() + " (" +livro.getAutor() + ")");
                }
            }
        }
    }

    public void listarEmprestimos(){
        for(Livro livro : this.livros){
            if(!livro.getIsDisonivel()){
                System.out.println(livro.getId() + " - " + livro.getTitulo() + " (" +livro.getAutor() + ")");
            }
        }
    }

    public void emprestimoLivro(int codigo, Cliente clienteAtual, Livro livroDesejado){
        for(Livro livro : this.livros){
            if(livro.getId() == codigo){
                System.out.println("Empréstimo Efetuado!");
                livro.setIsDisponivel();
            }
        }
        Emprestimo novoEmprestimo = new Emprestimo(livroDesejado, clienteAtual);
        emprestimos.add(novoEmprestimo);
    }

    public void iniciarAtendimento(){
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("===============================");
            System.out.println("Bem-vindo ao sistema de livraria 1.0!!");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Listar livros disponíveis");
            System.out.println("4 - Fazer emprestimo!");
            System.out.println("5 - Listar Clientes!");
            System.out.println("0 - Encerrar atendimento");
            System.out.println("===============================");
            menu = s.nextInt();

            switch (menu){
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:
                    String nomeCliente;
                    String emailCliente;
                    String dataNascimentoCliente;
                    System.out.println("Inserir nome do cliente:");
                    nomeCliente = s1.nextLine();
                    System.out.println("Inserir email do cliente:");
                    emailCliente = s1.nextLine();
                    System.out.println("Inserir data de nascimento do cliente: (YYYY-MM-DD)");
                    dataNascimentoCliente = s1.nextLine();
                    cadastrarCliente(new Cliente(nomeCliente, emailCliente, dataNascimentoCliente));
                    break;
                case 2:
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
                case 3:
                    System.out.println("Livros Disponíveis para empréstimo");
                    listarLivrosDisponiveis();
                    break;
                case 4:
                    int codigoLivro;
                    int codigoCliente;
                    Cliente atual;
                    Livro desejado;
                    System.out.println("Selecione um dos livros abaixo:");
                    listarLivrosDisponiveis();
                    codigoLivro = s1.nextInt();
                    System.out.println("Inserir código do cliente::");
                    codigoCliente = s1.nextInt();
                    atual = getClienteById(codigoCliente);
                    desejado = getLivroById(codigoLivro);
                    if(atual != null && desejado != null){
                        emprestimoLivro(codigoLivro, atual, desejado);
                    }else{
                        System.out.println("Código(s) inválido(s), verifique e  digite novamente!");
                    }
                    break;
                case 5:
                    System.out.println("Listagem de clientes cadastrados:");
                    listarClientes();
                    break;
                default:
                    System.out.println("Erro! Digite uma operação válida!");
            }
        }while(menu != 0);
    }
}

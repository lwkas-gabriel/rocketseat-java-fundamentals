package sistema_gerenciamento_livraria;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        if(this.emprestimos.isEmpty()){
            System.out.println("Sinto muito, mas ainda não fizemos nenhum empréstimo hoje!.");
        }else{
            for(Emprestimo emprestimo : this.emprestimos){
                System.out.println("============");
                System.out.println("Empréstimo efetuado por:  " + emprestimo.getCliente().getNome());
                System.out.println("Nome do Livro: " + emprestimo.getLivroEmprestado().getTitulo());
                System.out.println("Autor: "  + emprestimo.getLivroEmprestado().getAutor());
                System.out.println("Data do Empréstimo: " + emprestimo.getHorarioEmprestimo());
                System.out.println("Devolvido? " + ((emprestimo.isDevolvido()) ? "Sim." : "Não.") );
                System.out.println("Data da devolução: " + ((emprestimo.isDevolvido()) ? emprestimo.getHorarioDevolucao() : "N/A") );
                System.out.println("============");
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

    public void getLivrosEmprestadosByClienteId(){

    }

    public void devolverLivro(int codigoCliente){
        if (this.emprestimos.isEmpty()){
            System.out.println("Nenhum livro emprestrado!");
        }else{
            for(Emprestimo emprestimo : this.emprestimos){
                if(emprestimo.getCliente().getId() == codigoCliente){
                    int codigoLivro = emprestimo.getLivroEmprestado().getId();
                    emprestimo.setDevolvido();
                    emprestimo.setHorarioDevolucao();
                    for (Livro livro : this.livros){
                        if(livro.getId() == codigoLivro){
                            livro.setIsDisponivel();
                        }
                    }
                    System.out.println("Devolução efetuada!");
                }
            }
        }
    }

    public void getLivrosByAutor(String nomeAutor){
        if(livros.isEmpty()){
            System.out.println("Nenhum livro cadastrado na base de dados!");
        }else{
            for (Livro livro : this.livros){
                if(livro.getAutor().toLowerCase().contains(nomeAutor)){
                    System.out.println("Nome do Livro: " + livro.getTitulo());
                    System.out.println("Autor: "  + livro.getAutor());
                }
            }
        }
    }

    public void getLivrosByTitulo(String tituloLivro){
        if(livros.isEmpty()){
            System.out.println("Nenhum livro cadastrado na base de dados!");
        }else{
            for (Livro livro : this.livros){
                if(livro.getTitulo().toLowerCase().contains(tituloLivro)){
                    System.out.println("Nome do Livro: " + livro.getTitulo());
                    System.out.println("Autor: "  + livro.getAutor());
                }
            }
        }
    }

    public void imprimirMenu(){
        System.out.println("===============================");
        System.out.println("Bem-vindo ao sistema de livraria 1.0!!");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Livro");
        System.out.println("3 - Buscar livro por autor");
        System.out.println("4 - Buscar livro por titulo");
        System.out.println("5 - Listar livros disponíveis");
        System.out.println("6 - Fazer emprestimo!");
        System.out.println("7 - Listar Clientes!");
        System.out.println("8 - Exibir histórico de emprestimos");
        System.out.println("9 - Efetuar devolução");
        System.out.println("0 - Encerrar atendimento");
        System.out.println("===============================");
    }

    public void iniciarAtendimento(){
        int codigoLivro;
        int codigoCliente;
        String nomeCliente;
        String emailCliente;
        String dataNascimentoCliente;

        int menu = 999999;
        do {
            try{
                Scanner s = new Scanner(System.in);
                Scanner s1 = new Scanner(System.in);
                String nomeAutor;
                String tituloLivro;
                imprimirMenu();
                menu = s.nextInt();
                switch (menu){
                    case 0:
                        System.out.println("Encerrando...");
                        break;
                    case 1:
                        System.out.println("Inserir nome do cliente:");
                        nomeCliente = s1.nextLine();
                        System.out.println("Inserir email do cliente:");
                        emailCliente = s1.nextLine();
                        System.out.println("Inserir data de nascimento do cliente: (YYYY-MM-DD)");
                        dataNascimentoCliente = s1.nextLine();
                        cadastrarCliente(new Cliente(nomeCliente, emailCliente, dataNascimentoCliente));
                        break;
                    case 2:
                        System.out.println("Inserir nome do autor:");
                        nomeAutor = s1.nextLine();
                        System.out.println("Inserir titulo do livro:");
                        tituloLivro = s1.nextLine();
                        adicionarLivro(new Livro(tituloLivro, nomeAutor));
                        break;
                    case 3:
                        System.out.println("Inserir nome do autor:");
                        nomeAutor = s1.nextLine();
                        getLivrosByAutor(nomeAutor);
                        break;
                    case 4:
                        System.out.println("Inserir titulo do livro:");
                        tituloLivro = s1.nextLine();
                        getLivrosByTitulo(tituloLivro);
                        break;
                    case 5:
                        System.out.println("Livros Disponíveis para empréstimo");
                        listarLivrosDisponiveis();
                        break;
                    case 6:
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
                    case 7:
                        System.out.println("Listagem de clientes cadastrados:");
                        listarClientes();
                        break;
                    case 8:
                        System.out.println("Listagem de livros emprestados:");
                        listarEmprestimos();
                        break;
                    case 9:
                        System.out.println("Inserir codigo do cliente:");
                        codigoCliente = s1.nextInt();
                        devolverLivro(codigoCliente);
                        break;
                    default:
                        System.out.println("Erro! Digite uma operação válida!");
                }
            } catch (InputMismatchException error){
                System.out.println("Erro ao inserir informação no sistema, tente novamente!");
            } catch (Exception error){
                System.out.println("Erro!!");
            }
        }while(menu != 0);
    }
}
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
    private Genero[] generos;

    public Biblioteca() {
        this.autores = new ArrayList<>();
        this.emprestimos = new ArrayList<>();;
        this.livros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.generos = Genero.values();
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

    public void getLivrosByGenero(int codigoGenero){
        if(codigoGenero  < 1 || codigoGenero > generos.length){
            System.out.println("Opção inválida!");
        }else{
            Genero generoEscolhido = generos[codigoGenero - 1];
            for(Livro livro : this.livros){
                if(livro.getGenero() == generoEscolhido){
                    System.out.println(livro.getId() + " - " + livro.getTitulo() + " (" +livro.getAutor() + ")" + " - " + livro.getGenero().toString());
                }
            }
        }
    }

    public void cadastrarCliente(Cliente novoCliente){
        this.clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void adicionarLivro(String nomeLivro, String nomeAutor, int codigoGenero){
        if(codigoGenero  < 1 || codigoGenero > generos.length){
            System.out.println("Opção inválida!");
        }else{
            Genero generoEscolhido = generos[codigoGenero - 1];
            this.livros.add(new Livro(nomeLivro, nomeAutor, generoEscolhido));
            System.out.println("Livro cadastrado com sucesso!");
        }

    }

    public void adicionarLivro(Livro novoLivro){
        this.livros.add(novoLivro);
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
                    System.out.println(livro.getId() + " - " + livro.getTitulo() + " (" +livro.getAutor() + ")" + " - " + livro.getGenero().toString());
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
                System.out.println("Gênero: "  + emprestimo.getLivroEmprestado().getGenero().toString());
                System.out.println("Data do Empréstimo: " + emprestimo.getHorarioEmprestimo());
                System.out.println("Devolvido? " + ((emprestimo.isDevolvido()) ? "Sim." : "Não.") );
                System.out.println("Data da devolução: " + ((emprestimo.isDevolvido()) ? emprestimo.getHorarioDevolucao() : "N/A") );
                System.out.println("============");
            }
        }
    }

    public void emprestimoLivro(int codigoCliente, int codigoLivro){
        Cliente clienteAtual = getClienteById(codigoCliente);
        Livro livroDesejado = getLivroById(codigoLivro);
        if(clienteAtual != null && livroDesejado != null){
            for(Livro livro : this.livros){
                if(livro.getId() == livroDesejado.getId()){
                    System.out.println("Empréstimo de "  + livro.getTitulo() + " Efetuado!");
                    livro.setIsDisponivel();
                }
            }
            Emprestimo novoEmprestimo = new Emprestimo(livroDesejado, clienteAtual);
            emprestimos.add(novoEmprestimo);
        }else{
            System.out.println("Código(s) inválido(s), verifique e  digite novamente!");
        }
    }

    public void imprimirListaGeneros(){
        System.out.println("Escolha o gênero do livro:");
        for(Genero genero : this.generos){
            System.out.println((genero.ordinal() + 1) + " - " + genero);
        }
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
                if(livro.getAutor().toLowerCase().contains(nomeAutor.toLowerCase())){
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
                if(livro.getTitulo().toLowerCase().contains(tituloLivro.toLowerCase())){
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
        System.out.println("5 - Buscar livro por gênero");
        System.out.println("6 - Listar livros disponíveis");
        System.out.println("7 - Fazer emprestimo!");
        System.out.println("8 - Listar Clientes!");
        System.out.println("9 - Exibir histórico de emprestimos");
        System.out.println("10 - Efetuar devolução");
        System.out.println("0 - Encerrar atendimento");
        System.out.println("===============================");
    }

    public void iniciarAtendimento(){
        int menu = 999999;
        do {
            try{
                Scanner s = new Scanner(System.in);
                Scanner s1 = new Scanner(System.in);
                int codigoLivro;
                int codigoCliente;
                String nomeCliente;
                String emailCliente;
                String dataNascimentoCliente;
                String nomeAutor;
                String tituloLivro;
                int genero;
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
                        imprimirListaGeneros();
                        genero = s1.nextInt();
                        adicionarLivro(tituloLivro, nomeAutor, genero);
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
                        imprimirListaGeneros();
                        genero = s1.nextInt();
                        getLivrosByGenero(genero);
                        break;
                    case 6:
                        System.out.println("Livros Disponíveis para empréstimo");
                        listarLivrosDisponiveis();
                        break;
                    case 7:
                        System.out.println("Selecione um dos livros abaixo:");
                        listarLivrosDisponiveis();
                        codigoLivro = s1.nextInt();
                        System.out.println("Inserir código do cliente::");
                        codigoCliente = s1.nextInt();
                        emprestimoLivro(codigoLivro, codigoCliente);
                        break;
                    case 8:
                        System.out.println("Listagem de clientes cadastrados:");
                        listarClientes();
                        break;
                    case 9:
                        System.out.println("Listagem de livros emprestados:");
                        listarEmprestimos();
                        break;
                    case 10:
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
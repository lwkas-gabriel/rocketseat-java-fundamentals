package sistema_gerenciamento_livraria;

public class LivrariaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        //LISTA DE CLIENTES E LIVROS JÁ CADASTRADOS
        biblioteca.adicionarLivro(new Livro("O Hobbit", "J.R.R. Tolkien", Genero.FANTASIA));
        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", Genero.FANTASIA));
        biblioteca.adicionarLivro(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", Genero.REALISMO_MAGICO));
        biblioteca.adicionarLivro(new Livro("O Amor nos Tempos do Cólera", "Gabriel García Márquez", Genero.ROMANCE));
        biblioteca.adicionarLivro(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", Genero.FANTASIA));
        biblioteca.adicionarLivro(new Livro("Orgulho e Preconceito", "Jane Austen", Genero.ROMANCE));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell", Genero.DISTOPIA));
        biblioteca.adicionarLivro(new Livro("O Código Da Vinci", "Dan Brown", Genero.MISTERIO));
        biblioteca.adicionarLivro(new Livro("Drácula", "Bram Stoker", Genero.TERROR));
        biblioteca.adicionarLivro(new Livro("O Conde de Monte Cristo", "Alexandre Dumas", Genero.HISTORICO));
        biblioteca.adicionarLivro(new Livro("Anjos e Demônios", "Dan Brown", Genero.MISTERIO));
        biblioteca.adicionarLivro(new Livro("A Revolução dos Bichos", "George Orwell", Genero.SATIRA_POLITICA));
        biblioteca.adicionarLivro(new Livro("As Crônicas de Nárnia", "C.S. Lewis", Genero.FANTASIA));
        biblioteca.adicionarLivro(new Livro("Razão e Sensibilidade", "Jane Austen", Genero.ROMANCE));
        biblioteca.adicionarLivro(new Livro("O Nome da Rosa", "Umberto Eco", Genero.HISTORICO));
        biblioteca.adicionarLivro(new Livro("Os Miseráveis", "Victor Hugo", Genero.HISTORICO));
        biblioteca.adicionarLivro(new Livro("A Menina que Roubava Livros", "Markus Zusak", Genero.HISTORICO));
        biblioteca.adicionarLivro(new Livro("Frankenstein", "Mary Shelley", Genero.TERROR));
        biblioteca.adicionarLivro(new Livro("O Apanhador no Campo de Centeio", "J.D. Salinger", Genero.FICCAO_CIENTIFICA));
        biblioteca.adicionarLivro(new Livro("O Sol é Para Todos", "Harper Lee", Genero.DRAMA));

        biblioteca.cadastrarCliente(new Cliente("Alice Mendes", "alice.mendes@gmail.com", "1990-05-15"));
        biblioteca.cadastrarCliente(new Cliente("João Carvalho", "joao.carvalho@hotmail.com", "1985-11-20"));
        biblioteca.cadastrarCliente(new Cliente("Beatriz Lima", "beatriz.lima@yahoo.com", "1998-02-10"));
        biblioteca.cadastrarCliente(new Cliente("Carlos Silva", "carlos.silva@empresa.com", "1992-07-25"));
        biblioteca.cadastrarCliente(new Cliente("Fernanda Costa", "fernanda.costa@gmail.com", "2000-03-30"));
        biblioteca.iniciarAtendimento();
    }

}

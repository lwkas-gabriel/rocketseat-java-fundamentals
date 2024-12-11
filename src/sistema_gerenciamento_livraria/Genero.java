package sistema_gerenciamento_livraria;

public enum Genero {
    MISTERIO("Mistério"),
    FANTASIA("Fantasia"),
    ROMANCE("Romance"),
    DISTOPIA("Distopia"),
    DRAMA("Drama"),
    REALISMO_MAGICO("Realismo Mágico"),
    SATIRA_POLITICA("Sátira Politica"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    BIOGRAFIA("Biografia"),
    HISTORICO("História"),
    TERROR("Terror"),
    FICCAO_GOTICA("Ficção Gótica");

    private final String genero;

    Genero(String generoName) {
        this.genero = generoName;
    }

    public String toString(){
        return genero;
    }
}
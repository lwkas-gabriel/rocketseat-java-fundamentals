import rocket_03_java_beans.Aluno;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Aluno a = new Aluno("Lucas" , 32);

        System.out.println("O nome do aluno requisitado é: " + a.getNome());
        System.out.println("A idade do aluno requisitado é: " + a.getIdade());
    }
}
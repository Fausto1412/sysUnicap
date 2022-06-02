package negocio.excecoes;

public class AlunoInexistenteException extends Exception {

    public AlunoInexistenteException(){
        super("Matricula do aluno não inexistente!!");
    }
}

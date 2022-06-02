package negocio.excecoes;

public class ProfessorInexistenteException extends Exception{

    public ProfessorInexistenteException(){
        super("Id do professor não inexiste!!");
    }

}

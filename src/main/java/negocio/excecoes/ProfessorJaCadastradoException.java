package negocio.excecoes;

public class ProfessorJaCadastradoException extends Exception{

    public ProfessorJaCadastradoException(){
        super("Id do professor não inexiste!!");
    }
}

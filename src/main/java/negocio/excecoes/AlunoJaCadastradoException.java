package negocio.excecoes;

public class AlunoJaCadastradoException extends Exception{

  public AlunoJaCadastradoException() {
    super("Aluno ja cadastrada!!");
  }
}

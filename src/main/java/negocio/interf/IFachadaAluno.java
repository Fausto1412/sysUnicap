package negocio.interf;

import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Curso;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public interface IFachadaAluno {

  public void inserirAluno(Aluno aluno) throws AlunoJaCadastradoException;

  public void removerAluno(Aluno aluno) throws AlunoInexistenteException;

  public Aluno buscarAluno(String matricula) throws AlunoInexistenteException;

  public void editarNomedoAluno(Aluno aluno, String nome) throws AlunoInexistenteException;

  public void editarCursodoAluno(Aluno aluno, Curso curso) throws AlunoInexistenteException;

}

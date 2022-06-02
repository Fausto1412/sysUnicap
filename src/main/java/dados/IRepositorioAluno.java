package dados;

import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Curso;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public interface IRepositorioAluno {

  public void inserirAluno(Aluno aluno) throws AlunoJaCadastradoException;

  public boolean verificarExistenciaAluno(String matricula);

  public Aluno buscarAluno(String matricula) throws AlunoInexistenteException;

  public void removerAluno(Aluno aluno) throws AlunoInexistenteException;

  public void editarNomedoAluno(Aluno aluno, String nome) throws AlunoInexistenteException;

  public void editarCursodoAluno(Aluno aluno, Curso curso) throws AlunoInexistenteException;

  public void exibirListaAluno();
}

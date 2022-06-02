package negocio.aluno;

import dados.IRepositorioAluno;
import dados.aluno.RepositorioAluno;
import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Curso;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public class ControladorAluno {
  private IRepositorioAluno repositorioAluno;

  public ControladorAluno(){
    this.repositorioAluno = new RepositorioAluno();
  }

  public void inserirNovoAluno(Aluno aluno) throws AlunoJaCadastradoException {
    this.repositorioAluno.inserirAluno(aluno);
  }

  public Aluno buscarAlunoPorMatricula(String matricula) throws AlunoInexistenteException {
    return this.repositorioAluno.buscarAluno(matricula);
  }

  public void removerAluno(Aluno aluno) throws AlunoInexistenteException {
    this.repositorioAluno.removerAluno(aluno);
  }

  public void editarNomedoAluno(Aluno aluno, String nome) throws AlunoInexistenteException {
    this.repositorioAluno.editarNomedoAluno(aluno,nome);
  }

  public void editarCursodoAluno(Aluno aluno, Curso curso) throws AlunoInexistenteException {
    this.repositorioAluno.editarCursodoAluno(aluno, curso);
  }

  public boolean verificarExitenciadeMatricula(String matricula) {
    return this.repositorioAluno.verificarExistenciaAluno(matricula);

  }

  public void exibirListaAluno(){
    this.repositorioAluno.exibirListaAluno();
  }
}

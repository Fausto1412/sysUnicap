package negocio.aluno;

import dados.IRepositorioAluno;
import dados.aluno.RepositorioAluno;
import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Curso;
import negocio.excecoes.AlunoInexistenteException;

public class ControladorAluno {
  private IRepositorioAluno repositorioAluno;

  public ControladorAluno(){
    this.repositorioAluno = new RepositorioAluno();
  }

  public void inserirNovoAluno(Aluno aluno) {
    //implementar depois...
  }

  public Aluno buscarAlunoPorMatricula(String matricula) throws AlunoInexistenteException {
    return this.repositorioAluno.buscarAluno(matricula);
  }

  public void removerAluno(Aluno aluno) {
  }

  public void editarNomedoAluno(Aluno aluno, String nome) {
  }

  public void editarCursodoAluno(Aluno aluno, Curso curso) {
  }
}

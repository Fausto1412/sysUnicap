package negocio.aluno;

import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Curso;
import negocio.interf.IFachadaAluno;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public class FachadaAluno implements IFachadaAluno {
  private ControladorAluno controladorAluno;

  public FachadaAluno(){
    this.controladorAluno = new ControladorAluno();
  }

  @Override
  public void inserirAluno(Aluno aluno) throws AlunoJaCadastradoException {
    this.controladorAluno.inserirNovoAluno(aluno);
  }

  @Override
  public void removerAluno(Aluno aluno) throws AlunoInexistenteException {
    this.controladorAluno.removerAluno(aluno);
  }

  @Override
  public Aluno buscarAluno(String matricula) throws AlunoInexistenteException {
    return this.controladorAluno.buscarAlunoPorMatricula(matricula);
  }

  @Override
  public void editarNomedoAluno(Aluno aluno, String nome) throws AlunoInexistenteException {
    this.controladorAluno.editarNomedoAluno(aluno, nome);
  }

  @Override
  public void editarCursodoAluno(Aluno aluno, Curso curso) throws AlunoInexistenteException {
    this.controladorAluno.editarCursodoAluno(aluno, curso);
  }
}

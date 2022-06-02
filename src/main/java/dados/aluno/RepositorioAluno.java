package dados.aluno;

import dados.IRepositorioAluno;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Curso;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public class RepositorioAluno implements IRepositorioAluno {
  private List<Aluno> alunos;

  public RepositorioAluno(){
    this.alunos = new ArrayList<>();
  }

  @Override
  public void inserirAluno(Aluno aluno) throws AlunoJaCadastradoException {
    if(!this.alunos.contains(aluno)){
      this.alunos.add(aluno);
    }else{
      throw new AlunoJaCadastradoException();
    }
  }

  @Override
  public boolean verificarExistenciaAluno(String matricula) {
    for(Aluno aluno: this.alunos){
      if(aluno.getMatricula().equals(matricula)){
        return true;
      }
    }
    return false;
  }

  @Override
  public Aluno buscarAluno(String matricula) throws AlunoInexistenteException {
    for(Aluno aluno: this.alunos){
      if(aluno.getMatricula().equals(matricula)){
        return aluno;
      }
    }
    throw new AlunoInexistenteException();
  }

  @Override
  public void removerAluno(Aluno aluno) throws AlunoInexistenteException {
    if (this.alunos.contains(aluno)) {
      this.alunos.remove(aluno);
    } else {
      throw new AlunoInexistenteException();
    }
  }

  @Override
  public void editarNomedoAluno(Aluno aluno, String nome) throws AlunoInexistenteException {
    if (this.alunos.contains(aluno)) {
      aluno.setNome(nome);
    } else {
      throw new AlunoInexistenteException();
    }
  }

  @Override
  public void editarCursodoAluno(Aluno aluno, Curso curso) throws AlunoInexistenteException {
    if (this.alunos.contains(aluno)) {
      aluno.setCurso(curso);
    } else {
      throw new AlunoInexistenteException();
    }
  }

  @Override
  public void exibirListaAluno() {
    Stream<List<Aluno>> stream = Stream.of(alunos);
    stream.forEach(alunos1 -> System.out.println(alunos));
  }

}

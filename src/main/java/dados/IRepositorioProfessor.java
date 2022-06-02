package dados;

import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;
import negocio.professor.entidade.Professor;
import negocio.professor.entidade.Disciplina;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

import java.util.ArrayList;

public interface IRepositorioProfessor {

    public void inserirProfessor(Professor professor) throws AlunoJaCadastradoException, ProfessorJaCadastradoException;

    public boolean verificarExistenciaProfessor(String matricula);

    public Professor buscarProfessor(String id) throws AlunoInexistenteException, ProfessorInexistenteException;

    public void removerProfessor(Professor professor) throws AlunoInexistenteException, ProfessorInexistenteException;

    public void editarNomedoProfessor(Professor professor, String nome) throws AlunoInexistenteException, ProfessorInexistenteException;

    public void editarDisciplinadoProfessor(Professor professor, ArrayList<Disciplina> disciplina) throws AlunoInexistenteException, ProfessorInexistenteException;

}

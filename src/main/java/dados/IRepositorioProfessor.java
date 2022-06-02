package dados;

import dados.excecoes.VoceJadaEssaDisciplina;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;
import negocio.professor.entidade.Professor;
import negocio.professor.entidade.Disciplina;


import java.util.ArrayList;

public interface IRepositorioProfessor {

    public void inserirProfessor(Professor professor) throws ProfessorJaCadastradoException;

    public boolean verificarExistenciaProfessor(String matricula);

    public Professor buscarProfessor(String id) throws ProfessorInexistenteException;

    public void removerProfessor(Professor professor) throws ProfessorInexistenteException;

    public void editarNomedoProfessor(Professor professor, String nome) throws ProfessorInexistenteException;

    public void editarDisciplinadoProfessor(Professor professor, Disciplina disciplina) throws ProfessorInexistenteException, VoceJadaEssaDisciplina;

    public void exibirListaProfessor();

}

package negocio.interf;

import dados.excecoes.VoceJadaEssaDisciplina;
import negocio.professor.entidade.Professor;
import negocio.professor.entidade.Disciplina;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;

import java.util.ArrayList;

public interface IFachadaProfessor {

    void inserirProfessor(Professor professor) throws ProfessorJaCadastradoException;

    void editarNomedoProfessor(Professor professor, String novoNome) throws ProfessorInexistenteException;

    void editarDisciplinadoProfessor(Professor professor, Disciplina disciplina) throws ProfessorInexistenteException, VoceJadaEssaDisciplina;

    void removerProfessor(Professor professor) throws ProfessorInexistenteException;

    Professor buscarProfessor(String id) throws ProfessorInexistenteException;

    public boolean verificarExitenciadeID(String id);

    public void exibirListaProfessor();
}

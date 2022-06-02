package negocio.professor;

import dados.IRepositorioProfessor;
import dados.excecoes.VoceJadaEssaDisciplina;
import dados.professor.RepositorioProfessor;

import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;
import negocio.professor.entidade.Disciplina;
import negocio.professor.entidade.Professor;

import java.util.ArrayList;

public class ControladorProfessor {
    private IRepositorioProfessor repositorioProfessor;

    public ControladorProfessor(){
        this.repositorioProfessor = new RepositorioProfessor();
    }

    public void inserirNovoProfessor(Professor professor) throws ProfessorJaCadastradoException{
        this.repositorioProfessor.inserirProfessor(professor);
    }

    public void editarNomedoProfessor(Professor professor, String novoNome) throws ProfessorInexistenteException {
        this.repositorioProfessor.editarNomedoProfessor(professor, novoNome);
    }

    public void editarDisciplinadoProfessor(Professor professor, Disciplina disciplina) throws ProfessorInexistenteException, VoceJadaEssaDisciplina {
        this.repositorioProfessor.editarDisciplinadoProfessor(professor, disciplina);
    }

    public void removerProfessor(Professor professor) throws ProfessorInexistenteException {
        this.repositorioProfessor.removerProfessor(professor);
    }

    public Professor buscarProfessor(String id) throws ProfessorInexistenteException {
        return this.repositorioProfessor.buscarProfessor(id);
    }


    public boolean verificarExitenciadeID(String id) {
        return this.repositorioProfessor.verificarExistenciaProfessor(id);
    }

    public void exibirListaProfessor(){
        this.repositorioProfessor.exibirListaProfessor();
    }
}

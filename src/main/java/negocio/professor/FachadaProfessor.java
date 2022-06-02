package negocio.professor;

import dados.excecoes.VoceJadaEssaDisciplina;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;
import negocio.interf.IFachadaProfessor;
import negocio.professor.entidade.Disciplina;
import negocio.professor.entidade.Professor;

import java.util.ArrayList;

public class FachadaProfessor implements IFachadaProfessor {

    private ControladorProfessor controladorProfessor;

    public FachadaProfessor(){
        this.controladorProfessor = new ControladorProfessor();
    }

    @Override
    public void inserirProfessor(Professor professor) throws ProfessorJaCadastradoException {
        this.controladorProfessor.inserirNovoProfessor(professor);
    }

    @Override
    public void editarNomedoProfessor(Professor professor, String novoNome) throws ProfessorInexistenteException {
        this.controladorProfessor.editarNomedoProfessor(professor, novoNome);
    }

    @Override
    public void editarDisciplinadoProfessor(Professor professor, Disciplina disciplina) throws ProfessorInexistenteException, VoceJadaEssaDisciplina {
        this.controladorProfessor.editarDisciplinadoProfessor(professor, disciplina);
    }

    @Override
    public void removerProfessor(Professor professor) throws ProfessorInexistenteException {
        this.controladorProfessor.removerProfessor(professor);
    }

    @Override
    public Professor buscarProfessor(String id) throws ProfessorInexistenteException {
        return this.controladorProfessor.buscarProfessor(id);
    }

    @Override
    public boolean verificarExitenciadeID(String id) {
        return this.controladorProfessor.verificarExitenciadeID(id);
    }

    @Override
    public void exibirListaProfessor() {
        this.controladorProfessor.exibirListaProfessor();
    }

}

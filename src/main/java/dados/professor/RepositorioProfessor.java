package dados.professor;

import dados.IRepositorioProfessor;
import dados.excecoes.VoceJadaEssaDisciplina;
import negocio.professor.entidade.Professor;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;
import negocio.professor.entidade.Disciplina;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RepositorioProfessor implements IRepositorioProfessor {

    private List<Professor> professores;

    public RepositorioProfessor(){
        this.professores = new ArrayList<>();
    }

    @Override
    public void inserirProfessor(Professor professor) throws ProfessorJaCadastradoException {
        if(!this.professores.contains(professor)){
            this.professores.add(professor);
        }else{
            throw new ProfessorJaCadastradoException();
        }
    }

    @Override
    public boolean verificarExistenciaProfessor(String id) {
        for(Professor professor: this.professores){
            if(professor.getID().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Professor buscarProfessor(String id) throws ProfessorInexistenteException {
        for(Professor professor: this.professores){
            if(professor.getID().equals(id)){
                return professor;
            }
        }
        throw new ProfessorInexistenteException();
    }

    @Override
    public void removerProfessor(Professor professor) throws ProfessorInexistenteException {
        if(this.professores.contains(professor)){
            this.professores.remove(professor);
        }
        else {
            throw new ProfessorInexistenteException();
        }
    }

    @Override
    public void editarNomedoProfessor(Professor professor, String nome) throws ProfessorInexistenteException {
        if(this.professores.contains(professor)){
            professor.setNome(nome);
        }
        else {
            throw new ProfessorInexistenteException();
        }

    }

    @Override
    public void editarDisciplinadoProfessor(Professor professor, Disciplina disciplina) throws ProfessorInexistenteException, VoceJadaEssaDisciplina {
        if(this.professores.contains(professor)){
            if(this.professores.contains(professor)){
                professor.setDisciplina(disciplina);
            }
            else {
                throw new VoceJadaEssaDisciplina();
            }
        }
        else {
            throw new ProfessorInexistenteException();
        }
    }

    @Override
    public void exibirListaProfessor() {
        professores.forEach((professor -> System.out.println("\n"+professor)));
    }
}

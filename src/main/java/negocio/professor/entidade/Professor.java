package negocio.professor.entidade;

import java.util.ArrayList;

public class Professor {
    private String id;
    private String nome;
    private Disciplina disciplina;

    public Professor(String nome, String id, Disciplina disciplina) {
        this.nome = nome;
        this.id = id;
        this.disciplina = disciplina;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return String.format("Nome do Aluno %s, matricula %s faz curso de %s", getNome(), getID(), getDisciplina()) ;
    }

}


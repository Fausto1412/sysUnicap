package negocio.professor.entidade;

import java.util.ArrayList;

public class Professor {
    private String id;
    private String nome;
    private ArrayList<Disciplina> disciplina;

    public Professor(String nome, String id, ArrayList<Disciplina> disciplina) {
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

    public ArrayList<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(ArrayList<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

}


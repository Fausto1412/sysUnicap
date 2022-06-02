package gui.professor;


import dados.excecoes.VoceJadaEssaDisciplina;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;
import negocio.interf.IFachadaProfessor;
import negocio.professor.entidade.Disciplina;
import negocio.professor.entidade.Professor;

import java.util.Scanner;

public class GUIProfessor {
    Scanner in = new Scanner(System.in);

    public void menuProfessor(IFachadaProfessor fachadaProfessor) throws ProfessorJaCadastradoException, ProfessorInexistenteException {

        byte op = 0;
        while (op != 6) {
            gui();
            op = in.nextByte();
            switch (op) {
                case 1 -> inserirNovoProfessor(fachadaProfessor);
                case 2 -> buscarProfessor(fachadaProfessor);
                case 3 -> editarProfessor(fachadaProfessor);
                case 4 -> removerProfessor(fachadaProfessor);
                case 5 -> fachadaProfessor.exibirListaProfessor();
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void gui() {
        System.out.print("""
                
                ----------------------
                1 - Inserir novo professor;
                2 - Buscar professor;
                3 - Editar professor;
                4 - remover professor;
                5 - Exibir lista de Professores;
                6 - Fechar programa.
                                
                Escolha uma opção:\040 """);
    }

    private void guiDisciplina() {
        System.out.print("""
                
                -----------DISCIPLINA-----------

                1 - Ciencia da computação;
                2 - Design.
                                
                Escolha uma opção:\040 """);
    }

    private void guiEditar() {
        System.out.print("""
                
                -----------EDITAR-----------

                1 - Editar nome do professor;
                2 - Editar Disciplina do professor.
                                
                Escolha uma opção:\040 """);
    }


    private void inserirNovoProfessor(IFachadaProfessor fachadaProfessor) throws ProfessorJaCadastradoException {
        in.nextLine();
        System.out.println("\n==========================");
        System.out.print("Insira a id do professor : ");
        String id = in.nextLine();

        while(fachadaProfessor.verificarExitenciadeID(id)){
            System.out.println("ID ja cadastrada!!");
            id = in.nextLine();
        }

        System.out.print("\nNome do professor: ");
        String nome = in.nextLine();

        Disciplina disciplina = escolherDisciplina();


        Professor professor = new Professor(nome, id, disciplina);

        try{
            fachadaProfessor.inserirProfessor(professor);
            System.out.println("Professor inserido!!");
        }catch(ProfessorJaCadastradoException e){
            System.out.println(e.getMessage());
        }
    }

    private void buscarProfessor(IFachadaProfessor fachadaProfessor) {
        System.out.println("\n==========================");
        System.out.print("Digite a ID do Professor que voce quer procurar: ");
        String id = in.next();

        try{
            Professor professor = fachadaProfessor.buscarProfessor(id);
            System.out.println(professor);
        }
        catch (ProfessorInexistenteException e){
            System.out.println(e.getMessage());
        }
    }

    private void editarProfessor(IFachadaProfessor fachadaProfessor) {
        byte opEditar = 0;
        guiEditar();
        switch (opEditar){
            case 1 -> editarNomedoProfessor(fachadaProfessor);
            case 2 -> editarDisciplinadoProfessor(fachadaProfessor);
        }
    }

    private void editarNomedoProfessor(IFachadaProfessor fachadaProfessor) {
        System.out.print("Digite a id do professor que voce quer editar o nome: ");
        String id = in.next();

        Professor professor = null;
        try {
            professor = fachadaProfessor.buscarProfessor(id);
        } catch (ProfessorInexistenteException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Digite o novo nome do professor: ");
        String novoNome = in.next();

        try {
            fachadaProfessor.editarNomedoProfessor(professor, novoNome);
        } catch (ProfessorInexistenteException e ) {
            System.out.println(e.getMessage());
        }
    }

    private void editarDisciplinadoProfessor(IFachadaProfessor fachadaProfessor) {
        System.out.print("Digite a id do professor que voce quer editar o Disciplina: ");
        String id = in.next();

        Professor professor = null;
        try {
            professor = fachadaProfessor.buscarProfessor(id);
        } catch (ProfessorInexistenteException e) {
            System.out.println(e.getMessage());
        }

        Disciplina Disciplina = escolherDisciplina();

        try {
            fachadaProfessor.editarDisciplinadoProfessor(professor, Disciplina);
        } catch (ProfessorInexistenteException | VoceJadaEssaDisciplina e) {
            System.out.println(e.getMessage());
        }
    }

    private void removerProfessor(IFachadaProfessor fachadaProfessor) throws ProfessorInexistenteException {
        System.out.println("\n==========================");
        System.out.print("Digite a ID do professor que voce quer procurar: ");
        String id = in.next();

        try{
            fachadaProfessor.removerProfessor(fachadaProfessor.buscarProfessor(id));
            System.out.println("\nProfessor com a ID "+id+" foi removido!!");
        }catch (ProfessorInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private Disciplina escolherDisciplina() {
        int opDisciplina;
        do {
            guiDisciplina();
            opDisciplina = in.nextInt();
            if (opDisciplina != 1 && opDisciplina != 2){
                System.out.println("Opção invalida escolha de novo");
            }
        }while(opDisciplina == 1 && opDisciplina == 2 );
        return opçõesDisciplina(opDisciplina);
    }

    private Disciplina opçõesDisciplina(int opDisciplina) {
        if(opDisciplina == 1){
            return Disciplina.Ciencia_da_Computação;
        }
        else{
            return Disciplina.Design;
        }
    }
}

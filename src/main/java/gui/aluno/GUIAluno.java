package gui.aluno;


import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Curso;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;
import negocio.interf.IFachadaAluno;

import java.util.Scanner;
import java.util.stream.Stream;

public class GUIAluno {
    Scanner in = new Scanner(System.in);

    public void menuAluno(IFachadaAluno fachadaAluno) throws AlunoJaCadastradoException, AlunoInexistenteException {

        byte op = 0;
        while(op != 6){
            guiPrincipalAluno();
            op = in.nextByte();
            switch (op) {
                case 1 -> inserirNovoAluno(fachadaAluno);
                case 2 -> buscarAluno(fachadaAluno);
                case 3 -> editarAluno(fachadaAluno);
                case 4 -> removerAluno(fachadaAluno);
                case 5 -> fachadaAluno.exibirListaAluno();
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void guiPrincipalAluno() {
        System.out.print("""
                
                ----------------------
                1 - Inserir novo Aluno;
                2 - Buscar Aluno;
                3 - Editar Aluno;
                4 - remover Aluno;
                5 - Exibir lista de alunos;
                6 - Fechar programa;
                                
                Escolha uma opção:\040 """);

    }

    private void guiEditar() {
        System.out.print("""
                
                -----------EDITAR-----------

                1 - Editar nome do aluno;
                2 - Editar curso do aluno.
                                
                Escolha uma opção:\040 """);
    }

    private void guiCursos() {
        System.out.print("""
                
                -----------CURSOS-----------

                1 - Ciencia da computação;
                2 - Design.
                                
                Escolha uma opção:\040 """);
    }

    private void inserirNovoAluno(IFachadaAluno fachadaAluno) throws AlunoJaCadastradoException {

        in.nextLine();
        System.out.println("\n==========================");
        System.out.print("Insira a matricula do Aluno : ");
        String matricula = in.nextLine();

        while(fachadaAluno.verificarExitenciadeMatricula(matricula)){
            System.out.println("Matricual ja cadastrada!!");
            matricula = in.nextLine();
        }

        System.out.print("\nNome do Aluno: ");
        String nome = in.nextLine();

        Curso curso = escolhercurso();


        Aluno aluno = new Aluno(nome, matricula, curso);

        try{
            fachadaAluno.inserirAluno(aluno);
            System.out.println("Aluno inserido!!");
        }catch(AlunoJaCadastradoException e){
            System.out.println(e.getMessage());
        }

    }

    private void buscarAluno(IFachadaAluno fachadaAluno) throws AlunoInexistenteException {

        System.out.println("\n==========================");
        System.out.print("Digite a Matricula do aluno que voce quer procurar: ");
        String matricula = in.next();

        try{
            Aluno aluno = fachadaAluno.buscarAluno(matricula);
            System.out.println(aluno);
        }
        catch (AlunoInexistenteException e){
            System.out.println(e.getMessage());
        }

    }

    private void removerAluno(IFachadaAluno fachadaAluno) throws AlunoInexistenteException{

        System.out.println("\n==========================");
        System.out.print("Digite a Matricula do aluno que voce quer procurar: ");
        String matricula = in.next();

        try{
            fachadaAluno.removerAluno(fachadaAluno.buscarAluno(matricula));
            System.out.println("\nAluno com a Matricula "+matricula+" foi removido!!");
        }catch (AlunoInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void editarAluno(IFachadaAluno fachadaAluno) throws AlunoInexistenteException {
        byte opEditar = 0;
        guiEditar();
        opEditar = in.nextByte();
        switch (opEditar){
            case 1 -> editarNomedoAluno(fachadaAluno);
            case 2 -> editarCursodoAluno(fachadaAluno);
        }
    }

    private void editarCursodoAluno(IFachadaAluno fachadaAluno) throws AlunoInexistenteException{
        System.out.print("Digite a Matricula do aluno que voce quer editar o curso: ");
        String matricula = in.next();

        Aluno aluno = null;
        try {
            aluno = fachadaAluno.buscarAluno(matricula);
        } catch (AlunoInexistenteException e) {
            System.out.println(e.getMessage());
        }

        Curso curso = escolhercurso();

        try {
            fachadaAluno.editarCursodoAluno(aluno, curso);
        } catch (AlunoInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void editarNomedoAluno(IFachadaAluno fachadaAluno) throws AlunoInexistenteException{
        System.out.print("Digite a Matricula do aluno que voce quer editar o nome: ");
        String matricula = in.next();

        Aluno aluno = null;
        try {
            aluno = fachadaAluno.buscarAluno(matricula);
        } catch (AlunoInexistenteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Digite o novo nome do aluno: ");
        String novoNome = in.next();

        try {
            fachadaAluno.editarNomedoAluno(aluno, novoNome);
        } catch (AlunoInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }



    private Curso opçõesCursos(int opCurso) {
        if(opCurso == 1){
            return Curso.Ciencia_da_Computação;
        }
        else{
            return Curso.Design;
        }
    }

    private Curso escolhercurso() {
        int opCurso;
        do {
            guiCursos();
            opCurso = in.nextInt();
            if (opCurso != 1 && opCurso != 2){
                System.out.println("Opção invalida escolha de novo");
            }
        }while(opCurso == 1 && opCurso == 2 );
        return opçõesCursos(opCurso);
    }


}

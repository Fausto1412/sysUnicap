import gui.aluno.GUIAluno;
import gui.professor.GUIProfessor;
import negocio.aluno.FachadaAluno;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;
import negocio.interf.IFachadaAluno;
import negocio.interf.IFachadaProfessor;
import negocio.professor.FachadaProfessor;

import java.util.Scanner;

public class AplicacaoSysUnicap {

  public static void main(String[] args) throws AlunoJaCadastradoException, AlunoInexistenteException, ProfessorJaCadastradoException, ProfessorInexistenteException {

    Scanner in = new Scanner(System.in);
    GUIAluno guiAluno = new GUIAluno();
    GUIProfessor guiProfessor = new GUIProfessor();
    IFachadaAluno fachadaAluno = new FachadaAluno();
    IFachadaProfessor fachadaProfessor = new FachadaProfessor();


    byte op = 0;
    while (op != 3) {
      gui();
      op = in.nextByte();
      switch (op) {
        case 1 -> guiProfessor.menuProfessor(fachadaProfessor);
        case 2 -> guiAluno.menuAluno(fachadaAluno);
        case 3 -> {
          break;
        }
        default -> System.out.println("Opção inválida");
      }
    }

  }

  private static void gui() {
    System.out.print("""
              ----------------------
              1 - Entrar no menu de professor;
              2 - Entrar no menu de aluno;
              3 - Fechar o programa.
                              
              Escolha uma opção:\040 """);
  }
}


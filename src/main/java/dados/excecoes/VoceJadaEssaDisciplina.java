package dados.excecoes;

public class VoceJadaEssaDisciplina extends Exception{
    public VoceJadaEssaDisciplina(){
        super("Você ja da aula dessa disciplina!!");
    }
}

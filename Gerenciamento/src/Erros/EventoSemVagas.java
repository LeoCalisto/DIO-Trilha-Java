package Erros;

public class EventoSemVagas extends Exception {
    public EventoSemVagas(){
        super();
    }

    @Override
    public String toString() {
        return "O evento não tem vagas !";
    }

    
}

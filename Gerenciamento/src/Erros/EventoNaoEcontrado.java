package Erros;

public class EventoNaoEcontrado extends Exception{
    public EventoNaoEcontrado(){
        super();
    }

    @Override
    public String toString() {
        return "Evento não cadastrado no sistema !";
    }
    
}

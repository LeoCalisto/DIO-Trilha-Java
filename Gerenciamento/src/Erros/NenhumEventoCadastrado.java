package Erros;
public class NenhumEventoCadastrado extends Exception{

    public NenhumEventoCadastrado( ){
        super();
    }

    @Override
    public String toString() {
        return "Não tem evento cadastrado no sistema !";
    }
}

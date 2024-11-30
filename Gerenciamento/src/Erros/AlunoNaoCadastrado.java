package Erros;

public class AlunoNaoCadastrado extends Exception{

    public AlunoNaoCadastrado(){
        super();
    }
    
    @Override
    public String toString() {
        return "Aluno não cadastrado no sistema";
    }
}

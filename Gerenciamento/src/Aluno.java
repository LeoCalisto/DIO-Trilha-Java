public class Aluno extends Pessoa{
    private String turma;
    private String matricula;
    private boolean matriculado;
    
    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public boolean getMatriculado() {
        return matriculado;
    }
    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }
    
    @Override
    public String toString() {
        return "Aluno [turma=" + turma + ", matricula=" + matricula + ", matriculado=" + matriculado + "]";
    }
    
    
}

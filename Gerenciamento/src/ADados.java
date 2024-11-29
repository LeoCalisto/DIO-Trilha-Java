import java.util.HashSet;
import java.util.Set;

public abstract class ADados {
    private Administrador adm = new Administrador();
    private int qtalunos = 0, qtEventos = 0;
    private Set<Aluno> alunos = new HashSet<>();
    private Set<Evento> eventos = new HashSet<>();

    public int getQtEventos() {
        return qtEventos;
    }

    public void setQtEventos(int qtEventos) {
        this.qtEventos = qtEventos;
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public int getQtalunos() {
        return qtalunos;
    }

    public void setQtalunos(int qtalunos) {
        this.qtalunos = qtalunos;
    }

    public Set<Aluno> getAlunosGeral() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public abstract void cadAlunoGeral();

    public abstract Evento criarEvento();
    
    public abstract void cadEvento();

    public abstract Aluno criarAluno();

    public abstract void cadAlunoEvento(int idAluno, int idEvento);

    public  void excAlunoGeral(int id){
        for(Aluno a : getAlunosGeral()){
            if (a.getId() == id && a.getMatriculado() == false) {
                getAlunosGeral().remove(a);
            }
        }
    }

    public  void excAlunoEvento(int idA, int idE){
        for(Evento e : getEventos()){
            if (e.getId() == idE) {
                for(Aluno a : e.getParticipantes()){
                    if (a.getId() == idA) {
                        e.getParticipantes().remove(a);
                    }
                }
            }
        }
    }

}

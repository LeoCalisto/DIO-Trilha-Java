import java.util.List;
import java.util.Set;

public interface Idados {
    public void obterAdm(Administrador adm);

    public List<Aluno> obterEstudantesEvento(Set<Aluno> alunos);

    public Set<Evento> obterEventosDecrescente(Set<Evento> eventos);

    public Set<Evento> obterEventosTipo(Set<Evento> eventos);

    public Set<Evento> obterEventosData(Set<Evento> eventos, String dataInicial, String dataFinal);

    public Set<Evento> obterEventosAluno(Set<Evento> eventos, Aluno a);

    public boolean consultarAlunoEvento(Aluno a, Evento e);
}

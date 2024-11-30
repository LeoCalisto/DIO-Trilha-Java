import java.time.LocalDate;
import java.util.Set;

public interface IImprimir {
    
    public void imprimir(Administrador adm);
    public void imprimir(Set<Evento> eventos);
    public void imprimirQuantidade(Set<Evento> eventos);
    public void imprimirTipo(Set<Evento> eventos);
    public void imprimir(LocalDate dInicial, LocalDate dFinal, Set<Evento> eventos);
    public void imprimir(Set<Evento> eventos,int idA, Set<Aluno> alunos);
    public void imprimir(Set<Evento> eventos, int idA, int idE);
}

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
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

    public void setAlunosGeral(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public LocalDate gerarData(Scanner sc) {
        int a, m, day;
        System.out.println("Insira o ano do evento yyyy: ");
        a = sc.nextInt();
        System.out.println("Insira o mês do evento mm: ");
        m = sc.nextInt();
        System.out.println("Insira o dia do evento dd :");
        day = sc.nextInt();
        LocalDate data = LocalDate.of(a, m, day);
        return data;
    }

    public abstract void cadAlunoGeral(Aluno a);

    public abstract Evento criarEvento();

    public abstract Aluno criarAluno();

    public abstract void cadEvento(Evento e);

    public abstract void cadAlunoEvento(int idAluno, int idEvento);

    public abstract void excAlunoGeral(int id);

    public abstract void excAlunoEvento(int idA, int idE);

    public void obterEventos() {
        for (Evento e : eventos) {
            System.out.println(e);
        }
    }

    public void obterAluno() {
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }

    public boolean validarId(int n, Set<Aluno> alunos) {
        for (Aluno a : alunos) {
            if (a.getId() == n) {
                return true;
            }
        }
        return false;
    }

    public boolean validarId(Set<Evento> eventos, int n) {
        for (Evento e : eventos) {
            if (e.getId() == n) {
                return true;
            }
        }
        return false;
    }

}

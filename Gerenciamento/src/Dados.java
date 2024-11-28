import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dados {


    private Administrador adm = new Administrador();
    private int qtalunos = 0;
    private Set<Aluno> alunos = new HashSet<>();
    private Set<Evento> eventos = new HashSet<>();

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

    public void criarEvento(Set<Evento> eventos, Administrador adm, int qtalunos){
        Scanner sc = new Scanner(System.in);
        String descicao;
        int id, opc;
        Tipo tipoEvento = null;
        Evento e = new Evento();
        Set<Aluno> participantes = new HashSet<>();
        Aluno a;

        System.out.println("Digite a descição do Evento: ");
        descicao = sc.nextLine();
        id = eventos.size()+1;
        System.out.println("Tipo do evento: 1-Palestra 2-Workshop 3-Seminário 4-Minicurso 5-Competição");
        opc = sc.nextInt();
        switch (opc) {
            case 1:
                tipoEvento = Tipo.PALESTRA;
                break;
            case 2:
                tipoEvento = Tipo.WORKSHOPS;
                break;
            case 3:
                tipoEvento = Tipo.SEMINARIO;  
                break;
            case 4:
                tipoEvento = Tipo.MINICURSO;
                break;
            case 5:
                tipoEvento = Tipo.COMPETICAO;
                break;
            default:
                System.out.println("Tipo de não existente !");
                break;
        }
        if (adm.getId() != 1) {
            System.out.println("Digite o nome do ADM: ");
            adm.setNome(sc.next());
            adm.setId(1);
            System.out.println("Digite o email do ADM");
            adm.setEmail(sc.next());
        }

        for (int i = 0; i < 2; i++) {
            a = new Aluno();
            cadAlunoGeral(getAlunosGeral(),a = criarAluno(getQtalunos()));
            participantes.add(a);
            e.setVagas(e.getVagas()-1);
            e.setParticipantes(participantes);
        }
        
        e.setDescicao(descicao);
        e.setId(id);
        e.setAdm(adm);
        e.setTipoEvento(tipoEvento);
        eventos.add(e);

        setEventos(eventos);
    }

    public Aluno criarAluno(int qtalunos){
        Aluno a = new Aluno();
        Scanner sc = new Scanner(System.in);

        a.setId(getQtalunos()+1);
        System.out.println("Digite o nome do aluno: ");
        a.setNome(sc.nextLine());
        System.out.println("Digite a matricula do aluno: ");
        a.setMatricula(sc.nextLine());
        System.out.println("Digite a turma do aluno: ");
        a.setTurma(sc.nextLine());
        setQtalunos(getQtalunos()+1);

        return a;
    }

    public void cadAlunoGeral(Set<Aluno> alunos, Aluno a){alunos.add(a);}


    public void cadAlunoEvento(int id,Set<Aluno> alunos, int idEvento, Set<Evento> eventos){
       
        for (Aluno a:alunos){
            if (a.getId() == id) {
                for (Evento e:eventos){
                    if (e.getId() == id && e.getParticipantes().size() < 10) {
                        e.getParticipantes().add(a);
                    }    
                }
            }
        }
    }

    public void obterIdADM(Administrador a){
       System.out.println(a.getId());
    }

    public void obterAlunos(Set<Aluno> alunos){
        for (Aluno a:alunos){
            System.out.println(a);
        }
    }

}

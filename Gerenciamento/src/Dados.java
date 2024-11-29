import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dados extends ADados{

    public void obterAlunos(){
        for (Aluno a:getAlunosGeral()){
            System.out.println(a);
        }
    }

    public void obterEventos(){
        for (Evento e:getEventos()){
            System.out.println(e);
        }
    }

    @Override
    public Evento criarEvento(){
        Scanner sc = new Scanner(System.in);
        String descicao;
        int id, opc;
        Tipo tipoEvento = null;
        Evento e = new Evento();
        Set<Aluno> participantes = new HashSet<>();
        Aluno a;

        System.out.println("Digite a descição do Evento: ");
        descicao = sc.nextLine();
        id = getQtEventos()+1;
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
        
        if (getAdm().getId() != 1) {
            System.out.println("Digite o nome do ADM: ");
            getAdm().setNome(sc.next());
            getAdm().setId(1);
            System.out.println("Digite o email do ADM");
            getAdm().setEmail(sc.next());
        }

        for (int i = 0; i < 2; i++) {
            a = new Aluno();
            cadAlunoGeral();
            participantes.add(a);
            e.setVagas(e.getVagas()-1);
            e.setParticipantes(participantes);
        }
        
        e.setDescicao(descicao);
        e.setId(id);
        e.setAdm(getAdm());
        e.setTipoEvento(tipoEvento);

        return e;
    }

    @Override
    public void cadEvento(){
        getEventos().add(criarEvento());
    }

    @Override
    public Aluno criarAluno(){
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

    @Override
    public void cadAlunoGeral(){
        Aluno al = criarAluno();
        getAlunosGeral().add(al);
        al.setMatriculado(true);
    }

    @Override
    public void cadAlunoEvento(int idAluno, int idEvento){
        for (Aluno a:getAlunosGeral()){
            if (a.getId() == idAluno) {
                for (Evento e:getEventos()){
                    if (e.getId() == idEvento && e.getParticipantes().size() < 10) {
                        e.getParticipantes().add(a);
                        e.setVagas(e.getVagas()-1);
                    }    
                }
            }
        }
    }

}

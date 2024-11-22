import java.util.Set;
import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {

    Administrador adm;
    Set<Evento> eventos;
    Set<Aluno> alunos;


    System.out.println("1-Cadastrar evento");
    System.out.println("2-Cadastrar estudante");
    System.out.println("3-Excluir estudante");

    }


    public static void cadastrarEvento(Set<Evento> eventos, Administrador adm){
        Scanner sc = new Scanner(System.in);
        String descicao;
        int id, op;
        Tipo tipoEvento = null;
        Set<Aluno> participantes;
        Evento e;

        System.out.println("Digite a descição do Evento: ");
        descicao = sc.nextLine();
        id = eventos.size()+1;
        System.out.println("Tipo do evento: 1-Palestra 2-Workshop 3-Seminário 4-Minicurso 5-Competição");
        op = sc.nextInt();
        switch (op) {
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
        if (adm != null) {
            System.out.println("Digite o nome do administrador: ");
            adm = new Administrador();
            adm.setNome(sc.nextLine());
            adm.setId(1);
        }

        e = new Evento();
        e.setDescicao(descicao);
        e.setId(id);
        e.setAdm(adm);
        e.setTipoEvento(tipoEvento);
        
    }

    public void criarAluno(Scanner sc, Set<Aluno> alunos){
        Aluno a = null;

        a.setId(alunos.size()+1);
        System.out.println("Digite o nome do aluno: ");
        a.setNome(sc.nextLine());
        System.out.println("Digite a matricula do aluno: ");
        a.setMatricula(sc.nextLine());
        System.out.println("Digite a turma do aluno: ");
        a.setTurma(sc.nextLine());
        
        alunos.add(a);
    }

}

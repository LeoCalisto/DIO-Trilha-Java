import java.time.LocalDate;
import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Dados d = new Dados();
        Imprimir i = new Imprimir();
        int esc;
    
        do  {
            System.out.println("1-Cadastrar evento");
            System.out.println("2-Cadastramento Geral Aluno");
            System.out.println("3-Cadastrar Aluno em Evento");
            esc = sc.nextInt();
            switch (esc) {
                case 1:
                    d.criarEvento();
                    d.cadEvento();
                    break;
                case 2:
                    while (d.getAlunosGeral().size() < 8) {
                        d.criarAluno();
                    }
                    break;
                case 3:
                    System.out.println("Digite o ID do aluno:");
                    int idA = sc.nextInt();
                    System.out.println("Digite o ID do Evento:");
                    int idE = sc.nextInt();
                    d.cadAlunoEvento(idA,idE);
                    break;
                case 4:
                    System.out.println("Alunos cadastrados:");
                    d.getEventos();
                    System.out.println("Eventos cadastrados:");
                    d.getAlunosGeral();
                    break;
                case 5:
                    d.getAdm();
                    break;
                case 6:
                    i.imprimir(d.getEventos());
                    break;
                case 7:
                    i.imprimirQuantidade(d.getEventos());
                    break;
                case 8:
                    i.imprimirTipo(d.getEventos());
                    break;
                case 9:
                    i.imprimir(gerarData(sc), gerarData(sc), d.getEventos());
                case 10:
                    System.out.println("ID do aluno que quer excluir:");
                    int x = sc.nextInt();
                    d.excAlunoGeral(x);
                    break;
                case 11:
                    System.out.println("ID do aluno:");
                    int ida = sc.nextInt();
                    System.out.println("ID do evento:");
                    int ide = sc.nextInt();
                    d.excAlunoEvento(ida, ide);
                default:
                    break;
            }
        }while (esc != 0);
    }

}

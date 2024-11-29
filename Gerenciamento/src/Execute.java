import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int esc;
        Dados d = new Dados();
    
        do  {
            System.out.println("1-Cadastrar evento");
            System.out.println("2-Cadastramento Geral Aluno");
            System.out.println("3-Cadastrar Aluno em Evento");
            esc = sc.nextInt();
            switch (esc) {
                case 1:
                    d.criarEvento();
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
                    d.obterAlunos();
                    System.out.println("Eventos cadastrados:");
                    d.obterEventos();
                    break;
                case 5:
                    System.out.println("ID do aluno que quer excluir:");
                    int i = sc.nextInt();
                    d.excAlunoGeral(i);
                    break;
                case 6:
                    System.out.println("ID do aluno:");
                    int ida = sc.nextInt();
                    System.out.println("ID do evento:");
                    int ide = sc.nextInt();
                    d.excAlunoEvento(ida, ide);
                default:
                    break;
            }
        }while (esc != 5);
            
        
    }
}

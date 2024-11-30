import java.util.Scanner;
import Erros.NenhumEventoCadastrado;

public class Execute {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Dados d = new Dados();
        Imprimir i = new Imprimir();
        int esc;

        do {
            mostrarMenu();
            esc = sc.nextInt();
            switch (esc) {
                case 1:
                    d.cadEvento(d.criarEvento());
                    break;
                case 2:
                    d.cadAlunoGeral(d.criarAluno());
                    break;
                case 3:
                    System.out.println("Digite o ID do aluno:");
                    int idA = sc.nextInt();
                    System.out.println("Digite o ID do Evento:");
                    int idE = sc.nextInt();
                    d.cadAlunoEvento(idA, idE);
                    break;
                case 4:
                    System.out.println("Alunos cadastrados:");
                    d.obterAluno();
                    System.out.println("Eventos cadastrados:");
                    d.obterEventos();
                    ;
                    break;
                case 5:
                    i.imprimir(d.getAdm());
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
                    i.imprimir(d.gerarData(sc), d.gerarData(sc), d.getEventos());
                    break;
                case 10:
                    System.out.println("informe o ID do aluno: ");
                    int id = sc.nextInt();
                    i.imprimir(d.getEventos(), id, d.getAlunosGeral());
                    break;
                case 11:
                    int idaluno, idevento;
                    System.out.println("informe o ID do aluno: ");
                    idaluno = sc.nextInt();
                    System.out.println("informe o ID do Evento: ");
                    idevento = sc.nextInt();
                    i.imprimir(d.getEventos(), idaluno, idevento);
                    break;
                case 12:
                    System.out.println("ID do aluno que quer excluir:");
                    int x = sc.nextInt();
                    d.excAlunoGeral(x);
                    break;
                case 13:
                    System.out.println("ID do aluno:");
                    int ida = sc.nextInt();
                    System.out.println("ID do evento:");
                    int ide = sc.nextInt();
                    d.excAlunoEvento(ida, ide);
                    break;
                default:
                    System.out.println("Sistema Finalizado !!");
                    break;
            }
        } while (esc <= 13 && esc >= 1);
    }

    public static void mostrarMenu() {
        System.out.println("\n1-Cadastrar evento");
        System.out.println("2-Cadastramento Geral Aluno");
        System.out.println("3-Cadastrar Aluno em Evento");
        System.out.println("4-Mostrar alunos e eventos");
        System.out.println("5-Identificação do ADM");
        System.out.println("6-Lista de estudantes por evento");
        System.out.println("7-Lista dos evento pelo decrescente de inscritos");
        System.out.println("8-Liste de eventos pelo tipo do evento");
        System.out.println("9-Lista de eventos baseado em um periodo de datas");
        System.out.println("10-Lista de eventos de um aluno especifico");
        System.out.println("11-Saber se o aluno está inscrito em evento especifico");
        System.out.println("12-Excluir estudante da lista geral");
        System.out.println("13-Excluir estudante de um evento");
        System.out.println("Para sair insira um número fora da escala");
    }
}

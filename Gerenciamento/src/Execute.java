import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int esc=0;
        Dados d = new Dados();
    
        while (esc != 5) {
            System.out.println("1-Cadastrar evento");
            System.out.println("2-Cadastramento Geral Aluno");
            System.out.println("3-Cadastrar Aluno em Evento");
            esc = sc.nextInt();
            switch (esc) {
                case 1:
                    d.criarEvento(d.getEventos(),d.getAdm(),d.getQtalunos());
                    break;
                case 2:
                    d.cadAlunoGeral(d.getAlunosGeral(),d.criarAluno(d.getQtalunos()));
                    break;
                case 3:
                    d.cadAlunoEvento(sc.nextInt(),d.getAlunosGeral(),sc.nextInt(),d.getEventos());
                    break;
                case 4:
                    for(Aluno a: d.getAlunosGeral()){
                        System.out.println(a);
                    }
                    for(Evento e :d.getEventos()){
                        System.out.println(e);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

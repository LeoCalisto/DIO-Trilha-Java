import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Erros.AlunoNaoCadastrado;
import Erros.EventoNaoEcontrado;
import Erros.EventoSemVagas;

public class Dados extends ADados {

    @Override
    public Evento criarEvento() {
        Scanner sc = new Scanner(System.in);
        String descicao;
        LocalDate data;
        int id, opc;
        Tipo tipoEvento = null;
        Evento e = new Evento();
        Aluno a;
        Set<Aluno> inscritos = new HashSet<>();

        System.out.println("Digite a descição do Evento: ");
        descicao = sc.nextLine();
        id = getQtEventos() + 1;
        data = gerarData(sc);
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
            a = criarAluno();
            a.setMatriculado(true);
            cadAlunoGeral(a);
            inscritos.add(a);
            e.setParticipantes(inscritos);
            e.setVagas(e.getVagas() - 1);
        }

        e.setDescicao(descicao);
        e.setId(id);
        e.setData(data);
        e.setAdm(getAdm());
        e.setTipoEvento(tipoEvento);
        setQtEventos(id);

        return e;
    }

    @Override
    public void cadEvento(Evento e) {
        getEventos().add(e);
    }

    @Override
    public Aluno criarAluno() {
        Aluno a = new Aluno();
        Scanner sc = new Scanner(System.in);

        a.setId(getQtalunos() + 1);
        System.out.println("Digite o nome do aluno: ");
        a.setNome(sc.nextLine());
        System.out.println("Digite a matricula do aluno: ");
        a.setMatricula(sc.nextLine());
        System.out.println("Digite a turma do aluno: ");
        a.setTurma(sc.nextLine());
        a.setMatriculado(false);
        setQtalunos(getQtalunos() + 1);

        return a;
    }

    @Override
    public void cadAlunoGeral(Aluno a) {
        Set<Aluno> al = new HashSet<Aluno>();
        al = getAlunosGeral();
        al.add(a);
        setAlunosGeral(al);
    }

    @Override
    public void cadAlunoEvento(int idAluno, int idEvento) {
        try {
            if (!validarId(getEventos(), idEvento)) {
                throw new EventoNaoEcontrado();
            } else if (!validarId(idEvento, getAlunosGeral())) {
                throw new AlunoNaoCadastrado();
            } else {
                for (Aluno a : getAlunosGeral()) {
                    if (a.getId() == idAluno) {
                        for (Evento e : getEventos()) {
                            if (e.getId() == idEvento) {
                                if (e.getParticipantes().size() < 10) {
                                    e.getParticipantes().add(a);
                                    e.setVagas(e.getVagas() - 1);
                                    a.setMatriculado(true);
                                } else {
                                    throw new EventoSemVagas();
                                }
                            }
                        }
                    }
                }
            }
        } catch (EventoNaoEcontrado | AlunoNaoCadastrado | EventoSemVagas err) {
            System.out.println(err);
        }
    }

    @Override
    public void excAlunoGeral(int id) {
        try {
            if (!validarId(id, getAlunosGeral())) {
                throw new AlunoNaoCadastrado();
            }
            Set<Aluno> al = new HashSet<Aluno>();
            for (Aluno a : getAlunosGeral()) {
                if (a.getId() == id) {
                    if (!a.getMatriculado()) {
                        al = getAlunosGeral();
                        al.remove(a);
                        setAlunosGeral(al);
                    } else {
                        System.out.println("Operação negada! Aluno cadastrado em algum evento..");
                    }
                }
            }
        } catch (AlunoNaoCadastrado err) {
            System.out.println(err);
        }

    }

    @Override
    public void excAlunoEvento(int idA, int idE) {
        try {
            if (!validarId(getEventos(), idE)) {
                throw new EventoNaoEcontrado();
            } else if (!validarId(idE, getAlunosGeral())) {
                throw new AlunoNaoCadastrado();
            } else {
                Set<Aluno> al;
                for (Evento e : getEventos()) {
                    if (e.getId() == idE) {
                        if (e.getParticipantes().size() > 2) {
                            for (Aluno a : e.getParticipantes()) {
                                if (a.getId() == idA) {

                                    al = new HashSet<Aluno>();
                                    al = e.getParticipantes();
                                    al.remove(a);
                                    e.setVagas(e.getVagas() + 1);
                                    e.setParticipantes(al);

                                    al = getAlunosGeral();
                                    al.remove(a);
                                    a.setMatriculado(false);
                                    al.add(a);
                                    setAlunosGeral(al);
                                }
                            }
                        } else {
                            System.out.println("Operação negada ! Evento com a capacidade mímima de 2 ");
                        }

                    }
                }
            }

        } catch (EventoNaoEcontrado | AlunoNaoCadastrado err) {
            System.out.println(err);
        }

    }

}

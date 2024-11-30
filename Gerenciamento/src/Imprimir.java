import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Imprimir implements IImprimir{
    //3
    @Override
    public void imprimir(Administrador adm){
        System.out.println("O administrador registrado é:");
        System.out.println(adm);
    }
    //4
    @Override
    public void imprimir(Set<Evento> eventos){
        for(Evento e : eventos){
            System.out.printf("No evento de %s estão escritos: ",e.getDescicao());
            System.out.println(e.getParticipantes());
        }
    }
    //5
    @Override
    public void imprimirQuantidade(Set<Evento> eventos){
        List<Evento> e = new ArrayList<Evento>();
        e.addAll(eventos);
        Collections.sort(e);
        System.out.println(e);
    }
    //6
    @Override
    public void imprimirTipo(Set<Evento> eventos){
        Set<Evento> paletras = new HashSet<Evento>(),
        workshop = new HashSet<Evento>(), 
        seminario = new HashSet<Evento>(), 
        minicurso = new HashSet<Evento>(), 
        competicao = new HashSet<Evento>();

        for (Evento e : eventos) {
            if (e.getTipoEvento().equals(Tipo.COMPETICAO)) {
                competicao.add(e);
            }else if(e.getTipoEvento().equals(Tipo.MINICURSO)){
                minicurso.add(e);
            }else if(e.getTipoEvento().equals(Tipo.PALESTRA)){
                paletras.add(e);
            }else if(e.getTipoEvento().equals(Tipo.SEMINARIO)){
                seminario.add(e);
            }else if(e.getTipoEvento().equals(Tipo.WORKSHOPS)){
                workshop.add(e);
            }
        }
        System.out.println("Palestras: \n" + paletras);
        System.out.println("Workshops: \n" + workshop);
        System.out.println("Minicurso: \n" + minicurso);
        System.out.println("Competição: \n" + competicao);
        System.out.println("Seminário: \n" + seminario);
    }
    //7
    @Override
    public void imprimir(LocalDate dInicial, LocalDate dFinal, Set<Evento> eventos){
        for (Evento e : eventos) {
            if (
                (e.getData().isEqual(dInicial) || e.getData().isAfter(dInicial) )
                 && (e.getData().isEqual(dFinal) || e.getData().isBefore(dFinal))
            ) {
                System.out.println(e);
            }
        }
    }
    //8
    @Override
    public void imprimir(Set<Evento> eventos,int idA, Set<Aluno> alunos){
        boolean i = false;
        for(Evento e : eventos){
            for (Aluno a : e.getParticipantes()) {
                if (a.getId() == idA ) {
                    System.out.println(e);
                }
            }
        }
        if (!i) {
            System.out.println("O aluno não está inscrito em nenhum evento !");
        }
    }
    //9
    @Override
    public void imprimir(Set<Evento> eventos, int idA, int idE){
        boolean i = false;
        for(Evento e : eventos){
            if (e.getId() == idE) {
                for (Aluno a : e.getParticipantes()) {
                    if (a.getId() == idA) {
                        System.out.println("O Aluno esta inscrito no evento !");
                        i = true;
                    }
                }
            }
        }
        if (!i) {
            System.out.println("O aluno não está inscrito no evento !");
        }
    }
}
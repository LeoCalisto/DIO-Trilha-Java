import java.util.Set;

public class Evento {
    private String descicao;
    private int id;
    private Tipo tipoEvento;
    private Administrador adm;
    private Set<Aluno> participantes;
    private int vagas = 10;


    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Tipo tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public Set<Aluno> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Aluno> participantes) {
        this.participantes = participantes;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}

import java.time.LocalDate;
import java.util.Set;

public class Evento implements Comparable<Evento> {
    private String descicao;
    private int id;
    private Tipo tipoEvento;
    private LocalDate data;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "Evento [descicao=" + descicao + ", id=" + id + ", tipoEvento=" + tipoEvento + ", data=" + data
                + ", adm=" + adm + ",\n participantes=" + participantes + ", vagas=" + vagas + "]";
    }

    @Override
    public int compareTo(Evento o) {
        if (this.participantes.size() > o.getParticipantes().size()) {
            return -1;
        } else if (this.participantes.size() < o.getParticipantes().size()) {
            return 1;
        } else {
            return 0;
        }
    }

}

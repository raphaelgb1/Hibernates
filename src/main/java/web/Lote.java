package web;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "lote")
public class Lote implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @SequenceGenerator(name = "geradorLote", sequenceName = "lote_codigo_seq", allocationSize = 1)
    @GeneratedValue(generator = "geradorLote", strategy = GenerationType.SEQUENCE)
    private Long codigo;
    private LocalDate validade;
    @Column(name = "nro_doses_do_lote")
    private int nroDosesDoLote;
    @Column(name = "nro_doses_atual")
    private int nroDosesAtual;
    @ManyToOne
    @JoinColumn(name = "codigo_vacina")
    private Vacina vacina;
    

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public int getNroDosesDoLote() {
        return nroDosesDoLote;
    }

    public void setNroDosesDoLote(int nroDosesDoLote) {
        this.nroDosesDoLote = nroDosesDoLote;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((validade == null) ? 0 : validade.hashCode());
        result = prime * result + nroDosesDoLote;
        result = prime * result + nroDosesAtual;
        result = prime * result + ((vacina == null) ? 0 : vacina.hashCode());
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    public int getNroDosesAtual() {
        return nroDosesAtual;
    }

    public void setNroDosesAtual(int nroDosesAtual) {
        this.nroDosesAtual = nroDosesAtual;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lote other = (Lote) obj;
        if (validade == null) {
            if (other.validade != null)
                return false;
        } else if (!validade.equals(other.validade))
            return false;
        if (nroDosesDoLote != other.nroDosesDoLote)
            return false;
        if (nroDosesAtual != other.nroDosesAtual)
            return false;
        if (vacina == null) {
            if (other.vacina != null)
                return false;
        } else if (!vacina.equals(other.vacina))
            return false;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Lote [validade=" + validade + ", nroDosesDoLote=" + nroDosesDoLote + ", nroDosesAtual=" + nroDosesAtual
                + ", vacina=" + vacina + ", codigo=" + codigo + "]";
    }
}

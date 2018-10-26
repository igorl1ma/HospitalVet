package br.com.hospital.vet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "consultas",
        indexes = {@Index(
                columnList = "id_medico,dt_entrada",
                unique = true,
                name = "unique_medico_x_dt_entrada"
        )

        })
public class Consultas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_medico", nullable = false)
    private Integer idMedico;

    @Column(name = "nm_medico", nullable = false)
    private String nmMedico;

    @Column(name = "id_pet", nullable = false)
    private Integer idPet;

    @Column(name = "nm_pet", nullable = false)
    private String nmPet;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "dt_entrada", nullable = false)
    private LocalDateTime dtEntrada;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "dt_saida", nullable = false)
    private LocalDateTime dtSaida;

    @Column(name = "retorno", nullable = false)
    private Boolean retorno;

    @Column(name = "id_unidade", nullable = false)
    private Integer idLocal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNmMedico() {
        return nmMedico;
    }

    public void setNmMedico(String nmMedico) {
        this.nmMedico = nmMedico;
    }

    public Integer getIdPet() {
        return idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public String getNmPet() {
        return nmPet;
    }

    public void setNmPet(String nmPet) {
        this.nmPet = nmPet;
    }

    public LocalDateTime getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(LocalDateTime dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public LocalDateTime getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(LocalDateTime dtSaida) {
        this.dtSaida = dtSaida;
    }

    public Boolean getRetorno() {
        return retorno;
    }

    public void setRetorno(Boolean retorno) {
        this.retorno = retorno;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultas consultas = (Consultas) o;
        return Objects.equals(id, consultas.id) &&
                Objects.equals(idMedico, consultas.idMedico) &&
                Objects.equals(nmMedico, consultas.nmMedico) &&
                Objects.equals(idPet, consultas.idPet) &&
                Objects.equals(nmPet, consultas.nmPet) &&
                Objects.equals(dtEntrada, consultas.dtEntrada) &&
                Objects.equals(dtSaida, consultas.dtSaida) &&
                Objects.equals(retorno, consultas.retorno) &&
                Objects.equals(idLocal, consultas.idLocal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idMedico, nmMedico, idPet, nmPet, dtEntrada, dtSaida, retorno, idLocal);
    }

    @Override
    public String toString() {
        return "Consultas{" +
                "id=" + id +
                ", idMedico=" + idMedico +
                ", nmMedico='" + nmMedico + '\'' +
                ", idPet=" + idPet +
                ", nmPet='" + nmPet + '\'' +
                ", dtEntrada=" + dtEntrada +
                ", dtSaida=" + dtSaida +
                ", retorno=" + retorno +
                ", idLocal=" + idLocal +
                '}';
    }
}

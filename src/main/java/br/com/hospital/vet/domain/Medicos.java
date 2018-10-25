package br.com.hospital.vet.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "medicos",
        indexes = { @Index(
                columnList =  "nm_medico,especialidades",
                unique = true,
                name = "unique_medico_x_especialidade"
        )

        })
public class Medicos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_medico", nullable = false)
    private String nmMedico;

    @Column(name = "especialidades", nullable = false)
    @Enumerated(EnumType.STRING)
    private Especialidades especialidades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmMedico() {
        return nmMedico;
    }

    public void setNmMedico(String nmMedico) {
        this.nmMedico = nmMedico;
    }

    public Especialidades getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Especialidades especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicos medicos = (Medicos) o;
        return Objects.equals(id, medicos.id) &&
                Objects.equals(nmMedico, medicos.nmMedico) &&
                especialidades == medicos.especialidades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nmMedico, especialidades);
    }

    @Override
    public String toString() {
        return "Medicos{" +
                "id=" + id +
                ", nmMedico='" + nmMedico + '\'' +
                ", especialidades=" + especialidades +
                '}';
    }
}

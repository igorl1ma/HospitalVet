package br.com.hospital.vet.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pets",
        indexes = {@Index(
                columnList = "nm_pet,nm_dono",
                unique = true,
                name = "unique_pet_x_dono"
        )

        })
public class Pets implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_pet", nullable = false)
    private String nmPet;

    @Column(name = "nm_dono", nullable = false)
    private String nmDono;

    @Column(name = "sexo", nullable = false)
    private char sexo;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "celular", nullable = false)
    private String celular;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Column(name = "email", nullable = false)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmPet() {
        return nmPet;
    }

    public void setNmPet(String nmPet) {
        this.nmPet = nmPet;
    }

    public String getNmDono() {
        return nmDono;
    }

    public void setNmDono(String nmDono) {
        this.nmDono = nmDono;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pets pets = (Pets) o;
        return sexo == pets.sexo &&
                Objects.equals(id, pets.id) &&
                Objects.equals(nmPet, pets.nmPet) &&
                Objects.equals(nmDono, pets.nmDono) &&
                Objects.equals(telefone, pets.telefone) &&
                Objects.equals(celular, pets.celular) &&
                Objects.equals(idade, pets.idade) &&
                Objects.equals(email, pets.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nmPet, nmDono, sexo, telefone, celular, idade, email);
    }

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", nmPet='" + nmPet + '\'' +
                ", nmDono='" + nmDono + '\'' +
                ", sexo=" + sexo +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                '}';
    }
}

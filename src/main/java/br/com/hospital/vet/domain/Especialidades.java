package br.com.hospital.vet.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Especialidades {
    ATENDIMENTO_CLINICO_E_EMERGENCIAL("Atendimento Clínico e Emergencial"),
    HOSPITALIZACAO("Hospitalização"),
    RADIOGRAFIA("Radiografia"),
    LABORATORIO_CLINICO("Laboratório Clínico"),
    CIRURGIA_GERAL_E_ORTOPÉDICA("Cirurgia Geral e Ortopédica"),
    ACUPUNTURA("Acupuntura"),
    ANESTESIOLOGIA("Anestesiologia"),
    CARDIOLOGIA("Cardiologia"),
    DERMATOLOGIA("Dermatologia"),
    ECODOPPLERCARDIOGRAMA("Ecodopplercardiograma"),
    ELETROCARDIOGRAMA("Eletrocardiograma"),
    ENDOCRINOLOGIA("Endocrinologia"),
    ENDOSCOPIA("Endoscopia"),
    FISIOTERAPIA_REABILITACAO("Fisioterapia/Reabilitação"),
    GASTROENTEROLOGIA("Gastroenterologia"),
    HEMATOLOGIA("Hematologia"),
    HOMEOPATIA("Homeopatia"),
    MEDICINA_DIAGNOSTICA("Medicina Diagnóstica"),
    MEDICINA_FELINA("Medicina Felina"),
    NEFROLOGIA("Nefrologia"),
    NEUROLOGIA("Neurologia"),
    NUTRICAO("Nutrição"),
    ODONTOLOGIA("Odontologia"),
    OFTALMOLOGIA("Oftalmologia"),
    ONCOLOGIA("Oncologia"),
    ORTOPEDIA("Ortopedia"),
    SILVESTRES("Silvestres"),
    ULTRASSOM("Ultrassom");

    private String especialidades;

    Especialidades (String especialidades) {
        this.especialidades = especialidades;
    }

    @JsonValue
    public String getEspecialidades() {
        return especialidades;
    }


}

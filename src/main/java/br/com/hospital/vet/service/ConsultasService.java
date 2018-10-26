package br.com.hospital.vet.service;

import br.com.hospital.vet.domain.Consultas;

import java.util.List;

public interface ConsultasService {

    void save(Consultas consultas);

    void update(Long id, Consultas consultas);

    void delete(Long id);

    Consultas findById(Long id);

    List<Consultas> findAll();

}

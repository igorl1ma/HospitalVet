package br.com.hospital.vet.dao;

import br.com.hospital.vet.domain.Consultas;

import java.util.List;

public interface ConsultasDao {

    void save(Consultas consultas);

    void update(Consultas consultas);

    void delete(Long id);

    Consultas findById(Long id);

    List<Consultas> findAll();
}

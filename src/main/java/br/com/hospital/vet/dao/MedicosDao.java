package br.com.hospital.vet.dao;

import br.com.hospital.vet.domain.Medicos;

import java.util.List;

public interface MedicosDao {

    void save(Medicos medicos);

    void update(Medicos medicos);

    void delete(Long id);

    Medicos findById(Long id);

    List<Medicos> findAll();
}

package br.com.hospital.vet.dao;

import br.com.hospital.vet.domain.Medicos;
import br.com.hospital.vet.domain.Pets;

import java.util.List;

public interface PetsDao {

    void save(Pets pets);

    void update(Pets pets);

    void delete(Long id);

    Pets findById(Long id);

    List<Pets> findAll();
}

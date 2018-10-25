package br.com.hospital.vet.service;

import br.com.hospital.vet.domain.Medicos;

import java.util.List;

public interface MedicosService {

    void save(Medicos medicos);

    void update(Long id,Medicos medicos);

    void delete(Long id);

    Medicos findById(Long id);

    List<Medicos> findAll();

}

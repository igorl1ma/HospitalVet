package br.com.hospital.vet.service;

import br.com.hospital.vet.domain.Pets;

import java.util.List;

public interface PetsService {

    void save(Pets pets);

    void update(Long id, Pets pets);

    void delete(Long id);

    Pets findById(Long id);

    List<Pets> findAll();

}

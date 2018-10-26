package br.com.hospital.vet.service;

import br.com.hospital.vet.dao.PetsDao;
import br.com.hospital.vet.domain.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetsServiceImpl implements PetsService {

    @Autowired
    private PetsDao dao;

    @Override
    public void save(Pets pets) {
        dao.save(pets);
    }

    @Override
    public void update(Long id, Pets pets) {
        pets.setId(id);
        dao.update(pets);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Pets findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pets> findAll() {
        return dao.findAll();
    }
}

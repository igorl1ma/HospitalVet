package br.com.hospital.vet.service;

import br.com.hospital.vet.dao.MedicosDao;
import br.com.hospital.vet.domain.Medicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicosServiceImpl implements MedicosService {

    @Autowired
    private MedicosDao dao;

    @Override
    public void save(Medicos medicos) {
        dao.save(medicos);
    }

    @Override
    public void update(Long id, Medicos medicos) {
        medicos.setId(id);
        dao.update(medicos);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Medicos findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medicos> findAll() {
        return dao.findAll();
    }
}

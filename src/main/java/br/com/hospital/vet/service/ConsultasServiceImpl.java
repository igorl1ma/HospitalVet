package br.com.hospital.vet.service;

import br.com.hospital.vet.dao.ConsultasDao;
import br.com.hospital.vet.domain.Consultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConsultasServiceImpl implements ConsultasService {

    @Autowired
    private ConsultasDao dao;

    @Override
    public void save(Consultas consultas) {
        dao.save(consultas);
    }

    @Override
    public void update(Long id, Consultas consultas) {
        consultas.setId(id);
        dao.update(consultas);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Consultas findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Consultas> findAll() {
        return dao.findAll();
    }
}

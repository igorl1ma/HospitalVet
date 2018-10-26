package br.com.hospital.vet.dao;

import br.com.hospital.vet.domain.Consultas;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ConsultasDaoImpl implements ConsultasDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Consultas consultas) {
        entityManager.persist(consultas);

    }

    @Override
    public void update(Consultas consultas) {
        entityManager.merge(consultas);

    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.getReference(Consultas.class, id));

    }

    @Override
    public Consultas findById(Long id) {

        return entityManager.find(Consultas.class,id);
    }

    @Override
    public List<Consultas> findAll() {
        return entityManager
                .createQuery("select c from Consultas c", Consultas.class)
                .getResultList();
    }
}

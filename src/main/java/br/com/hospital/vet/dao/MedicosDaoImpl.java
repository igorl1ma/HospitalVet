package br.com.hospital.vet.dao;

import br.com.hospital.vet.domain.Medicos;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MedicosDaoImpl implements MedicosDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Medicos medicos) {
        entityManager.persist(medicos);

    }

    @Override
    public void update(Medicos medicos) {
        entityManager.merge(medicos);

    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.getReference(Medicos.class, id));

    }

    @Override
    public Medicos findById(Long id) {
        return entityManager.find(Medicos.class,id);
    }

    @Override
    public List<Medicos> findAll() {
        return entityManager
                .createQuery("select m from Medicos m", Medicos.class)
                .getResultList();
    }
}

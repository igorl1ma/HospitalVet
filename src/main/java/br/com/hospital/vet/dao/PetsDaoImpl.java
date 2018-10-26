package br.com.hospital.vet.dao;

import br.com.hospital.vet.domain.Pets;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PetsDaoImpl implements PetsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Pets pets) {
        entityManager.persist(pets);

    }

    @Override
    public void update(Pets pets) {
        entityManager.merge(pets);

    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.getReference(Pets.class, id));

    }

    @Override
    public Pets findById(Long id) {

        return entityManager.find(Pets.class,id);
    }

    @Override
    public List<Pets> findAll() {
        return entityManager
                .createQuery("select p from Pets p", Pets.class)
                .getResultList();
    }
}

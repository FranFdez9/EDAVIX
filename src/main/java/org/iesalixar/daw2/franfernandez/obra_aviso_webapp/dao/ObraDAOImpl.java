
package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Obra;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ObraDAOImpl implements ObraDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Obra> findAll() {
        return entityManager.createQuery(
                "SELECT o FROM Obra o", Obra.class
        ).getResultList();
    }

    @Override
    public Optional<Obra> findById(Long id) {
        return Optional.ofNullable(
                entityManager.find(Obra.class, id)
        );
    }

    @Override
    public Obra save(Obra obra) {
        if (obra.getIdObra() == null) {
            entityManager.persist(obra);
            return obra;
        }

        return entityManager.merge(obra);
    }

    @Override
    public void deleteById(Long id) {
        Obra obra = entityManager.find(Obra.class, id);

        if (obra != null) {
            entityManager.remove(obra);
        }
    }
}

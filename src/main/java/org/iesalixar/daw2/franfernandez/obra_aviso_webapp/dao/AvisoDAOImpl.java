
package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Aviso;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public class AvisoDAOImpl implements AvisoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Aviso> findAll() {
        return entityManager.createQuery(
                "SELECT a FROM Aviso a", Aviso.class
        ).getResultList();
    }

    @Override
    public Optional<Aviso> findById(Long id) {
        return Optional.ofNullable(
                entityManager.find(Aviso.class, id)
        );
    }

    @Override
    public Aviso save(Aviso aviso) {
        if (aviso.getIdAviso() == null) {
            entityManager.persist(aviso);
            return aviso;
        }

        return entityManager.merge(aviso);
    }

    @Override
    public void deleteById(Long id) {
        Aviso aviso = entityManager.find(Aviso.class, id);

        if (aviso != null) {
            entityManager.remove(aviso);
        }
    }
}

package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dao;

import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Obra;

import java.util.List;
import java.util.Optional;

public interface ObraDAO {

    List<Obra> findAll();

    Optional<Obra> findById(Long id);

    Obra save(Obra obra);

    void deleteById(Long id);

}


package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dao;

import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Aviso;

import java.util.List;
import java.util.Optional;

public interface AvisoDAO {

    List<Aviso> findAll();

    Optional<Aviso> findById(Long id);

    Aviso save(Aviso aviso);

    void deleteById(Long id);
}

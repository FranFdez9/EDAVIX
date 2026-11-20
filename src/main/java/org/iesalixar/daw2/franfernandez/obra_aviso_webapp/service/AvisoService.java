
package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.service;

import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto.AvisoDTO;

import java.util.List;
import java.util.Optional;

public interface AvisoService {

    List<AvisoDTO> findAll();

    Optional<AvisoDTO> findById(Long id);

    AvisoDTO save(AvisoDTO avisoDTO);

    void deleteById(Long id);
}

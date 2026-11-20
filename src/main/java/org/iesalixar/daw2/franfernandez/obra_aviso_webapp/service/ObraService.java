package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.service;

import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto.ObraDTO;
import java.util.List;
import java.util.Optional;

public interface ObraService {

List<ObraDTO> findAll();
Optional<ObraDTO> findById(Long id);
ObraDTO save(ObraDTO obraDTO);
void deleteById(Long id);

}

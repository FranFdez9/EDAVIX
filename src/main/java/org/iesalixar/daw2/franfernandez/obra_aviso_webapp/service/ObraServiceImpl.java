
package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dao.ObraDAO;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto.ObraDTO;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Obra;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.mapper.ObraMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ObraServiceImpl implements ObraService {

    private final ObraDAO obraDAO;

    @Override
    @Transactional(readOnly = true)
    public List<ObraDTO> findAll() {
        return obraDAO.findAll()
                .stream()
                .map(ObraMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ObraDTO> findById(Long id) {
        return obraDAO.findById(id)
                .map(ObraMapper::toDTO);
    }

    @Override
    public ObraDTO save(ObraDTO obraDTO) {

        Obra obra = ObraMapper.toEntity(obraDTO);

        Obra obraGuardada = obraDAO.save(obra);

        return ObraMapper.toDTO(obraGuardada);
    }

    @Override
    public void deleteById(Long id) {
        obraDAO.deleteById(id);
    }
}

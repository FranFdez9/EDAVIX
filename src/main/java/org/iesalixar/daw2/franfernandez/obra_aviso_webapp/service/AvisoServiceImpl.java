package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dao.AvisoDAO;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dao.ObraDAO;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto.AvisoDTO;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Aviso;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Obra;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.mapper.AvisoMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AvisoServiceImpl implements AvisoService {

    private final AvisoDAO avisoDAO;
    private final ObraDAO obraDAO;

    @Override
    @Transactional(readOnly = true)
    public List<AvisoDTO> findAll() {
        return avisoDAO.findAll()
                .stream()
                .map(AvisoMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AvisoDTO> findById(Long id) {
        return avisoDAO.findById(id)
                .map(AvisoMapper::toDTO);
    }

    @Override
    public AvisoDTO save(AvisoDTO avisoDTO) {

        // Buscamos la obra seleccionada en el formulario
        Obra obra = obraDAO.findById(avisoDTO.getIdObra())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "La obra seleccionada no existe"
                        )
                );

        // Convertimos el DTO en entidad
        Aviso aviso = AvisoMapper.toEntity(avisoDTO, obra);

        // Guardamos el aviso
        Aviso avisoGuardado = avisoDAO.save(aviso);

        // Devolvemos el DTO
        return AvisoMapper.toDTO(avisoGuardado);
    }

    @Override
    public void deleteById(Long id) {
        avisoDAO.deleteById(id);
    }
}

package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.mapper;

import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto.ObraDTO;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Obra;

public class ObraMapper {
    public static ObraDTO toDTO(Obra obra) {
        ObraDTO dto = new ObraDTO();
        dto.setIdObra(obra.getIdObra());
        dto.setNombre(obra.getNombre());
        dto.setDescripcion(obra.getDescripcion());
        dto.setDireccion(obra.getDireccion());
        dto.setFechaInicio(obra.getFechaInicio());
        dto.setFechaFin(obra.getFechaFin());
        dto.setEstado(obra.getEstado());


        return dto;
    }

    public static Obra toEntity(ObraDTO dto){

        Obra obra = new Obra();
        obra.setIdObra(dto.getIdObra());
        obra.setNombre(dto.getNombre());
        obra.setDescripcion(dto.getDescripcion());
        obra.setDireccion(dto.getDireccion());
        obra.setFechaInicio(dto.getFechaInicio());
        obra.setFechaFin(dto.getFechaFin());
        obra.setEstado(dto.getEstado());

        return obra;
    }

}

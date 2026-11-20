
package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.mapper;

import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto.AvisoDTO;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Aviso;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.entity.Obra;

public class AvisoMapper {

    public static AvisoDTO toDTO(Aviso aviso) {
        AvisoDTO dto = new AvisoDTO();

        dto.setIdAviso(aviso.getIdAviso());
        dto.setFecha(aviso.getFecha());
        dto.setTipo(aviso.getTipo());
        dto.setLeido(aviso.getLeido());
        dto.setMensaje(aviso.getMensaje());
        dto.setIdObra(aviso.getObra().getIdObra());

        return dto;
    }

    public static Aviso toEntity(AvisoDTO dto, Obra obra) {
        Aviso aviso = new Aviso();

        aviso.setIdAviso(dto.getIdAviso());
        aviso.setTipo(dto.getTipo());
        aviso.setMensaje(dto.getMensaje());
        aviso.setFecha(dto.getFecha());
        aviso.setLeido(dto.getLeido());
        aviso.setObra(obra);

        return aviso;
    }
}

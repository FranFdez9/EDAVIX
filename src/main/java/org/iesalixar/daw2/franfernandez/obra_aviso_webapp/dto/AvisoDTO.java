
package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto;

import lombok.Data;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class AvisoDTO {

    private Long idAviso;

    @NotBlank(message = "{aviso.tipo.notblank}")
    @Size(max = 50, message = "{aviso.tipo.size}")
    private String tipo;

    @NotBlank(message = "{aviso.mensaje.notblank}")
    @Size(max = 500, message = "{aviso.mensaje.size}")
    private String mensaje;

    @NotNull(message = "{aviso.fecha.notnull}")
    private LocalDateTime fecha;

    @NotNull(message = "{aviso.leido.notnull}")
    private Boolean leido;

    @NotNull(message = "{aviso.obra.notnull}")
    private Long idObra;
}

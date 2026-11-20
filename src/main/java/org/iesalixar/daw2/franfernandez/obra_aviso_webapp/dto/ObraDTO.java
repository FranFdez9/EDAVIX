
package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto;

import lombok.Data;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.AssertTrue;

@Data
public class ObraDTO {

    private Long idObra;

    @NotBlank(message = "{obra.nombre.notblank}")
    @Size(max = 100, message = "{obra.nombre.size}")
    private String nombre;

    @NotBlank(message = "{obra.direccion.notblank}")
    @Size(max = 200, message = "{obra.direccion.size}")
    private String direccion;

    @Size(max = 1000, message = "{obra.descripcion.size}")
    private String descripcion;

    @NotNull(message = "{obra.fechaInicio.notnull}")
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @NotBlank(message = "{obra.estado.notblank}")
    @Size(max = 30, message = "{obra.estado.size}")
    private String estado;
}


package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto.ObraDTO;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.service.ObraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ObraController {

    private final ObraService obraService;

    // LISTAR OBRAS
    @GetMapping("/obras")
    public String listarObras(Model model) {
        model.addAttribute("obras", obraService.findAll());
        return "obras/lista";
    }

    // MOSTRAR FORMULARIO DE CREACIÓN
    @GetMapping("/obras/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("obra", new ObraDTO());
        model.addAttribute("titulo", "Crear obra");
        model.addAttribute("accion", "/obras/guardar");

        return "obras/formulario";
    }

    // GUARDAR OBRA
    @PostMapping("/obras/guardar")
    public String guardarObra(
            @Valid ObraDTO obra,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("obra", obra);
            model.addAttribute("titulo", "Crear obra");
            model.addAttribute("accion", "/obras/guardar");

            return "obras/formulario";
        }

        obraService.save(obra);

        return "redirect:/obras";
    }

    // MOSTRAR FORMULARIO DE EDICIÓN
    @GetMapping("/obras/{id}/editar")
    public String mostrarFormularioEdicion(
            @PathVariable Long id,
            Model model) {

        ObraDTO obra = obraService.findById(id).orElse(null);

        if (obra == null) {
            return "redirect:/obras";
        }

        model.addAttribute("obra", obra);
        model.addAttribute("titulo", "Editar obra");
        model.addAttribute("accion", "/obras/actualizar");

        return "obras/formulario";
    }

    // ACTUALIZAR OBRA
    @PostMapping("/obras/actualizar")
    public String actualizarObra(
            @Valid ObraDTO obra,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("obra", obra);
            model.addAttribute("titulo", "Editar obra");
            model.addAttribute("accion", "/obras/actualizar");

            return "obras/formulario";
        }

        obraService.save(obra);

        return "redirect:/obras";
    }

    // ELIMINAR OBRA
    @PostMapping("/obras/{id}/eliminar")
    public String eliminarObra(@PathVariable Long id) {
        obraService.deleteById(id);
        return "redirect:/obras";
    }
}


package org.iesalixar.daw2.franfernandez.obra_aviso_webapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.dto.AvisoDTO;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.service.AvisoService;
import org.iesalixar.daw2.franfernandez.obra_aviso_webapp.service.ObraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AvisoController {

    private final AvisoService avisoService;
    private final ObraService obraService;

    // LISTAR AVISOS
    @GetMapping("/avisos")
    public String listarAvisos(Model model) {
        model.addAttribute("avisos", avisoService.findAll());
        return "avisos/lista";
    }

    // MOSTRAR FORMULARIO DE CREACIÓN
    @GetMapping("/avisos/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("aviso", new AvisoDTO());
        model.addAttribute("obras", obraService.findAll());
        model.addAttribute("titulo", "Crear aviso");
        model.addAttribute("accion", "/avisos/guardar");

        return "avisos/formulario";
    }

    // GUARDAR AVISO
    @PostMapping("/avisos/guardar")
    public String guardarAviso(
            @Valid AvisoDTO aviso,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("aviso", aviso);
            model.addAttribute("obras", obraService.findAll());
            model.addAttribute("titulo", "Crear aviso");
            model.addAttribute("accion", "/avisos/guardar");

            return "avisos/formulario";
        }

        avisoService.save(aviso);

        return "redirect:/avisos";
    }

    // MOSTRAR FORMULARIO DE EDICIÓN
    @GetMapping("/avisos/{id}/editar")
    public String mostrarFormularioEdicion(
            @PathVariable Long id,
            Model model) {

        AvisoDTO aviso = avisoService.findById(id).orElse(null);

        if (aviso == null) {
            return "redirect:/avisos";
        }

        model.addAttribute("aviso", aviso);
        model.addAttribute("obras", obraService.findAll());
        model.addAttribute("titulo", "Editar aviso");
        model.addAttribute("accion", "/avisos/actualizar");

        return "avisos/formulario";
    }

    // ACTUALIZAR AVISO
    @PostMapping("/avisos/actualizar")
    public String actualizarAviso(
            @Valid AvisoDTO aviso,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("aviso", aviso);
            model.addAttribute("obras", obraService.findAll());
            model.addAttribute("titulo", "Editar aviso");
            model.addAttribute("accion", "/avisos/actualizar");

            return "avisos/formulario";
        }

        avisoService.save(aviso);

        return "redirect:/avisos";
    }

    // ELIMINAR AVISO
    @PostMapping("/avisos/{id}/eliminar")
    public String eliminarAviso(@PathVariable Long id) {
        avisoService.deleteById(id);
        return "redirect:/avisos";
    }
}

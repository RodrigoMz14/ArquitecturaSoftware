package com.ProyectoArqui.CrudSpringBoot.controlador;

import com.ProyectoArqui.CrudSpringBoot.interfaceService.InterfacePersonaService;
import com.ProyectoArqui.CrudSpringBoot.modelo.Persona;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador del programa
 */
@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private InterfacePersonaService interfacePersonaService;

    /**
     * Recupera lista de las personas
     * @param model objeto Modelo
     * @return redirige vista a Index
     */
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Persona> personas = interfacePersonaService.listar();
        model.addAttribute("personas", personas);
        return "index";
    }

    /**
     * Agrega un nuevo objeto persona al modelo
     * @param model objeto Modelo
     * @return redirige a vista form
     */
    @GetMapping("/new")
    public String agregar(Model model) {
        model.addAttribute("persona", new Persona());
        return "form";

    }

    /**
     * Guarda objeto persona a la base de datos
     * @param p objeto persona
     * @param model Modelo
     * @return redirige a la vista listar
     */
    @PostMapping("/save")
    public String save(@Valid Persona p, Model model) {
        interfacePersonaService.save(p);
        return "redirect:/listar";

    }

    /**
     *  Modifica objeto persona y agrega al modelo
     * @param id id persona
     * @param model Modelo
     * @return redirige a la vista form
     */
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Persona> persona = interfacePersonaService.listarId(id);
        model.addAttribute("persona", persona);
        return "form";
    }

    /**
     * Indica el objeto persona a eliminar
     * @param model Modelo
     * @param id id persona
     * @return redirige a listar
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable int id){
        interfacePersonaService.delete(id);
        return "redirect:/listar";
    }

    /**
     * Indica las personas seleccionadas a eliminar
     * @param selectedIds ids seleccionados
     * @return redirige a listar
     */
    @PostMapping("/deleteSelected")
    public String deleteSelected(@RequestParam(name = "selectedIds", required = false) List<Integer> selectedIds) {
        if (selectedIds != null && !selectedIds.isEmpty()) {
            for (Integer id : selectedIds) {
                if (id != null) {
                    interfacePersonaService.delete(id.intValue());
                }
            }
        }
        return "redirect:/listar";
    }
}

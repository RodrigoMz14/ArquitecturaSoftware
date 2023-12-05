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

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private InterfacePersonaService interfacePersonaService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Persona> personas = interfacePersonaService.listar();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model) {
        model.addAttribute("persona", new Persona());
        return "form";

    }

    @PostMapping("/save")
    public String save(@Valid Persona p, Model model) {
        interfacePersonaService.save(p);
        return "redirect:/listar";

    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Persona> persona = interfacePersonaService.listarId(id);
        model.addAttribute("persona", persona);
        return "form";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable int id){
        interfacePersonaService.delete(id);
        return "redirect:/listar";


    }

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
